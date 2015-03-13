package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.dto.AplicacionDTO;
import cl.jazocar.jselector.dto.CreacionDTO;
import cl.jazocar.jselector.dto.EmpresaDTO;
import cl.jazocar.jselector.dto.InstanciaDTO;
import cl.jazocar.jselector.dto.OrganizacionDTO;
import cl.jazocar.jselector.dto.TareaDTO;

@ManagedBean (name = ConstruccionFrontBean.CONSTRUCCION_BEAN)
@SessionScoped
public class ConstruccionFrontBean {

	public static final String CONSTRUCCION_BEAN = "construccionFrontBean";
	
	public List<AplicacionDTO>     listaAplicacion;	
	public List<CreacionDTO>       listaConstruccion;
	public List<InstanciaDTO>      listaInstancia;
	private IConfigJProcessService configJProcessService;
	
	private List<SelectItem> listaOrganizacion;
	private List<SelectItem> listaEmpresas;
	
	private AplicacionDTO aplicacion;
	private CreacionDTO   creacion;
	private InstanciaDTO  instancia;
	private boolean selected;
	private boolean selectedCreacion;
	private boolean selectedCrearInstancia;
	private int     idAplicacion;
	private int     idCreacion;
	
	private List<SelectItem> tareasInicio;
	private List<SelectItem> tareasDestino;
	private List<SelectItem> tareasRechazo;
	
	private String tareaInicial;
	private String tareaFinal;
	
	//Instancia.
	private int    idInstancia;
	private String nombreInstancia;
	private String empresa;
	private String tipoAsociacion;
	private String organizacion;
	private String tareaInicio;
	private String tareaFin;
	
	private List<SelectItem> tareaInicioInstancia;
	private List<SelectItem> tareaFinInstancia;
	
	private String selectedTareaInicio;
	private String selectedTareaDestino;
	private String selectedTareaRechazo;
	private String selectedEsCondicional;
	private String selectedTipoDestino;
	
	//Duplicacion.
	private String nombreInstanciaDup;
	private String selectedOrganizacionDup;
	private String selectedEmpresaDup;
	
	
	private static boolean selectedFlujo;
	private static boolean selectedInstancia;
	private static boolean selectedGeneracion;
	private boolean abrirDuplicarFlujo;
	
	public ConstruccionFrontBean(){
		configJProcessService = JProcessFactoryService.getInstance()
				.getService("CONF_JPROCESS_SERVICE",
						IConfigJProcessService.class);
		
		listaAplicacion = configJProcessService.selectAllAplicacion();
		tareasInicio   = new ArrayList<SelectItem>();
		tareasDestino  = new ArrayList<SelectItem>();
		tareasRechazo  = new ArrayList<SelectItem>();
		tareaInicioInstancia  = new ArrayList<SelectItem>();
		tareaFinInstancia   = new ArrayList<SelectItem>();
		
		
		listaConstruccion = new ArrayList<CreacionDTO>();
		for (TareaDTO tarea : configJProcessService.selectAllTarea()){
			tareasInicio.add(new SelectItem( tarea.getId(), tarea.getNombre()));
			tareasDestino.add(new SelectItem( tarea.getId(), tarea.getNombre()));
			tareasRechazo.add(new SelectItem( tarea.getId(), tarea.getNombre()));
			tareaInicioInstancia.add(new SelectItem( tarea.getId(), tarea.getNombre()));
			tareaFinInstancia.add(new SelectItem( tarea.getId(), tarea.getNombre()));
		}
		
		selectedInstancia = false;
		selectedGeneracion = false;
		selectedFlujo = true;		
		
		listaInstancia = new ArrayList<InstanciaDTO>();
		
		listaOrganizacion  = new ArrayList<SelectItem>();
		listaEmpresas      = new ArrayList<SelectItem>();
		
		for(OrganizacionDTO org : configJProcessService.selectAllOrganizacion())
			listaOrganizacion.add(new SelectItem(org.getId(), org.getNombre()));
	}
	
