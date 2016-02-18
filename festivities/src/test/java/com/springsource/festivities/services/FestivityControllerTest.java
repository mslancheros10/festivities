package com.springsource.festivities.services;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springsource.festivities.model.Festivity;
import com.springsource.festivities.utils.FestivityDateStringPojo;

/**
 * Service Festivity Test
 * @author mlancheros
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/META-INF/spring/applicationContext.xml"})
public class FestivityControllerTest {
	
	/**
	 * Festivity Controller
	 */
	@Autowired
	private FestivityController festivityController;
	
	/**
	 * This method test the festivity creation
	 */
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateFestivity(){
		Festivity festivity = new Festivity();
        festivity.setName("Edna's event");
        festivity.setPlace("Coleman's joint");
        festivity.setStartDate(new Date("02/16/2016"));
        festivity.setEndDate(new Date("02/17/2016"));
        ResponseEntity<String> responseEntity = festivityController.createFestivity(festivity);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	/**
	 * This method test the method that gets all festivities
	 */
	@Test
	public void testGetAllFestivities() {
		@SuppressWarnings("unchecked")
		ResponseEntity<List<FestivityDateStringPojo>> responseEntity = 
			(ResponseEntity<List<FestivityDateStringPojo>>)festivityController.getAllFestivities();
		assertTrue(!responseEntity.getBody().isEmpty());
	}
	
	/**
	 * This method test the method that gets the festivity by Id
	 */
	@Test
    public void testGetFestivityById(){
		@SuppressWarnings("unchecked")
		ResponseEntity<FestivityDateStringPojo> responseEntity = 
			(ResponseEntity<FestivityDateStringPojo>)festivityController.getFestivityByid(1L);
    	assertNotNull(responseEntity.getBody());
    }
	
	/**
	 * This method test the method that gets the festivity by name
	 */
	@Test
    public void testGetFestivityByName(){
		@SuppressWarnings("unchecked")
		ResponseEntity<FestivityDateStringPojo> responseEntity = 
			(ResponseEntity<FestivityDateStringPojo>)festivityController.getFestivityByName("Edna's event");
    	assertNotNull(responseEntity.getBody());
    }
	
	/**
	 * This method test the method that gets the festivity by place
	 */
	@Test
    public void testGetFestivityByPlace(){
		@SuppressWarnings("unchecked")
		ResponseEntity<FestivityDateStringPojo> responseEntity = 
			(ResponseEntity<FestivityDateStringPojo>)festivityController.getFestivityByPlace("Coleman's joint");
    	assertNotNull(responseEntity.getBody());
    }
	
	
	/**
	 * This method test the method that updates a festivity. 
	 */
	@SuppressWarnings("deprecation")
	@Test
    public void testUpdate(){
    	Festivity newFestivity = new Festivity();
    	newFestivity.setId(2L);
    	newFestivity.setName("testNameService");
    	newFestivity.setPlace("testPlaceService");
    	newFestivity.setStartDate(new Date("02/16/2016"));
    	newFestivity.setEndDate(new Date("02/17/2016"));
    	festivityController.updateFestivity(newFestivity);
    	@SuppressWarnings("unchecked")
		ResponseEntity<FestivityDateStringPojo> responseEntity = 
			(ResponseEntity<FestivityDateStringPojo>)festivityController.getFestivityByid(2L);
    	assertEquals("testNameService", responseEntity.getBody().getName());
    }
	
	
}
