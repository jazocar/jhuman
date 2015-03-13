package cl.jazocar.jselector.dto;

public class EmpresaDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;

	private int    id;
	private String nombre;
	private String descripcion;
	private int    idOrganizacion;	
	
	/**
	 * @param mensaje
	 * @param estado
	 */
	public EmpresaDTO() {
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
	public int getIdOrganizacion() {
		return idOrganizacion;
	}
	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}
	
	
}
