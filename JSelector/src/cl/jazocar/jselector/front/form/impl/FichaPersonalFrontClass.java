package cl.jazocar.jselector.front.form.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.CiudadDTO;
import cl.jazocar.jselector.dto.ComunaDTO;
import cl.jazocar.jselector.dto.ListaDTO;
import cl.jazocar.jselector.dto.RegionDTO;
import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.front.form.dto.FichaPersonalDTO;

@ManagedBean (name = "fichaPersonalFrontClass")
@SessionScoped
public class FichaPersonalFrontClass extends AplicationAbstract {
	
	private FichaPersonalDTO fichaPersonalDto;
	
	private List<SelectItem> listaSexo;
	private List<SelectItem> listaEstadoCivil;
	private List<SelectItem> listaDiscapacidad;
	private List<SelectItem> listaSituacionMilitar;
	private List<SelectItem> listaPaises;
	private List<SelectItem> listaRegiones;
	private List<SelectItem> listaCiudades;
	private List<SelectItem> listaComunas;
	
	private int    idEmpleado;
	private String rutaImagen;
	private String rut;
	private String apPaterno;
	private String apMaterno;
	private String nombres;
	private String sexo;
	private String estCivil;
	private String discapacidad;
	private Date   fecNac;
	private String idPais;
	private String sitMilitar;
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
	private String idRegion;
    private String idComuna;
    private String idCiudad;