	public void agregarEventoListener(ActionEvent e){
		CreacionDTO creacion = new CreacionDTO();
		int idCreacion = configJProcessService.selectNewSolicitudId();
		creacion.setId(idCreacion);
		creacion.setIdAplicacion(idAplicacion);
		creacion.setIdTareaInicio(Integer.parseInt(selectedTareaInicio));
		creacion.setIdTareaExito(Integer.parseInt(selectedTareaDestino));
		creacion.setEsCondicional(selectedEsCondicional);
		creacion.setIdTareaRechazo(Integer.parseInt(selectedTareaRechazo));
		creacion.setTipoDestino(selectedTipoDestino);
		
		configJProcessService.insertCreacion(creacion);
		configJProcessService.updateInicioFinAplicacion(idAplicacion);
		listaConstruccion = configJProcessService.selectCreacionByIdAplicacion(idAplicacion);
		resetEvento();
	}
	
	public void updateEventoListener(ActionEvent e){
		CreacionDTO creacion = new CreacionDTO();
		creacion.setId(idCreacion);
		creacion.setIdAplicacion(idAplicacion);
		creacion.setIdTareaInicio(Integer.parseInt(selectedTareaInicio));
		creacion.setIdTareaExito(Integer.parseInt(selectedTareaDestino));
		creacion.setEsCondicional(selectedEsCondicional);
		creacion.setIdTareaRechazo(Integer.parseInt(selectedTareaRechazo));
		creacion.setTipoDestino(selectedTipoDestino);
		
		configJProcessService.updateCreacion(creacion);
		configJProcessService.updateInicioFinAplicacion(idAplicacion);
		aplicacion = configJProcessService.selectAplicacionById(idAplicacion);
		tareaInicial = String.valueOf(aplicacion.getIdTareaInicial());
		tareaFinal   = String.valueOf(aplicacion.getIdTareaFinal());
		listaConstruccion = configJProcessService.selectCreacionByIdAplicacion(idAplicacion);
		
		resetEvento();
	}
	
	public void eventoSelectListener(SelectEvent event){
		creacion = (CreacionDTO) event.getObject();	
		
		selectedTareaInicio   = String.valueOf(creacion.getIdTareaInicio());
		selectedTareaDestino  = String.valueOf(creacion.getIdTareaExito());
		selectedTareaRechazo  = String.valueOf(creacion.getIdTareaRechazo());
		selectedEsCondicional = creacion.getEsCondicional();
		selectedTipoDestino   = String.valueOf(creacion.getTipoDestino());
		idCreacion            = creacion.getId();
		
		selectedCreacion = true;		
	}
	
	
	
	public void changeOrganizacionListener(ValueChangeEvent evnt) {
		String valor = evnt.getNewValue().toString();
		listaEmpresas = new ArrayList<SelectItem>();
		for(EmpresaDTO empresa : configJProcessService.selectEmpresasByOrganizacion(Integer.parseInt(valor)))
				listaEmpresas.add(new SelectItem(empresa.getId(), empresa.getNombre()));
	}
	
	public void instanciaSelectListener(SelectEvent event){
		instancia = (InstanciaDTO) event.getObject();
		idInstancia     = instancia.getId();
		nombreInstancia = instancia.getNombreInstancia();
		organizacion    = String.valueOf(instancia.getIdOrganizacion());
		
		listaEmpresas = new ArrayList<SelectItem>();
		for(EmpresaDTO empresa : configJProcessService.selectEmpresasByOrganizacion(Integer.parseInt(organizacion)))
				listaEmpresas.add(new SelectItem(empresa.getId(), empresa.getNombre()));
		
		empresa         = String.valueOf(instancia.getIdEmpresa());
		tareaInicio     = String.valueOf(instancia.getIdTareaInicial());
		tareaFin        = String.valueOf(instancia.getIdTareaFinal());
		
		selectedCrearInstancia = true;
	}
	
