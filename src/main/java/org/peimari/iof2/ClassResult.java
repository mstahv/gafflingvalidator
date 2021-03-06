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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "classIdOrClassShortNameOrEventClass",
    "personResultOrTeamResult"
})
@XmlRootElement(name = "ClassResult")
public class ClassResult {

    @XmlElements({
        @XmlElement(name = "ClassId", required = true, type = ClassId.class),
        @XmlElement(name = "ClassShortName", required = true, type = ClassShortName.class),
        @XmlElement(name = "EventClass", required = true, type = EventClass.class)
    })
    protected List<Object> classIdOrClassShortNameOrEventClass;
    @XmlElements({
        @XmlElement(name = "PersonResult", type = PersonResult.class),
        @XmlElement(name = "TeamResult", type = TeamResult.class)
    })
    protected List<Object> personResultOrTeamResult;

    /**
     * Gets the value of the classIdOrClassShortNameOrEventClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classIdOrClassShortNameOrEventClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassIdOrClassShortNameOrEventClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassId }
     * {@link ClassShortName }
     * {@link EventClass }
     * 
     * 
     */
    public List<Object> getClassIdOrClassShortNameOrEventClass() {
        if (classIdOrClassShortNameOrEventClass == null) {
            classIdOrClassShortNameOrEventClass = new ArrayList<Object>();
        }
        return this.classIdOrClassShortNameOrEventClass;
    }

    /**
     * Gets the value of the personResultOrTeamResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personResultOrTeamResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonResultOrTeamResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonResult }
     * {@link TeamResult }
     * 
     * 
     */
    public List<Object> getPersonResultOrTeamResult() {
        if (personResultOrTeamResult == null) {
            personResultOrTeamResult = new ArrayList<Object>();
        }
        return this.personResultOrTeamResult;
    }

}
