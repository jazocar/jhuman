/**
 * 
 */
package cl.jazocar.jselector.front.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;

import org.icefaces.ace.component.fileentry.FileEntry;
import org.icefaces.ace.component.fileentry.FileEntryEvent;
import org.icefaces.ace.component.fileentry.FileEntryResults;
import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.dto.AplicacionDTO;
import cl.jazocar.jselector.dto.CasoComentarioDTO;
import cl.jazocar.jselector.dto.CasoDTO;
import cl.jazocar.jselector.dto.CreacionDTO;
import cl.jazocar.jselector.dto.InstanciaDTO;
import cl.jazocar.jselector.dto.PendienteDTO;
import cl.jazocar.jselector.dto.SolicitudDTO;
import cl.jazocar.jselector.dto.SolicitudFormularioDTO;
import cl.jazocar.jselector.dto.TareaConfiguracionDTO;
import cl.jazocar.jselector.dto.TareaDTO;
import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.front.form.impl.HipotecaFrontClass;
import cl.jazocar.jselector.sys.dto.PanelDTO;
import cl.jazocar.jselector.util.EmailService;

/**
 * @author Diablo
 * 
 */
@ManagedBean(name = ToDoFrontBean.TODOFRONTBEAN)
@SessionScoped
public class ToDoFrontBean extends AplicationAbstract{

	public static final String TODOFRONTBEAN = "toDoFrontBean";

	public static TareaDTO tareaDto						  = null;
	private CasoDTO       casoDto     					  = null;
	private AplicacionDTO appDto      				      = null;
	private SolicitudDTO  solicitudDto                    = null;
	private SolicitudFormularioDTO solicitudFormularioDto = null;
	private CreacionDTO   creacionDto  					  = null;
	private PendienteDTO  pendienteDto				      = null;
	private PanelDTO      panelDto   				      = null;
	private InstanciaDTO  instanciaDto					  = null;
	
	public List<TareaDTO> listaTareaDto = null;
	public List<CasoComentarioDTO> listaComentario = null;
	public List<AplicacionDTO> listaAplicacion = null;
	public List<CasoDTO> listaCaso = null;
	public static List<SolicitudDTO> listaSolicitud;
	public static boolean selected;
	private boolean selectAll;

	public static int idSolicitud;
	
	private String outputNombreTarea;
	private String outputDescripcionTarea;
	public static String outputCaso;
	private String outputAplicacion;
	private String outputVencimiento;
	private String outputPrioridad;
	private String outputUsuario;
	public static boolean ingresaFormulario;
	public static boolean modificarFormulario;

	private String inputComentario;

	// Caso.
	private String outputCasoIdCaso;
	private String outputCasoAplicacion;
	private String outputCasoVersion;
	private String outputCasoIniciadoEn;
	private String outputCasoIniciadoPor;

	// Aplicacion
	public static String outputAppId;
	private String outputAppAplicacion;
	private String outputAppDescripcion;
	private String outputAppVersion;
	private String outputAppInicio;
	private String outputAppFin;

	private boolean tareaPanel;
	private boolean casoPanel;
	private boolean apliacionPanel;
	private boolean esRechazo;
	private boolean esAutomatica;
	private boolean mensajes;
	private boolean tieneFlujo;
	private boolean tieneAsignacion;

	private List<CasoComentarioDTO> listaComentariosCaso;
	
	private boolean tieneConfiguracion;
	private List<TareaConfiguracionDTO> listaConfiguracion;

	private IConfigJProcessService configJProcessService;
	
	 private List<String> fileData;

	private String autoHide = "true";
    private boolean closeAll = true;
    private int maxVisibleMessages = 0;
    private String position = "top-right";
    
    private boolean info;
    private boolean warn;
    private boolean error;
    private boolean fatal;
    
    //Email.
    private String destinatario;
    private String asunto;
    private String mensajeEmail;
    
    private boolean isPopUpError;
    private String  rutaImagen;
    private String  mensaje;
    private boolean popEmail;
    
    private EmailService emailService;
    private boolean errorEmail;
    private boolean errorAsuntoMensaje;
    
	public ToDoFrontBean() {
		configJProcessService = JProcessFactoryService.getInstance()
				.getService("CONF_JPROCESS_SERVICE",
						IConfigJProcessService.class);

		init();
	}

	public void init() {
		if (listaTareaDto == null) {

			listaSolicitud     = new ArrayList<SolicitudDTO>();
			listaTareaDto      = new ArrayList<TareaDTO>();
			listaComentario    = new ArrayList<CasoComentarioDTO>();			
			listaConfiguracion = new ArrayList<TareaConfiguracionDTO>();

			listaAplicacion = configJProcessService.selectAllAplicacion();

			listaCaso = new ArrayList<CasoDTO>();
			listaCaso.add(new CasoDTO(1, "Alzamiento", "1.0", "Walter Bates",
					new Date(), null, null));
			listaCaso.add(new CasoDTO(2, "Hipoteca", "1.0", "Juan Azócar M.",
					new Date(), null, null));
			listaCaso.add(new CasoDTO(3, "Prenda", "1.0", "María Rodriguez",
					new Date(), null, null));
			listaCaso.add(new CasoDTO(4, "Prenda", "1.0", "Isidora Azócar",
					new Date(), null, null));
			listaCaso.add(new CasoDTO(5, "Alzamiento", "1.0", "Juan Azócar M.",
					new Date(), null, null));

		} else {
			System.out.println("No pasa nada");
		}	
	}

