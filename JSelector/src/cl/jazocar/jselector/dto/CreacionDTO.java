/**
 * 
 */
package cl.jazocar.jselector.dto;

/**
 * @author Diablo
 *
 */
public class CreacionDTO extends ResponseDTO{

	private int    id;
	private int    idAplicacion;
	private int    idTareaInicio;
	private int    idTareaExito;
	private int    idTareaRechazo;
	private String esCondicional;
	private String tipoDestino;
	private String tipoAsociacion;
	private int    organizacion;

	
	public CreacionDTO(){
		
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
	 * @return the idAplicacion
	 */
	public int getIdAplicacion() {
		return idAplicacion;
	}

	/**
	 * @param idAplicacion the idAplicacion to set
	 */
	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	/**
	 * @return the idTareaInicio
	 */
	public int getIdTareaInicio() {
		return idTareaInicio;
	}

	/**
	 * @param idTareaInicio the idTareaInicio to set
	 */
	public void setIdTareaInicio(int idTareaInicio) {
		this.idTareaInicio = idTareaInicio;
	}

	/**
	 * @return the idTareaExito
	 */
	public int getIdTareaExito() {
		return idTareaExito;
	}

	/**
	 * @param idTareaExito the idTareaExito to set
	 */
	public void setIdTareaExito(int idTareaExito) {
		this.idTareaExito = idTareaExito;
	}

	/**
	 * @return the idTareaRechazo
	 */
	public int getIdTareaRechazo() {
		return idTareaRechazo;
	}

	/**
	 * @param idTareaRechazo the idTareaRechazo to set
	 */
	public void setIdTareaRechazo(int idTareaRechazo) {
		this.idTareaRechazo = idTareaRechazo;
	}

	/**
	 * @return the esCondicional
	 */
	public String getEsCondicional() {
		return esCondicional;
	}

	/**
	 * @param esCondicional the esCondicional to set
	 */
	public void setEsCondicional(String esCondicional) {
		this.esCondicional = esCondicional;
	}

	/**
	 * @return the tipoDestino
	 */
	public String getTipoDestino() {
		return tipoDestino;
	}

	/**
	 * @param tipoDestino the tipoDestino to set
	 */
	public void setTipoDestino(String tipoDestino) {
		this.tipoDestino = tipoDestino;
	}

	public String getTipoAsociacion() {
		return tipoAsociacion;
	}

	public void setTipoAsociacion(String tipoAsociacion) {
		this.tipoAsociacion = tipoAsociacion;
	}

	public int getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(int organizacion) {
		this.organizacion = organizacion;
	}
	
	
}
