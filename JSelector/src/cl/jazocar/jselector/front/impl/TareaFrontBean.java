/**
 * 
 */
package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.dto.OrganizacionDTO;
import cl.jazocar.jselector.dto.TareaDTO;
import cl.jazocar.jselector.sys.dto.RolDTO;

/**
 * @author Diablo
 *
 */
@ManagedBean (name = TareaFrontBean.TAREA_BEAN)
@SessionScoped
public class TareaFrontBean {

	public static final String TAREA_BEAN = "tareaBean";
	
	private List<TareaDTO> listaTareas;
	private List<SelectItem> listaOrg;
	private List<SelectItem> listaRol;
	private static TareaDTO tarea;
	
	private boolean selected;
	
	//Valores
	private String inputNombre;
	private String inputDescripcion;
	private String selectedPrioridad;
	private String selectedTipoTarea;
	private String selectedOrganizacion;
	private String selectedTipoDuracion;
	private String inputDuracion;
	private String selectedTipoAsignacion;
	private String selectedRolAsignacion;
	
	private int    idTarea;
	
	private IConfigJProcessService configJProcessService;	
	
	
	public TareaFrontBean(){
		configJProcessService = JProcessFactoryService.getInstance().getService("CONF_JPROCESS_SERVICE", IConfigJProcessService.class );		
		listaOrg = new ArrayList<SelectItem>();
		
		for (OrganizacionDTO org : configJProcessService.selectAllOrganizacion())
			listaOrg.add(new SelectItem(org.getId(), org.getNombre()));
		
		listaRol = new ArrayList<SelectItem>();
		
		for (RolDTO rol : configJProcessService.selectAllRol())
			listaRol.add(new SelectItem(rol.getId(), rol.getNombreRol()));
		
		listaTareas = configJProcessService.selectAllTarea();
	}