	public void checkboxValueChangeListener(ValueChangeEvent evt) {
		boolean estado = Boolean.parseBoolean(evt.getNewValue().toString());
		System.out.println(estado);

		if (estado) {
			for (int i = 0; i < listaSolicitud.size(); i++)
				listaSolicitud.get(i).setSelected(true);
		} else
			for (int i = 0; i < listaSolicitud.size(); i++)
				listaSolicitud.get(i).setSelected(false);
		System.out.println("");

	}

	public void insertComentarioListener(ActionEvent e) {
		/*
		 * listaComentario.add(new CasoComentarioDTO("Invitado", new Date(),
		 * inputComentario));
		 */
		configJProcessService.insertSolicitudComentario(
				Integer.parseInt(outputCaso),
				UsuarioFrontBean.usuarioBean.getUsuario(), inputComentario);
		inputComentario = "";
		listaComentario = configJProcessService
				.selectComentariosBySolicitud(Integer.parseInt(outputCaso));
	}

	
	public void hacerTareaListener(AjaxBehaviorEvent e) {
		 mensajes = false;
		creacionDto = configJProcessService.selectCreacionByTareaInicial(
				tareaDto.getId(), Integer.parseInt(outputAppId));
		appDto = configJProcessService.selectAplicacionById(Integer
				.parseInt(outputAppId));
		pendienteDto = configJProcessService
				.selectPendientesBySolicitud(solicitudDto.getId());

		idSolicitud = pendienteDto.getIdSolicitud();
		
		instanciaDto = configJProcessService.selectInstanciaByEmpresaAplicacion(UsuarioFrontBean.usuarioBean.getIdEmpresa(), appDto.getId());

		if (tareaDto.getTipoTarea().equals("Manual"))
			esAutomatica = false;
		else
			esAutomatica = true;
		
		if(tareaDto.getTieneFormulario().equals("S")){
			
			panelDto = configJProcessService.selectAllPanelFormularioByTarea(tareaDto.getId(), Integer.parseInt(outputAppId), instanciaDto.getId());					
			solicitudFormularioDto = configJProcessService.selectSolicitudFormulario(Integer.parseInt(ToDoFrontBean.outputCaso), tareaDto.getId());
			
			if(solicitudFormularioDto != null){
				if(solicitudFormularioDto.getEstado().equals("P")){
					ingresaFormulario = true;
					modificarFormulario = false;
				}else{
					modificarFormulario = true;
					ingresaFormulario = false;				
				}
			}else{
				modificarFormulario = false;
				ingresaFormulario = false;	
			}
			
		}
		else{
			ingresaFormulario = false;
			modificarFormulario = false;
		}
		
		if(creacionDto != null){
			if (creacionDto.getEsCondicional().equals("S"))
				esRechazo = true;
			else
				esRechazo = false;
		}

		NavigationBean.selectedPanel = "tareaDetallePanel";
	}

	public void despacharCreacionListener(ActionEvent e) {
		try{
		 mensajes = false;
		 
		for(TareaConfiguracionDTO conf : listaConfiguracion){
			if(conf.isRequerido() == true && conf.isSeleccionado() == false){
			//	mensajesListener(conf.getCheckOption(), "Error");
				isPopUpError = true;
				mensaje = "El Check '"+conf.getCheckOption()+"', es obligatorio.";
				rutaImagen = "./img/error.gif";
			}
		}
		
		configJProcessService.cerrarCreacion(pendienteDto.getId());

		if (tareaDto.getId() == appDto.getIdTareaFinal())
			configJProcessService
					.cerrarSolicitud(solicitudDto.getId());
		else {
			TareaDTO tarea = configJProcessService.selectTareaById(creacionDto
					.getIdTareaExito());
			configJProcessService.despacharCreacion(
					creacionDto.getIdTareaExito(), solicitudDto.getId(),
					tarea.getIdRolAsignacion());
		}
		listaSolicitud = configJProcessService
				.selectAllSolicitudesPendientesByRol(UsuarioFrontBean.usuarioBean
						.getRol(), UsuarioFrontBean.usuarioBean.getOrganizacion(), UsuarioFrontBean.usuarioBean.getIdEmpresa());
		selected = false;
		NavigationBean.selectedPanel = "inicioPorHacerPanel";
		
		}catch(Exception ex){
			//mensajes = true;
		}
	}

	public void rechazarTareaListener(ActionEvent e) {
		configJProcessService.cerrarCreacion(pendienteDto.getId());

		if (tareaDto.getId() == appDto.getIdTareaFinal())
			configJProcessService
					.cerrarSolicitud(Integer.parseInt(outputAppId));
		else {
			TareaDTO tarea = configJProcessService.selectTareaById(creacionDto
					.getIdTareaRechazo());
			configJProcessService.despacharCreacion(
					creacionDto.getIdTareaRechazo(), solicitudDto.getId(),
					tarea.getIdRolAsignacion());
		}
		listaSolicitud = configJProcessService
				.selectAllSolicitudesPendientesByRol(UsuarioFrontBean.usuarioBean
						.getRol(), UsuarioFrontBean.usuarioBean.getOrganizacion(), UsuarioFrontBean.usuarioBean.getIdEmpresa());
		selected = false;
		NavigationBean.selectedPanel = "inicioPorHacerPanel";
	}

