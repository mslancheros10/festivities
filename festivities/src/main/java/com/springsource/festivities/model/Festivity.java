package com.springsource.festivities.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Festivity entity
 * @author mlancheros
 *
 */
@Entity
@NamedQueries({
@NamedQuery(name="Festivity.findAll", query="SELECT f FROM Festivity f"),
@NamedQuery(name="Festivity.findById", query="SELECT f FROM Festivity f WHERE f.id=:id"),
@NamedQuery(name="Festivity.findByName", query="SELECT f FROM Festivity f WHERE f.name=:name"),
@NamedQuery(name="Festivity.findByPlace", query="SELECT f FROM Festivity f WHERE f.place=:place"),
@NamedQuery(name="Festivity.findByStartDate", query="SELECT f FROM Festivity f WHERE f.startDate=:startDate"),
@NamedQuery(name="Festivity.findByRange", query="SELECT f FROM Festivity f WHERE f.startDate>=:date1 AND f.startDate<=:date2")
})
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "festivity")
public class Festivity implements Serializable{
	
/**
 * class version number
 */
private static final long serialVersionUID = 1L;
	
	/**
	 * Festivity's id
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;
	
	/**
	 * Festivity's name
	 */
	@XmlElement(name = "name")
	@NotNull
	@Size(min=1, max=100)
	private String name;
	
	/**
	 * Festivity's place
	 */
	@XmlElement(name = "place")
	@NotNull
	@Size(min=1, max=100)
	private String place;
	
	/**
	 * Festivity's start date
	 */
	@XmlElement(name = "start")
	@NotNull
	private Date startDate;
	
	/**
	 * Festivity's end date
	 */
	@XmlElement(name = "end")
	@NotNull
	private Date endDate;

	/**
	 * get the festivity's Id
	 * @return the festivity's Id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * set the festivity's Id
	 * @param id the festivity's Id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * get the festivity's name
	 * @return the festivity's name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set the festivity's name
	 * @param name the festivity's name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get the festivity's start date
	 * @return the festivity's start date
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * set the festivity's start date
	 * @param startDate the festivity's start date
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * get the festivity's end date
	 * @return the festivity's end date
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * set the festivity's end date
	 * @param endDate the festivity's end date
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * get the festivity's place
	 * @return the festivity's place
	 */
	public String getPlace() {
		return place;
	}

	/**
	 * set the festivity's place
	 * @param place the festivity's place
	 */
	public void setPlace(String place) {
		this.place = place;
	}
	
	

}