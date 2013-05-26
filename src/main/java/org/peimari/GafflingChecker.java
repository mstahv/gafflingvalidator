package org.peimari;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.peimari.iof2.ControlCode;
import org.peimari.iof2.Course;
import org.peimari.iof2.CourseControl;
import org.peimari.iof2.CourseData;
import org.peimari.iof2.CourseVariation;
import org.peimari.iof2.Name;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import au.com.bytecode.opencsv.CSVReader;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.event.Action;
import com.vaadin.event.Action.Handler;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.OptionGroup;
import com.vaadin.ui.ProgressIndicator;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnGenerator;
import com.vaadin.ui.Table.RowHeaderMode;
import com.vaadin.ui.UI;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

/**
 * The Application's "main" class
 */
@SuppressWarnings("serial")
public class GafflingChecker extends UI {
	private ByteArrayOutputStream bout;
	private ArrayList<CourseVariation> coursevariations;
	Table courseTable = new Table("Courses");

	LinkedHashMap<String, Integer> classToStartNum = new LinkedHashMap<String, Integer>();

	private VerticalLayout actions = new VerticalLayout();

	ProgressIndicator pi = new ProgressIndicator();

	SucceededListener coursesLoaded = new SucceededListener() {

		@Override
		public void uploadSucceeded(SucceededEvent event) {
			event.getUpload().setVisible(false);
			pi.setVisible(false);
			actions.setVisible(true);
			courseTable.setVisible(true);

			try {
				// Pirilä courses is not std based, so we gotta just unmarshall
				// CourseData section
				Document doc = readUploadedXml();
				String tagName = doc.getDocumentElement().getTagName();
				Node node;
				if (tagName.equals("CourseData")) {
					node = doc.getDocumentElement();
				} else {
					node = doc.getDocumentElement()
							.getElementsByTagName("CourseData").item(0);
				}

				JAXBContext jbc = JAXBContext.newInstance("org.peimari.iof2");
				Unmarshaller unmarshaller = jbc.createUnmarshaller();
				unmarshaller.setSchema(null);

				JAXBElement<CourseData> unmarshal2 = unmarshaller.unmarshal(
						node, CourseData.class);
				CourseData value = unmarshal2.getValue();

				List<Course> course = value.getCourse();

				coursevariations = new ArrayList<CourseVariation>();
				for (Course c : course) {
					for (CourseVariation v : c.getCourseVariation()) {
						if (v.getName() == null) {
							// Generate name if does not exist (at least
							// PurplePen)
							Name name = new Name();
							name.setvalue(c.getCourseName()
									+ (c.getCourseVariation().size() == 1 ? ""
											: ":" + v.getCourseVariationId()));
							v.setName(name);
						}
						coursevariations.add(v);
					}
				}

				BeanItemContainer<CourseVariation> ds = new BeanItemContainer<CourseVariation>(
						CourseVariation.class, coursevariations);
				courseTable.setContainerDataSource(ds);
				courseTable.setVisibleColumns(new Object[] { "name",
						"courseControl" });

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}

	};

	private Document readUploadedXml() throws ParserConfigurationException,
			SAXException, IOException {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dbFactory.setIgnoringElementContentWhitespace(true);
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new ByteArrayInputStream(bout
				.toByteArray()));
		return doc;
	}