	public void insertTareaListener(ActionEvent e){
		try{
			configJProcessService.insertTarea(getTareaFromForm());
			resetTarea();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void updateTareaListener(ActionEvent e){
		try{
			configJProcessService.updateTarea(getTareaFromForm());
			resetTarea();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void deleteTareaListener(ActionEvent e){
		try{
			configJProcessService.deleteTarea(getTareaFromForm());
			resetTarea();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void resetTareaListener(ActionEvent e){
		resetTarea();
	}
	
	public void resetTarea(){
		inputNombre            = "";
		inputDescripcion       = "";
		selectedPrioridad      = "-1";
		selectedTipoTarea      = "-1";
		selectedOrganizacion   = "-1";
		selectedTipoDuracion   = "-1";
		inputDuracion          = "";
		selectedTipoAsignacion = "-1";
		selectedRolAsignacion  = "-1";
		idTarea                = 0;
		listaTareas = configJProcessService.selectAllTarea();
		
		selected = false;
	}

	
	public void tareaSelectListener(SelectEvent event) {
		tarea = (TareaDTO) event.getObject();		
		inputNombre            = tarea.getNombre();
		inputDescripcion       = tarea.getDescripcion();
		selectedPrioridad      = tarea.getPrioridad();
		selectedTipoTarea      = tarea.getTipoTarea();
		selectedOrganizacion   = String.valueOf(tarea.getIdOrganizacion());
		selectedTipoDuracion   = tarea.getTipoDuracion();
		inputDuracion          = String.valueOf(tarea.getDuracion());
		selectedTipoAsignacion = tarea.getTipoAsignacion();
		selectedRolAsignacion  = String.valueOf(tarea.getIdRolAsignacion());
		idTarea                = tarea.getId();
		selected = true;
		
	}
	
	public TareaDTO getTareaFromForm(){
		tarea = new TareaDTO();
		tarea.setId(idTarea);
		tarea.setNombre(inputNombre);
		tarea.setDescripcion(inputDescripcion);
		tarea.setPrioridad(selectedPrioridad);
		tarea.setTipoTarea(selectedTipoTarea);
		tarea.setIdOrganizacion(Integer.parseInt(selectedOrganizacion));
		tarea.setTipoDuracion(selectedTipoDuracion);
		tarea.setDuracion(Integer.parseInt(inputDuracion));
		tarea.setTipoAsignacion(selectedTipoAsignacion);
		tarea.setIdRolAsignacion(Integer.parseInt(selectedRolAsignacion));
		return tarea;
	}
	
	/**
	 * @return the configjselectorService
	 */
	public IConfigJProcessService getConfigJProcessService() {
		return configJProcessService;
	}


	/**
	 * @param configjselectorService the configjselectorService to set
	 */
	public void setConfigjselectorService(
			IConfigJProcessService configJProcessService) {
		this.configJProcessService = configJProcessService;
	}

	/**
	 * @return the listaTareas
	 */
	public List<TareaDTO> getListaTareas() {
		return listaTareas;
	}

	/**
	 * @param listaTareas the listaTareas to set
	 */
	public void setListaTareas(List<TareaDTO> listaTareas) {
		this.listaTareas = listaTareas;
	}

	/**
	 * @return the tarea
	 */
	public static TareaDTO getTarea() {
		return tarea;
	}

	/**
	 * @param tarea the tarea to set
	 */
	public static void setTarea(TareaDTO tarea) {
		TareaFrontBean.tarea = tarea;
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
	 * @return the inputNombre
	 */
	public String getInputNombre() {
		return inputNombre;
	}

	/**
	 * @param inputNombre the inputNombre to set
	 */
	public void setInputNombre(String inputNombre) {
		this.inputNombre = inputNombre;
	}

	/**
	 * @return the inputDescripcion
	 */
	public String getInputDescripcion() {
		return inputDescripcion;
	}

	/**
	 * @param inputDescripcion the inputDescripcion to set
	 */
	public void setInputDescripcion(String inputDescripcion) {
		this.inputDescripcion = inputDescripcion;
	}

	/**
	 * @return the selectedPrioridad
	 */
	public String getSelectedPrioridad() {
		return selectedPrioridad;
	}

	/**
	 * @param selectedPrioridad the selectedPrioridad to set
	 */
	public void setSelectedPrioridad(String selectedPrioridad) {
		this.selectedPrioridad = selectedPrioridad;
	}

	/**
	 * @return the selectedTipoTarea
	 */
	public String getSelectedTipoTarea() {
		return selectedTipoTarea;
	}

	/**
	 * @param selectedTipoTarea the selectedTipoTarea to set
	 */
	public void setSelectedTipoTarea(String selectedTipoTarea) {
		this.selectedTipoTarea = selectedTipoTarea;
	}

	/**
	 * @return the selectedOrganizacion
	 */
	public String getSelectedOrganizacion() {
		return selectedOrganizacion;
	}

	/**
	 * @param selectedOrganizacion the selectedOrganizacion to set
	 */
	public void setSelectedOrganizacion(String selectedOrganizacion) {
		this.selectedOrganizacion = selectedOrganizacion;
	}

	/**
	 * @return the selectedTipoDuracion
	 */
	public String getSelectedTipoDuracion() {
		return selectedTipoDuracion;
	}

	/**
	 * @param selectedTipoDuracion the selectedTipoDuracion to set
	 */
	public void setSelectedTipoDuracion(String selectedTipoDuracion) {
		this.selectedTipoDuracion = selectedTipoDuracion;
	}

	/**
	 * @return the inputDuracion
	 */
	public String getInputDuracion() {
		return inputDuracion;
	}

	/**
	 * @param inputDuracion the inputDuracion to set
	 */
	public void setInputDuracion(String inputDuracion) {
		this.inputDuracion = inputDuracion;
	}

	/**
	 * @return the selectedTipoAsignacion
	 */
	public String getSelectedTipoAsignacion() {
		return selectedTipoAsignacion;
	}

	/**
	 * @param selectedTipoAsignacion the selectedTipoAsignacion to set
	 */
	public void setSelectedTipoAsignacion(String selectedTipoAsignacion) {
		this.selectedTipoAsignacion = selectedTipoAsignacion;
	}

	/**
	 * @return the selectedRolAsignacion
	 */
	public String getSelectedRolAsignacion() {
		return selectedRolAsignacion;
	}

	/**
	 * @param selectedRolAsignacion the selectedRolAsignacion to set
	 */
	public void setSelectedRolAsignacion(String selectedRolAsignacion) {
		this.selectedRolAsignacion = selectedRolAsignacion;
	}

	/**
	 * @return the idTarea
	 */
	public int getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * @return the listaOrg
	 */
	public List<SelectItem> getListaOrg() {
		return listaOrg;
	}

	/**
	 * @param listaOrg the listaOrg to set
	 */
	public void setListaOrg(List<SelectItem> listaOrg) {
		this.listaOrg = listaOrg;
	}

	/**
	 * @return the listaRol
	 */
	public List<SelectItem> getListaRol() {
		return listaRol;
	}

	/**
	 * @param listaRol the listaRol to set
	 */
	public void setListaRol(List<SelectItem> listaRol) {
		this.listaRol = listaRol;
	}
	
	
	
}