	public void iniciarAplicacionListener(AjaxBehaviorEvent e) {
		@SuppressWarnings("rawtypes")
		Map map = FacesContext.getCurrentInstance().getExternalContext()
				.getRequestParameterMap();
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		
		SolicitudDTO solicitud = new SolicitudDTO();
		idSolicitud = configJProcessService.selectNewSolicitudId();
		solicitud.setId(idSolicitud);

		solicitud.setIdAplicacion(Integer.parseInt((String) map.get("aplicacion")));
		solicitud.setIdEmpresa(UsuarioFrontBean.usuarioBean.getIdEmpresa());
		configJProcessService.insertSolicitud(solicitud);		

		PendienteDTO pendiente = new PendienteDTO();
		pendiente.setIdSolicitud(idSolicitud);
		pendiente.setIdTarea(Integer.parseInt(outputAppInicio));
		pendiente.setIdRol(configJProcessService.selectTareaById(pendiente.getIdTarea()).getIdRolAsignacion());

		configJProcessService.insertPendiente(pendiente);
		
		solicitud = configJProcessService.selectSolicitudById(idSolicitud);

		listaComentario = configJProcessService
				.selectComentariosBySolicitud(idSolicitud);

		listaSolicitud = configJProcessService
				.selectAllSolicitudesPendientesByRol(UsuarioFrontBean.usuarioBean
						.getRol(), UsuarioFrontBean.usuarioBean.getOrganizacion(), UsuarioFrontBean.usuarioBean.getIdEmpresa());

		creacionDto = configJProcessService.selectCreacionByTareaInicial(
				Integer.parseInt(outputAppInicio),
				Integer.parseInt((String) map.get("aplicacion")));
		
		tareaDto = configJProcessService
				.selectTareaActualBySolicitudId(solicitud.getId());
		
		listaConfiguracion = configJProcessService.selectTareaConfiguracionByTarea(tareaDto.getId());
		if(listaConfiguracion.size()>0)
			tieneConfiguracion = true;
		else
			tieneConfiguracion = false;
		
		outputNombreTarea = tareaDto.getNombre();
		outputDescripcionTarea = tareaDto.getDescripcion();
		
		if(tareaDto.getTieneFormulario().equals("S")){
			
			panelDto = configJProcessService.selectAllPanelFormularioByTarea(tareaDto.getId(), Integer.parseInt(outputAppId), instanciaDto.getId());		

			SolicitudFormularioDTO solicitudFormulario = new SolicitudFormularioDTO();
			solicitudFormulario.setIdSolicitud(idSolicitud);
			solicitudFormulario.setIdTarea(tareaDto.getId());
			solicitudFormulario.setIdPanel(panelDto.getId());			
			configJProcessService.insertSolicitudFormulario(solicitudFormulario);
			
			solicitudFormularioDto = configJProcessService.selectSolicitudFormulario(idSolicitud, tareaDto.getId());
			
			if(solicitudFormularioDto.getEstado().equals("P")){
				ingresaFormulario = true;
				modificarFormulario = false;
			}else{
				modificarFormulario = true;
				ingresaFormulario = false;				
			}
			
		}
		else{
			ingresaFormulario = false;
			modificarFormulario = false;
		}
		
		outputCaso = String.valueOf(solicitud.getId());
		outputAplicacion = configJProcessService.selectAplicacionById(
				solicitud.getIdAplicacion()).getAplicacion();
		outputVencimiento = format.format(solicitud.getFechaFin());
		outputPrioridad = tareaDto.getPrioridad();
		outputAppId = String.valueOf(solicitud.getIdAplicacion());
		outputAppDescripcion = configJProcessService.selectAplicacionById(
				solicitud.getIdAplicacion()).getDescripcion();
		outputUsuario = String.valueOf(pendiente.getIdUsuario());
		
		if(pendiente.getIdUsuario()==0)
			tieneAsignacion = false;
		else
			tieneAsignacion = true;

		if (creacionDto.getEsCondicional().equals("S"))
			esRechazo = true;
		else
			esRechazo = false;
		
		if (tareaDto.getTipoTarea().equals("Manual"))
			esAutomatica = false;
		else
			esAutomatica = true;

		configJProcessService.asignarResponsable(UsuarioFrontBean.usuarioBean.getId(), idSolicitud);
		NavigationBean.selectedPanel = "tareaDetallePanel";
	}
	
	
	public void generarFormularioListener(ActionEvent e){		
		instanciaDto = configJProcessService.selectInstanciaByEmpresaAplicacion(UsuarioFrontBean.usuarioBean.getIdEmpresa(), appDto.getId());
		panelDto = configJProcessService.selectAllPanelFormularioByTarea(tareaDto.getId(), appDto.getId(), instanciaDto.getId());		
		NavigationBean.selectedPanel = panelDto.getIdPanel(); 				
	}
	
	
	public void verFormularioListener(ActionEvent e){
		if(outputAplicacion.equals("Hipoteca")){
			panelDto = configJProcessService.selectAllPanelFormularioByTarea(tareaDto.getId(), appDto.getId(), instanciaDto.getId());	
			HipotecaFrontClass.getDataForForm(Integer.parseInt(outputCaso));
			HipotecaFrontClass.formularioCompleto = true;
			NavigationBean.selectedPanel = panelDto.getIdPanel(); 	
		}
	}
	

	public void tomarTareaListener(ActionEvent e) {
		for (SolicitudDTO solicitud : listaSolicitud) {
			if(solicitud.isSelected() == true){
				configJProcessService.asignarResponsable(UsuarioFrontBean.usuarioBean.getId(), solicitud.getId());				
				toDoSelect(solicitud);
			}
		}
		
		selected = true;
	}
	