	SucceededListener kilpSjrReceived = new SucceededListener() {

		@Override
		public void uploadSucceeded(SucceededEvent event) {
			event.getUpload().setVisible(false);
			pi.setVisible(false);

			try {
				Document doc = readUploadedXml();
				// Snippets from Pirilä kilpsjr.xml that we are interested of
				// <Class ClassNo="1">
				// <ClassId>H21A</ClassId>
				// <IdStart>1</IdStart>

				int classesAccepted = 0;

				NodeList classes = doc.getDocumentElement()
						.getElementsByTagName("Class");
				for (int i = 0; i < classes.getLength(); i++) {
					Element c = (Element) classes.item(i);
					String classId = c.getElementsByTagName("ClassId").item(0)
							.getTextContent();
					String firstIdStr = c.getElementsByTagName("IdStart")
							.item(0).getTextContent();
					Integer firstId = Integer.parseInt(firstIdStr);
					if (firstId > 0) {
						classToStartNum.put(classId, firstId);
						classesAccepted++;
					}
				}
				coursesupload.setVisible(true);
				if (classesAccepted == 0) {
					Notification.show("Couldn't read classes",
							Type.ERROR_MESSAGE);
				} else {
					Notification.show("Read " + classesAccepted + " classes");
				}

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	};

	SucceededListener gafflinsReceived = new SucceededListener() {
		@Override
		public void uploadSucceeded(SucceededEvent event) {
			Upload upload = event.getUpload();
			// V7 issue!? Replace with new to allow same file uploaded twice.
			// Should be reset on client side.
			((AbstractOrderedLayout) upload.getParent()).replaceComponent(
					upload, createGafflingUpload());
			pi.setVisible(false);
			CSVReader csvReader = new CSVReader(new InputStreamReader(
					new ByteArrayInputStream(bout.toByteArray())),
					(Character) separator.getValue(), '"');
			try {
				String[] data = csvReader.readNext();

				try {
					HashMap<String, CompetitionClass> nameToCompClass = new HashMap<String, CompetitionClass>();
					// Consider as simple number-gaffling pairs for
					// individual race
					Integer competitorId = Integer.parseInt(data[0]);
					String courseId = data[1];
					String className = detectClassName(competitorId);

					storeVariations(nameToCompClass, courseId, className);

					while ((data = csvReader.readNext()) != null) {
						courseId = data[1];
						competitorId = Integer.parseInt(data[0]);
						className = detectClassName(competitorId);
						storeVariations(nameToCompClass, courseId, className);
					}
					for (Entry<String, CompetitionClass> cc : nameToCompClass
							.entrySet()) {
						compareCourses(cc.getKey(), cc.getValue().values());
					}
				} catch (Exception e) {
					parseRelay(csvReader, data);
				}

			} catch (IOException e) {
				try {
					csvReader.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				throw new RuntimeException(e);
			}
		}

		private void storeVariations(
				HashMap<String, CompetitionClass> nameToCompClass,
				String courseId, String className) throws Exception {
			CompetitionClass compClass = nameToCompClass.get(className);
			if (compClass == null) {
				compClass = new CompetitionClass();
				nameToCompClass.put(className, compClass);
			}
			compClass.put(courseId, getCourseVariation(courseId));
		}

	};

	private OptionGroup separator;
	private Upload coursesupload;

	@Override
	protected void init(VaadinRequest request) {
		final VerticalLayout layout = new VerticalLayout();
		layout.setMargin(true);
		layout.setSpacing(true);

		layout.addComponent(new Label(
				"<h1>GafflingValidator</h1><a href='https://github.com/mstahv/gafflingvalidator'>Details and help.</a>",
				ContentMode.HTML));

		setContent(layout);
		pi.setIndeterminate(true);
		pi.setVisible(false);
		layout.addComponent(pi);
		courseTable.setSelectable(true);
		courseTable.setMultiSelect(true);
		courseTable.addActionHandler(new Handler() {
			Action[] actions = new Action[] { new Action("Compare selected") };

			@Override
			public void handleAction(Action action, Object sender, Object target) {
				compareSelectedCourses();
			}

			@Override
			public Action[] getActions(Object target, Object sender) {
				return actions;
			}
		});

		Upload upload = new Upload(
				"Load KilpSJR.xml, optional but suggested with CSV files without 'Sarja' field.",
				new Receiver() {

					@Override
					public OutputStream receiveUpload(String filename,
							String mimeType) {
						pi.setVisible(true);
						bout = new ByteArrayOutputStream();
						return bout;
					}
				});

		upload.addSucceededListener(kilpSjrReceived);

		upload.setImmediate(true);
		layout.addComponent(upload);

		coursesupload = new Upload("Load courses xml (Required)",
				new Receiver() {

					@Override
					public OutputStream receiveUpload(String filename,
							String mimeType) {
						pi.setVisible(true);
						bout = new ByteArrayOutputStream();
						return bout;
					}
				});

		coursesupload.addSucceededListener(coursesLoaded);

		coursesupload.setImmediate(true);
		layout.addComponent(coursesupload);

		courseTable.setVisible(false);
		layout.addComponent(courseTable);

		Button button = new Button("Compare selected courses");
		button.addClickListener(new ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				compareSelectedCourses();
			}
		});
		actions.setSpacing(true);
		actions.addComponent(button);

		HorizontalLayout csv = new HorizontalLayout();
		csv.setSpacing(true);

		separator = new OptionGroup("Separator");
		separator.addItem(';');
		separator.addItem(',');
		separator.addItem('|');
		separator.setValue(';');
		// BUG in V7, should not be needed but now without this don't get to
		// server when upload is handled
		separator.setImmediate(true);
		csv.addComponent(separator);

		Upload gafflingUpload = createGafflingUpload();
		csv.addComponent(gafflingUpload);
		csv.setCaption("Analyze using gaffling CSV file. See Pirilä docs for details.");
		actions.addComponent(csv);
		actions.setVisible(false);
		layout.addComponent(actions);

		layout.addComponent(new Label("Reload page to reset."));
	}

	private Upload createGafflingUpload() {
		Upload gafflingUpload = new Upload(null, new Receiver() {

			@Override
			public OutputStream receiveUpload(String filename, String mimeType) {
				pi.setVisible(true);
				bout = new ByteArrayOutputStream();
				return bout;
			}
		});

		gafflingUpload.addSucceededListener(gafflinsReceived);
		gafflingUpload.setButtonCaption("Choose file...");
		gafflingUpload.setImmediate(true);
		return gafflingUpload;
	}

	protected CourseVariation getCourseVariation(String id) throws Exception {
		for (CourseVariation cv : coursevariations) {
			if (cv.getName().getvalue().equals(id)) {
				return cv;
			}
		}
		throw new Exception("Course not found: " + id);
	}

	protected void compareSelectedCourses() {
		@SuppressWarnings("unchecked")
		Collection<CourseVariation> coursesToCompare = (Collection<CourseVariation>) courseTable
				.getValue();
		compareCourses("-", coursesToCompare);
	}

	/**
	 * Creates a Table based representation and compare given courses
	 * 
	 * @param classname
	 * @param coursesToCompare
	 */
	private void compareCourses(String classname,
			Collection<CourseVariation> coursesToCompare) {
		if (coursesToCompare == null || coursesToCompare.size() < 2) {
			Notification.show("No courses to compare in " + classname);
			return;
		}
		StringBuilder sb = new StringBuilder();
		Type t = Type.HUMANIZED_MESSAGE;

		sb.append("<br/>");

		List<CourseComparisonTool> ctl = new ArrayList<CourseComparisonTool>();

		for (CourseVariation courseVariation : coursesToCompare) {
			ctl.add(new CourseComparisonTool(courseVariation));
		}

		Table legCountTable = new Table();
		legCountTable.setSizeFull();

		final HashMap<String, Integer> previousKeyToCount = new HashMap<String, Integer>();

		CourseComparisonTool prev = null;
		for (final CourseComparisonTool courseTool : ctl) {
			if (prev != null && !prev.equals(courseTool)) {
				t = Type.ERROR_MESSAGE;
				sb.append(prev.c.getName());
				sb.append(" is not equal to ");
				sb.append(courseTool.c.getName());
				sb.append("<br/>");
			}
			prev = courseTool;
			legCountTable.addGeneratedColumn(courseTool.c.getName(),
					new ColumnGenerator() {
						@Override
						public Object generateCell(Table source, Object itemId,
								Object columnId) {
							String code = (String) itemId;
							Integer count = courseTool.legKeyToCount.get(code);
							if (count == null) {
								count = 0;
							}
							Integer prev = previousKeyToCount.get(code);
							if (prev != null && !prev.equals(count)) {
								return new Label(
										"<div style='background-color:red;'>"
												+ count + "</div>",
										ContentMode.HTML);
							}
							previousKeyToCount.put(code, count);
							return count;
						}
					});
		}

		Window window = new Window("Analyzed " + coursesToCompare.size()
				+ " courses (" + classname + "): "
				+ (t == Type.ERROR_MESSAGE ? "PROBLEMS!" : "OK"));
		window.setContent(legCountTable);
		window.setWidth("50%");
		window.setHeight("70%");
		addWindow(window);

		Set<String> keySet = prev.legKeyToCount.keySet();
		for (String string : keySet) {
			legCountTable.addItem(string);
		}
		legCountTable.setRowHeaderMode(RowHeaderMode.ID);

		if (t == Type.ERROR_MESSAGE) {
			new Notification("Potential problems in " + classname,
					sb.toString(), t, true).show(Page.getCurrent());
		}

	}

	/**
	 * Collects course variations in same class that should match.
	 */
	static class CompetitionClass extends HashMap<String, CourseVariation> {
	}

	private void parseRelay(CSVReader csvReader, String[] data) {

		HashMap<String, CompetitionClass> nameToCompClass = new HashMap<String, CompetitionClass>();

		// Consider first line as header -> relay mode
		String[] header = data;
		try {
			while ((data = csvReader.readNext()) != null) {
				// Each line is a team, each line has n Rata-[INT]
				// which are coursevariation identifiers

				// We'll create "virtual course" for the whole team and
				// then analyze those

				String className = null;
				String no = null;

				CourseVariation courseVariation = new CourseVariation();
				String name = "R";
				for (int i = 0; i < header.length; i++) {
					String s = header[i];
					if (s.startsWith("Rata")) {
						String id = data[i];
						if (!id.isEmpty()) {
							name += "-" + id;
							CourseVariation variation = getCourseVariation(id);
							if (!courseVariation.getCourseControl().isEmpty()) {
								CourseControl o = new CourseControl();
								ControlCode o2 = new ControlCode();
								o2.setvalue("K");
								o.getControlCodeOrControl().add(o2);
								courseVariation.getCourseControl().add(o);
							}
							courseVariation.getCourseControl().addAll(
									variation.getCourseControl());
						}
					} else if (s.equals("Sarja")) {
						className = data[i];
					} else if (s.equals("No")) {
						no = data[i];
					}
				}
				Name n = new Name();
				n.setvalue(name);
				courseVariation.setName(n);

				if (className == null) {
					className = detectClassName(Integer.parseInt(no));
				}
				CompetitionClass compClass = nameToCompClass.get(className);
				if (compClass == null) {
					compClass = new CompetitionClass();
					nameToCompClass.put(className, compClass);
				}
				compClass.put(name, courseVariation);
			}
			for (String className : nameToCompClass.keySet()) {
				compareCourses(className,
						(nameToCompClass.get(className).values()));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public String detectClassName(Integer competitorId) {
		if (competitorId == null) {
			return null;
		}
		String className = null;
		Integer prevMinId = null;
		Set<Entry<String, Integer>> entrySet = classToStartNum.entrySet();
		for (Entry<String, Integer> entry : entrySet) {
			Integer value = entry.getValue();
			if (competitorId >= value) {
				if (prevMinId == null || prevMinId < value) {
					className = entry.getKey();
				}
			}
		}
		return className;
	}

}