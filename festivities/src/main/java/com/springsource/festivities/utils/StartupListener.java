package com.springsource.festivities.utils;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.springsource.festivities.dao.FestivityDAO;
import com.springsource.festivities.model.Festivity;

/**
 * Class that runs a method at the deployment time.
 * This method load the inital data of festivities from an XML into the database
 * @author mlancheros
 *
 */
@Component
public class StartupListener implements ApplicationListener<ContextRefreshedEvent> {
	
	/**
	 * Festivity Data Access Object.
	 */
	@Autowired
	private FestivityDAO festivityDAO;
	
	/**
	 * Flag that shows if the data was loaded or not.
	 */
	private static boolean dataLoaded = false;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationListener#onApplicationEvent(org.springframework.context.ApplicationEvent)
	 */
	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		if(!dataLoaded){
			try {
				List<Festivity> festivities = XMLUtils.loadInitialData();
				for(Festivity festivity:festivities){
					festivityDAO.save(festivity);
				}
				dataLoaded=true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
  }
}