/**
 * 
 */
package cl.jazocar.jselector.dto;


/**
 * @author Diablo
 *
 */
public class RecursosDTO extends ResponseDTO{
	
	/**
	 * 
	 */
	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	private int    idRecurso;
	private String nombreRecurso;
	private String descripcion;
	private int    cantidad;
	private int    idCategoria;
	private String idEstado;
	private String responsable;
	
	
	
	public RecursosDTO() {
		
	}
	
	
	public RecursosDTO(int idRecurso, String nombreRecurso, String descripcion,
			int cantidad, int idCategoria, String idEstado, String responsable) {
		super();
		this.idRecurso = idRecurso;
		this.nombreRecurso = nombreRecurso;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.idCategoria = idCategoria;
		this.idEstado = idEstado;
		this.responsable = responsable;
	}
	/**
	 * @return the idRecurso
	 */
	public int getIdRecurso() {
		return idRecurso;
	}
	/**
	 * @param idRecurso the idRecurso to set
	 */
	public void setIdRecurso(int idRecurso) {
		this.idRecurso = idRecurso;
	}
	/**
	 * @return the nombreRecurso
	 */
	public String getNombreRecurso() {
		return nombreRecurso;
	}
	/**
	 * @param nombreRecurso the nombreRecurso to set
	 */
	public void setNombreRecurso(String nombreRecurso) {
		this.nombreRecurso = nombreRecurso;
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
	 * @return the cantidad
	 */
	public int getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the idCategoria
	 */
	public int getIdCategoria() {
		return idCategoria;
	}
	/**
	 * @param idCategoria the idCategoria to set
	 */
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	/**
	 * @return the idEstado
	 */
	public String getIdEstado() {
		return idEstado;
	}
	/**
	 * @param idEstado the idEstado to set
	 */
	public void setIdEstado(String idEstado) {
		this.idEstado = idEstado;
	}
	/**
	 * @return the responsable
	 */
	public String getResponsable() {
		return responsable;
	}
	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}

	
}


