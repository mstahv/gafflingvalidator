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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "firstStart",
    "startInterval",
    "estimatedBestTime",
    "estimatedLastPrizeTime",
    "prizeCeremonyTime",
    "allocationMethod",
    "startMethod",
    "classRaceStatus",
    "courseVariationId",
    "modifyDate"
})
@XmlRootElement(name = "ClassRaceInfo")
public class ClassRaceInfo {

    @XmlAttribute(name = "numberOfVacants")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String numberOfVacants;
    @XmlAttribute(name = "rankingRace")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String rankingRace;
    @XmlAttribute(name = "numberOfPrizes")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String numberOfPrizes;
    @XmlAttribute(name = "bibNumberPrefix")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String bibNumberPrefix;
    @XmlAttribute(name = "bibNumberBase")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String bibNumberBase;
    @XmlAttribute(name = "finishChute")
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String finishChute;
    @XmlElement(name = "FirstStart")
    protected FirstStart firstStart;
    @XmlElement(name = "StartInterval")
    protected StartInterval startInterval;
    @XmlElement(name = "EstimatedBestTime")
    protected EstimatedBestTime estimatedBestTime;
    @XmlElement(name = "EstimatedLastPrizeTime")
    protected EstimatedLastPrizeTime estimatedLastPrizeTime;
    @XmlElement(name = "PrizeCeremonyTime")
    protected PrizeCeremonyTime prizeCeremonyTime;
    @XmlElement(name = "AllocationMethod")
    protected AllocationMethod allocationMethod;
    @XmlElement(name = "StartMethod")
    protected StartMethod startMethod;
    @XmlElement(name = "ClassRaceStatus", required = true)
    protected ClassRaceStatus classRaceStatus;
    @XmlElement(name = "CourseVariationId")
    protected List<CourseVariationId> courseVariationId;
    @XmlElement(name = "ModifyDate")
    protected ModifyDate modifyDate;

    /**
     * Gets the value of the numberOfVacants property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfVacants() {
        return numberOfVacants;
    }

    /**
     * Sets the value of the numberOfVacants property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfVacants(String value) {
        this.numberOfVacants = value;
    }

    /**
     * Gets the value of the rankingRace property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRankingRace() {
        if (rankingRace == null) {
            return "N";
        } else {
            return rankingRace;
        }
    }

    /**
     * Sets the value of the rankingRace property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRankingRace(String value) {
        this.rankingRace = value;
    }

    /**
     * Gets the value of the numberOfPrizes property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfPrizes() {
        return numberOfPrizes;
    }

    /**
     * Sets the value of the numberOfPrizes property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfPrizes(String value) {
        this.numberOfPrizes = value;
    }

    /**
     * Gets the value of the bibNumberPrefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBibNumberPrefix() {
        return bibNumberPrefix;
    }

    /**
     * Sets the value of the bibNumberPrefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBibNumberPrefix(String value) {
        this.bibNumberPrefix = value;
    }

    /**
     * Gets the value of the bibNumberBase property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBibNumberBase() {
        return bibNumberBase;
    }

    /**
     * Sets the value of the bibNumberBase property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBibNumberBase(String value) {
        this.bibNumberBase = value;
    }

    /**
     * Gets the value of the finishChute property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFinishChute() {
        return finishChute;
    }

    /**
     * Sets the value of the finishChute property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFinishChute(String value) {
        this.finishChute = value;
    }

    /**
     * Gets the value of the firstStart property.
     * 
     * @return
     *     possible object is
     *     {@link FirstStart }
     *     
     */
    public FirstStart getFirstStart() {
        return firstStart;
    }

    /**
     * Sets the value of the firstStart property.
     * 
     * @param value
     *     allowed object is
     *     {@link FirstStart }
     *     
     */
    public void setFirstStart(FirstStart value) {
        this.firstStart = value;
    }

    /**
     * Gets the value of the startInterval property.
     * 
     * @return
     *     possible object is
     *     {@link StartInterval }
     *     
     */
    public StartInterval getStartInterval() {
        return startInterval;
    }

    /**
     * Sets the value of the startInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartInterval }
     *     
     */
    public void setStartInterval(StartInterval value) {
        this.startInterval = value;
    }

    /**
     * Gets the value of the estimatedBestTime property.
     * 
     * @return
     *     possible object is
     *     {@link EstimatedBestTime }
     *     
     */
    public EstimatedBestTime getEstimatedBestTime() {
        return estimatedBestTime;
    }

    /**
     * Sets the value of the estimatedBestTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedBestTime }
     *     
     */
    public void setEstimatedBestTime(EstimatedBestTime value) {
        this.estimatedBestTime = value;
    }

    /**
     * Gets the value of the estimatedLastPrizeTime property.
     * 
     * @return
     *     possible object is
     *     {@link EstimatedLastPrizeTime }
     *     
     */
    public EstimatedLastPrizeTime getEstimatedLastPrizeTime() {
        return estimatedLastPrizeTime;
    }

    /**
     * Sets the value of the estimatedLastPrizeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstimatedLastPrizeTime }
     *     
     */
    public void setEstimatedLastPrizeTime(EstimatedLastPrizeTime value) {
        this.estimatedLastPrizeTime = value;
    }

    /**
     * Gets the value of the prizeCeremonyTime property.
     * 
     * @return
     *     possible object is
     *     {@link PrizeCeremonyTime }
     *     
     */
    public PrizeCeremonyTime getPrizeCeremonyTime() {
        return prizeCeremonyTime;
    }

    /**
     * Sets the value of the prizeCeremonyTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrizeCeremonyTime }
     *     
     */
    public void setPrizeCeremonyTime(PrizeCeremonyTime value) {
        this.prizeCeremonyTime = value;
    }

    /**
     * Gets the value of the allocationMethod property.
     * 
     * @return
     *     possible object is
     *     {@link AllocationMethod }
     *     
     */
    public AllocationMethod getAllocationMethod() {
        return allocationMethod;
    }

    /**
     * Sets the value of the allocationMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link AllocationMethod }
     *     
     */
    public void setAllocationMethod(AllocationMethod value) {
        this.allocationMethod = value;
    }

    /**
     * Gets the value of the startMethod property.
     * 
     * @return
     *     possible object is
     *     {@link StartMethod }
     *     
     */
    public StartMethod getStartMethod() {
        return startMethod;
    }

    /**
     * Sets the value of the startMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link StartMethod }
     *     
     */
    public void setStartMethod(StartMethod value) {
        this.startMethod = value;
    }

    /**
     * Gets the value of the classRaceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ClassRaceStatus }
     *     
     */
    public ClassRaceStatus getClassRaceStatus() {
        return classRaceStatus;
    }

    /**
     * Sets the value of the classRaceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ClassRaceStatus }
     *     
     */
    public void setClassRaceStatus(ClassRaceStatus value) {
        this.classRaceStatus = value;
    }

    /**
     * Gets the value of the courseVariationId property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the courseVariationId property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCourseVariationId().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CourseVariationId }
     * 
     * 
     */
    public List<CourseVariationId> getCourseVariationId() {
        if (courseVariationId == null) {
            courseVariationId = new ArrayList<CourseVariationId>();
        }
        return this.courseVariationId;
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
