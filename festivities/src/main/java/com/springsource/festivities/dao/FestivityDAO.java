package com.springsource.festivities.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.springsource.festivities.model.Festivity;



/**
 * Data access to Festivity
 * @author mlancheros
 *
 */

public class FestivityDAO {
	
	
	/**
	 * A persistence context
	 */
	@PersistenceContext(unitName="persistenceUnit")
	private EntityManager entityManager;
	
	
	/**
	 * This method gets all the festivities rows
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Festivity>getAllFestivity(){
		return entityManager.createNamedQuery("Festivity.findAll")
				.getResultList();
	}
	
	/**
	 * This method persists a festivity
	 * @param festivity
	 * @return
	 */
	@Transactional
	public Festivity save(Festivity festivity){
		entityManager.persist(festivity);
		return festivity;
	}

	
	/**
	 * This method update a festivity
	 * @param festivity
	 * @return
	 */
	@Transactional
	public Festivity update(Festivity festivity){
		entityManager.merge(festivity);
		return festivity;
	}
	
	/**
	 * This method get a festivity by its Id
	 * @param id
	 * @return list of festivities
	 */
	@SuppressWarnings("unchecked")
	public List<Festivity> getFestivity(Long id){
		return entityManager.createNamedQuery("Festivity.findById")
				.setParameter("id", id)
				.getResultList();
	}
	
	/**
	 * @param name
	 * @return list of festivities
	 */
	@SuppressWarnings("unchecked")
	public List<Festivity> getFestivityByName(String name){
		return entityManager.createNamedQuery("Festivity.findByName")
				.setParameter("name", name)
				.getResultList();
	}
	
	/**
	 * This method get a festivity by its name
	 * @param place
	 * @return list of festivities
	 */
	@SuppressWarnings("unchecked")
	public List<Festivity> getFestivityByPlace(String place){
		return entityManager.createNamedQuery("Festivity.findByPlace")
				.setParameter("place", place)
				.getResultList();
	}
	
	/**
	 * This method get a festivity by its start date
	 * @param statDate
	 * @return list of festivities
	 */
	@SuppressWarnings("unchecked")
	public List<Festivity> getFestivityByStartDate(Date startDate){
		return entityManager.createNamedQuery("Festivity.findByStartDate")
				.setParameter("startDate", startDate)
				.getResultList();
	}
	
	/**
	 * This method get a festivity between two dates
	 * @param date1
	 * @param date2
	 * @return list of festivities
	 */
	@SuppressWarnings("unchecked")
	public List<Festivity> getFestivityByRange(Date date1, Date date2){
		return entityManager.createNamedQuery("Festivity.findByRange")
				.setParameter("date1", date1)
				.setParameter("date2", date2)
				.getResultList();
	}
	
	

}
