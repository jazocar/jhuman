/**
 * 
 */
package cl.jazocar.jselector.dto;

/**
 * @author Diablo
 *
 */
public class BodegaDTO extends ResponseDTO{

	private int id;
	private String codigo;
	private String sucursal;
	private String descripcion;
	private String direccion;
	private String telefono;
	private String email;
	private String estado;
	
	
	
	
	/**
	 * @param mensaje
	 * @param estado
	 */
	public BodegaDTO() {
		
	}
	/**
	 * @param mensaje
	 * @param estado
	 * @param id
	 * @param codigo
	 * @param sucursal
	 * @param descripcion
	 * @param direccion
	 * @param telefono
	 * @param email
	 */
	public BodegaDTO(int id, String codigo,
			String sucursal, String descripcion, String direccion,
			String telefono, String email) {
		this.id = id;
		this.codigo = codigo;
		this.sucursal = sucursal;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	/**
	 * @param mensaje
	 * @param estado
	 * @param codigo
	 * @param sucursal
	 * @param descripcion
	 * @param direccion
	 * @param telefono
	 * @param email
	 */
	public BodegaDTO(String codigo,
			String sucursal, String descripcion, String direccion,
			String telefono, String email) {
		this.codigo = codigo;
		this.sucursal = sucursal;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}
	/**
	 * @param id
	 * @param codigo
	 * @param sucursal
	 * @param descripcion
	 * @param direccion
	 * @param telefono
	 * @param email
	 * @param estado
	 */
	public BodegaDTO(int id, String codigo, String sucursal,
			String descripcion, String direccion, String telefono,
			String email, String estado) {
		this.id = id;
		this.codigo = codigo;
		this.sucursal = sucursal;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
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
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
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
