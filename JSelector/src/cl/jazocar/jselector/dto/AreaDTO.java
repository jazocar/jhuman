/**
 * 
 */
package cl.jazocar.jselector.dto;

/**
 * @author Diablo
 *
 */
public class AreaDTO extends ResponseDTO{

	private int id;
	private int idOrganizacion;
	private String nombre;
	private String descripcion;
	
	
	
	/**
	 * 
	 */
	public AreaDTO() {
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
	 * @return the idOrganizacion
	 */
	public int getIdOrganizacion() {
		return idOrganizacion;
	}
	/**
	 * @param idOrganizacion the idOrganizacion to set
	 */
	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
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
	
	
}
