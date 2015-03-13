/**
 * 
 */
package cl.jazocar.jselector.dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Diablo
 *
 */
public class CasoDTO extends ResponseDTO{
	
	private int id;
	private String         aplicacion;
	private String  	   aplicacionVersion;
	private String         iniciadoPor;
	private Date           iniciadoEn;
	private String         strIniciadoEn;
	private List<TareaDTO> listaTareasPorHacer;
	private List<TareaDTO> listaTareasHechas;  	
	
	/**
	 * @param aplicacion
	 * @param iniciadoPor
	 * @param iniciadoEn
	 * @param listaTareasPorHacer
	 * @param listaTareasHechas
	 */
	public CasoDTO(String aplicacion, String aplicacionVersion, String iniciadoPor, Date iniciadoEn,
			List<TareaDTO> listaTareasPorHacer, List<TareaDTO> listaTareasHechas) {
		this.aplicacion = aplicacion;
		this.aplicacionVersion = aplicacionVersion;
		this.iniciadoPor = iniciadoPor;
		this.iniciadoEn = iniciadoEn;
		this.listaTareasPorHacer = listaTareasPorHacer;
		this.listaTareasHechas = listaTareasHechas;
	}
	/**
	 * @param id
	 * @param aplicacion
	 * @param iniciadoPor
	 * @param iniciadoEn
	 * @param listaTareasPorHacer
	 * @param listaTareasHechas
	 */
	public CasoDTO(int id, String aplicacion, String aplicacionVersion, String iniciadoPor,
			Date iniciadoEn, List<TareaDTO> listaTareasPorHacer,
			List<TareaDTO> listaTareasHechas) {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		this.id = id;
		this.aplicacion = aplicacion;
		this.aplicacionVersion = aplicacionVersion;
		this.iniciadoPor = iniciadoPor;
		this.iniciadoEn = iniciadoEn;
		this.strIniciadoEn = format.format(iniciadoEn);
		this.listaTareasPorHacer = listaTareasPorHacer;
		this.listaTareasHechas = listaTareasHechas;
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
	 * @return the iniciadoPor
	 */
	public String getIniciadoPor() {
		return iniciadoPor;
	}
	/**
	 * @param iniciadoPor the iniciadoPor to set
	 */
	public void setIniciadoPor(String iniciadoPor) {
		this.iniciadoPor = iniciadoPor;
	}
	/**
	 * @return the iniciadoEn
	 */
	public Date getIniciadoEn() {
		return iniciadoEn;
	}
	/**
	 * @param iniciadoEn the iniciadoEn to set
	 */
	public void setIniciadoEn(Date iniciadoEn) {
		this.iniciadoEn = iniciadoEn;
	}
	/**
	 * @return the listaTareasPorHacer
	 */
	public List<TareaDTO> getListaTareasPorHacer() {
		return listaTareasPorHacer;
	}
	/**
	 * @param listaTareasPorHacer the listaTareasPorHacer to set
	 */
	public void setListaTareasPorHacer(List<TareaDTO> listaTareasPorHacer) {
		this.listaTareasPorHacer = listaTareasPorHacer;
	}
	/**
	 * @return the listaTareasHechas
	 */
	public List<TareaDTO> getListaTareasHechas() {
		return listaTareasHechas;
	}
	/**
	 * @param listaTareasHechas the listaTareasHechas to set
	 */
	public void setListaTareasHechas(List<TareaDTO> listaTareasHechas) {
		this.listaTareasHechas = listaTareasHechas;
	}
	/**
	 * @return the strIniciadoEn
	 */
	public String getStrIniciadoEn() {
		return strIniciadoEn;
	}
	/**
	 * @param strIniciadoEn the strIniciadoEn to set
	 */
	public void setStrIniciadoEn(String strIniciadoEn) {
		this.strIniciadoEn = strIniciadoEn;
	}
	/**
	 * @return the aplicacionVersion
	 */
	public String getAplicacionVersion() {
		return aplicacionVersion;
	}
	/**
	 * @param aplicacionVersion the aplicacionVersion to set
	 */
	public void setAplicacionVersion(String aplicacionVersion) {
		this.aplicacionVersion = aplicacionVersion;
	}
	
	
	
}
