package cl.jazocar.jselector.front.form.dto;

import java.util.List;

import cl.jazocar.jselector.dto.ResponseDTO;

public class AntecedentesPropiedadDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	private int id;
	private int idHipoteca;
	private String avCalle;
    private String numero;
    private String deptoCasaNumero;
    private int    idRegion;
    private int    idComuna;
    private int    idCiudad;
    private String propiedadHipotecada;
    private String acreedorHipotecario;
    private String rolAvaluo1;
    private String rolAvaluo2;
    private List<BodegaDTO> listaBodegas;
    private List<EstacionamientoDTO> listaEstacionamientos;


	public AntecedentesPropiedadDTO() {
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
	public String getAvCalle() {
		return avCalle;
	}
	public void setAvCalle(String avCalle) {
		this.avCalle = avCalle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getDeptoCasaNumero() {
		return deptoCasaNumero;
	}
	public void setDeptoCasaNumero(String deptoCasaNumero) {
		this.deptoCasaNumero = deptoCasaNumero;
	}
	public int getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}
	public int getIdComuna() {
		return idComuna;
	}
	public void setIdComuna(int idComuna) {
		this.idComuna = idComuna;
	}
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public String getPropiedadHipotecada() {
		return propiedadHipotecada;
	}
	public void setPropiedadHipotecada(String propiedadHipotecada) {
		this.propiedadHipotecada = propiedadHipotecada;
	}
	public String getAcreedorHipotecario() {
		return acreedorHipotecario;
	}
	public void setAcreedorHipotecario(String acreedorHipotecario) {
		this.acreedorHipotecario = acreedorHipotecario;
	}
	public String getRolAvaluo1() {
		return rolAvaluo1;
	}
	public void setRolAvaluo1(String rolAvaluo1) {
		this.rolAvaluo1 = rolAvaluo1;
	}
	public String getRolAvaluo2() {
		return rolAvaluo2;
	}
	public void setRolAvaluo2(String rolAvaluo2) {
		this.rolAvaluo2 = rolAvaluo2;
	}
	public List<BodegaDTO> getListaBodegas() {
		return listaBodegas;
	}
	public void setListaBodegas(List<BodegaDTO> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}
	public List<EstacionamientoDTO> getListaEstacionamientos() {
		return listaEstacionamientos;
	}
	public void setListaEstacionamientos(
			List<EstacionamientoDTO> listaEstacionamientos) {
		this.listaEstacionamientos = listaEstacionamientos;
	}   
    
	
}
