package org.zkoss.zkspringboot.demo.model;


public class Especialidad {


	private long id;


	private String nombre;

	public Especialidad() {
	}

	public Especialidad(String nombre) {
		this.nombre = nombre;
	}
	
	
	public Especialidad(long id, String nombre) {
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
