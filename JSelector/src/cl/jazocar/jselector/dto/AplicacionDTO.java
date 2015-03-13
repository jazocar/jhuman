/**
 * 
 */
package cl.jazocar.jselector.dto;

/**
 * @author Diablo
 *
 */
public class AplicacionDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	private int    id;
	private String aplicacion;
	private String descripcion;
	private String version;	
	private int    idTareaInicial;
	private int    idTareaFinal;
	private String tipoAsociacion;
	private boolean selected;
	
	
	public AplicacionDTO() {
		
	}
	/**
	 * @param aplicacion
	 * @param descripcion
	 * @param version
	 */
	public AplicacionDTO(String aplicacion, String descripcion, String version) {
		this.aplicacion = aplicacion;
		this.descripcion = descripcion;
		this.version = version;
	}
	/**
	 * @param id
	 * @param aplicacion
	 * @param descripcion
	 * @param version
	 */
	public AplicacionDTO(int id, String aplicacion, String descripcion,
			String version) {
		this.id = id;
		this.aplicacion = aplicacion;
		this.descripcion = descripcion;
		this.version = version;
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
	 * @return the aplicacion
	 */
	public String getAplicacion() {
		return aplicacion;
	}
	/**
	 * @param aplicacion the aplicacion to set
	 */
	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
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
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the idTareaInicial
	 */
	public int getIdTareaInicial() {
		return idTareaInicial;
	}
	/**
	 * @param idTareaInicial the idTareaInicial to set
	 */
	public void setIdTareaInicial(int idTareaInicial) {
		this.idTareaInicial = idTareaInicial;
	}
	/**
	 * @return the idTareaFinal
	 */
	public int getIdTareaFinal() {
		return idTareaFinal;
	}
	/**
	 * @param idTareaFinal the idTareaFinal to set
	 */
	public void setIdTareaFinal(int idTareaFinal) {
		this.idTareaFinal = idTareaFinal;
	}
	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}
	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getTipoAsociacion() {
		return tipoAsociacion;
	}
	public void setTipoAsociacion(String tipoAsociacion) {
		this.tipoAsociacion = tipoAsociacion;
	}	
}