	public void limpiarInstanciaListener(ActionEvent e){
		limpiarInstancia();
	}
	
	public void limpiarInstancia(){
		idInstancia     = 0;
		nombreInstancia = "";
		organizacion    = "-1";
		empresa         = "-1";
		listaEmpresas   = new ArrayList<SelectItem>();
		tareaInicio = "-1";
		tareaFin    = "-1";
		selectedCrearInstancia = false;
	}
	
	public void aplicacionSelectListener(SelectEvent event) {
		aplicacion = (AplicacionDTO) event.getObject();			
		idAplicacion     = aplicacion.getId();
		tareaInicial     = String.valueOf(aplicacion.getIdTareaInicial());
		tareaFinal       = String.valueOf(aplicacion.getIdTareaFinal());
		
		tipoAsociacion    = aplicacion.getTipoAsociacion();
		listaConstruccion = configJProcessService.selectCreacionByIdAplicacion(idAplicacion);
		
		listaInstancia  = configJProcessService.selectInstanciaByAplicacion(aplicacion.getId());
		selectedFlujo         = false;
		selectedGeneracion    = false;
		selectedInstancia     = true;
	}
	
	public void insertarInstanciaListener(ActionEvent e){
		InstanciaDTO instancia = new InstanciaDTO();
		idInstancia = configJProcessService.selectIdNextInstancia();		
		instancia.setId(idInstancia);
		instancia.setIdAplicacion(idAplicacion);
		instancia.setIdOrganizacion(Integer.parseInt(organizacion));
		instancia.setIdEmpresa(Integer.parseInt(empresa));
		instancia.setIdTareaInicial(Integer.parseInt(tareaInicio));
		instancia.setIdTareaFinal(Integer.parseInt(tareaFin));
		instancia.setNombreInstancia(nombreInstancia);
		
		configJProcessService.insertInstancia(instancia);
		listaInstancia  = configJProcessService.selectInstanciaByAplicacion(aplicacion.getId());
		limpiarInstancia();
	}
	
	public void resetEventoListener(ActionEvent e){
		resetEvento();
	}
	
	public void resetEvento(){
		selectedTareaInicio   = "-1";
		selectedTareaDestino  = "-1";
		selectedTareaRechazo  = "-1";
		selectedEsCondicional = "-1";
		selectedTipoDestino   = "-1";
		idCreacion            = 0;
		
		selectedCreacion = false;
	}
	
	public void cerrarVentanaInstanciaListener(ActionEvent e){
		selectedGeneracion = false;
		selectedInstancia  = false;
		selectedFlujo  = true;
	}
	
	public void cerrarVentanaGeneracionListener(ActionEvent e){
		selectedGeneracion = false;
		selectedFlujo  = false;
		selectedInstancia  = true;		
	}
	
	public void generarFlujoListener(ActionEvent e){
		
		tareaInicial     = String.valueOf(tareaInicio);
		tareaFinal       = String.valueOf(tareaFin);
		
		listaConstruccion = configJProcessService.selectCreacionByIdAplicacion(idInstancia);
		
		selectedFlujo      = false;
		selectedInstancia  = false;		
		selectedGeneracion = true;
	}
	
	public void avanzarVentanaInstanciaListener(ActionEvent e){		
		
		idAplicacion     = aplicacion.getId();
		tareaInicial     = String.valueOf(aplicacion.getIdTareaInicial());
		tareaFinal       = String.valueOf(aplicacion.getIdTareaFinal());
		
		listaConstruccion = configJProcessService.selectCreacionByIdAplicacion(idInstancia);
		
		selectedFlujo      = false;
		selectedInstancia  = false;		
		selectedGeneracion = true;
	}
	
