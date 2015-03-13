package cl.jazocar.jselector.front.form.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

public class VendedorGaranteDTO extends ResponseDTO{

	private int    id;
	private int    idHipoteca;
	private String nombre;
	private String rut;
	/**
	 * 
	 */
	public VendedorGaranteDTO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdHipoteca() {
		return idHipoteca;
	}
	public void setIdHipoteca(int idHipoteca) {
		this.idHipoteca = idHipoteca;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	
}
