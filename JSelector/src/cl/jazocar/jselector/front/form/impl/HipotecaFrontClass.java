package cl.jazocar.jselector.front.form.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;

import org.apache.commons.io.FileUtils;
import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;
import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dto.CiudadDTO;
import cl.jazocar.jselector.dto.ComunaDTO;
import cl.jazocar.jselector.dto.EmpresaDTO;
import cl.jazocar.jselector.dto.RegionDTO;
import cl.jazocar.jselector.dto.SolicitudFormularioDTO;
import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.front.form.dto.AntecedentesPropiedadDTO;
import cl.jazocar.jselector.front.form.dto.AvalDTO;
import cl.jazocar.jselector.front.form.dto.BodegaDTO;
import cl.jazocar.jselector.front.form.dto.EstacionamientoDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckAdjuntosDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaDTO;
import cl.jazocar.jselector.front.form.dto.InformeLegalDTO;
import cl.jazocar.jselector.front.form.dto.VendedorGaranteDTO;
import cl.jazocar.jselector.front.impl.NavigationBean;
import cl.jazocar.jselector.front.impl.ToDoFrontBean;
import cl.jazocar.jselector.front.impl.UsuarioFrontBean;

@ManagedBean(name = IConstants.HIPOTECA_FRONT_CLASS)
@SessionScoped
public class HipotecaFrontClass extends AplicationAbstract {

	private boolean selected;
	private boolean isJuridica;

	private static InformeLegalDTO informeLegal;
	
	private List<SelectItem> listaBancos;
	private List<SelectItem> listaRegiones;
	private List<SelectItem> listaCiudades;
	private List<SelectItem> listaComunas;
	
	//Atributos Transversales.
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
	
	//Atributos Hipoteca.
	private static HipotecaDTO hipotecaDto;
	private static int         idHipoteca;
	private static String 		selectedDatosOperacion;
	private static String 		titulosEstudiados;
	
	//Vendedor Garante
	private VendedorGaranteDTO vendedorGaranteDto;
	private static String nombreVendedorGarante;
	private static String rutVendedorGarante;
	private static boolean selectedVendedorGarante;
	private static List<VendedorGaranteDTO> listaVendedorGarante;
	
	//Aval
	private AvalDTO avalDto;
	private static String nombreAval;
	private static String rutAval;
	private static boolean selectedAval;
	private static List<AvalDTO>            listaAval;
	
	//Antecedentes de la Propiedad.
	private AntecedentesPropiedadDTO antecedentesPropiedadDto;
	private String avCalle;
    private String numero;
    private String deptoCasaNumero;
    private String idRegion;
    private String idComuna;
    private String idCiudad;
    private String propiedadHipotecada;
    private String acreedorHipotecario;
    private String rolAvaluo1;
    private String rolAvaluo2;
    private boolean selectedAntecedentesPropiedad;
    private static List<AntecedentesPropiedadDTO> listaAntecedentesPropiedad;
    
    //Estacionamientos;
    private EstacionamientoDTO estacionamientoDto;
    private String estRolAvaluo1;
    private String estRolAvaluo2;
    private String estNumero;
    private boolean selectedEstacionamiento;
    private List<EstacionamientoDTO> listaEstacionamientos;
    
    //Bodegas.
    private BodegaDTO bodegaDto;
    private String    bodRolAvaluo1;
    private String    bodRolAvaluo2;
    private String    bodNumero;
    private boolean   selectedBodega;
    private List<BodegaDTO> listaBodegas;
    
    //Checks.
    private static HipotecaCheckDTO hipotecaCheck;
    private static String chkTasacion;
    private static String chkInsDomVig;
    private static String chkCertMatSol;
    private static String chkCertHipGrav;
    private static String chkPersEscrPod;
    private static String chkCertAfectUtil;
    private static String chkInfExpServiu;
    private static String chkEscPropCli;
    private static String chkOtrosDoc;
    
    //Otros Documentos Adjuntos
    private List<UploadedFile> fileData = new ArrayList<UploadedFile>();
    private String totalFiles;
    private String totalSize;
    private static List<HipotecaCheckAdjuntosDTO> listaAduntos;

    
	public static boolean isHipoteca;
	private static boolean isAdjuntos;

	public static boolean formularioCompleto;
	
	//Mensajes.
	private String  mensaje;
	private boolean abrirPopUp;
	private String  rutaImagen;
	private boolean abrirPopUpConfirmacion;
	private boolean abrirPopUpError;
	
