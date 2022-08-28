package org.zkoss.zkspringboot.demo.model;



public class Doctor {


	private long id;


	private String nombre;

	public Doctor() {
	}



	public Doctor(String nombre) {
		this.nombre = nombre;
	}



	public Doctor(long id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + "]";
	}

}


