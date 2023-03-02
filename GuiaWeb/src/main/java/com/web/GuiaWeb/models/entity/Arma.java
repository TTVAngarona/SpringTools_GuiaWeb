package com.web.GuiaWeb.models.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity //We specify that the class is an entity.
@Table(name = "Armas") //We specify how the table will be mapped if we dont specify this parameter it will automatically name it as the class name.
public class Arma {
	
	//Attributes	
	@Id //Specifies the primary-key of the entity
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Specifies which type of generation we want for our primary-key
	private long id;
	@Column(name = "nombreArma", nullable = false) //Specifies that this attribute is going to be a column and named "nombreArma" and it cant be null.
	private String nombreArma; //Name of the gun
	@Column(name = "nombreSkin", nullable = false) 
	private String nombreSkin; //Name of the skin
	@Column(name = "coleccion")
	private String coleccion; //In which collection is it in.
	
	/**
	 * This attribute makes a reference to the "Float" of the gun, if it is more worn or not there are 5 types:
	 * Este atributo hace referencia a la "Flot" del arma, si está más desgastada o no hay 5 tipos:
	 * Float -> numero que tiene el arma como desgaste.
	 * 
	 * 1. Factory New (Recién fabricado)
	 * 2. Minimal Wear (Casi nuevo)
	 * 3. Field-Tested (Algo desgastado)
	 * 4. Well-Worn (Bastante desgastado)
	 * 5. Battle-Scarred (Deplorable)
	 * https://counterstrike.fandom.com/es/wiki/Aspectos (more info.) 
	 * 
	 * @return A decimal number that refers to the above mentioned wear names.
	 */
	@Column(name = "desgaste", nullable = false)
	private double desgaste; //The worm of the weapon 
	@Column(name = "calidad", nullable = false)
	private float calidad; //The quality of the weapon.
	@Column(name = "precio", nullable = false)
	private float precio; //Price of the skin gun.
	//Constructor
	/**
	 * Constructor with all params except the Id because it is auto-incremental.
	 * There is no empty constructor because we need to create weapons with all attributes.
	 * Constructor con todos los params excepto el Id porque es auto-incremental. 
	 * No hay constructor vacío porque necesitamos crear armas con todos los atributos.
	 * @param nombreArma
	 * @param nombreSkin
	 * @param coleccion
	 * @param desgaste
	 * @param calidad
	 * @param precio
	 */
	public Arma(String nombreArma, String nombreSkin, String coleccion, double desgaste, float calidad, float precio) {
		super();
		this.nombreArma = nombreArma;
		this.nombreSkin = nombreSkin;
		this.coleccion = coleccion;
		this.desgaste = desgaste;
		this.calidad = calidad;
		this.precio = precio;
	}
	
	
	//Getters&Setters
	/******* Id *******/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	/******* GunName *******/
	public String getNombreArma() {
		return nombreArma;
	}
	public void setNombreArma(String nombreArma) {
		this.nombreArma = nombreArma;
	}
	/******* SkinName *******/
	public String getNombreSkin() {
		return nombreSkin;
	}
	public void setNombreSkin(String nombreSkin) {
		this.nombreSkin = nombreSkin;
	}
	/******* Collection *******/
	public String getColeccion() {
		return coleccion;
	}
	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}
	/******* Worn *******/
	public double getDesgaste() {
		return desgaste;
	}
	public void setDesgaste(double desgaste) {
		this.desgaste = desgaste;
	}
	/******* Quality *******/
	public float getCalidad() {
		return calidad;
	}
	public void setCalidad(float calidad) {
		this.calidad = calidad;
	}
	/******* Price *******/
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	//ToString
	@Override
	public String toString() {
		return "Arma: [id=" + id + ", nombreArma=" + nombreArma + ", nombreSkin=" + nombreSkin + ", coleccion="
				+ coleccion + ", desgaste=" + desgaste + ", calidad=" + calidad + ", precio=" + precio + "]";
	}	
}
