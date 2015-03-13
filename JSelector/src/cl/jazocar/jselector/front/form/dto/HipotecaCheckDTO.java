/**
 * 
 */
package cl.jazocar.jselector.front.form.dto;

import java.util.List;

import cl.jazocar.jselector.dto.ResponseDTO;

/**
 * @author Diablo
 *
 */
public class HipotecaCheckDTO extends ResponseDTO {

	private static final long serialVersionUID = 1L;
	private int id;
	private int idHipoteca;
	private String tasacion;
	private String insDomVig;
	private String certMatSol;
	private String certHipGrav;
	private String persEscPoder;
	private String certAfecUtil;
	private String infExpServiu;
	private String escPropCli;
	private String otrosDoc;
	private List<HipotecaCheckAdjuntosDTO> listaAdjuntos;
	
	public HipotecaCheckDTO() {
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdHipoteca() {
		return idHipoteca;
	}
	public void setIdHipoteca(int idHipoteca) {
		this.idHipoteca = idHipoteca;
	}
	public String getTasacion() {
		return tasacion;
	}
	public void setTasacion(String tasacion) {
		this.tasacion = tasacion;
	}
	public String getInsDomVig() {
		return insDomVig;
	}
	public void setInsDomVig(String insDomVig) {
		this.insDomVig = insDomVig;
	}
	public String getCertMatSol() {
		return certMatSol;
	}
	public void setCertMatSol(String certMatSol) {
		this.certMatSol = certMatSol;
	}
	public String getCertHipGrav() {
		return certHipGrav;
	}
	public void setCertHipGrav(String certHipGrav) {
		this.certHipGrav = certHipGrav;
	}
	public String getPersEscPoder() {
		return persEscPoder;
	}
	public void setPersEscPoder(String persEscPoder) {
		this.persEscPoder = persEscPoder;
	}
	public String getCertAfecUtil() {
		return certAfecUtil;
	}
	public void setCertAfecUtil(String certAfecUtil) {
		this.certAfecUtil = certAfecUtil;
	}
	public String getInfExpServiu() {
		return infExpServiu;
	}
	public void setInfExpServiu(String infExpServiu) {
		this.infExpServiu = infExpServiu;
	}
	public String getEscPropCli() {
		return escPropCli;
	}
	public void setEscPropCli(String escPropCli) {
		this.escPropCli = escPropCli;
	}
	public String getOtrosDoc() {
		return otrosDoc;
	}
	public void setOtrosDoc(String otrosDoc) {
		this.otrosDoc = otrosDoc;
	}

	public List<HipotecaCheckAdjuntosDTO> getListaAdjuntos() {
		return listaAdjuntos;
	}

	public void setListaAdjuntos(List<HipotecaCheckAdjuntosDTO> listaAdjuntos) {
		this.listaAdjuntos = listaAdjuntos;
	}	
	
}
