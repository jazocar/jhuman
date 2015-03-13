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
import cl.jazocar.jselector.dto.AreaDTO;
import cl.jazocar.jselector.dto.SubareaDTO;

@ManagedBean(name = SubareaFrontBean.SUBAREA_BEAN)
@SessionScoped
public class SubareaFrontBean {

	public static final String SUBAREA_BEAN = "subareaFrontBean";

	private List<SubareaDTO> listaSubarea;
	private List<SelectItem> listaAreas;

	private SubareaDTO subarea;

	private String inputArea;
	private String inputNombre;
	private String inputDescripcion;

	private int idSubarea;

	private boolean selected;

	private IConfigJProcessService configJProcessService;

	public SubareaFrontBean() {
		configJProcessService = JProcessFactoryService.getInstance()
				.getService("CONF_JPROCESS_SERVICE",
						IConfigJProcessService.class);
		listaSubarea = configJProcessService.selectSubareas();

		listaAreas = new ArrayList<SelectItem>();
		for (AreaDTO area : configJProcessService.selectAreas())
			listaAreas.add(new SelectItem(area.getId(), area.getNombre()));
	}

	public void insertSubareaListener(ActionEvent e) {
		subarea = new SubareaDTO();
		subarea.setIdArea(Integer.parseInt(inputArea));
		subarea.setNombre(inputNombre);
		subarea.setDescripcion(inputDescripcion);
		configJProcessService.insertSubarea(subarea);
		resetSubarea();
	}

	public void updateSubareaListener(ActionEvent e) {
		subarea = new SubareaDTO();
		subarea.setId(idSubarea);
		subarea.setIdArea(Integer.parseInt(inputArea));
		subarea.setNombre(inputNombre);
		subarea.setDescripcion(inputDescripcion);
		configJProcessService.updateSubarea(subarea);
		resetSubarea();
	}

	public void deleteSubareaListener(ActionEvent e) {
		subarea = new SubareaDTO();
		subarea.setId(idSubarea);
		configJProcessService.deleteSubarea(subarea);
		resetSubarea();
	}

	public void resetSubareaListener(ActionEvent e){
		resetSubarea();
	}
	
	public void resetSubarea(){
		
		inputArea = "-1";
		inputNombre = "";
		inputDescripcion = "";
		idSubarea = 0;
		
		listaSubarea = configJProcessService.selectSubareas();

		selected = false;
	}
	
	public void subareaSelectListener(SelectEvent event) {
		subarea = (SubareaDTO) event.getObject();	
		
		idSubarea = subarea.getId();
		inputArea = String.valueOf(subarea.getIdArea());
		inputNombre = subarea.getNombre();
		inputDescripcion = subarea.getDescripcion();		
		selected = true;
	}

	/**
	 * @return the listaSubarea
	 */
	public List<SubareaDTO> getListaSubarea() {
		return listaSubarea;
	}

	/**
	 * @param listaSubarea the listaSubarea to set
	 */
	public void setListaSubarea(List<SubareaDTO> listaSubarea) {
		this.listaSubarea = listaSubarea;
	}

	/**
	 * @return the listaAreas
	 */
	public List<SelectItem> getListaAreas() {
		return listaAreas;
	}

	/**
	 * @param listaAreas the listaAreas to set
	 */
	public void setListaAreas(List<SelectItem> listaAreas) {
		this.listaAreas = listaAreas;
	}

	/**
	 * @return the subarea
	 */
	public SubareaDTO getSubarea() {
		return subarea;
	}

	/**
	 * @param subarea the subarea to set
	 */
	public void setSubarea(SubareaDTO subarea) {
		this.subarea = subarea;
	}

	/**
	 * @return the inputArea
	 */
	public String getInputArea() {
		return inputArea;
	}

	/**
	 * @param inputArea the inputArea to set
	 */
	public void setInputArea(String inputArea) {
		this.inputArea = inputArea;
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
	 * @return the idSubarea
	 */
	public int getIdSubarea() {
		return idSubarea;
	}

	/**
	 * @param idSubarea the idSubarea to set
	 */
	public void setIdSubarea(int idSubarea) {
		this.idSubarea = idSubarea;
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
	 * @return the subareaBean
	 */
	public static String getSubareaBean() {
		return SUBAREA_BEAN;
	}
	
	
}
