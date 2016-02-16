package com.springsource.festivities.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springsource.festivities.dao.FestivityDAO;
import com.springsource.festivities.model.Festivity;

@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private FestivityDAO festivityDAO;

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		System.out.println("Ingresa a metodo");
		try {
			List<Festivity> festivities = XMLUtils.loadInitialData();
			for(Festivity festivity:festivities){
				festivityDAO.save(festivity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
  }
}