	public HipotecaFrontClass() {
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		isHipoteca = true;
		fecha = new Date();
		
		listaBancos   = new ArrayList<SelectItem>();
		listaRegiones = new ArrayList<SelectItem>();
		listaCiudades = new ArrayList<SelectItem>();
		listaComunas  = new ArrayList<SelectItem>();
		
		for(EmpresaDTO empresa : configJProcessService.selectEmpresasByOrganizacion(1))
			listaBancos.add(new SelectItem(empresa.getId(), empresa.getNombre()));
		
		for(RegionDTO region : configJProcessService.selectRegiones())
			listaRegiones.add(new SelectItem(region.getId(), region.getNombre()));			
		
		listaVendedorGarante         = new ArrayList<VendedorGaranteDTO>();
		listaAval                    = new ArrayList<AvalDTO>();
		listaAntecedentesPropiedad   = new ArrayList<AntecedentesPropiedadDTO>();
		listaBodegas                 = new ArrayList<BodegaDTO>();
		listaEstacionamientos        = new ArrayList<EstacionamientoDTO>();
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			validateForm();
			getInformeLegalFromForm();	
			idInformeLegal = formService.selectNextIdInformeLegal();
			informeLegal.setId(idInformeLegal);
			formService.insertInformeLegal(informeLegal);
			
			//Hipoteca.
			idHipoteca = formService.selectNextIdHipoteca();
			getHipotecaFromForm();
			hipotecaDto.setId(idHipoteca);
			hipotecaDto.setIdInformeLegal(idInformeLegal);
			
			formService.insertHipoteca(hipotecaDto);
			
			for(AvalDTO aval : listaAval){
				aval.setIdHipoteca(idHipoteca);
				formService.insertAval(aval);
			}
			
			for(VendedorGaranteDTO vendedorGarante : listaVendedorGarante){
				vendedorGarante.setIdHipoteca(idHipoteca);
				formService.insertVendedorGarante(vendedorGarante);
			}
			
			//getAntecedentesPropiedadFromForm();
			for(AntecedentesPropiedadDTO ant : listaAntecedentesPropiedad){
				int idAntecedentesPropiedad = formService.selectNextIdAntecedentesPropiedad();
				ant.setId(idAntecedentesPropiedad);
				ant.setIdHipoteca(idHipoteca);
				
				formService.insertAntecedentesPropiedad(ant);
			}
			
			getHipotecaCheckFromForm();
			hipotecaCheck.setIdHipoteca(idHipoteca);
			formService.insertDocAdjuntosHipoteca(hipotecaCheck);
			
			if(chkOtrosDoc.equals("true")){
				if(fileData.size()>0){
					File source; 
					File destResp; 
					File dest;
					HipotecaCheckAdjuntosDTO adjuntos;
					for(UploadedFile uploadedFile : fileData){				
			        
						source = new File(uploadedFile.getFile().getParent());	
						destResp = new File("C:\\adjuntos\\hipoteca\\"+idHipoteca);						
						if(!destResp.exists()) {destResp.mkdirs();}
						
						ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
						String realPath=(String) servletContext.getRealPath("/");
						realPath +="adjuntos/hipoteca/"+idHipoteca;						
						dest = new File(realPath);
						if(!dest.exists()) {dest.mkdirs();}		
						
						try {
						    FileUtils.copyDirectory(source, destResp);
						    FileUtils.copyDirectory(source, dest);						    
						    
						} catch (IOException ex) {
						    ex.printStackTrace();
						}
						
						uploadedFile.getFile();
						
						adjuntos = new HipotecaCheckAdjuntosDTO();
						adjuntos.setIdHipoteca(idHipoteca);
						adjuntos.setNombre(uploadedFile.getName());
						adjuntos.setRuta("http://localhost:8181/jselector/adjuntos/hipoteca/"+idHipoteca+"/"+uploadedFile.getName());
						formService.insertDocAdjuntosHipotecaFile(adjuntos);
					}
				}
			}
			
			SolicitudFormularioDTO solicitudFormulario = new SolicitudFormularioDTO();
			solicitudFormulario.setIdSolicitud(Integer.parseInt(ToDoFrontBean.outputCaso));
			solicitudFormulario.setIdTarea(ToDoFrontBean.tareaDto.getId());
			configJProcessService.updateSolicitudFormulario(solicitudFormulario);
			
			mensaje = "Formulario ingresado correctamente";
			abrirPopUp = true;
			rutaImagen = "./img/ok.png";
			formularioCompleto = true;
			
			ToDoFrontBean.ingresaFormulario = false;
			ToDoFrontBean.modificarFormulario = true;
			resetObject();					
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	

	@Override
	public void deleteObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub

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
		tipoCliente            = "";
		idBanco                = "-1";
		sucursal    		   = "";
		ejecutivo     		   = "";
		telefono     		   = "";
		email     			   = "";
		fecha 				   = new Date();
		autCargoCtaCte         = ""; 
		sucursalProvision      = "";
		fondosCtaN     		   = "";
		monto     			   = "";
		rutEmpresa     		   = "";
		rutPersona     		   = "";
		numeroClienteEmpresa   = "";
		numeroClientePersona   = "";
		nombre     			   = "";
		apellidoPaterno        = "";
		apellidoMaterno        = "";
		estadoCivil            = "";
		telefonoClienteEmpresa = "";
		telefonoClientePersona = "";
		emailClienteEmpresa    = "";
		emailClientePersona    = "";
		razonSocial     	   = "";
		
		selectedDatosOperacion = "CV";
		titulosEstudiados      = "";
		
		nombreVendedorGarante = "";
		rutVendedorGarante    = "";
		
		nombreAval            = "";
		rutAval               = "";
		listaAval = new ArrayList<AvalDTO>();
		listaVendedorGarante = new ArrayList<VendedorGaranteDTO>();
		
		listaAntecedentesPropiedad = new ArrayList<AntecedentesPropiedadDTO>();
		listaEstacionamientos = new ArrayList<EstacionamientoDTO>();
		listaBodegas = new ArrayList<BodegaDTO>();
		
		chkTasacion      = "false";
	    chkInsDomVig     = "false";
	    chkCertMatSol    = "false";
	    chkCertHipGrav   = "false";
	    chkPersEscrPod   = "false";
	    chkCertAfectUtil = "false";
	    chkInfExpServiu  = "false";
	    chkEscPropCli    = "false";
	    chkOtrosDoc      = "false";
	    
	    isAdjuntos       = false;
	    listaAduntos     = new ArrayList<HipotecaCheckAdjuntosDTO>();
	    fileData         = new ArrayList<AplicationAbstract.UploadedFile>();
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub

	}
	
