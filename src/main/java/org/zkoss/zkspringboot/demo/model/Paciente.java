package org.zkoss.zkspringboot.demo.model;





public class Paciente {


	private long id;


	private String nombre;


	private String identificacion;

	public String getIdentificacion() {
		return identificacion;
	}

	public Paciente(String nombre, String identificacion) {
		this.nombre = nombre;
		this.identificacion = identificacion;
	}
	
	

	public Paciente(long id, String nombre, String identificacion) {
		this.nombre = nombre;
		this.identificacion = identificacion;
	}

	public Paciente() {
	}

	public Paciente(String nombre) {
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
		return "Paciente [id=" + id + ", nombre=" + nombre + ", identificacion=" + identificacion + "]";
	}

}
