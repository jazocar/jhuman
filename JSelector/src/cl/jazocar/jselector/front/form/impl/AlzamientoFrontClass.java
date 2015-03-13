package cl.jazocar.jselector.front.form.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dto.EmpresaDTO;
import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.front.form.dto.InformeLegalDTO;

@ManagedBean (name = IConstants.ALZAMIENTO_FRONT_CLASS)
@SessionScoped
public class AlzamientoFrontClass  extends AplicationAbstract {

	private boolean selected;
	private boolean isJuridica;

	private static InformeLegalDTO informeLegal;
	
	private List<SelectItem> listaBancos;
	private List<SelectItem> listaRegiones;
	private List<SelectItem> listaCiudades;
	private List<SelectItem> listaComunas;
	
	private static int    idInformeLegal;
	private static String selectedTipoPersona;
	private static String tipoCliente;
	private static String idBanco;
	private static String sucursal;
	private static String telefono;
	private static String ejecutivo;
	private static String email;
	private static Date   fecha;
	private static String autCargoCtaCte; 
	private static String sucursalProvision;
	private static String fondosCtaN;
	private static String monto;
	private static String rutEmpresa;
	private static String rutPersona;
	private static String numeroClienteEmpresa;
	private static String numeroClientePersona;
	private static String nombre;
	private static String apellidoPaterno;
	private static String apellidoMaterno;
	private static String estadoCivil;
	private static String telefonoClienteEmpresa;
	private static String telefonoClientePersona;
	private static String emailClienteEmpresa;
	private static String emailClientePersona;
	private static String razonSocial;
	
	public static boolean formularioCompleto;
	
	//Mensajes.
	private String  mensaje;
	private boolean abrirPopUp;
	private String  rutaImagen;
	private boolean abrirPopUpConfirmacion;
	private boolean abrirPopUpError;
	
	public AlzamientoFrontClass(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		fecha = new Date();
		
		listaBancos   = new ArrayList<SelectItem>();
		listaRegiones = new ArrayList<SelectItem>();
		listaCiudades = new ArrayList<SelectItem>();
		listaComunas  = new ArrayList<SelectItem>();
		
		for(EmpresaDTO empresa : configJProcessService.selectEmpresasByOrganizacion(1))
			listaBancos.add(new SelectItem(empresa.getId(), empresa.getNombre()));
	}
	

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	public boolean isJuridica() {
		return isJuridica;
	}


	public void setJuridica(boolean isJuridica) {
		this.isJuridica = isJuridica;
	}


	public static InformeLegalDTO getInformeLegal() {
		return informeLegal;
	}


	public static void setInformeLegal(InformeLegalDTO informeLegal) {
		AlzamientoFrontClass.informeLegal = informeLegal;
	}


	public List<SelectItem> getListaBancos() {
		return listaBancos;
	}


	public void setListaBancos(List<SelectItem> listaBancos) {
		this.listaBancos = listaBancos;
	}


	public List<SelectItem> getListaRegiones() {
		return listaRegiones;
	}


	public void setListaRegiones(List<SelectItem> listaRegiones) {
		this.listaRegiones = listaRegiones;
	}


	public List<SelectItem> getListaCiudades() {
		return listaCiudades;
	}


	public void setListaCiudades(List<SelectItem> listaCiudades) {
		this.listaCiudades = listaCiudades;
	}


	public List<SelectItem> getListaComunas() {
		return listaComunas;
	}


	public void setListaComunas(List<SelectItem> listaComunas) {
		this.listaComunas = listaComunas;
	}


	public int getIdInformeLegal() {
		return idInformeLegal;
	}


	public void setIdInformeLegal(int idInformeLegal) {
		this.idInformeLegal = idInformeLegal;
	}


	public String getSelectedTipoPersona() {
		return selectedTipoPersona;
	}


	public void setSelectedTipoPersona(String selectedTipoPersona) {
		this.selectedTipoPersona = selectedTipoPersona;
	}


	public String getTipoCliente() {
		return tipoCliente;
	}


	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}


	public String getIdBanco() {
		return idBanco;
	}


	public void setIdBanco(String idBanco) {
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


	public String getMonto() {
		return monto;
	}


	public void setMonto(String monto) {
		this.monto = monto;
	}


	public String getRutEmpresa() {
		return rutEmpresa;
	}


	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}


	public String getRutPersona() {
		return rutPersona;
	}


	public void setRutPersona(String rutPersona) {
		this.rutPersona = rutPersona;
	}


	public String getNumeroClienteEmpresa() {
		return numeroClienteEmpresa;
	}


	public void setNumeroClienteEmpresa(String numeroClienteEmpresa) {
		this.numeroClienteEmpresa = numeroClienteEmpresa;
	}


	public String getNumeroClientePersona() {
		return numeroClientePersona;
	}


	public void setNumeroClientePersona(String numeroClientePersona) {
		this.numeroClientePersona = numeroClientePersona;
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


	public String getTelefonoClienteEmpresa() {
		return telefonoClienteEmpresa;
	}


	public void setTelefonoClienteEmpresa(String telefonoClienteEmpresa) {
		this.telefonoClienteEmpresa = telefonoClienteEmpresa;
	}


	public String getTelefonoClientePersona() {
		return telefonoClientePersona;
	}


	public void setTelefonoClientePersona(String telefonoClientePersona) {
		this.telefonoClientePersona = telefonoClientePersona;
	}


	public String getEmailClienteEmpresa() {
		return emailClienteEmpresa;
	}


	public void setEmailClienteEmpresa(String emailClienteEmpresa) {
		this.emailClienteEmpresa = emailClienteEmpresa;
	}


	public String getEmailClientePersona() {
		return emailClientePersona;
	}


	public void setEmailClientePersona(String emailClientePersona) {
		this.emailClientePersona = emailClientePersona;
	}


	public String getRazonSocial() {
		return razonSocial;
	}


	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public boolean isFormularioCompleto() {
		return formularioCompleto;
	}

	public void setFormularioCompleto(boolean formularioCompleto) {
		this.formularioCompleto = formularioCompleto;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isAbrirPopUp() {
		return abrirPopUp;
	}

	public void setAbrirPopUp(boolean abrirPopUp) {
		this.abrirPopUp = abrirPopUp;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public boolean isAbrirPopUpConfirmacion() {
		return abrirPopUpConfirmacion;
	}

	public void setAbrirPopUpConfirmacion(boolean abrirPopUpConfirmacion) {
		this.abrirPopUpConfirmacion = abrirPopUpConfirmacion;
	}

	public boolean isAbrirPopUpError() {
		return abrirPopUpError;
	}

	public void setAbrirPopUpError(boolean abrirPopUpError) {
		this.abrirPopUpError = abrirPopUpError;
	}

	
	
}
