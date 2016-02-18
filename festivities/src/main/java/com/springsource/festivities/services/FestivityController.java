package com.springsource.festivities.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springsource.festivities.dao.FestivityDAO;
import com.springsource.festivities.model.Festivity;
import com.springsource.festivities.utils.DateUtils;
import com.springsource.festivities.utils.FestivityDateStringPojo;



/**
 * Festivity Service
 * @author mlancheros
 *
 */
@Controller
@RequestMapping("festivities")
public class FestivityController {
	
	/**
	 * Festivity Data Access Object
	 */
	@Autowired
	private FestivityDAO festivityDAO;
	
	/**
	 * Get the resource bundle context
	 */
	ApplicationContext context = new ClassPathXmlApplicationContext("locale.xml");
	
	/**
	 * Geographical region
	 */
	Locale locale = Locale.US;

	
	/**
	 * This method gets all the festivities
	 * @return json
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getAllFestivities(){
		try {
			List<Festivity> festivities = festivityDAO.getAllFestivity();
			if(festivities.isEmpty())
				return new ResponseEntity<String>(context.getMessage("label.festivities.festivitiesNotFound", 
						new Object[] {}, locale), HttpStatus.NOT_FOUND);
			
			List<FestivityDateStringPojo> json = new ArrayList<FestivityDateStringPojo>();
			for(Festivity festivity:festivities){
				json.add(new FestivityDateStringPojo(festivity));
			}
			return new ResponseEntity<List<FestivityDateStringPojo>>(json, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method gets a festivity by its id
	 * @param id the festivity's Id
	 * @return json
	 */
	@RequestMapping(value="/id/{id}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getFestivityByid(@PathVariable("id") Long id){
		try {
			List<Festivity> festivities = festivityDAO.getFestivity(id);
			if(festivities.isEmpty())
				return new ResponseEntity<String>(context.getMessage("label.festivities.notFoundById", 
						new Object[] {id}, locale), HttpStatus.NOT_FOUND);
			
			List<FestivityDateStringPojo> json = new ArrayList<FestivityDateStringPojo>();
			for(Festivity festivity:festivities){
				json.add(new FestivityDateStringPojo(festivity));
			}
			return new ResponseEntity<FestivityDateStringPojo>(json.get(0), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method gets a festivity by its name
	 * @param name the festivity's name
	 * @return json
	 */
	@RequestMapping(value="/name/{name}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getFestivityByName(@PathVariable("name") String name){
		try {
			List<Festivity> festivities = festivityDAO.getFestivityByName(name);
			if(festivities.isEmpty())
				return new ResponseEntity<String>(context.getMessage("label.festivities.notFoundByName", 
						new Object[] {name}, locale), HttpStatus.NOT_FOUND);
			
			List<FestivityDateStringPojo> json = new ArrayList<FestivityDateStringPojo>();
			for(Festivity festivity:festivities){
				json.add(new FestivityDateStringPojo(festivity));
			}
			return new ResponseEntity<FestivityDateStringPojo>(json.get(0), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method gets a festivity by its place
	 * @param place the festivity's place
	 * @return json
	 */
	@RequestMapping(value="/place/{place}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getFestivityByPlace(@PathVariable("place") String place){
		try {
			List<Festivity> festivities = festivityDAO.getFestivityByPlace(place);
			if(festivities.isEmpty())
				return new ResponseEntity<String>(context.getMessage("label.festivities.notFoundByPlace", 
						new Object[] {place}, locale), HttpStatus.NOT_FOUND);
			
			List<FestivityDateStringPojo> json = new ArrayList<FestivityDateStringPojo>();
			for(Festivity festivity:festivities){
				json.add(new FestivityDateStringPojo(festivity));
			}
			return new ResponseEntity<FestivityDateStringPojo>(json.get(0), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/**
	 * This method gets a festivity by its startDate
	 * @param startDate the festivity's startDate
	 * @return json
	 */
	@RequestMapping(value="/startDate/{startDate:.+}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getFestivityByDate(@PathVariable("startDate") String startDate){
		try {
			List<Festivity> festivities = festivityDAO.getFestivityByStartDate(DateUtils.convertToDateFromUTCFormat(startDate));
			if(festivities.isEmpty())
				return new ResponseEntity<String>(context.getMessage("label.festivities.notFoundByStartDate", 
						new Object[] {startDate}, locale), HttpStatus.NOT_FOUND);
			
			List<FestivityDateStringPojo> json = new ArrayList<FestivityDateStringPojo>();
			for(Festivity festivity:festivities){
				json.add(new FestivityDateStringPojo(festivity));
			}
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**
	 * This method gets a festivity which its date its between two dates
	 * @param date1, date2 range dates
	 * @return json
	 */
	@RequestMapping(value="/rangeDate/{date1:.+}/{date2:.+}", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getFestivityByRange(@PathVariable("date1") String date1, @PathVariable("date2") String date2){
		try {
			List<Festivity> festivities = festivityDAO.getFestivityByRange(DateUtils.convertToDateFromUTCFormat(date1), DateUtils.convertToDateFromUTCFormat(date2));
			if(festivities.isEmpty())
				return new ResponseEntity<String>(context.getMessage("label.festivities.notFoundByRangeDate", 
						new Object[] {date1, date2}, locale), HttpStatus.NOT_FOUND);
			
			List<FestivityDateStringPojo> json = new ArrayList<FestivityDateStringPojo>();
			for(Festivity festivity:festivities){
				json.add(new FestivityDateStringPojo(festivity));
			}
			return new ResponseEntity<List<FestivityDateStringPojo>>(json, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	/**
	 * Method that creates a festivity
	 * @param festivity Festivity's json
	 * @return Http Status
	 */
	@RequestMapping(method = RequestMethod.POST, consumes="application/json")
	public @ResponseBody ResponseEntity<String> createFestivity(@RequestBody Festivity festivity){
		try{
			if(festivity.getName() == null || festivity.getName().isEmpty()
					|| festivity.getPlace() == null || festivity.getPlace().isEmpty()
					|| festivity.getStartDate() == null || festivity.getEndDate() == null){
				
				return new ResponseEntity<String>(context.getMessage("label.festivities.jsonMissingData", 
						new Object[] {}, locale), HttpStatus.BAD_REQUEST);
			}
			
			if(festivity.getEndDate().compareTo(festivity.getStartDate()) <0){
				return new ResponseEntity<String>(context.getMessage("label.festivities.endDateGreater", 
						new Object[] {}, locale), HttpStatus.BAD_REQUEST);
			}
			
			festivityDAO.save(festivity);
			return new ResponseEntity<String>(context.getMessage("label.festivities.festivitySaved", 
					new Object[] {}, locale), HttpStatus.OK);
			
		}catch(Exception e){
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	/**
	 * Method that updates a festivity
	 * @param festivity Festivity's json
	 * @return Http Status
	 */
	@RequestMapping(method = RequestMethod.PUT, consumes="application/json")
	public @ResponseBody ResponseEntity<String> updateFestivity(@RequestBody Festivity festivity){
		try{
			if(festivity.getName() == null || festivity.getName().isEmpty()
					|| festivity.getPlace() == null || festivity.getPlace().isEmpty()
					|| festivity.getStartDate() == null || festivity.getEndDate() == null
					|| festivity.getId() == null){
				
				return new ResponseEntity<String>(context.getMessage("label.festivities.jsonMissingData", 
						new Object[] {}, locale), HttpStatus.BAD_REQUEST);
			}
			if(festivity.getEndDate().compareTo(festivity.getStartDate()) <0){
				return new ResponseEntity<String>(context.getMessage("label.festivities.endDateGreater", 
						new Object[] {}, locale), HttpStatus.BAD_REQUEST);
			}
			
			List<Festivity> festivityOld = festivityDAO.getFestivity(festivity.getId());
			if(festivityOld.isEmpty())
				return new ResponseEntity<String>(context.getMessage("label.festivities.notFoundById", 
						new Object[] {festivity.getId()}, locale), HttpStatus.NOT_FOUND);
			
			festivityOld.get(0).setName(festivity.getName());
			festivityOld.get(0).setStartDate(festivity.getStartDate());
			festivityOld.get(0).setEndDate(festivity.getEndDate());
			festivityDAO.update(festivityOld.get(0));
			return new ResponseEntity<String>(context.getMessage("label.festivities.festivityUpdated", 
					new Object[] {}, locale), HttpStatus.OK);			
		}catch(Exception e){
			return new ResponseEntity<String>(context.getMessage("label.serverError", 
					new Object[] {}, locale), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
