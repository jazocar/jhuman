package cl.jazocar.jselector.dto;

public class RegionDTO extends ResponseDTO {

	private int id;
	private String nombre;
	private String descripcion;
	
	/**
	 * 
	 */
	public RegionDTO() {
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
