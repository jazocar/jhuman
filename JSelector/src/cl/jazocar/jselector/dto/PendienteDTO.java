/**
 * 
 */
package cl.jazocar.jselector.dto;

import java.util.Date;

/**
 * @author Diablo
 *
 */
public class PendienteDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	
	private int      id;
	private int      idSolicitud;
	private int      idTarea;
	private int      idRol;
	private Date     fechaInicio;
	private Date     fechaTermino;
	private Date     tiempoFinalizacion;
	private String   estado;
	private int      idUsuario;
	private boolean  asignada;
	private TareaDTO tareaAsociada;
	
	/**
	 * 
	 */
	public PendienteDTO() {
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
	 * @return the idSolicitud
	 */
	public int getIdSolicitud() {
		return idSolicitud;
	}
	/**
	 * @param idSolicitud the idSolicitud to set
	 */
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	/**
	 * @return the idTarea
	 */
	public int getIdTarea() {
		return idTarea;
	}
	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	/**
	 * @return the idRol
	 */
	public int getIdRol() {
		return idRol;
	}
	/**
	 * @param idRol the idRol to set
	 */
	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}
	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}
	/**
	 * @return the tiempoFinalizacion
	 */
	public Date getTiempoFinalizacion() {
		return tiempoFinalizacion;
	}
	/**
	 * @param tiempoFinalizacion the tiempoFinalizacion to set
	 */
	public void setTiempoFinalizacion(Date tiempoFinalizacion) {
		this.tiempoFinalizacion = tiempoFinalizacion;
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
	/**
	 * @return the idUsuario
	 */
	public int getIdUsuario() {
		return idUsuario;
	}
	/**
	 * @param idUsuario the idUsuario to set
	 */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	/**
	 * @return the asignada
	 */
	public boolean isAsignada() {
		return asignada;
	}
	/**
	 * @param asignada the asignada to set
	 */
	public void setAsignada(boolean asignada) {
		this.asignada = asignada;
	}


	/**
	 * @return the tareaAsociada
	 */
	public TareaDTO getTareaAsociada() {
		return tareaAsociada;
	}


	/**
	 * @param tareaAsociada the tareaAsociada to set
	 */
	public void setTareaAsociada(TareaDTO tareaAsociada) {
		this.tareaAsociada = tareaAsociada;
	}
	
}
