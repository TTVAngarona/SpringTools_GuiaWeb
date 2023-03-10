package com.dam.springboot.app.models.dao;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dam.springboot.app.models.entity.Arma;
import com.dam.springboot.app.repository.ArmaRepository;

@Repository
@Primary
public class ArmaDaoImpl implements ArmaRepository {

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private ArmaRepository armaRepo;

	@Override
	public <S extends Arma> List<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void flush() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Arma> S saveAndFlush(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteInBatch(Iterable<Arma> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllInBatch() {
		// TODO Auto-generated method stub

	}

	@Override
	public Arma getOne(Long id) {
		return em.find(Arma.class, id);
	}

	@Override
	public <S extends Arma> List<S> findAll(Example<S> example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Arma> List<S> findAll(Example<S> example, Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(Long id) {
		return Objects.equals(em.find(Arma.class, id).getId(), id);
	}

	@Override
	public long count() {
		return (long) em.createQuery("select count(a) from Arma a").getSingleResult();
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		em.remove(em.find(Arma.class, id));
	}

	@Override
	public void delete(Arma entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends Arma> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public <S extends Arma> Optional<S> findOne(Example<S> example) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public <S extends Arma> Page<S> findAll(Example<S> example, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Arma> long count(Example<S> example) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public <S extends Arma> boolean exists(Example<S> example) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Arma> findAll() {
		return em.createQuery("from Arma").getResultList();
	}

	@Override
	public List<Arma> findAll(Sort sort) {
		return em.createQuery("from Arma").getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Arma> findAll(Pageable pageable) {
		return armaRepo.findAll(pageable);
	}

	@Override
	public Optional<Arma> findById(Long id) {
		Arma a = em.find(Arma.class, id);
		return Optional.of(a);
	}

	@Override
	public List<Arma> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public <S extends Arma> S save(S entity) {
		return em.merge(entity);
	}

}