	public void liberarTareaListener(ActionEvent e){
		for (SolicitudDTO solicitud : listaSolicitud) {
			if(solicitud.isSelected() == true)
				configJProcessService.liberarResponsable(UsuarioFrontBean.usuarioBean.getId(), solicitud.getId());			
		}
		
		selected = false;
	}
	
	public void ocultarTareaListener(ActionEvent e){
		Iterator<SolicitudDTO> it = listaSolicitud.iterator();
		while (it.hasNext()) {
			SolicitudDTO solicitud = it.next(); 
		    if (solicitud.isSelected() == true) {
		         it.remove();
		         listaSolicitud.remove(solicitud);
		     }
		}
	}
	
	public void refreshListaTareasListener(ActionEvent e){
		listaSolicitud = configJProcessService
				.selectAllSolicitudesPendientesByRol(UsuarioFrontBean.usuarioBean
						.getRol(), UsuarioFrontBean.usuarioBean.getOrganizacion(), UsuarioFrontBean.usuarioBean.getIdEmpresa());
	}

	public void checkboxValueTareaChangeListener(ValueChangeEvent evt) {
		boolean estado = Boolean.parseBoolean(evt.getNewValue().toString());
		System.out.println(estado);
		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map map = context.getExternalContext().getRequestParameterMap();
		int id = Integer.parseInt(String.valueOf(map.get("id")).trim());
		System.out.println("Id : " + selected);

		if (estado) {
			for (int i = 0; i < listaTareaDto.size(); i++) {
				if (listaTareaDto.get(i).getId() == id) {
					// listaTareaDto.get(i).setSelected(false);
				}
			}

		} else
			for (int i = 0; i < listaTareaDto.size(); i++) {
				if (listaTareaDto.get(i).getId() == id) {
					// listaTareaDto.get(i).setSelected(true);
				}
			}

	}

	public void cerrarPopUpErrorListener(ActionEvent e){
		isPopUpError = false;
		mensaje      = "";
	}
	
	public void ajax(AjaxBehaviorEvent e) {
		FacesContext context = FacesContext.getCurrentInstance();
		@SuppressWarnings("rawtypes")
		Map map = context.getExternalContext().getRequestParameterMap();
		String selected = (String) map.get("valor");
		System.out.println("Valor : " + selected);

		System.out.println("ajax(AjaxBehaviorEvent)");
	}

	public void toDoSelect(SolicitudDTO sol){		
		solicitudDto = sol;
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		tareaDto = configJProcessService
				.selectTareaActualBySolicitudId(solicitudDto.getId());
		
		pendienteDto = configJProcessService.selectPendientesBySolicitud(solicitudDto.getId());
		
		listaConfiguracion = configJProcessService.selectTareaConfiguracionByTarea(tareaDto.getId());
		
		if(listaConfiguracion.size()>0)
			tieneConfiguracion = true;
		else
			tieneConfiguracion = false;

		outputNombreTarea = tareaDto.getNombre();
		outputDescripcionTarea = tareaDto.getDescripcion();
		outputCaso = String.valueOf(solicitudDto.getId());
		outputAplicacion = configJProcessService.selectAplicacionById(
				solicitudDto.getIdAplicacion()).getAplicacion();
		outputVencimiento =    format.format(solicitudDto.getFechaFin());
		outputPrioridad = tareaDto.getPrioridad();
		outputAppId = String.valueOf(solicitudDto.getIdAplicacion());
		outputAppDescripcion = configJProcessService.selectAplicacionById(
				solicitudDto.getIdAplicacion()).getDescripcion();
		outputUsuario = String.valueOf(pendienteDto.getIdUsuario());
		
		if(pendienteDto.getIdUsuario()==0)
			tieneAsignacion = false;
		else
			tieneAsignacion = true;
		

		listaComentario = configJProcessService
				.selectComentariosBySolicitud(Integer.parseInt(outputCaso));

		/*
		 * outputNombreTarea = tareaDto.getNombreTarea(); outputDescripcionTarea
		 * = tareaDto.getDescripcion(); outputCaso =
		 * String.valueOf(tareaDto.getCaso()); outputAplicacion =
		 * tareaDto.getAplicacion(); outputVencimiento =
		 * format.format(tareaDto.getFechaVencimiento()); outputPrioridad =
		 * tareaDto.getPrioridad();
		 */
		selected = true;

		tareaPanel = true;
		casoPanel = false;
		apliacionPanel = false;
	}
	
	public void toDoSelectListener(SelectEvent event) {
		toDoSelect((SolicitudDTO) event.getObject());	
	}

	public void casoSelectListener(SelectEvent event) {
		casoDto = (CasoDTO) event.getObject();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");

		outputCasoIdCaso = String.valueOf(casoDto.getId());
		outputCasoAplicacion = casoDto.getAplicacion();
		outputCasoVersion = casoDto.getAplicacionVersion();
		outputCasoIniciadoEn = format.format(casoDto.getIniciadoEn());
		outputCasoIniciadoPor = casoDto.getIniciadoPor();
		selected = true;

		casoPanel = true;
		tareaPanel = false;
		apliacionPanel = false;
	}

