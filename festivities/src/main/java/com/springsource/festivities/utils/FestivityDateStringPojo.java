package com.springsource.festivities.utils;

import com.springsource.festivities.model.Festivity;

/**
 * Festivity pojo with it's Dates as Strings
 * @author mlancheros
 *
 */
public class FestivityDateStringPojo {
	
	/**
	 * Festivity's id
	 */
	private Long id;
	
	/**
	 * Festivity's name
	 */
	private String name;
	
	/**
	 * Festivity's place
	 */
	private String place;
	
	/**
	 * Festivity's start date
	 */
	private String startDate;
	
	/**
	 * Festivity's end date
	 */
	private String endDate;
	
	/**
	 * Constructor
	 * @param festivity Festivity object
	 */
	public FestivityDateStringPojo(Festivity festivity){
		this.id = festivity.getId();
		this.name = festivity.getName();
		this.place = festivity.getPlace();
		this.startDate = DateUtils.convertToUTCFormat(festivity.getStartDate());
		this.endDate = DateUtils.convertToUTCFormat(festivity.getEndDate());
	}

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
	public String getStartDate() {
		return startDate;
	}

	/**
	 * set the festivity's start date
	 * @param startDate the festivity's start date
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * get the festivity's end date
	 * @return the festivity's end date
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * set the festivity's end date
	 * @param endDate the festivity's end date
	 */
	public void setEndDate(String endDate) {
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
