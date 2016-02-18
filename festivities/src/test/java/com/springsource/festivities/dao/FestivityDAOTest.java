package com.springsource.festivities.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springsource.festivities.model.Festivity;

/**
 * DAO Festivity Test
 * @author mlancheros
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/resources/META-INF/spring/applicationContext.xml"})
public class FestivityDAOTest {

    /**
     * Festivity Data Acces Object
     */
    @Autowired
    private FestivityDAO festivityDAO;
    
    
    /**
     * This method test the festivity creation
     * @throws ParseException
     */
    @SuppressWarnings("deprecation")
	@Test
    public void testSave() throws ParseException {
        Festivity festivity = new Festivity();
        festivity.setName("Jimmy's event");
        festivity.setPlace("Clark's castle");
        festivity.setStartDate(new Date("02/16/2016"));
        festivity.setEndDate(new Date("02/17/2016"));
        Festivity entity = festivityDAO.save(festivity);
        assertNotNull(entity);

    }
    
    /**
     * This method test the method that gets all the festivities
     */
    @Test
    public void testGetAllFestivity(){
    	assertTrue(!festivityDAO.getAllFestivity().isEmpty());
    }
   

    /**
     * This method test the method that updates a festivity
     */
    @Test
    public void testUpdate(){
    	Festivity festivity = festivityDAO.getAllFestivity().get(0);
    	festivity.setName("testName");
    	festivity.setPlace("testPlace");
    	festivityDAO.update(festivity);
    	
    	Festivity newFestivity = festivityDAO.getAllFestivity().get(0);
    	assertEquals("testName", newFestivity.getName());
    	assertEquals("testPlace", newFestivity.getPlace());
    }
    
    /**
     * This method test the method that gets a festivity by id
     */
    @Test
    public void testGetFestivity(){
    	assertTrue(!festivityDAO.getFestivity(1L).isEmpty());
    }
    
    /**
     * This method test the method that gets a festivity by name
     */
    @Test
    public void testGetFestivityByName() {
    	assertTrue(!festivityDAO.getFestivityByName("Jimmy's event").isEmpty());
    }
    
    /**
     * This method test the method that gets a festivity by place
     */
    @Test
    public void testGetFestivityByPlace() {
    	assertTrue(!festivityDAO.getFestivityByPlace("Clark's castle").isEmpty());
    }
    
    /**
     * This method test the method that gets a festivity by start date
     */
    @SuppressWarnings("deprecation")
	@Test
    public void testGetFestivityByStartDate() {
    	assertTrue(!festivityDAO.getFestivityByStartDate(new Date("02/16/2016")).isEmpty());
    }
    
    /**
     * This method test the method that gets a festivity between a date range
     */
    @SuppressWarnings("deprecation")
	@Test
    public void testGetFestivityByRange() {
    	assertTrue(!festivityDAO.getFestivityByRange(new Date("02/01/2016"), new Date("02/20/2016")).isEmpty());
    }
    

}
