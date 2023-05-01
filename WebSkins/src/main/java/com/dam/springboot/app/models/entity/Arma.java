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
	@NotEmpty
	private Float precio;
	private String coleccion;
	private Float desgaste;
	@NotEmpty
	private String imagen;
	private String tipo;
	
	
	public Arma(Long id, @NotEmpty String nombre_Arma, @NotEmpty String nombre_Skin, @NotEmpty Float precio, String coleccion, Float desgaste,@NotEmpty String imagen, String tipo) {
		super();
		this.id = id;
		this.nombre_Arma = nombre_Arma;
		this.nombre_Skin = nombre_Skin;
		this.precio = precio;
		this.coleccion = coleccion;
		this.desgaste = desgaste;
		this.imagen = imagen;
		this.tipo = tipo;
	}
	public Arma() {
		
	}
	
	
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Float getDesgaste() {
		return desgaste;
	}
	public void setDesgaste(Float desgaste) {
		this.desgaste = desgaste;
	}
	public String getColeccion() {
		return coleccion;
	}
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
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
