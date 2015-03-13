/**
 * 
 */
package cl.jazocar.jselector.dto;

import java.util.Date;

/**
 * @author Diablo
 *
 */
public class InventarioConceptoDTO extends ResponseDTO {

	private int id;
	private String nombre;
	private String descripcion;
	private Date   fechaCreacion;
	private String estado;
	
	/**
	 * @param mensaje
	 * @param estado
	 */
	public InventarioConceptoDTO() {
		
	}
	/**
	 * @param mensaje
	 * @param estado
	 * @param nombre
	 * @param descripcion
	 */
	public InventarioConceptoDTO(String nombre,
			String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}
	/**
	 * @param mensaje
	 * @param estado
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param fechaCreacion
	 * @param estado2
	 */
	public InventarioConceptoDTO(int id,
			String nombre, String descripcion, Date fechaCreacion,
			String estadoConcepto) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
		this.estado = estadoConcepto;
	}
	
	
	/**
	 * @param mensaje
	 * @param estado
	 * @param id
	 * @param nombre
	 * @param descripcion
	 */
	public InventarioConceptoDTO(int id,
			String nombre, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
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
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
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
