/**
 * 
 */
package cl.jazocar.jselector.dto;

import java.io.Serializable;

/**
 * @author Diablo
 *
 */
public class ResponseDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensajeResponse;
	private int    estadoResponse;
	/**
	 * @param mensaje
	 * @param estado
	 */
	public ResponseDTO(String mensaje, int estado) {
		this.mensajeResponse = mensaje;
		this.estadoResponse = estado;
	}
	
	
	/**
	 * 
	 */
	public ResponseDTO() {
	}


	/**
	 * @return the mensaje
	 */
	public String getMensajeResponse() {
		return mensajeResponse;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensajeResponse(String mensajeResponse) {
		this.mensajeResponse = mensajeResponse;
	}
	/**
	 * @return the estado
	 */
	public int getEstadoResponse() {
		return estadoResponse;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstadoResponse(int estadoResponse) {
		this.estadoResponse = estadoResponse;
	}
	
	
}
