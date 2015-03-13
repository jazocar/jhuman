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
import cl.jazocar.jselector.dto.AreaDTO;
import cl.jazocar.jselector.dto.OrganizacionDTO;

/**
 * @author Diablo
 *
 */
@ManagedBean (name = AreaFrontBean.AREA_BEAN)
@SessionScoped
public class AreaFrontBean {

	public static final String AREA_BEAN = "areaFrontBean";
	private List<AreaDTO> listaArea;
	private List<SelectItem> listaOrg;
	
	private IConfigJProcessService configJProcessService;		
	
	private String inputOrganizacion;
	private String inputNombre;
	private String inputDescripcion;
	
	private boolean selected;
	private AreaDTO area;
	
	private int idArea;
	
	public AreaFrontBean(){
		configJProcessService = JProcessFactoryService.getInstance().getService("CONF_JPROCESS_SERVICE", IConfigJProcessService.class );		
		listaArea = configJProcessService.selectAreas();
		
		listaOrg = new ArrayList<SelectItem>();
		
		for(OrganizacionDTO org : configJProcessService.selectAllOrganizacion())
			listaOrg.add(new SelectItem( org.getId(), org.getNombre()));
		
	}
	
	public void insertAreaListener(ActionEvent e){
		area = new AreaDTO();
		area.setIdOrganizacion(Integer.parseInt(inputOrganizacion));
		area.setNombre(inputNombre);
		area.setDescripcion(inputDescripcion);
		configJProcessService.insertArea(area);
		resetArea();
	}
	
	public void updateAreaListener(ActionEvent e){
		area = new AreaDTO();
		area.setId(idArea);
		area.setIdOrganizacion(Integer.parseInt(inputOrganizacion));
		area.setNombre(inputNombre);
		area.setDescripcion(inputDescripcion);
		configJProcessService.insertArea(area);
		resetArea();
	}
	
	public void deleteAreaListener(ActionEvent e){
		area = new AreaDTO();
		area.setId(idArea);
		configJProcessService.insertArea(area);
		resetArea();
	}
	
	public void resetAreaListener(ActionEvent e){
		resetArea();
	}
	public void resetArea(){
		inputOrganizacion = "-1";
		inputNombre       = "";
		inputDescripcion  = "";
		
		idArea = 0;
		listaArea = configJProcessService.selectAreas();
		selected = false;
	}
	
	public void organizacionSelectListener(SelectEvent event) {
		area = (AreaDTO) event.getObject();	
		
		idArea = area.getId();
		inputOrganizacion = String.valueOf(area.getIdOrganizacion());
		inputNombre = area.getNombre();
		inputDescripcion = area.getDescripcion();
		
		selected = true;
	}

	/**
	 * @return the listaArea
	 */
	public List<AreaDTO> getListaArea() {
		return listaArea;
	}

	/**
	 * @param listaArea the listaArea to set
	 */
	public void setListaArea(List<AreaDTO> listaArea) {
		this.listaArea = listaArea;
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
	 * @return the inputOrganizacion
	 */
	public String getInputOrganizacion() {
		return inputOrganizacion;
	}

	/**
	 * @param inputOrganizacion the inputOrganizacion to set
	 */
	public void setInputOrganizacion(String inputOrganizacion) {
		this.inputOrganizacion = inputOrganizacion;
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
	 * @return the area
	 */
	public AreaDTO getArea() {
		return area;
	}

	/**
	 * @param area the area to set
	 */
	public void setArea(AreaDTO area) {
		this.area = area;
	}

	/**
	 * @return the idArea
	 */
	public int getIdArea() {
		return idArea;
	}

	/**
	 * @param idArea the idArea to set
	 */
	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}

	/**
	 * @return the areaBean
	 */
	public static String getAreaBean() {
		return AREA_BEAN;
	}	
}
