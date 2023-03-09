package com.dam.springboot.app.models.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dam.springboot.app.models.entity.Arma;

@Repository
public class ArmaDaoImpl implements IArmaDao{

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public Page<Arma> findAll(Pageable pageable) {
		 Query queryCount = em.createQuery("SELECT COUNT(a) FROM Arma a");
		    Long countResult = (Long) queryCount.getSingleResult();
		    System.out.println(countResult);

		    TypedQuery<Arma> query = em.createQuery("FROM Arma ORDER BY id ASC", Arma.class)
		            .setFirstResult(pageable.getPageNumber() * pageable.getPageSize())
		            .setMaxResults(pageable.getPageSize());

		    List<Arma> armas = query.getResultList();
		    return new PageImpl<>(armas, pageable, countResult);
	}

	@Override
	@Transactional
	public void save(Arma arma) {
		// TODO Auto-generated method stub
		if (arma.getId() != null && arma.getId() > 0) {
			em.merge(arma);
		} else {
			em.persist(arma);
		}
		
	}
	
	@Override
	@Transactional(readOnly = true)
	public Arma findOne(Long id) {
		return em.find(Arma.class, id);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		em.remove(findOne(id));
	}

}
