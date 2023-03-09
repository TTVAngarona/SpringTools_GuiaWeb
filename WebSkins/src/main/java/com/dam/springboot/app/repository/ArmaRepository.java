package com.dam.springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.dam.springboot.app.models.entity.Arma;

@Repository
public interface ArmaRepository extends JpaRepository<Arma, Long>, PagingAndSortingRepository<Arma, Long>{

	
}