	public void duplicarFlujoListener(ActionEvent e){
		
		InstanciaDTO instancia = new InstanciaDTO();
		int id = configJProcessService.selectIdNextInstancia();		
		instancia.setId(id);
		instancia.setIdAplicacion(idAplicacion);
		instancia.setIdOrganizacion(Integer.parseInt(selectedOrganizacionDup));
		instancia.setIdEmpresa(Integer.parseInt(selectedEmpresaDup));
		instancia.setIdTareaInicial(Integer.parseInt(tareaInicio));
		instancia.setIdTareaFinal(Integer.parseInt(tareaFin));
		instancia.setNombreInstancia(nombreInstanciaDup);
		
		configJProcessService.insertInstancia(instancia);
		listaInstancia  = configJProcessService.selectInstanciaByAplicacion(aplicacion.getId());		
		listaConstruccion = configJProcessService.selectCreacionByIdAplicacion(idInstancia);
		
		int idCreacion = 0;
		
		for(CreacionDTO creacion : listaConstruccion){
			//creacion.set			
			idCreacion = configJProcessService.selectNewSolicitudId();
			creacion.setIdAplicacion(id);
			creacion.setId(idCreacion);
			
			configJProcessService.insertCreacion(creacion);
		}
		
		limpiarInstancia();
		
		abrirDuplicarFlujo = false;
	}
	
	public void abrirDuplicarFlujoListener(ActionEvent e){
		abrirDuplicarFlujo = true;
	}
	
	public void cerrarDuplicarFlujoListener(ActionEvent e){
		abrirDuplicarFlujo = false;
	}
	

	/**
	 * @return the listaAplicacion
	 */
	public List<AplicacionDTO> getListaAplicacion() {
		return listaAplicacion;
	}

	/**
	 * @param listaAplicacion the listaAplicacion to set
	 */
	public void setListaAplicacion(List<AplicacionDTO> listaAplicacion) {
		this.listaAplicacion = listaAplicacion;
	}

	/**
	 * @return the configjselectorService
	 */
	public IConfigJProcessService getConfigjselectorService() {
		return configJProcessService;
	}

	/**
	 * @param configjselectorService the configjselectorService to set
	 */
	public void setConfigJProcessService(
			IConfigJProcessService configJProcessService) {
		this.configJProcessService = configJProcessService;
	}

	/**
	 * @return the construccionBean
	 */
	public static String getConstruccionBean() {
		return CONSTRUCCION_BEAN;
	}

	/**
	 * @return the aplicacion
	 */
	public AplicacionDTO getAplicacion() {
		return aplicacion;
	}

	/**
	 * @param aplicacion the aplicacion to set
	 */
	public void setAplicacion(AplicacionDTO aplicacion) {
		this.aplicacion = aplicacion;
	}

	/**
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the idAplicacion
	 */
	public int getIdAplicacion() {
		return idAplicacion;
	}

	/**
	 * @param idAplicacion the idAplicacion to set
	 */
	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	/**
	 * @return the tareasInicio
	 */
	public List<SelectItem> getTareasInicio() {
		return tareasInicio;
	}

	/**
	 * @param tareasInicio the tareasInicio to set
	 */
	public void setTareasInicio(List<SelectItem> tareasInicio) {
		this.tareasInicio = tareasInicio;
	}

	/**
	 * @return the tareasDestino
	 */
	public List<SelectItem> getTareasDestino() {
		return tareasDestino;
	}

	/**
	 * @param tareasDestino the tareasDestino to set
	 */
	public void setTareasDestino(List<SelectItem> tareasDestino) {
		this.tareasDestino = tareasDestino;
	}

	/**
	 * @return the selectedTareaInicio
	 */
	public String getSelectedTareaInicio() {
		return selectedTareaInicio;
	}

	/**
	 * @param selectedTareaInicio the selectedTareaInicio to set
	 */
	public void setSelectedTareaInicio(String selectedTareaInicio) {
		this.selectedTareaInicio = selectedTareaInicio;
	}

