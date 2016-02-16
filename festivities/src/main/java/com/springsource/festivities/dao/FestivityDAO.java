package com.springsource.festivities.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.springsource.festivities.model.Festivity;


public class FestivityDAO {
	
	@PersistenceContext(unitName="persistenceUnit")
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public List<Festivity>getAllFestivity(){
		return entityManager.createNamedQuery("Festivity.findAll")
				.getResultList();
	}
	
	@Transactional
	public Festivity save(Festivity festivity){
		entityManager.persist(festivity);
		return festivity;
	}

	
	public Festivity update(Festivity festivity){
		entityManager.merge(festivity);
		return festivity;
	}
	
	@SuppressWarnings("unchecked")
	public List<Festivity> getFestivity(Long id){
		return entityManager.createNamedQuery("Festivity.findAll")
				.setParameter("id", id)
				.getResultList();
	}

}