	public void aplicacionSelectListener(SelectEvent event) {

		appDto = (AplicacionDTO) event.getObject();
		
		instanciaDto = configJProcessService.selectInstanciaByEmpresaAplicacion(UsuarioFrontBean.usuarioBean.getIdEmpresa(), appDto.getId());
		outputAppAplicacion = appDto.getAplicacion();
		outputAppDescripcion = appDto.getDescripcion();
		outputAppVersion = appDto.getVersion();
		outputAppInicio = String.valueOf(instanciaDto.getIdTareaInicial());
		outputAppFin = String.valueOf(instanciaDto.getIdTareaFinal());
		outputAppId = String.valueOf(instanciaDto.getIdAplicacion());

		if(instanciaDto != null)
			tieneFlujo = true;
		else
			tieneFlujo = false;
		
		selected = true;
		apliacionPanel = true;
		tareaPanel = false;
		casoPanel = false;
	}
	
	public void abrirPanelEmailListener(ActionEvent e){
		popEmail = true;
	}
	
	public void enviarCorreoListener(ActionEvent e){
		errorEmail         = false;
		errorAsuntoMensaje = false;
		
		if(emailService == null)
			emailService = new EmailService();
		
		if(validateMail(destinatario))
			if(!asunto.trim().equals("") && !mensajeEmail.trim().equals(""))
				emailService.sendEmail(destinatario, asunto, mensajeEmail);	
			else
				errorAsuntoMensaje = true;
		else
			errorEmail = true;
	}
	
	public static boolean validateMail(String mail) {
		Pattern pattern = Pattern.compile(IConstants.REGULAR_PATTERN_MAIL);
		Matcher matcher = pattern.matcher(mail);
		return matcher.matches();
	}
	
	public void cerrarPanelEmailListener(ActionEvent e){
		errorEmail         = false;
		errorAsuntoMensaje = false;
		destinatario = "";
		asunto       = "";
		mensajeEmail = "";
		
		popEmail = false;
	}
	
	public void listener(ActionEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        
        // remove existing messages
        Iterator<FacesMessage> i = facesContext.getMessages();
        while (i.hasNext()) {
            i.next();
            i.remove();
        }
        
        // add messages
        UIComponent component = event.getComponent();
        if (info) {
            String message = "Info Sample";
            FacesMessage facesMessage = new FacesMessage((FacesMessage.Severity) FacesMessage.VALUES.get(0), message, message);
            facesContext.addMessage(component.getClientId(), facesMessage);
        }
        if (warn) {
            String message = "Warn Sample";
            FacesMessage facesMessage = new FacesMessage((FacesMessage.Severity) FacesMessage.VALUES.get(1), message, message);
            facesContext.addMessage(component.getClientId(), facesMessage);
        }
        if (error) {
            String message = "Error Sample";
            FacesMessage facesMessage = new FacesMessage((FacesMessage.Severity) FacesMessage.VALUES.get(2), message, message);
            facesContext.addMessage(component.getClientId(), facesMessage);
        }
        if (fatal) {
            String message = "Fatal Sample";
            FacesMessage facesMessage = new FacesMessage((FacesMessage.Severity) FacesMessage.VALUES.get(3), message, message);
            facesContext.addMessage(component.getClientId(), facesMessage);
        }
        if (!info && !warn && !error && !fatal) {
            String message = "No checkboxes checked";
            FacesMessage facesMessage = new FacesMessage((FacesMessage.Severity) FacesMessage.VALUES.get(0), message, message);
            facesContext.addMessage(component.getClientId(), facesMessage);     
        }
    }
	
	
	
	 public void sampleListener(FileEntryEvent e)
	    {
	        FileEntry fe = (FileEntry)e.getComponent();
	        FileEntryResults results = fe.getResults();
	        File parent = null;

	        fileData = new ArrayList<String>();

	    //get data About File
	    
	        for (FileEntryResults.FileInfo i : results.getFiles()) 
	        {
	            fileData.add("Nombre del Archivo: " + i.getFileName());

	            if (i.isSaved()) {
	                fileData.add("Peso del Archivo: " + i.getSize() + " bytes");
	                //fileData.add("Ruta del Archivo: " + i.getFile().getAbsolutePath() + " bytes");
	                File file = i.getFile();
	                if (file != null) {
	                    parent = file.getParentFile();
	                }
	            } else {
	                fileData.add("File was not saved because: " +
	                    i.getStatus().getFacesMessage(
	                        FacesContext.getCurrentInstance(),
	                        fe, i).getSummary());
	            }
	        }

	        if (parent != null) {
	            long dirSize = 0;
	            int fileCount = 0;
	            for (File file : parent.listFiles()) {
	                fileCount++;
	                dirSize += file.length();
	            }
	            fileData.add("Total de Archivos Subidos: " + fileCount);
	            fileData.add("Total de tamano de archivos en el direcotorio: " + dirSize + " bytes");
	        }
	    }
	 
	/* public void mensajesListener(String checkOption, String level) throws Exception{
            int index = severityMap.get(level);
            String message = severityNames[index] + ": La opción : \"" + checkOption + "\", es requerida para poder continuar";
            FacesMessage facesMessage = new FacesMessage((FacesMessage.Severity) FacesMessage.VALUES.get(index), message, message);
            FacesContext.getCurrentInstance().addMessage("No puede ser nulo", facesMessage);
	        throw new Exception();
	    } */

	/**
	 * @return the tareaDto
	 */
	public TareaDTO getTareaDto() {
		return tareaDto;
	}

	/**
	 * @param tareaDto
	 *            the tareaDto to set
	 */
	public void setTareaDto(TareaDTO tareaDto) {
		this.tareaDto = tareaDto;
	}

