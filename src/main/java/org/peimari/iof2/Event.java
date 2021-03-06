//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.25 at 02:13:44 PM EEST 
//


package org.peimari.iof2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "eventId",
    "name",
    "eventClassificationIdOrEventClassification",
    "startDate",
    "finishDate",
    "eventOfficial",
    "organiser",
    "eventClass",
    "eventRace",
    "webURL",
    "entryData",
    "service",
    "account",
    "modifyDate"
})
@XmlRootElement(name = "Event")
public class Event {

    @XmlAttribute(name = "eventForm")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String eventForm;
    @XmlElement(name = "EventId", required = true)
    protected EventId eventId;
    @XmlElement(name = "Name", required = true)
    protected Name name;
    @XmlElements({
        @XmlElement(name = "EventClassificationId", required = true, type = EventClassificationId.class),
        @XmlElement(name = "EventClassification", required = true, type = EventClassification.class)
    })
    protected List<Object> eventClassificationIdOrEventClassification;
    @XmlElement(name = "StartDate", required = true)
    protected StartDate startDate;
    @XmlElement(name = "FinishDate")
    protected FinishDate finishDate;
    @XmlElement(name = "EventOfficial")
    protected List<EventOfficial> eventOfficial;
    @XmlElement(name = "Organiser")
    protected Organiser organiser;
    @XmlElement(name = "EventClass")
    protected List<EventClass> eventClass;
    @XmlElement(name = "EventRace")
    protected List<EventRace> eventRace;
    @XmlElement(name = "WebURL")
    protected List<WebURL> webURL;
    @XmlElement(name = "EntryData")
    protected EntryData entryData;
    @XmlElement(name = "Service")
    protected List<Service> service;
    @XmlElement(name = "Account")
    protected List<Account> account;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;

    /**
     * Gets the value of the eventForm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventForm() {
        if (eventForm == null) {
            return "IndSingleDay";
        } else {
            return eventForm;
        }
    }

    /**
     * Sets the value of the eventForm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventForm(String value) {
        this.eventForm = value;
    }

    /**
     * Gets the value of the eventId property.
     * 
     * @return
     *     possible object is
     *     {@link EventId }
     *     
     */
    public EventId getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventId }
     *     
     */
    public void setEventId(EventId value) {
        this.eventId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link Name }
     *     
     */
    public Name getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link Name }
     *     
     */
    public void setName(Name value) {
        this.name = value;
    }

    /**
     * Gets the value of the eventClassificationIdOrEventClassification property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventClassificationIdOrEventClassification property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventClassificationIdOrEventClassification().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventClassificationId }
     * {@link EventClassification }
     * 
     * 
     */
    public List<Object> getEventClassificationIdOrEventClassification() {
        if (eventClassificationIdOrEventClassification == null) {
            eventClassificationIdOrEventClassification = new ArrayList<Object>();
        }
        return this.eventClassificationIdOrEventClassification;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link StartDate }
     *     
     */
    public StartDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartDate }
     *     
     */
    public void setStartDate(StartDate value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the finishDate property.
     * 
     * @return
     *     possible object is
     *     {@link FinishDate }
     *     
     */
    public FinishDate getFinishDate() {
        return finishDate;
    }

    /**
     * Sets the value of the finishDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinishDate }
     *     
     */
    public void setFinishDate(FinishDate value) {
        this.finishDate = value;
    }

    /**
     * Gets the value of the eventOfficial property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventOfficial property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventOfficial().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventOfficial }
     * 
     * 
     */
    public List<EventOfficial> getEventOfficial() {
        if (eventOfficial == null) {
            eventOfficial = new ArrayList<EventOfficial>();
        }
        return this.eventOfficial;
    }

    /**
     * Gets the value of the organiser property.
     * 
     * @return
     *     possible object is
     *     {@link Organiser }
     *     
     */
    public Organiser getOrganiser() {
        return organiser;
    }

    /**
     * Sets the value of the organiser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organiser }
     *     
     */
    public void setOrganiser(Organiser value) {
        this.organiser = value;
    }

    /**
     * Gets the value of the eventClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventClass }
     * 
     * 
     */
    public List<EventClass> getEventClass() {
        if (eventClass == null) {
            eventClass = new ArrayList<EventClass>();
        }
        return this.eventClass;
    }

    /**
     * Gets the value of the eventRace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the eventRace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEventRace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link EventRace }
     * 
     * 
     */
    public List<EventRace> getEventRace() {
        if (eventRace == null) {
            eventRace = new ArrayList<EventRace>();
        }
        return this.eventRace;
    }

    /**
     * Gets the value of the webURL property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the webURL property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWebURL().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WebURL }
     * 
     * 
     */
    public List<WebURL> getWebURL() {
        if (webURL == null) {
            webURL = new ArrayList<WebURL>();
        }
        return this.webURL;
    }

    /**
     * Gets the value of the entryData property.
     * 
     * @return
     *     possible object is
     *     {@link EntryData }
     *     
     */
    public EntryData getEntryData() {
        return entryData;
    }

    /**
     * Sets the value of the entryData property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntryData }
     *     
     */
    public void setEntryData(EntryData value) {
        this.entryData = value;
    }

    /**
     * Gets the value of the service property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the service property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getService().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Service }
     * 
     * 
     */
    public List<Service> getService() {
        if (service == null) {
            service = new ArrayList<Service>();
        }
        return this.service;
    }

    /**
     * Gets the value of the account property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the account property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Account }
     * 
     * 
     */
    public List<Account> getAccount() {
        if (account == null) {
            account = new ArrayList<Account>();
        }
        return this.account;
    }

    /**
     * Gets the value of the modifyDate property.
     * 
     * @return
     *     possible object is
     *     {@link ModifyDate }
     *     
     */
    public ModifyDate getModifyDate() {
        return modifyDate;
    }

    /**
     * Sets the value of the modifyDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link ModifyDate }
     *     
     */
    public void setModifyDate(ModifyDate value) {
        this.modifyDate = value;
    }

}
