//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.05.25 at 02:13:44 PM EEST 
//


package org.peimari.iof2;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "date",
    "clock"
})
@XmlRootElement(name = "FirstStart")
public class FirstStart {

    @XmlElement(name = "Date")
    protected Date date;
    @XmlElement(name = "Clock", required = true)
    protected Clock clock;

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setDate(Date value) {
        this.date = value;
    }

    /**
     * Gets the value of the clock property.
     * 
     * @return
     *     possible object is
     *     {@link Clock }
     *     
     */
    public Clock getClock() {
        return clock;
    }

    /**
     * Sets the value of the clock property.
     * 
     * @param value
     *     allowed object is
     *     {@link Clock }
     *     
     */
    public void setClock(Clock value) {
        this.clock = value;
    }

}
