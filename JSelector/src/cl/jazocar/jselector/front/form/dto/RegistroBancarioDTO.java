package cl.jazocar.jselector.front.form.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

public class RegistroBancarioDTO extends ResponseDTO {

	private static final long serialVersionUID = 1L;
	
	private int    id;
	private int    idEmpleado;
	private int    idEstado;
	private int    idBanco;
	private int    idProductoBanco;
	private String numeroCuenta;
	private String observaciones;
	
	/**
	 * 
	 */
	public RegistroBancarioDTO() {
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public int getIdProductoBanco() {
		return idProductoBanco;
	}
	public void setIdProductoBanco(int idProductoBanco) {
		this.idProductoBanco = idProductoBanco;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	
	

}