	public static void getDataForForm(int idSolicitud){
		informeLegal = new InformeLegalDTO();
		
		informeLegal = formService.selectInformeLegalById(idSolicitud);
		
		idInformeLegal         = informeLegal.getId();
		tipoCliente            = informeLegal.getTipoCliente();
		idBanco                = String.valueOf(informeLegal.getIdBanco());
		sucursal    		   = informeLegal.getSucursal();
		ejecutivo     		   = informeLegal.getEjecutivo();
		telefono     		   = informeLegal.getTelefono();
		email     			   = informeLegal.getEmail();
		fecha 				   = informeLegal.getFecha();
		autCargoCtaCte         = informeLegal.getAutCargoCtaCte(); 
		sucursalProvision      = informeLegal.getSucursalProvision();
		fondosCtaN     		   = informeLegal.getFondosCtaN();
		monto     			   = String.valueOf(informeLegal.getMonto());
		rutEmpresa     		   = informeLegal.getRut();
		rutPersona     		   = informeLegal.getRut();
		numeroClienteEmpresa   = informeLegal.getNumeroCliente();
		numeroClientePersona   = informeLegal.getNumeroCliente();
		nombre     			   = informeLegal.getNombre();
		apellidoPaterno        = informeLegal.getApellidoPaterno();
		apellidoMaterno        = informeLegal.getApellidoMaterno();
		estadoCivil            = informeLegal.getEstadoCivil();
		telefonoClienteEmpresa = informeLegal.getTelefono();
		telefonoClientePersona = informeLegal.getTelefono();
		emailClienteEmpresa    = informeLegal.getEmail();
		emailClientePersona    = informeLegal.getEmail();
		razonSocial     	   = informeLegal.getRazonSocial();
		
		
		hipotecaDto = new HipotecaDTO();
		hipotecaDto = formService.selectHipotecaByInformeLegal(idInformeLegal);
		
		selectedDatosOperacion = hipotecaDto.getDatosOperacion();
		titulosEstudiados      = hipotecaDto.getTitulosEstudiados();		
		
		nombreVendedorGarante = "";
		rutVendedorGarante    = "";
		listaVendedorGarante = formService.selectVendedorGaranteByHipoteca(hipotecaDto.getId());
		
		nombreAval            = "";
		rutAval               = "";
		listaAval             = formService.selectAvalByHipoteca(hipotecaDto.getId());
	
		listaAntecedentesPropiedad = formService.selectAntecedentesPropiedadByHipoteca(hipotecaDto.getId());
		
		hipotecaCheck = formService.selectDocAdjuntosHipotecaByHipoteca(hipotecaDto.getId());
	    chkTasacion      = hipotecaCheck.getTasacion();
	    chkInsDomVig     = hipotecaCheck.getInsDomVig();
	    chkCertMatSol    = hipotecaCheck.getCertMatSol();
	    chkCertHipGrav   = hipotecaCheck.getCertHipGrav();
	    chkPersEscrPod   = hipotecaCheck.getPersEscPoder();
	    chkCertAfectUtil = hipotecaCheck.getCertAfecUtil();
	    chkInfExpServiu  = hipotecaCheck.getInfExpServiu();
	    chkEscPropCli    = hipotecaCheck.getEscPropCli();
	    chkOtrosDoc      = hipotecaCheck.getOtrosDoc();
	    
	    if(chkOtrosDoc.equals("true")){
	    	isAdjuntos = true;
	    	listaAduntos = formService.selectDocAdjuntosHipotecaFileByHipoteca(hipotecaDto.getId());
	    }else{
	    	isAdjuntos = false;
	    }
	}

