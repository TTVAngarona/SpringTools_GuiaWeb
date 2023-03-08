package com.web.proyecto.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public class Arma {
	@Entity
	@Table(name = "armas")
	public class Cliente implements Serializable {
		// Me llamo oskar
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;

		private String nombre_Arma;

		private String nombre_Skin;

		private String calidad;
		
		private String coleccion;
		
		private Float desgaste;
		
		private float precio;

	}
}