	/**
	 * @return the selectedTareaDestino
	 */
	public String getSelectedTareaDestino() {
		return selectedTareaDestino;
	}

	/**
	 * @param selectedTareaDestino the selectedTareaDestino to set
	 */
	public void setSelectedTareaDestino(String selectedTareaDestino) {
		this.selectedTareaDestino = selectedTareaDestino;
	}

	/**
	 * @return the listaConstruccion
	 */
	public List<CreacionDTO> getListaConstruccion() {
		return listaConstruccion;
	}

	/**
	 * @param listaConstruccion the listaConstruccion to set
	 */
	public void setListaConstruccion(List<CreacionDTO> listaConstruccion) {
		this.listaConstruccion = listaConstruccion;
	}

	/**
	 * @return the tareasRechazo
	 */
	public List<SelectItem> getTareasRechazo() {
		return tareasRechazo;
	}

	/**
	 * @param tareasRechazo the tareasRechazo to set
	 */
	public void setTareasRechazo(List<SelectItem> tareasRechazo) {
		this.tareasRechazo = tareasRechazo;
	}

	/**
	 * @return the selectedTareaRechazo
	 */
	public String getSelectedTareaRechazo() {
		return selectedTareaRechazo;
	}

	/**
	 * @param selectedTareaRechazo the selectedTareaRechazo to set
	 */
	public void setSelectedTareaRechazo(String selectedTareaRechazo) {
		this.selectedTareaRechazo = selectedTareaRechazo;
	}

	/**
	 * @return the selectedEsCondicional
	 */
	public String getSelectedEsCondicional() {
		return selectedEsCondicional;
	}

	/**
	 * @param selectedEsCondicional the selectedEsCondicional to set
	 */
	public void setSelectedEsCondicional(String selectedEsCondicional) {
		this.selectedEsCondicional = selectedEsCondicional;
	}

	/**
	 * @return the creacion
	 */
	public CreacionDTO getCreacion() {
		return creacion;
	}

	/**
	 * @param creacion the creacion to set
	 */
	public void setCreacion(CreacionDTO creacion) {
		this.creacion = creacion;
	}

	/**
	 * @return the selectedCreacion
	 */
	public boolean isSelectedCreacion() {
		return selectedCreacion;
	}

	/**
	 * @param selectedCreacion the selectedCreacion to set
	 */
	public void setSelectedCreacion(boolean selectedCreacion) {
		this.selectedCreacion = selectedCreacion;
	}

	/**
	 * @return the idCreacion
	 */
	public int getIdCreacion() {
		return idCreacion;
	}

	/**
	 * @param idCreacion the idCreacion to set
	 */
	public void setIdCreacion(int idCreacion) {
		this.idCreacion = idCreacion;
	}

	/**
	 * @return the tareaInicial
	 */
	public String getTareaInicial() {
		return tareaInicial;
	}

	/**
	 * @param tareaInicial the tareaInicial to set
	 */
	public void setTareaInicial(String tareaInicial) {
		this.tareaInicial = tareaInicial;
	}

	/**
	 * @return the tareaFinal
	 */
	public String getTareaFinal() {
		return tareaFinal;
	}

	/**
	 * @param tareaFinal the tareaFinal to set
	 */
	public void setTareaFinal(String tareaFinal) {
		this.tareaFinal = tareaFinal;
	}

	/**
	 * @return the selectedTipoDestino
	 */
	public String getSelectedTipoDestino() {
		return selectedTipoDestino;
	}

	/**
	 * @param selectedTipoDestino the selectedTipoDestino to set
	 */
	public void setSelectedTipoDestino(String selectedTipoDestino) {
		this.selectedTipoDestino = selectedTipoDestino;
	}

	public boolean isSelectedFlujo() {
		return selectedFlujo;
	}

	public void setSelectedFlujo(boolean selectedFlujo) {
		this.selectedFlujo = selectedFlujo;
	}

