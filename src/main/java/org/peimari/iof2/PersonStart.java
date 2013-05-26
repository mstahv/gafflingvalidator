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
    "personIdOrPerson",
    "clubIdOrClubOrCountryIdOrCountry",
    "rank",
    "startOrRaceStart"
})
@XmlRootElement(name = "PersonStart")
public class PersonStart {

    @XmlElements({
        @XmlElement(name = "PersonId", required = true, type = PersonId.class),
        @XmlElement(name = "Person", required = true, type = Person.class)
    })
    protected List<Object> personIdOrPerson;
    @XmlElements({
        @XmlElement(name = "ClubId", type = ClubId.class),
        @XmlElement(name = "Club", type = Club.class),
        @XmlElement(name = "CountryId", type = CountryId.class),
        @XmlElement(name = "Country", type = Country.class)
    })
    protected List<Object> clubIdOrClubOrCountryIdOrCountry;
    @XmlElement(name = "Rank")
    protected List<Rank> rank;
    @XmlElements({
        @XmlElement(name = "Start", required = true, type = Start.class),
        @XmlElement(name = "RaceStart", required = true, type = RaceStart.class)
    })
    protected List<Object> startOrRaceStart;

    /**
     * Gets the value of the personIdOrPerson property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personIdOrPerson property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonIdOrPerson().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PersonId }
     * {@link Person }
     * 
     * 
     */
    public List<Object> getPersonIdOrPerson() {
        if (personIdOrPerson == null) {
            personIdOrPerson = new ArrayList<Object>();
        }
        return this.personIdOrPerson;
    }

    /**
     * Gets the value of the clubIdOrClubOrCountryIdOrCountry property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the clubIdOrClubOrCountryIdOrCountry property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClubIdOrClubOrCountryIdOrCountry().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClubId }
     * {@link Club }
     * {@link CountryId }
     * {@link Country }
     * 
     * 
     */
    public List<Object> getClubIdOrClubOrCountryIdOrCountry() {
        if (clubIdOrClubOrCountryIdOrCountry == null) {
            clubIdOrClubOrCountryIdOrCountry = new ArrayList<Object>();
        }
        return this.clubIdOrClubOrCountryIdOrCountry;
    }

    /**
     * Gets the value of the rank property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the rank property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRank().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Rank }
     * 
     * 
     */
    public List<Rank> getRank() {
        if (rank == null) {
            rank = new ArrayList<Rank>();
        }
        return this.rank;
    }

    /**
     * Gets the value of the startOrRaceStart property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the startOrRaceStart property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStartOrRaceStart().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Start }
     * {@link RaceStart }
     * 
     * 
     */
    public List<Object> getStartOrRaceStart() {
        if (startOrRaceStart == null) {
            startOrRaceStart = new ArrayList<Object>();
        }
        return this.startOrRaceStart;
    }

}