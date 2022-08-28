package org.zkoss.zkspringboot.demo.model;




public class Reservacion {


	private long id;
	private int idpaciente;
	private int idespecialidad;
	private int iddoctor;
	private String fecha;
	private String hora;
	private double valor;
	private boolean pagado;
	
	
	
	
	public Reservacion(long id, int idpaciente, int idespecialidad, int iddoctor, String fecha, String hora,
			double valor, boolean pagado) {
		this.id = id;
		this.idpaciente = idpaciente;
		this.idespecialidad = idespecialidad;
		this.iddoctor = iddoctor;
		this.fecha = fecha;
		this.hora = hora;
		this.valor = valor;
		this.pagado = pagado;
	}

	public Reservacion() {
	}
	
	public Reservacion(int idpaciente, int idespecialidad, int iddoctor, String fecha, String hora, double valor,
			boolean pagado) {
		this.idpaciente = idpaciente;
		this.idespecialidad = idespecialidad;
		this.iddoctor = iddoctor;
		this.fecha = fecha;
		this.hora = hora;
		this.valor = valor;
		this.pagado = pagado;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getIdpaciente() {
		return idpaciente;
	}
	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}
	public int getIdespecialidad() {
		return idespecialidad;
	}
	public void setIdespecialidad(int idespecialidad) {
		this.idespecialidad = idespecialidad;
	}
	public int getIddoctor() {
		return iddoctor;
	}
	public void setIddoctor(int iddoctor) {
		this.iddoctor = iddoctor;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public boolean isPagado() {
		return pagado;
	}
	public void setPagado(boolean pagado) {
		this.pagado = pagado;
	}

	@Override
	public String toString() {
		return "Reservacion [id=" + id + ", idpaciente=" + idpaciente + ", idespecialidad=" + idespecialidad
				+ ", iddoctor=" + iddoctor + ", fecha=" + fecha + ", hora=" + hora + ", valor=" + valor + ", pagado="
				+ pagado + "]";
	}


	
	
}
