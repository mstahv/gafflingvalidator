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
    "symbolId",
    "name"
})
@XmlRootElement(name = "Symbol")
public class Symbol {

    @XmlElement(name = "SymbolId", required = true)
    protected String symbolId;
    @XmlElement(name = "Name")
    protected Name name;

    /**
     * Gets the value of the symbolId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSymbolId() {
        return symbolId;
    }

    /**
     * Sets the value of the symbolId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSymbolId(String value) {
        this.symbolId = value;
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

}
