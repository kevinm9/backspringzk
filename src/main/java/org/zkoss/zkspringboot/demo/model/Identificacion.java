package org.zkoss.zkspringboot.demo.model;





public class Identificacion {


	private long id;


	private String nombre;

	public Identificacion() {
	}

	public Identificacion(String nombre) {
		this.nombre = nombre;
	}
	
	

	public Identificacion(long id, String nombre) {
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
		return nombre;
	}

}