	/**
	 * @return the listaTareaDto
	 */
	public List<TareaDTO> getListaTareaDto() {
		return listaTareaDto;
	}

	/**
	 * @param listaTareaDto
	 *            the listaTareaDto to set
	 */
	public void setListaTareaDto(List<TareaDTO> listaTareaDto) {
		this.listaTareaDto = listaTareaDto;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected
	 *            the selected to set
	 */
	@SuppressWarnings("static-access")
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the selectAll
	 */
	public boolean isSelectAll() {
		return selectAll;
	}

	/**
	 * @param selectAll
	 *            the selectAll to set
	 */
	public void setSelectAll(boolean selectAll) {
		this.selectAll = selectAll;
	}

	/**
	 * @return the listaComentario
	 */
	public List<CasoComentarioDTO> getListaComentario() {
		return listaComentario;
	}

	/**
	 * @param listaComentario
	 *            the listaComentario to set
	 */
	public void setListaComentario(List<CasoComentarioDTO> listaComentario) {
		this.listaComentario = listaComentario;
	}

	/**
	 * @return the listaAplicacion
	 */
	public List<AplicacionDTO> getListaAplicacion() {
		return listaAplicacion;
	}

	/**
	 * @param listaAplicacion
	 *            the listaAplicacion to set
	 */
	public void setListaAplicacion(List<AplicacionDTO> listaAplicacion) {
		this.listaAplicacion = listaAplicacion;
	}

	/**
	 * @return the listaCaso
	 */
	public List<CasoDTO> getListaCaso() {
		return listaCaso;
	}

	/**
	 * @param listaCaso
	 *            the listaCaso to set
	 */
	public void setListaCaso(List<CasoDTO> listaCaso) {
		this.listaCaso = listaCaso;
	}

	/**
	 * @return the outputNombreTarea
	 */
	public String getOutputNombreTarea() {
		return outputNombreTarea;
	}

	/**
	 * @param outputNombreTarea
	 *            the outputNombreTarea to set
	 */
	public void setOutputNombreTarea(String outputNombreTarea) {
		this.outputNombreTarea = outputNombreTarea;
	}

	/**
	 * @return the outputDescripcionTarea
	 */
	public String getOutputDescripcionTarea() {
		return outputDescripcionTarea;
	}

	/**
	 * @param outputDescripcionTarea
	 *            the outputDescripcionTarea to set
	 */
	public void setOutputDescripcionTarea(String outputDescripcionTarea) {
		this.outputDescripcionTarea = outputDescripcionTarea;
	}

	/**
	 * @return the outputCaso
	 */
	public String getOutputCaso() {
		return outputCaso;
	}

	/**
	 * @param outputCaso
	 *            the outputCaso to set
	 */
	public void setOutputCaso(String outputCaso) {
		this.outputCaso = outputCaso;
	}

	/**
	 * @return the outputAplicacion
	 */
	public String getOutputAplicacion() {
		return outputAplicacion;
	}

	/**
	 * @param outputAplicacion
	 *            the outputAplicacion to set
	 */
	public void setOutputAplicacion(String outputAplicacion) {
		this.outputAplicacion = outputAplicacion;
	}

	/**
	 * @return the outputVencimiento
	 */
	public String getOutputVencimiento() {
		return outputVencimiento;
	}

	/**
	 * @param outputVencimiento
	 *            the outputVencimiento to set
	 */
	public void setOutputVencimiento(String outputVencimiento) {
		this.outputVencimiento = outputVencimiento;
	}

	/**
	 * @return the outputPrioridad
	 */
	public String getOutputPrioridad() {
		return outputPrioridad;
	}

	/**
	 * @param outputPrioridad
	 *            the outputPrioridad to set
	 */
	public void setOutputPrioridad(String outputPrioridad) {
		this.outputPrioridad = outputPrioridad;
	}

	/**
	 * @return the listaComentariosCaso
	 */
	public List<CasoComentarioDTO> getListaComentariosCaso() {
		return listaComentariosCaso;
	}

	/**
	 * @param listaComentariosCaso
	 *            the listaComentariosCaso to set
	 */
	public void setListaComentariosCaso(
			List<CasoComentarioDTO> listaComentariosCaso) {
		this.listaComentariosCaso = listaComentariosCaso;
	}

	/**
	 * @return the inputComentario
	 */
	public String getInputComentario() {
		return inputComentario;
	}

	/**
	 * @param inputComentario
	 *            the inputComentario to set
	 */
	public void setInputComentario(String inputComentario) {
		this.inputComentario = inputComentario;
	}

	/**
	 * @return the tareaPanel
	 */
	public boolean isTareaPanel() {
		return tareaPanel;
	}

	/**
	 * @param tareaPanel
	 *            the tareaPanel to set
	 */
	public void setTareaPanel(boolean tareaPanel) {
		this.tareaPanel = tareaPanel;
	}

	/**
	 * @return the casoPanel
	 */
	public boolean isCasoPanel() {
		return casoPanel;
	}

	/**
	 * @param casoPanel
	 *            the casoPanel to set
	 */
	public void setCasoPanel(boolean casoPanel) {
		this.casoPanel = casoPanel;
	}

	/**
	 * @return the apliacionPanel
	 */
	public boolean isApliacionPanel() {
		return apliacionPanel;
	}

	/**
	 * @param apliacionPanel
	 *            the apliacionPanel to set
	 */
	public void setApliacionPanel(boolean apliacionPanel) {
		this.apliacionPanel = apliacionPanel;
	}

	/**
	 * @return the outputCasoIdCaso
	 */
	public String getOutputCasoIdCaso() {
		return outputCasoIdCaso;
	}

	/**
	 * @param outputCasoIdCaso
	 *            the outputCasoIdCaso to set
	 */
	public void setOutputCasoIdCaso(String outputCasoIdCaso) {
		this.outputCasoIdCaso = outputCasoIdCaso;
	}

	/**
	 * @return the outputCasoAplicacion
	 */
	public String getOutputCasoAplicacion() {
		return outputCasoAplicacion;
	}

	/**
	 * @param outputCasoAplicacion
	 *            the outputCasoAplicacion to set
	 */
	public void setOutputCasoAplicacion(String outputCasoAplicacion) {
		this.outputCasoAplicacion = outputCasoAplicacion;
	}

	/**
	 * @return the outputCasoVersion
	 */
	public String getOutputCasoVersion() {
		return outputCasoVersion;
	}

	/**
	 * @param outputCasoVersion
	 *            the outputCasoVersion to set
	 */
	public void setOutputCasoVersion(String outputCasoVersion) {
		this.outputCasoVersion = outputCasoVersion;
	}

	/**
	 * @return the outputCasoIniciadoEn
	 */
	public String getOutputCasoIniciadoEn() {
		return outputCasoIniciadoEn;
	}

	/**
	 * @param outputCasoIniciadoEn
	 *            the outputCasoIniciadoEn to set
	 */
	public void setOutputCasoIniciadoEn(String outputCasoIniciadoEn) {
		this.outputCasoIniciadoEn = outputCasoIniciadoEn;
	}

	/**
	 * @return the outputCasoIniciadoPor
	 */
	public String getOutputCasoIniciadoPor() {
		return outputCasoIniciadoPor;
	}

	/**
	 * @param outputCasoIniciadoPor
	 *            the outputCasoIniciadoPor to set
	 */
	public void setOutputCasoIniciadoPor(String outputCasoIniciadoPor) {
		this.outputCasoIniciadoPor = outputCasoIniciadoPor;
	}

	/**
	 * @return the outputAppAplicacion
	 */
	public String getOutputAppAplicacion() {
		return outputAppAplicacion;
	}

	/**
	 * @param outputAppAplicacion
	 *            the outputAppAplicacion to set
	 */
	public void setOutputAppAplicacion(String outputAppAplicacion) {
		this.outputAppAplicacion = outputAppAplicacion;
	}

	/**
	 * @return the outputAppDescripcion
	 */
	public String getOutputAppDescripcion() {
		return outputAppDescripcion;
	}

	/**
	 * @param outputAppDescripcion
	 *            the outputAppDescripcion to set
	 */
	public void setOutputAppDescripcion(String outputAppDescripcion) {
		this.outputAppDescripcion = outputAppDescripcion;
	}

	/**
	 * @return the outputAppVersion
	 */
	public String getOutputAppVersion() {
		return outputAppVersion;
	}

	/**
	 * @param outputAppVersion
	 *            the outputAppVersion to set
	 */
	public void setOutputAppVersion(String outputAppVersion) {
		this.outputAppVersion = outputAppVersion;
	}

	/**
	 * @return the casoDto
	 */
	public CasoDTO getCasoDto() {
		return casoDto;
	}

	/**
	 * @param casoDto
	 *            the casoDto to set
	 */
	public void setCasoDto(CasoDTO casoDto) {
		this.casoDto = casoDto;
	}

	/**
	 * @return the appDto
	 */
	public AplicacionDTO getAppDto() {
		return appDto;
	}

	/**
	 * @param appDto
	 *            the appDto to set
	 */
	public void setAppDto(AplicacionDTO appDto) {
		this.appDto = appDto;
	}

	/**
	 * @return the outputAppInicio
	 */
	public String getOutputAppInicio() {
		return outputAppInicio;
	}

	/**
	 * @param outputAppInicio
	 *            the outputAppInicio to set
	 */
	public void setOutputAppInicio(String outputAppInicio) {
		this.outputAppInicio = outputAppInicio;
	}

	/**
	 * @return the outputAppFin
	 */
	public String getOutputAppFin() {
		return outputAppFin;
	}

	/**
	 * @param outputAppFin
	 *            the outputAppFin to set
	 */
	public void setOutputAppFin(String outputAppFin) {
		this.outputAppFin = outputAppFin;
	}

	/**
	 * @return the configjselectorService
	 */
	public IConfigJProcessService getConfigJProcessService() {
		return configJProcessService;
	}

	/**
	 * @param configjselectorService
	 *            the configjselectorService to set
	 */
	public void setConfigJProcessService(
			IConfigJProcessService configJProcessService) {
		this.configJProcessService = configJProcessService;
	}

	/**
	 * @return the outputAppId
	 */
	public String getOutputAppId() {
		return outputAppId;
	}

	/**
	 * @param outputAppId
	 *            the outputAppId to set
	 */
	public void setOutputAppId(String outputAppId) {
		this.outputAppId = outputAppId;
	}

	/**
	 * @return the listaSolicitud
	 */
	public List<SolicitudDTO> getListaSolicitud() {
		return listaSolicitud;
	}

	/**
	 * @param listaSolicitud
	 *            the listaSolicitud to set
	 */
	public void setListaSolicitud(List<SolicitudDTO> listaSolicitud) {
		this.listaSolicitud = listaSolicitud;
	}

	/**
	 * @return the solicitudDto
	 */
	public SolicitudDTO getSolicitudDto() {
		return solicitudDto;
	}

	/**
	 * @param solicitudDto
	 *            the solicitudDto to set
	 */
	public void setSolicitudDto(SolicitudDTO solicitudDto) {
		this.solicitudDto = solicitudDto;
	}

	/**
	 * @return the creacionDto
	 */
	public CreacionDTO getCreacionDto() {
		return creacionDto;
	}

	/**
	 * @param creacionDto
	 *            the creacionDto to set
	 */
	public void setCreacionDto(CreacionDTO creacionDto) {
		this.creacionDto = creacionDto;
	}

	/**
	 * @return the esRechazo
	 */
	public boolean isEsRechazo() {
		return esRechazo;
	}

	/**
	 * @param esRechazo
	 *            the esRechazo to set
	 */
	public void setEsRechazo(boolean esRechazo) {
		this.esRechazo = esRechazo;
	}

	/**
	 * @return the esAutomatica
	 */
	public boolean isEsAutomatica() {
		return esAutomatica;
	}

	/**
	 * @param esAutomatica
	 *            the esAutomatica to set
	 */
	public void setEsAutomatica(boolean esAutomatica) {
		this.esAutomatica = esAutomatica;
	}

	/**
	 * @return the outputUsuario
	 */
	public String getOutputUsuario() {
		return outputUsuario;
	}

	/**
	 * @param outputUsuario the outputUsuario to set
	 */
	public void setOutputUsuario(String outputUsuario) {
		this.outputUsuario = outputUsuario;
	}

	/**
	 * @return the tieneAsignacion
	 */
	public boolean isTieneAsignacion() {
		return tieneAsignacion;
	}

	/**
	 * @param tieneAsignacion the tieneAsignacion to set
	 */
	public void setTieneAsignacion(boolean tieneAsignacion) {
		this.tieneAsignacion = tieneAsignacion;
	}

	/**
	 * @return the fileData
	 */
	public List<String> getFileData() {
		return fileData;
	}

	/**
	 * @param fileData the fileData to set
	 */
	public void setFileData(List<String> fileData) {
		this.fileData = fileData;
	}

	/**
	 * @return the pendienteDto
	 */
	public PendienteDTO getPendienteDto() {
		return pendienteDto;
	}

	/**
	 * @param pendienteDto the pendienteDto to set
	 */
	public void setPendienteDto(PendienteDTO pendienteDto) {
		this.pendienteDto = pendienteDto;
	}

	/**
	 * @return the listaConfiguracion
	 */
	public List<TareaConfiguracionDTO> getListaConfiguracion() {
		return listaConfiguracion;
	}

	/**
	 * @param listaConfiguracion the listaConfiguracion to set
	 */
	public void setListaConfiguracion(List<TareaConfiguracionDTO> listaConfiguracion) {
		this.listaConfiguracion = listaConfiguracion;
	}

	/**
	 * @return the mensajes
	 */
	public boolean isMensajes() {
		return mensajes;
	}

	/**
	 * @param mensajes the mensajes to set
	 */
	public void setMensajes(boolean mensajes) {
		this.mensajes = mensajes;
	}

	public boolean isPopUpError() {
		return isPopUpError;
	}

	public void setPopUpError(boolean isPopUpError) {
		this.isPopUpError = isPopUpError;
	}

	public String getRutaImagen() {
		return rutaImagen;
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public boolean isIngresaFormulario() {
		return ingresaFormulario;
	}

	public void setIngresaFormulario(boolean ingresaFormulario) {
		this.ingresaFormulario = ingresaFormulario;
	}

	public boolean isModificarFormulario() {
		return modificarFormulario;
	}

	public void setModificarFormulario(boolean modificarFormulario) {
		this.modificarFormulario = modificarFormulario;
	}

	public boolean isPopEmail() {
		return popEmail;
	}

	public void setPopEmail(boolean popEmail) {
		this.popEmail = popEmail;
	}

	public boolean isTieneConfiguracion() {
		return tieneConfiguracion;
	}

	public void setTieneConfiguracion(boolean tieneConfiguracion) {
		this.tieneConfiguracion = tieneConfiguracion;
	}

	public InstanciaDTO getInstanciaDto() {
		return instanciaDto;
	}

	public void setInstanciaDto(InstanciaDTO instanciaDto) {
		this.instanciaDto = instanciaDto;
	}

	public boolean isTieneFlujo() {
		return tieneFlujo;
	}

	public void setTieneFlujo(boolean tieneFlujo) {
		this.tieneFlujo = tieneFlujo;
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public EmailService getEmailService() {
		return emailService;
	}

	public void setEmailService(EmailService emailService) {
		this.emailService = emailService;
	}

	public String getMensajeEmail() {
		return mensajeEmail;
	}

	public void setMensajeEmail(String mensajeEmail) {
		this.mensajeEmail = mensajeEmail;
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

	public boolean isErrorEmail() {
		return errorEmail;
	}

	public void setErrorEmail(boolean errorEmail) {
		this.errorEmail = errorEmail;
	}

	public boolean isErrorAsuntoMensaje() {
		return errorAsuntoMensaje;
	}

	public void setErrorAsuntoMensaje(boolean errorAsuntoMensaje) {
		this.errorAsuntoMensaje = errorAsuntoMensaje;
	}		
}
