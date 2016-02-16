package com.springsource.festivities.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springsource.festivities.dao.FestivityDAO;
import com.springsource.festivities.model.Festivity;


@Controller
@RequestMapping("festivities")
public class FestivityController {
	
	@Autowired
	private FestivityDAO festivityDAO;
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody Object getAllFestivities(){
		List<Festivity> json = festivityDAO.getAllFestivity();
		if(json.isEmpty())
			return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		return json;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Object createFestivity(Festivity festivity){
		try{
			if(festivity.getName() == null || festivity.getName().isEmpty()
					|| festivity.getPlace() == null || festivity.getPlace().isEmpty()
					|| festivity.getStartDate() == null || festivity.getEndDate() == null){
				
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}
			festivityDAO.save(festivity);
			return new ResponseEntity<String>(HttpStatus.OK);
			
		}catch(Exception e){
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