	public FichaPersonalFrontClass(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaRegiones 		   = new ArrayList<SelectItem>();
		listaCiudades 		   = new ArrayList<SelectItem>();
		listaComunas  		   = new ArrayList<SelectItem>();
		
		listaSexo  			   = new ArrayList<SelectItem>();
		listaEstadoCivil       = new ArrayList<SelectItem>();
		listaDiscapacidad      = new ArrayList<SelectItem>();
		listaSituacionMilitar  = new ArrayList<SelectItem>();
		listaPaises            = new ArrayList<SelectItem>();
		
		for(RegionDTO region : configJProcessService.selectRegiones())
			listaRegiones.add(new SelectItem(region.getId(), region.getNombre()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(48))
			listaSexo.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(49))
			listaEstadoCivil.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(52))
			listaDiscapacidad.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(53))
			listaSituacionMilitar.add(new SelectItem(lista.getId(), lista.getValor()));		
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(54))
			listaPaises.add(new SelectItem(lista.getId(), lista.getValor()));			
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		fichaPersonalDto = new FichaPersonalDTO();
		fichaPersonalDto.setRutaImagen(rutaImagen);
		fichaPersonalDto.setRut(rut);
		fichaPersonalDto.setApPaterno(apPaterno);
		fichaPersonalDto.setApMaterno(apMaterno);
		fichaPersonalDto.setNombres(nombres);
		fichaPersonalDto.setSexo(Integer.parseInt(sexo));
		fichaPersonalDto.setEstCivil(Integer.parseInt(estCivil));
		fichaPersonalDto.setDiscapacidad(Integer.parseInt(discapacidad));
		fichaPersonalDto.setFecNac(fecNac);
		fichaPersonalDto.setIdPais(Integer.parseInt(idPais));
		fichaPersonalDto.setSitMilitar(Integer.parseInt(sitMilitar));
		fichaPersonalDto.setCalle(calle);
		fichaPersonalDto.setNumero(numero);
		fichaPersonalDto.setVilla(villa);
		fichaPersonalDto.setCalleRef(calleRef);
		fichaPersonalDto.setCodPostal(codPostal);
		fichaPersonalDto.setFonoMovil(fonoMovil);
		fichaPersonalDto.setTelefonoFijo(telefonoFijo);
		fichaPersonalDto.setEmailEmpresa(emailEmpresa);
		fichaPersonalDto.setEmailPersonal(emailPersonal);
		fichaPersonalDto.setFonoEmergencia(fonoEmergencia);
		fichaPersonalDto.setIdRegion(Integer.parseInt(idRegion));
		fichaPersonalDto.setIdCiudad(Integer.parseInt(idCiudad));
		fichaPersonalDto.setIdComuna(Integer.parseInt(idComuna));
	
		formService.insertFichaPersonal(fichaPersonalDto);
		resetObject();
	}

	@Override
	public void updateObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		fichaPersonalDto = new FichaPersonalDTO();
		fichaPersonalDto.setIdEmpleado(idEmpleado);
		fichaPersonalDto.setRutaImagen(rutaImagen);
		fichaPersonalDto.setRut(rut);
		fichaPersonalDto.setApPaterno(apPaterno);
		fichaPersonalDto.setApMaterno(apMaterno);
		fichaPersonalDto.setNombres(nombres);
		fichaPersonalDto.setSexo(Integer.parseInt(sexo));
		fichaPersonalDto.setEstCivil(Integer.parseInt(estCivil));
		fichaPersonalDto.setDiscapacidad(Integer.parseInt(discapacidad));
		fichaPersonalDto.setFecNac(fecNac);
		fichaPersonalDto.setIdPais(Integer.parseInt(idPais));
		fichaPersonalDto.setSitMilitar(Integer.parseInt(sitMilitar));
		fichaPersonalDto.setCalle(calle);
		fichaPersonalDto.setNumero(numero);
		fichaPersonalDto.setVilla(villa);
		fichaPersonalDto.setCalleRef(calleRef);
		fichaPersonalDto.setCodPostal(codPostal);
		fichaPersonalDto.setFonoMovil(fonoMovil);
		fichaPersonalDto.setTelefonoFijo(telefonoFijo);
		fichaPersonalDto.setEmailEmpresa(emailEmpresa);
		fichaPersonalDto.setEmailPersonal(emailPersonal);
		fichaPersonalDto.setFonoEmergencia(fonoEmergencia);
		fichaPersonalDto.setIdRegion(Integer.parseInt(idRegion));
		fichaPersonalDto.setIdCiudad(Integer.parseInt(idCiudad));
		fichaPersonalDto.setIdComuna(Integer.parseInt(idComuna));
	
		formService.updateFichaPersonal(fichaPersonalDto);
		resetObject();
	}

	@Override
	public void deleteObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		fichaPersonalDto = new FichaPersonalDTO();
		fichaPersonalDto.setIdEmpleado(idEmpleado);
	
		formService.updateFichaPersonal(fichaPersonalDto);
		resetObject();
	}

	@Override
	public void resetObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		resetObject();
	}

	@Override
	public void searchObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetObject() {
		// TODO Auto-generated method stub
		idEmpleado     = 0;
		rutaImagen     = "";
		rut            = "";
		apPaterno      = "";
		apMaterno      = "";
		nombres        = "";
		sexo           = "-1";
		estCivil       = "-1";
		discapacidad   = "-1";
		fecNac         = null;
		idPais         = "-1";
		sitMilitar     = "-1";
		calle          = "";
		numero         = "";
		villa          = "";
		calleRef       = "";
		codPostal      = "";
		fonoMovil      = "";
		telefonoFijo   = "";
		emailEmpresa   = "";
		emailPersonal  = "";
		fonoEmergencia = "";
		idRegion       = "-1";
	    idComuna       = "-1";
	    idCiudad       = "-1";
	    
	    listaRegiones = new ArrayList<SelectItem>();
		listaCiudades = new ArrayList<SelectItem>();
		listaComunas  = new ArrayList<SelectItem>();
		
		for(RegionDTO region : configJProcessService.selectRegiones())
			listaRegiones.add(new SelectItem(region.getId(), region.getNombre()));	
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub

	}
	
	
	public void changeRegionListener(ValueChangeEvent evnt) {
		String estado = evnt.getNewValue().toString();
		listaCiudades = new ArrayList<SelectItem>();
		
		for(CiudadDTO ciudad : configJProcessService.selectCiudadesByRegion(Integer.parseInt(estado)))
			listaCiudades.add(new SelectItem(ciudad.getId(), ciudad.getNombre()));		
	}
	
	public void changeProvinciaListener(ValueChangeEvent evnt) {
		if(evnt != null){
			String estado = evnt.getNewValue().toString();
			listaComunas = new ArrayList<SelectItem>();
			
			List<ComunaDTO> lista = configJProcessService.selectComunasByProvincia(Integer.parseInt(estado));
			
			if(lista != null){
			for(ComunaDTO comuna : lista)
				listaComunas.add(new SelectItem(comuna.getId(), comuna.getNombre()));		
			}
		}
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

	public String getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	public String getIdComuna() {
		return idComuna;
	}

	public void setIdComuna(String idComuna) {
		this.idComuna = idComuna;
	}

	public String getIdCiudad() {
		return idCiudad;
	}

	public void setIdCiudad(String idCiudad) {
		this.idCiudad = idCiudad;
	}

	public FichaPersonalDTO getFichaPersonalDto() {
		return fichaPersonalDto;
	}

	public void setFichaPersonalDto(FichaPersonalDTO fichaPersonalDto) {
		this.fichaPersonalDto = fichaPersonalDto;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEstCivil() {
		return estCivil;
	}

	public void setEstCivil(String estCivil) {
		this.estCivil = estCivil;
	}

	public String getDiscapacidad() {
		return discapacidad;
	}

	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public String getIdPais() {
		return idPais;
	}

	public void setIdPais(String idPais) {
		this.idPais = idPais;
	}

	public String getSitMilitar() {
		return sitMilitar;
	}

	public void setSitMilitar(String sitMilitar) {
		this.sitMilitar = sitMilitar;
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

	public List<SelectItem> getListaSexo() {
		return listaSexo;
	}

	public void setListaSexo(List<SelectItem> listaSexo) {
		this.listaSexo = listaSexo;
	}

	public List<SelectItem> getListaEstadoCivil() {
		return listaEstadoCivil;
	}

	public void setListaEstadoCivil(List<SelectItem> listaEstadoCivil) {
		this.listaEstadoCivil = listaEstadoCivil;
	}

	public List<SelectItem> getListaDiscapacidad() {
		return listaDiscapacidad;
	}

	public void setListaDiscapacidad(List<SelectItem> listaDiscapacidad) {
		this.listaDiscapacidad = listaDiscapacidad;
	}

	public List<SelectItem> getListaSituacionMilitar() {
		return listaSituacionMilitar;
	}

	public void setListaSituacionMilitar(List<SelectItem> listaSituacionMilitar) {
		this.listaSituacionMilitar = listaSituacionMilitar;
	}

	public List<SelectItem> getListaPaises() {
		return listaPaises;
	}

	public void setListaPaises(List<SelectItem> listaPaises) {
		this.listaPaises = listaPaises;
	}	
	
	
}
