package cl.jazocar.jselector.sys.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

public class RolDTO extends ResponseDTO{

	private int id;
	private String nombreRol;
	private String estado;	
	
	/**
	 * 
	 */
	public RolDTO() {
	}
	
	
	/**
	 * @param nombreRol
	 */
	public RolDTO(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	/**
	 * @param id
	 * @param nombreRol
	 * @param estado
	 */
	public RolDTO(int id, String nombreRol, String estado) {
		this.id = id;
		this.nombreRol = nombreRol;
		this.estado = estado;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nombreRol
	 */
	public String getNombreRol() {
		return nombreRol;
	}
	/**
	 * @param nombreRol the nombreRol to set
	 */
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
