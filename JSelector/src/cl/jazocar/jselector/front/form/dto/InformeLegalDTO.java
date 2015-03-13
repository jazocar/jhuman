package cl.jazocar.jselector.front.form.dto;

import java.util.Date;

import cl.jazocar.jselector.dto.ResponseDTO;

public class InformeLegalDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;

	private int id;
	private int idSolicitud;
	private String tipoCliente;
	private int    idBanco;
	private String sucursal;
	private String telefono;
	private String ejecutivo;
	private String email;
	private Date   fecha;
	private String autCargoCtaCte; 
	private String sucursalProvision;
	private String fondosCtaN;
	private int    monto;
	private String rut;
	private String numeroCliente;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String estadoCivil;
	private String telefonoCliente;
	private String emailCliente;
	private String razonSocial;
	
	
	public InformeLegalDTO() {
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getIdSolicitud() {
		return idSolicitud;
	}


	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}


	public String getTipoCliente() {
		return tipoCliente;
	}


	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}


	public int getIdBanco() {
		return idBanco;
	}


	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}


	public String getSucursal() {
		return sucursal;
	}


	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public String getEjecutivo() {
		return ejecutivo;
	}


	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getAutCargoCtaCte() {
		return autCargoCtaCte;
	}


	public void setAutCargoCtaCte(String autCargoCtaCte) {
		this.autCargoCtaCte = autCargoCtaCte;
	}


	public String getSucursalProvision() {
		return sucursalProvision;
	}


	public void setSucursalProvision(String sucursalProvision) {
		this.sucursalProvision = sucursalProvision;
	}


	public String getFondosCtaN() {
		return fondosCtaN;
	}


	public void setFondosCtaN(String fondosCtaN) {
		this.fondosCtaN = fondosCtaN;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public String getRut() {
		return rut;
	}


	public void setRut(String rut) {
		this.rut = rut;
	}


	public String getNumeroCliente() {
		return numeroCliente;
	}


	public void setNumeroCliente(String numeroCliente) {
		this.numeroCliente = numeroCliente;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public String getTelefonoCliente() {
		return telefonoCliente;
	}


	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}


	public String getEmailCliente() {
		return emailCliente;
	}


	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	
	
	
	
	
}
