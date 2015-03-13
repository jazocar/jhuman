package cl.jazocar.jselector.sys.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

public class RolProcesoDTO extends ResponseDTO{

	private int id;
	private String nombre;
	private String descripcion;
	
	/**
	 * 
	 */
	public RolProcesoDTO() {
	}

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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}	
	
}
