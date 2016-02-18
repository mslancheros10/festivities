package com.springsource.festivities.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.springsource.festivities.model.Festivity;

/**
 * XML Utilities
 * @author mlancheros
 *
 */
public class XMLUtils {
	
	/**
	 * Method that converts an XML into a Festivities object
	 * @return List of festivities
	 * @throws JAXBException
	 */
	public static List<Festivity>  loadInitialData() throws JAXBException{
		Festivities festivities = new Festivities();
		try {
			File file = new File("../webapps/festivities-0.1.0.BUILD-SNAPSHOT/WEB-INF/festivities.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Festivities.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			festivities = (Festivities) jaxbUnmarshaller.unmarshal(file);
			return festivities.getFestivities();
	
		  } catch (JAXBException e) {
			throw e;
		  }
	
	}
	
	/**
	 * Class for unmarshall process.
	 * @author mlancheros
	 *
	 */
	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlRootElement(name = "festivities")
	public static class Festivities{
		
		@XmlElement(name = "festivity", type = Festivity.class)
		private List<Festivity> festivities = new ArrayList<Festivity>();
		
		public Festivities(){}
		
		public Festivities(List<Festivity> festivities){
			this.festivities=festivities;
		}

		public List<Festivity> getFestivities() {
			return festivities;
		}

		public void setFestivities(List<Festivity> festivities) {
			this.festivities = festivities;
		}
		
		
	}
	
	
	
}


