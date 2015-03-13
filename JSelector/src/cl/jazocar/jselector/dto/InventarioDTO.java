/**
 * 
 */
package cl.jazocar.jselector.dto;

/**
 * @author Diablo
 *
 */
public class InventarioDTO {
	
	private int    id;
	private String nombre;
	private String descripcion;
	private int    estado;
	private String estadoDescripcion;
	private String fechaCreacion;
	private String sucursal;
	private String direccion;
	private String emailContacto;
	private int    idResponsable;
		
	/**
	 * @param nombre
	 * @param descripcion
	 * @param sucursal
	 * @param direccion
	 * @param emailContacto
	 * @param idResponsable
	 */
	public InventarioDTO(String nombre, String descripcion, String sucursal,
			String direccion, String emailContacto, int idResponsable) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.sucursal = sucursal;
		this.direccion = direccion;
		this.emailContacto = emailContacto;
		this.idResponsable = idResponsable;
	}
	/**
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param estado
	 * @param estadoDescripcion
	 * @param fechaCreacion
	 * @param sucursal
	 * @param direccion
	 * @param emailContacto
	 * @param idResponsable
	 */
	public InventarioDTO(int id, String nombre, String descripcion, int estado,
			String estadoDescripcion, String fechaCreacion, String sucursal,
			String direccion, String emailContacto, int idResponsable) {
		
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estado = estado;
		this.estadoDescripcion = estadoDescripcion;
		this.fechaCreacion = fechaCreacion;
		this.sucursal = sucursal;
		this.direccion = direccion;
		this.emailContacto = emailContacto;
		this.idResponsable = idResponsable;
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
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}
	/**
	 * @return the estadoDescripcion
	 */
	public String getEstadoDescripcion() {
		return estadoDescripcion;
	}
	/**
	 * @param estadoDescripcion the estadoDescripcion to set
	 */
	public void setEstadoDescripcion(String estadoDescripcion) {
		this.estadoDescripcion = estadoDescripcion;
	}
	/**
	 * @return the fechaCreacion
	 */
	public String getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the emailContacto
	 */
	public String getEmailContacto() {
		return emailContacto;
	}
	/**
	 * @param emailContacto the emailContacto to set
	 */
	public void setEmailContacto(String emailContacto) {
		this.emailContacto = emailContacto;
	}
	/**
	 * @return the idResponsable
	 */
	public int getIdResponsable() {
		return idResponsable;
	}
	/**
	 * @param idResponsable the idResponsable to set
	 */
	public void setIdResponsable(int idResponsable) {
		this.idResponsable = idResponsable;
	}
	
	
	
	
	
	
}