	// Custom Method.
	public void changeHipotecaAdjuntosListener(ValueChangeEvent evnt) {
		String estado = evnt.getNewValue().toString();
		if (estado.equals("true")) {
			isAdjuntos = true;
		} else {
			isAdjuntos = false;
		}
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

	public void onChangeTipoCliente(ValueChangeEvent evnt) {
		if (evnt.getNewValue().equals("PN"))
			isJuridica = false;
		else if (evnt.getNewValue().equals("PJ"))
			isJuridica = true;
	}
	
	public AntecedentesPropiedadDTO getAntecedentesPropiedadFromForm(){
		antecedentesPropiedadDto = new AntecedentesPropiedadDTO();
		antecedentesPropiedadDto.setAvCalle(avCalle);
		antecedentesPropiedadDto.setNumero(numero);
		antecedentesPropiedadDto.setDeptoCasaNumero(deptoCasaNumero);
		antecedentesPropiedadDto.setIdRegion(Integer.parseInt(idRegion));
		antecedentesPropiedadDto.setIdComuna(Integer.parseInt(idComuna));
		antecedentesPropiedadDto.setIdCiudad(Integer.parseInt(idCiudad));
		antecedentesPropiedadDto.setPropiedadHipotecada(propiedadHipotecada);
		antecedentesPropiedadDto.setAcreedorHipotecario(acreedorHipotecario);
		antecedentesPropiedadDto.setRolAvaluo1(rolAvaluo1);
		antecedentesPropiedadDto.setRolAvaluo2(rolAvaluo2);
		antecedentesPropiedadDto.setListaBodegas(listaBodegas);
		antecedentesPropiedadDto.setListaEstacionamientos(listaEstacionamientos);
		return antecedentesPropiedadDto;
	}
	
	
	public HipotecaCheckDTO getHipotecaCheckFromForm(){
		hipotecaCheck = new HipotecaCheckDTO();
		hipotecaCheck.setTasacion(chkTasacion);
		hipotecaCheck.setInsDomVig(chkInsDomVig);
		hipotecaCheck.setCertMatSol(chkCertMatSol);
		hipotecaCheck.setCertHipGrav(chkCertHipGrav);
		hipotecaCheck.setPersEscPoder(chkPersEscrPod);
		hipotecaCheck.setCertAfecUtil(chkCertAfectUtil);
		hipotecaCheck.setInfExpServiu(chkInfExpServiu);
		hipotecaCheck.setEscPropCli(chkEscPropCli);
		hipotecaCheck.setOtrosDoc(chkOtrosDoc);

		return hipotecaCheck;
	}
	public HipotecaDTO getHipotecaFromForm(){
		hipotecaDto = new HipotecaDTO();		
		hipotecaDto.setIdInformeLegal(idInformeLegal);
		hipotecaDto.setDatosOperacion(selectedDatosOperacion);
		hipotecaDto.setTitulosEstudiados(titulosEstudiados);
		hipotecaDto.setListaAval(listaAval);
		hipotecaDto.setListaVendedorGarante(listaVendedorGarante);
		
		return hipotecaDto;
	}
	
	public InformeLegalDTO getInformeLegalFromForm(){
		informeLegal = new InformeLegalDTO();
		informeLegal.setIdSolicitud(ToDoFrontBean.idSolicitud);
		informeLegal.setTipoCliente(selectedTipoPersona);
		informeLegal.setIdBanco(UsuarioFrontBean.usuarioBean.getIdEmpresa());
		informeLegal.setSucursal(sucursal);
		informeLegal.setTelefono(telefono);
		informeLegal.setEjecutivo(ejecutivo);
		informeLegal.setEmail(email);
		informeLegal.setFecha(fecha);
		informeLegal.setAutCargoCtaCte(autCargoCtaCte);
		informeLegal.setSucursalProvision(sucursalProvision);
		informeLegal.setFondosCtaN(fondosCtaN);
		
		if(monto.equals(""))
			monto = "0";
		
		informeLegal.setMonto(Integer.parseInt(monto));
		
		if(selectedTipoPersona.equals("PN")){
			informeLegal.setRut(rutPersona);
			informeLegal.setNumeroCliente(numeroClientePersona);
			informeLegal.setTelefonoCliente(telefonoClientePersona);
			informeLegal.setEmailCliente(emailClientePersona);
		}else{
			informeLegal.setRut(rutEmpresa);
			informeLegal.setNumeroCliente(numeroClienteEmpresa);
			informeLegal.setTelefonoCliente(telefonoClienteEmpresa);
			informeLegal.setEmailCliente(emailClienteEmpresa);
		}		
		
		informeLegal.setNombre(nombre);
		informeLegal.setApellidoPaterno(apellidoPaterno);
		informeLegal.setApellidoMaterno(apellidoMaterno);
		informeLegal.setEstadoCivil(estadoCivil);
		
		informeLegal.setRazonSocial(razonSocial);
		
		return informeLegal;
	}
	
	
	public void ingresarVendedorGaranteListener(ActionEvent e){
		VendedorGaranteDTO vendedorGarante = new VendedorGaranteDTO();
		vendedorGarante.setNombre(nombreVendedorGarante);
		vendedorGarante.setRut(rutVendedorGarante);
		listaVendedorGarante.add(vendedorGarante);
		nombreVendedorGarante = "";
		rutVendedorGarante    = "";
	}
	
	public void limpiarVendedorGaranteListener(ActionEvent e){
		nombreVendedorGarante = "";
		rutVendedorGarante    = "";
	}
	
	public void objectVendedorGaranteSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		vendedorGaranteDto = (VendedorGaranteDTO) event.getObject();		
		nombreVendedorGarante = vendedorGaranteDto.getNombre();
		rutVendedorGarante    = vendedorGaranteDto.getRut();
		selectedVendedorGarante   = true;
	}
	
	public void ingresarAvalListener(ActionEvent e){
		AvalDTO aval = new AvalDTO();
		aval.setNombre(nombreAval);
		aval.setRut(rutAval);
		listaAval.add(aval);
		nombreAval = "";
		rutAval    = "";
	}
	
