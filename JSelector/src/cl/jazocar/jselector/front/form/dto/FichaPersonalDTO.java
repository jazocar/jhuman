package cl.jazocar.jselector.front.form.dto;

import java.util.Date;

import cl.jazocar.jselector.dto.ResponseDTO;

public class FichaPersonalDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	private int    idEmpleado;
	private String rutaImagen;
	private String rut;
	private String apPaterno;
	private String apMaterno;
	private String nombres;
	private int    sexo;
	private int    estCivil;
	private int    discapacidad;
	private Date   fecNac;
	private int    idCiudad;
	private int    idComuna;
	private int    idRegion;
	private int    idPais;
	private int    sitMilitar;
	private String calle;
	private String numero;
	private String villa;
	private String calleRef;
	private String codPostal;
	private String fonoMovil;
	private String telefonoFijo;
	private String emailEmpresa;
	private String emailPersonal;
	private String fonoEmergencia;
	/**
	 * 
	 */
	public FichaPersonalDTO() {
	}
	public int getIdEmpleado() {
		return idEmpleado;
	}
	public void setIdEmpleado(int idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	public String getRutaImagen() {
		return rutaImagen;
	}
	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public String getApPaterno() {
		return apPaterno;
	}
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}
	public String getApMaterno() {
		return apMaterno;
	}
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	
	public int getDiscapacidad() {
		return discapacidad;
	}
	public void setDiscapacidad(int discapacidad) {
		this.discapacidad = discapacidad;
	}
	public Date getFecNac() {
		return fecNac;
	}
	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public int getIdComuna() {
		return idComuna;
	}
	public void setIdComuna(int idComuna) {
		this.idComuna = idComuna;
	}
	public int getIdRegion() {
		return idRegion;
	}
	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getVilla() {
		return villa;
	}
	public void setVilla(String villa) {
		this.villa = villa;
	}
	public String getCalleRef() {
		return calleRef;
	}
	public void setCalleRef(String calleRef) {
		this.calleRef = calleRef;
	}
	public String getCodPostal() {
		return codPostal;
	}
	public void setCodPostal(String codPostal) {
		this.codPostal = codPostal;
	}
	public String getFonoMovil() {
		return fonoMovil;
	}
	public void setFonoMovil(String fonoMovil) {
		this.fonoMovil = fonoMovil;
	}
	public String getTelefonoFijo() {
		return telefonoFijo;
	}
	public void setTelefonoFijo(String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}
	public String getEmailEmpresa() {
		return emailEmpresa;
	}
	public void setEmailEmpresa(String emailEmpresa) {
		this.emailEmpresa = emailEmpresa;
	}
	public String getEmailPersonal() {
		return emailPersonal;
	}
	public void setEmailPersonal(String emailPersonal) {
		this.emailPersonal = emailPersonal;
	}
	public String getFonoEmergencia() {
		return fonoEmergencia;
	}
	public void setFonoEmergencia(String fonoEmergencia) {
		this.fonoEmergencia = fonoEmergencia;
	}
	public int getSexo() {
		return sexo;
	}
	public void setSexo(int sexo) {
		this.sexo = sexo;
	}
	public int getEstCivil() {
		return estCivil;
	}
	public void setEstCivil(int estCivil) {
		this.estCivil = estCivil;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public int getSitMilitar() {
		return sitMilitar;
	}
	public void setSitMilitar(int sitMilitar) {
		this.sitMilitar = sitMilitar;
	}	
}
