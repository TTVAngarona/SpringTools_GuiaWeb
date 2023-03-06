package com.dam.springboot.app.models.dao;

import java.util.List;

import com.dam.springboot.app.models.entity.Arma;

public interface IArmaDao {

	public List<Arma> findAll();

	public void save(Arma arma);
	
	public Arma findOne(Long id);
	
	public void delete(Long id);
}
