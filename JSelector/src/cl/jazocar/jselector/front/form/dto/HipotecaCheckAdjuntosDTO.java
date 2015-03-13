package cl.jazocar.jselector.front.form.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

public class HipotecaCheckAdjuntosDTO extends ResponseDTO{
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int idHipoteca;
	private String nombre;
	private String ruta;
	/**
	 * 
	 */
	public HipotecaCheckAdjuntosDTO() {
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
	public String getRuta() {
		return ruta;
	}
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
