/**
 * 
 */
package cl.jazocar.jselector.dto;

import java.util.List;

/**
 * @author Diablo
 *
 */
public class TareaDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	
	private int    id;
	private String nombre;
	private String descripcion;
	private String prioridad;
	private String tipoTarea;
	private int    duracion;
	private String tipoDuracion;
	private int    idOrganizacion;
	private String tipoAsignacion;
	private int    idRolAsignacion;	
	private String tieneFormulario;
	private List<TareaConfiguracionDTO> listaConfiguracion;
		
	/**
	 * 
	 */
	public TareaDTO() {
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
	 * @return the prioridad
	 */
	public String getPrioridad() {
		return prioridad;
	}

	/**
	 * @param prioridad the prioridad to set
	 */
	public void setPrioridad(String prioridad) {
		this.prioridad = prioridad;
	}

	/**
	 * @return the tipoTarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}

	/**
	 * @param tipoTarea the tipoTarea to set
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	/**
	 * @return the duracion
	 */
	public int getDuracion() {
		return duracion;
	}

	/**
	 * @param duracion the duracion to set
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	/**
	 * @return the tipoDuracion
	 */
	public String getTipoDuracion() {
		return tipoDuracion;
	}

	/**
	 * @param tipoDuracion the tipoDuracion to set
	 */
	public void setTipoDuracion(String tipoDuracion) {
		this.tipoDuracion = tipoDuracion;
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
	 * @return the tipoAsignacion
	 */
	public String getTipoAsignacion() {
		return tipoAsignacion;
	}

	/**
	 * @param tipoAsignacion the tipoAsignacion to set
	 */
	public void setTipoAsignacion(String tipoAsignacion) {
		this.tipoAsignacion = tipoAsignacion;
	}

	/**
	 * @return the idRolAsignacion
	 */
	public int getIdRolAsignacion() {
		return idRolAsignacion;
	}

	/**
	 * @param idRolAsignacion the idRolAsignacion to set
	 */
	public void setIdRolAsignacion(int idRolAsignacion) {
		this.idRolAsignacion = idRolAsignacion;
	}

	/**
	 * @return the listaConfiguracion
	 */
	public List<TareaConfiguracionDTO> getListaConfiguracion() {
		return listaConfiguracion;
	}

	/**
	 * @param listaConfiguracion the listaConfiguracion to set
	 */
	public void setListaConfiguracion(List<TareaConfiguracionDTO> listaConfiguracion) {
		this.listaConfiguracion = listaConfiguracion;
	}

	public String getTieneFormulario() {
		return tieneFormulario;
	}

	public void setTieneFormulario(String tieneFormulario) {
		this.tieneFormulario = tieneFormulario;
	}
	
}
