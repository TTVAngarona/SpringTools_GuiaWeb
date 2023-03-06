package com.dam.springboot.app.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Arma implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	private String nombre_Arma;
	@NotEmpty
	private String nombre_Skin;
	private Float precio;
	
	public Arma(Long id, @NotEmpty String nombre_Arma, @NotEmpty String nombre_Skin, @NotEmpty Float precio) {
		super();
		this.id = id;
		this.nombre_Arma = nombre_Arma;
		this.nombre_Skin = nombre_Skin;
		this.precio = precio;
	}
	public Arma() {
		
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_Arma() {
		return nombre_Arma;
	}
	public void setNombre_Arma(String nombre_Arma) {
		this.nombre_Arma = nombre_Arma;
	}
	public String getNombre_Skin() {
		return nombre_Skin;
	}
	public void setNombre_Skin(String nombre_Skin) {
		this.nombre_Skin = nombre_Skin;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	
	@Override
	public String toString() {
		return "Arma [id=" + id + ", nombre_Arma=" + nombre_Arma + ", nombre_Skin=" + nombre_Skin + ", precio=" + precio
				+ "]";
	}
	
	
	
	
}