	public void limpiarAvalListener(ActionEvent e){
		nombreAval = "";
		rutAval    = "";
	}	
	
	public void objectAvalSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		avalDto = (AvalDTO) event.getObject();		
		nombreAval = avalDto.getNombre();
		rutAval    = avalDto.getRut();
		selectedAval   = true;
	}
	
	public void ingresarEstacionamientoListener(ActionEvent e){
		EstacionamientoDTO estacionamiento = new EstacionamientoDTO();
		estacionamiento.setRolAvaluo1(estRolAvaluo1);
		estacionamiento.setRolAvaluo2(estRolAvaluo2);
		estacionamiento.setNumero(estNumero);
		listaEstacionamientos.add(estacionamiento);
		estRolAvaluo1 = "";
		estRolAvaluo2    = "";
		estNumero    = "";
	}
	
	public void limpiarEstacionamientoListener(ActionEvent e){
		estRolAvaluo1 = "";
		estRolAvaluo2    = "";
		estNumero    = "";
	}	
	
	public void objectEstacionamientoSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		estacionamientoDto = (EstacionamientoDTO) event.getObject();		
		estRolAvaluo1    = estacionamientoDto.getRolAvaluo1();
		estRolAvaluo2    = estacionamientoDto.getRolAvaluo2();
		estNumero        = estacionamientoDto.getNumero();
		selectedEstacionamiento   = true;
	}	
	
	
	public void ingresarBodegaListener(ActionEvent e){
		BodegaDTO bodega = new BodegaDTO();
		bodega.setRolAvaluo1(bodRolAvaluo1);
		bodega.setRolAvaluo2(bodRolAvaluo2);
		bodega.setNumero(bodNumero);
		listaBodegas.add(bodega);
		bodRolAvaluo1 = "";
		bodRolAvaluo2 = "";
		bodNumero     = "";
	}
	
	public void limpiarBodegaListener(ActionEvent e){
		bodRolAvaluo1 = "";
		bodRolAvaluo2 = "";
		bodNumero     = "";
	}	
	
	public void objectBodegaSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		bodegaDto = (BodegaDTO) event.getObject();			
		
		bodRolAvaluo1    = bodegaDto.getRolAvaluo1();
		bodRolAvaluo2    = bodegaDto.getRolAvaluo2();
		bodNumero        = bodegaDto.getNumero();
		selectedBodega   = true;
	}	
	
	
	public void ingresarAntecedentesPropiedadListener(ActionEvent e){
		AntecedentesPropiedadDTO antecedentes = new AntecedentesPropiedadDTO();
		antecedentes.setAvCalle(avCalle);
		antecedentes.setNumero(numero);
		antecedentes.setDeptoCasaNumero(deptoCasaNumero);
		antecedentes.setIdRegion(Integer.parseInt(idRegion));
		antecedentes.setIdComuna(Integer.parseInt(idComuna));
		antecedentes.setIdCiudad(Integer.parseInt(idCiudad));
		antecedentes.setPropiedadHipotecada(propiedadHipotecada);
		antecedentes.setAcreedorHipotecario(acreedorHipotecario);
		antecedentes.setRolAvaluo1(rolAvaluo1);
		antecedentes.setRolAvaluo2(rolAvaluo2);
		
		antecedentes.setListaBodegas(listaBodegas);
		antecedentes.setListaEstacionamientos(listaEstacionamientos);
	    
		listaAntecedentesPropiedad.add(antecedentes);
		 avCalle = "";
		 numero = "";
		 deptoCasaNumero = "";
		 idRegion = "-1";
		 idComuna = "-1";
		 idCiudad = "-1";
		 propiedadHipotecada = "";
		 acreedorHipotecario = "";
		 rolAvaluo1 = "";
		 rolAvaluo2 = "";
		 
		 listaBodegas = new ArrayList<BodegaDTO>();
		 listaEstacionamientos = new ArrayList<EstacionamientoDTO>();
		 
		 bodRolAvaluo1 = "";
		 bodRolAvaluo2 = "";
		 bodNumero     = "";
		 
		 estRolAvaluo1 = "";
		 estRolAvaluo2 = "";
		 estNumero     = "";
	}
	
	public void limpiarAntecedentesPropiedadListener(ActionEvent e){
		  avCalle = "";
		  numero = "";
		  deptoCasaNumero = "";
		  idRegion = "-1";
		  idComuna = "-1";
		  idCiudad = "-1";
		  propiedadHipotecada = "";
		  acreedorHipotecario = "";
		  rolAvaluo1 = "";
		  rolAvaluo2 = "";
		  
		  listaBodegas = new ArrayList<BodegaDTO>();
		  listaEstacionamientos = new ArrayList<EstacionamientoDTO>();
		 
		  bodRolAvaluo1 = "";
		  bodRolAvaluo2 = "";
		  bodNumero     = "";
		 
		  estRolAvaluo1 = "";
		  estRolAvaluo2 = "";
		  estNumero     = "";
	}		
	
	public void objectAntecedentesPropiedadSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		antecedentesPropiedadDto = (AntecedentesPropiedadDTO) event.getObject();			
		
		avCalle             = antecedentesPropiedadDto.getAvCalle();
	    numero              = antecedentesPropiedadDto.getNumero();
	    deptoCasaNumero     = antecedentesPropiedadDto.getDeptoCasaNumero();
	    idRegion            = String.valueOf(antecedentesPropiedadDto.getIdRegion());
	    idComuna            = String.valueOf(antecedentesPropiedadDto.getIdComuna());
	    idCiudad            = String.valueOf(antecedentesPropiedadDto.getIdCiudad());
	    propiedadHipotecada = antecedentesPropiedadDto.getPropiedadHipotecada();
	    acreedorHipotecario = antecedentesPropiedadDto.getAcreedorHipotecario();
	    rolAvaluo1          = antecedentesPropiedadDto.getRolAvaluo1();
	    rolAvaluo2          = antecedentesPropiedadDto.getRolAvaluo2();
	    
	    listaBodegas        = antecedentesPropiedadDto.getListaBodegas();
	    listaEstacionamientos = antecedentesPropiedadDto.getListaEstacionamientos();
		selectedAntecedentesPropiedad   = true;
	}	
	
	public void validateForm() throws Exception{
		if(selectedTipoPersona.equals("PN")){
			if(rutPersona.equals("")){
				mensaje = "Debe ingresar un valor para el rut de persona";
				abrirPopUp = true;
				rutaImagen = "./img/error.gif";
				throw new Exception();
			}else if(nombre.equals("")){
				mensaje = "Debe ingresar el nombre de la persona";
				abrirPopUp = true;
				rutaImagen = "./img/error.gif";
				throw new Exception();				
			}else if(apellidoPaterno.equals("")){
				mensaje = "Debe ingresar el apellido paterno de la persona";
				abrirPopUp = true;
				rutaImagen = "./img/error.gif";
				throw new Exception();				
			}else if(apellidoMaterno.equals("")){
				mensaje = "Debe ingresar el apellido materno de la persona";
				abrirPopUp = true;
				rutaImagen = "./img/error.gif";
				throw new Exception();				
			}else if(estadoCivil.equals("-1")){
				mensaje = "Debe ingresar seleccionar el estado civil de la persona";
				abrirPopUp = true;
				rutaImagen = "./img/error.gif";
				throw new Exception();				
			}
		}else{
			if(rutEmpresa.equals("")){
				mensaje = "Debe ingresar un valor para el rut de empresa";
				abrirPopUp = true;
				rutaImagen = "./img/error.gif";
				throw new Exception();
			}else if(razonSocial.equals("")){
				mensaje = "Debe ingresar la razón social de la empresa";
				abrirPopUp = true;
				rutaImagen = "./img/error.gif";
				throw new Exception();				
			}
		}
		
		if(sucursal.equals("")){
			mensaje = "Debe ingresar una sucursal ";
			abrirPopUp = true;
			rutaImagen = "./img/error.gif";
			throw new Exception();	
		}else if(ejecutivo.equals("")){
			mensaje = "Debe ingresar el nombre del ejecutivo";
			abrirPopUp = true;
			rutaImagen = "./img/error.gif";
			throw new Exception();	
		}		
	}
	
	
	public void sampleListener(FileEntryEvent e) {
		
        FileEntry fe = (FileEntry)e.getComponent();        
        FileEntryResults results = fe.getResults();
        File parent = null;

        for (FileEntryResults.FileInfo i : results.getFiles()) {
            fileData.add(
                new UploadedFile(
                    i.getFileName(),
                    i.getSize() + " bytes",
                    i.getContentType(),
                    i.isSaved() ? null : ("File was not saved because: " +
                        i.getStatus().getFacesMessage(
                            FacesContext.getCurrentInstance(),
                            fe, i).getSummary()), i.getFile().getAbsolutePath(), i.getFile()));

            if (i.isSaved()) {
                File file = i.getFile();
                if (file != null) {
                    parent = file.getParentFile();
                }
            }
        }

        if (parent != null) {
            long dirSize = 0;
            int fileCount = 0;
            for (File file : parent.listFiles()) {
                fileCount++;
                dirSize += file.length();
            }
            totalFiles = "Total Files in Upload Directory: " + fileCount;
            totalSize = "Total Size of Files In Directory: " + dirSize + " bytes";
        }
    }

	//Mensajes.
	public void cerrarPopUpListener(ActionEvent e) {
		abrirPopUp = false;
		mensaje = "";

		if (!rutaImagen.equals("./img/error.gif"))
			resetObject();
		
		if(formularioCompleto = true)
			NavigationBean.selectedPanel = "tareaDetallePanel";
	}
	
	public void abrirPopUpConfirmacionListener(ActionEvent e){
		mensaje                = "Desea eliminar?";
		abrirPopUpConfirmacion = true;
		rutaImagen = "./img/question.png";
	}
	
	public void cerrarPopUpConfirmacionListener(ActionEvent e){
		abrirPopUpConfirmacion = false;
		mensaje = "";
	}

	public void cerrarPopUpErrorListener(ActionEvent e){
		abrirPopUpError = false;
		mensaje = "";
	}
	
	
	public void setTipoOperacionToFalse() {
		isHipoteca = false;
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

	public boolean isHipoteca() {
		return isHipoteca;
	}

	public void setHipoteca(boolean isHipoteca) {
		HipotecaFrontClass.isHipoteca = isHipoteca;
	}

	public boolean isAdjuntos() {
		return isAdjuntos;
	}

	public void setAdjuntos(boolean isAdjuntos) {
		this.isAdjuntos = isAdjuntos;
	}

	public String getSelectedTipoPersona() {
		return selectedTipoPersona;
	}

	public void setSelectedTipoPersona(String selectedTipoPersona) {
		this.selectedTipoPersona = selectedTipoPersona;
	}

	public InformeLegalDTO getInformeLegal() {
		return informeLegal;
	}

	public void setInformeLegal(InformeLegalDTO informeLegal) {
		this.informeLegal = informeLegal;
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

	public String getTitulosEstudiados() {
		return titulosEstudiados;
	}

	public void setTitulosEstudiados(String titulosEstudiados) {
		this.titulosEstudiados = titulosEstudiados;
	}

	public String getNombreVendedorGarante() {
		return nombreVendedorGarante;
	}

	public void setNombreVendedorGarante(String nombreVendedorGarante) {
		this.nombreVendedorGarante = nombreVendedorGarante;
	}

	public String getRutVendedorGarante() {
		return rutVendedorGarante;
	}

	public void setRutVendedorGarante(String rutVendedorGarante) {
		this.rutVendedorGarante = rutVendedorGarante;
	}

	public List<VendedorGaranteDTO> getListaVendedorGarante() {
		return listaVendedorGarante;
	}

	public void setListaVendedorGarante(
			List<VendedorGaranteDTO> listaVendedorGarante) {
		this.listaVendedorGarante = listaVendedorGarante;
	}

	public List<AvalDTO> getListaAval() {
		return listaAval;
	}

	public void setListaAval(List<AvalDTO> listaAval) {
		this.listaAval = listaAval;
	}

	public String getNombreAval() {
		return nombreAval;
	}

	public void setNombreAval(String nombreAval) {
		this.nombreAval = nombreAval;
	}

	public String getRutAval() {
		return rutAval;
	}

	public void setRutAval(String rutAval) {
		this.rutAval = rutAval;
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

	public List<AntecedentesPropiedadDTO> getListaAntecedentesPropiedad() {
		return listaAntecedentesPropiedad;
	}

	public void setListaAntecedentesPropiedad(
			List<AntecedentesPropiedadDTO> listaAntecedentesPropiedad) {
		this.listaAntecedentesPropiedad = listaAntecedentesPropiedad;
	}

	public String getEstRolAvaluo1() {
		return estRolAvaluo1;
	}

	public void setEstRolAvaluo1(String estRolAvaluo1) {
		this.estRolAvaluo1 = estRolAvaluo1;
	}

	public String getEstRolAvaluo2() {
		return estRolAvaluo2;
	}

	public void setEstRolAvaluo2(String estRolAvaluo2) {
		this.estRolAvaluo2 = estRolAvaluo2;
	}

	public String getEstNumero() {
		return estNumero;
	}

	public void setEstNumero(String estNumero) {
		this.estNumero = estNumero;
	}

	public List<EstacionamientoDTO> getListaEstacionamientos() {
		return listaEstacionamientos;
	}

	public void setListaEstacionamientos(
			List<EstacionamientoDTO> listaEstacionamientos) {
		this.listaEstacionamientos = listaEstacionamientos;
	}

	public String getBodRolAvaluo1() {
		return bodRolAvaluo1;
	}

	public void setBodRolAvaluo1(String bodRolAvaluo1) {
		this.bodRolAvaluo1 = bodRolAvaluo1;
	}

	public String getBodRolAvaluo2() {
		return bodRolAvaluo2;
	}

	public void setBodRolAvaluo2(String bodRolAvaluo2) {
		this.bodRolAvaluo2 = bodRolAvaluo2;
	}

	public String getBodNumero() {
		return bodNumero;
	}

	public void setBodNumero(String bodNumero) {
		this.bodNumero = bodNumero;
	}

	public List<BodegaDTO> getListaBodegas() {
		return listaBodegas;
	}

	public void setListaBodegas(List<BodegaDTO> listaBodegas) {
		this.listaBodegas = listaBodegas;
	}

	public VendedorGaranteDTO getVendedorGaranteDto() {
		return vendedorGaranteDto;
	}

	public void setVendedorGaranteDto(VendedorGaranteDTO vendedorGaranteDto) {
		this.vendedorGaranteDto = vendedorGaranteDto;
	}

	public boolean isSelectedVendedorGarante() {
		return selectedVendedorGarante;
	}

	public void setSelectedVendedorGarante(boolean selectedVendedorGarante) {
		this.selectedVendedorGarante = selectedVendedorGarante;
	}

	public AvalDTO getAvalDto() {
		return avalDto;
	}

	public void setAvalDto(AvalDTO avalDto) {
		this.avalDto = avalDto;
	}

	public boolean isSelectedAval() {
		return selectedAval;
	}

	public void setSelectedAval(boolean selectedAval) {
		this.selectedAval = selectedAval;
	}

	public EstacionamientoDTO getEstacionamientoDto() {
		return estacionamientoDto;
	}

	public void setEstacionamientoDto(EstacionamientoDTO estacionamientoDto) {
		this.estacionamientoDto = estacionamientoDto;
	}

	public boolean isSelectedEstacionamiento() {
		return selectedEstacionamiento;
	}

	public void setSelectedEstacionamiento(boolean selectedEstacionamiento) {
		this.selectedEstacionamiento = selectedEstacionamiento;
	}

	public BodegaDTO getBodegaDto() {
		return bodegaDto;
	}

	public void setBodegaDto(BodegaDTO bodegaDto) {
		this.bodegaDto = bodegaDto;
	}

	public boolean isSelectedBodega() {
		return selectedBodega;
	}

	public void setSelectedBodega(boolean selectedBodega) {
		this.selectedBodega = selectedBodega;
	}

	public AntecedentesPropiedadDTO getAntecedentesPropiedadDto() {
		return antecedentesPropiedadDto;
	}

	public void setAntecedentesPropiedadDto(
			AntecedentesPropiedadDTO antecedentesPropiedadDto) {
		this.antecedentesPropiedadDto = antecedentesPropiedadDto;
	}

	public boolean isSelectedAntecedentesPropiedad() {
		return selectedAntecedentesPropiedad;
	}

	public void setSelectedAntecedentesPropiedad(
			boolean selectedAntecedentesPropiedad) {
		this.selectedAntecedentesPropiedad = selectedAntecedentesPropiedad;
	}

	public HipotecaDTO getHipotecaDto() {
		return hipotecaDto;
	}

	public void setHipotecaDto(HipotecaDTO hipotecaDto) {
		this.hipotecaDto = hipotecaDto;
	}

	public String getSelectedDatosOperacion() {
		return selectedDatosOperacion;
	}

	public void setSelectedDatosOperacion(String selectedDatosOperacion) {
		this.selectedDatosOperacion = selectedDatosOperacion;
	}

	public int getIdInformeLegal() {
		return idInformeLegal;
	}

	public void setIdInformeLegal(int idInformeLegal) {
		this.idInformeLegal = idInformeLegal;
	}

	public int getIdHipoteca() {
		return idHipoteca;
	}

	public void setIdHipoteca(int idHipoteca) {
		this.idHipoteca = idHipoteca;
	}

	public String getChkTasacion() {
		return chkTasacion;
	}

	public void setChkTasacion(String chkTasacion) {
		this.chkTasacion = chkTasacion;
	}

	public String getChkInsDomVig() {
		return chkInsDomVig;
	}

	public void setChkInsDomVig(String chkInsDomVig) {
		this.chkInsDomVig = chkInsDomVig;
	}

	public String getChkCertMatSol() {
		return chkCertMatSol;
	}

	public void setChkCertMatSol(String chkCertMatSol) {
		this.chkCertMatSol = chkCertMatSol;
	}

	public String getChkCertHipGrav() {
		return chkCertHipGrav;
	}

	public void setChkCertHipGrav(String chkCertHipGrav) {
		this.chkCertHipGrav = chkCertHipGrav;
	}

	public String getChkPersEscrPod() {
		return chkPersEscrPod;
	}

	public void setChkPersEscrPod(String chkPersEscrPod) {
		this.chkPersEscrPod = chkPersEscrPod;
	}

	public String getChkCertAfectUtil() {
		return chkCertAfectUtil;
	}

	public void setChkCertAfectUtil(String chkCertAfectUtil) {
		this.chkCertAfectUtil = chkCertAfectUtil;
	}

	public String getChkInfExpServiu() {
		return chkInfExpServiu;
	}

	public void setChkInfExpServiu(String chkInfExpServiu) {
		this.chkInfExpServiu = chkInfExpServiu;
	}

	public String getChkEscPropCli() {
		return chkEscPropCli;
	}

	public void setChkEscPropCli(String chkEscPropCli) {
		this.chkEscPropCli = chkEscPropCli;
	}

	public String getChkOtrosDoc() {
		return chkOtrosDoc;
	}

	public void setChkOtrosDoc(String chkOtrosDoc) {
		this.chkOtrosDoc = chkOtrosDoc;
	}

	public HipotecaCheckDTO getHipotecaCheck() {
		return hipotecaCheck;
	}

	public void setHipotecaCheck(HipotecaCheckDTO hipotecaCheck) {
		this.hipotecaCheck = hipotecaCheck;
	}

	public List<UploadedFile> getFileData() {
		return fileData;
	}

	public void setFileData(List<UploadedFile> fileData) {
		this.fileData = fileData;
	}

	public String getTotalFiles() {
		return totalFiles;
	}

	public void setTotalFiles(String totalFiles) {
		this.totalFiles = totalFiles;
	}

	public String getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(String totalSize) {
		this.totalSize = totalSize;
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

	public boolean isFormularioCompleto() {
		return formularioCompleto;
	}

	public void setFormularioCompleto(boolean formularioCompleto) {
		this.formularioCompleto = formularioCompleto;
	}

	@Override
	public void updateObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public List<HipotecaCheckAdjuntosDTO> getListaAduntos() {
		return listaAduntos;
	}

	public void setListaAduntos(List<HipotecaCheckAdjuntosDTO> listaAduntos) {
		this.listaAduntos = listaAduntos;
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
	
	
}