	public boolean isSelectedInstancia() {
		return selectedInstancia;
	}

	public void setSelectedInstancia(boolean selectedInstancia) {
		this.selectedInstancia = selectedInstancia;
	}

	public boolean isSelectedGeneracion() {
		return selectedGeneracion;
	}

	public void setSelectedGeneracion(boolean selectedGeneracion) {
		this.selectedGeneracion = selectedGeneracion;
	}

	public String getTipoAsociacion() {
		return tipoAsociacion;
	}

	public void setTipoAsociacion(String tipoAsociacion) {
		this.tipoAsociacion = tipoAsociacion;
	}

	public String getOrganizacion() {
		return organizacion;
	}

	public void setOrganizacion(String organizacion) {
		this.organizacion = organizacion;
	}

	public List<SelectItem> getListaOrganizacion() {
		return listaOrganizacion;
	}

	public void setListaOrganizacion(List<SelectItem> listaOrganizacion) {
		this.listaOrganizacion = listaOrganizacion;
	}

	public List<SelectItem> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<SelectItem> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public InstanciaDTO getInstancia() {
		return instancia;
	}

	public void setInstancia(InstanciaDTO instancia) {
		this.instancia = instancia;
	}

	public boolean isSelectedCrearInstancia() {
		return selectedCrearInstancia;
	}

	public void setSelectedCrearInstancia(boolean selectedCrearInstancia) {
		this.selectedCrearInstancia = selectedCrearInstancia;
	}

	public String getNombreInstancia() {
		return nombreInstancia;
	}

	public void setNombreInstancia(String nombreInstancia) {
		this.nombreInstancia = nombreInstancia;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public List<InstanciaDTO> getListaInstancia() {
		return listaInstancia;
	}

	public void setListaInstancia(List<InstanciaDTO> listaInstancia) {
		this.listaInstancia = listaInstancia;
	}

	public String getTareaInicio() {
		return tareaInicio;
	}

	public void setTareaInicio(String tareaInicio) {
		this.tareaInicio = tareaInicio;
	}

	public String getTareaFin() {
		return tareaFin;
	}

	public void setTareaFin(String tareaFin) {
		this.tareaFin = tareaFin;
	}

	public List<SelectItem> getTareaInicioInstancia() {
		return tareaInicioInstancia;
	}

	public void setTareaInicioInstancia(List<SelectItem> tareaInicioInstancia) {
		this.tareaInicioInstancia = tareaInicioInstancia;
	}

	public List<SelectItem> getTareaFinInstancia() {
		return tareaFinInstancia;
	}

	public void setTareaFinInstancia(List<SelectItem> tareaFinInstancia) {
		this.tareaFinInstancia = tareaFinInstancia;
	}

	public boolean isAbrirDuplicarFlujo() {
		return abrirDuplicarFlujo;
	}

	public void setAbrirDuplicarFlujo(boolean abrirDuplicarFlujo) {
		this.abrirDuplicarFlujo = abrirDuplicarFlujo;
	}

	public int getIdInstancia() {
		return idInstancia;
	}

	public void setIdInstancia(int idInstancia) {
		this.idInstancia = idInstancia;
	}

	public String getNombreInstanciaDup() {
		return nombreInstanciaDup;
	}

	public void setNombreInstanciaDup(String nombreInstanciaDup) {
		this.nombreInstanciaDup = nombreInstanciaDup;
	}

	public String getSelectedOrganizacionDup() {
		return selectedOrganizacionDup;
	}

	public void setSelectedOrganizacionDup(String selectedOrganizacionDup) {
		this.selectedOrganizacionDup = selectedOrganizacionDup;
	}

	public String getSelectedEmpresaDup() {
		return selectedEmpresaDup;
	}

	public void setSelectedEmpresaDup(String selectedEmpresaDup) {
		this.selectedEmpresaDup = selectedEmpresaDup;
	}
		
	
}
