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
import cl.jazocar.jselector.dto.TareaConfiguracionDTO;
import cl.jazocar.jselector.dto.TareaDTO;

/**
 * @author Diablo
 * 
 */
@ManagedBean(name = TareaConfiguracionFrontBean.TAREA_CONFIGURACION_BEAN)
@SessionScoped
public class TareaConfiguracionFrontBean {

	public static final String TAREA_CONFIGURACION_BEAN = "tareaConfiguracionFrontBean";

	private IConfigJProcessService configJProcessService;
	private List<TareaConfiguracionDTO> listaConfiguracion;
	
	private List<SelectItem> listaTareas;

	private TareaConfiguracionDTO configuracion;
	
	private String inputIdTarea;
	private String inputCheckOption;
	private String inputRequerido;

	private boolean selected;
	private int idTareaConfiguracion;

	public TareaConfiguracionFrontBean() {
		configJProcessService = JProcessFactoryService.getInstance()
				.getService("CONF_JPROCESS_SERVICE",
						IConfigJProcessService.class);
		listaConfiguracion = configJProcessService.selectTareaConfiguracion();
		
		listaTareas = new ArrayList<SelectItem>();
		for(TareaDTO tarea : configJProcessService.selectAllTarea())
			listaTareas.add(new SelectItem(tarea.getId(), tarea.getNombre()));
		
	}

	public void insertOrganizacionListener(ActionEvent e) {
		configuracion = new TareaConfiguracionDTO();
		configuracion.setIdTarea(Integer.parseInt(inputIdTarea));
		configuracion.setCheckOption(inputCheckOption);
		configuracion.setRequerido(Boolean.parseBoolean(inputRequerido));
		configJProcessService.insertTareaConfiguracion(configuracion);
		resetTareaConfiguracion();
	}

	public void updateOrganizacionListener(ActionEvent e) {
		configuracion = new TareaConfiguracionDTO();
		configuracion.setId(idTareaConfiguracion);
		configuracion.setIdTarea(Integer.parseInt(inputIdTarea));
		configuracion.setCheckOption(inputCheckOption);
		configuracion.setRequerido(Boolean.parseBoolean(inputRequerido));
		configJProcessService.updateTareaConfiguracion(configuracion);
		resetTareaConfiguracion();
	}

	public void deleteOrganizacionListener(ActionEvent e) {
		configuracion = new TareaConfiguracionDTO();
		configuracion.setId(idTareaConfiguracion);
		configJProcessService.deleteTareaConfiguracion(configuracion);
		resetTareaConfiguracion();
	}
	
	public void resetTareaConfiguracionListener(ActionEvent e){
		resetTareaConfiguracion();
	}
	
	public void resetTareaConfiguracion(){
		
		inputIdTarea = "-1";
		inputCheckOption = "";		
		idTareaConfiguracion = 0;
		inputRequerido = "-1";
		listaConfiguracion = configJProcessService.selectTareaConfiguracion();
		selected = false;
	}
	
	public void tareaConfiguracionSelectListener(SelectEvent event) {
		configuracion = (TareaConfiguracionDTO) event.getObject();			
		idTareaConfiguracion = configuracion.getId();
		inputIdTarea         = String.valueOf(configuracion.getIdTarea());
		inputCheckOption     = configuracion.getCheckOption();
		inputRequerido       = String.valueOf(configuracion.isRequerido());
		selected = true;
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
	public void setConfigJProcessService(
			IConfigJProcessService configJProcessService) {
		this.configJProcessService = configJProcessService;
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
	 * @return the listaTareas
	 */
	public List<SelectItem> getListaTareas() {
		return listaTareas;
	}

	/**
	 * @param listaTareas the listaTareas to set
	 */
	public void setListaTareas(List<SelectItem> listaTareas) {
		this.listaTareas = listaTareas;
	}

	/**
	 * @return the configuracion
	 */
	public TareaConfiguracionDTO getConfiguracion() {
		return configuracion;
	}

	/**
	 * @param configuracion the configuracion to set
	 */
	public void setConfiguracion(TareaConfiguracionDTO configuracion) {
		this.configuracion = configuracion;
	}

	/**
	 * @return the inputIdTarea
	 */
	public String getInputIdTarea() {
		return inputIdTarea;
	}

	/**
	 * @param inputIdTarea the inputIdTarea to set
	 */
	public void setInputIdTarea(String inputIdTarea) {
		this.inputIdTarea = inputIdTarea;
	}

	/**
	 * @return the inputCheckOption
	 */
	public String getInputCheckOption() {
		return inputCheckOption;
	}

	/**
	 * @param inputCheckOption the inputCheckOption to set
	 */
	public void setInputCheckOption(String inputCheckOption) {
		this.inputCheckOption = inputCheckOption;
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
	 * @return the idTareaConfiguracion
	 */
	public int getIdTareaConfiguracion() {
		return idTareaConfiguracion;
	}

	/**
	 * @param idTareaConfiguracion the idTareaConfiguracion to set
	 */
	public void setIdTareaConfiguracion(int idTareaConfiguracion) {
		this.idTareaConfiguracion = idTareaConfiguracion;
	}

	/**
	 * @return the tareaConfiguracionBean
	 */
	public static String getTareaConfiguracionBean() {
		return TAREA_CONFIGURACION_BEAN;
	}

	/**
	 * @return the inputRequerido
	 */
	public String getInputRequerido() {
		return inputRequerido;
	}

	/**
	 * @param inputRequerido the inputRequerido to set
	 */
	public void setInputRequerido(String inputRequerido) {
		this.inputRequerido = inputRequerido;
	}	
	
}
