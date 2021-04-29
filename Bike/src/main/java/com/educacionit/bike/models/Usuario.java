package com.educacionit.bike.models;

import javax.persistence.Entity;
import javax.persistence.Id;

/*Esta Entidad sera la represatara a los usuarios y sus respectivas claves */
@Entity // la tabla creada tomara por default l nombre de la clase "usuario"
public class Usuario {

	// estos tres atributos de la clase representan a las columnas de la tabla
	@Id
	private int id;
	private String nombre;
	private String clave;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
