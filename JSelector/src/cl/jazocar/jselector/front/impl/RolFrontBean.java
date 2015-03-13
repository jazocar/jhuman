package cl.jazocar.jselector.front.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.sys.dto.RolDTO;

@ManagedBean(name = RolFrontBean.ROL_BEAN)
@SessionScoped
public class RolFrontBean {

	public static final String ROL_BEAN = "rolFrontBean";

	public List<RolDTO> listaRol;
	private RolDTO rol;
	
	private String inputNombreRol;

	private IConfigJProcessService configJProcessService;
	
	private boolean selected;
	
	private int idRol;

	public RolFrontBean() {
		configJProcessService = JProcessFactoryService.getInstance()
				.getService("CONF_JPROCESS_SERVICE",
						IConfigJProcessService.class);
		listaRol = configJProcessService.selectAllRol();
	}

	public void insertRolListener(ActionEvent e) {
		rol = new RolDTO();
		rol.setNombreRol(inputNombreRol);
		configJProcessService.insertRol(rol);
		listaRol = configJProcessService.selectAllRol();
	}

	public void updateRolListener(ActionEvent e) {
		rol = new RolDTO();
		rol.setId(idRol);
		rol.setNombreRol(inputNombreRol);
		configJProcessService.updateRol(rol);
		selected = false;
		listaRol = configJProcessService.selectAllRol();
	}

	public void deleteRolListener(ActionEvent e) {		
		configJProcessService.deleteRol(idRol);
		selected = false;
		listaRol = configJProcessService.selectAllRol();
	}
	
	public void resetRolListener(ActionEvent e){
		resetRol();
	}
	
	public void resetRol(){
		inputNombreRol = "";
		idRol = 0;
		selected = false;
	}
	
	public void rolSelectListener(SelectEvent event) {
		rol = (RolDTO) event.getObject();		
		inputNombreRol = rol.getNombreRol();
		idRol          = rol.getId();
		selected = true;
	}

	/**
	 * @return the listaRol
	 */
	public List<RolDTO> getListaRol() {
		return listaRol;
	}

	/**
	 * @param listaRol the listaRol to set
	 */
	public void setListaRol(List<RolDTO> listaRol) {
		this.listaRol = listaRol;
	}

	/**
	 * @return the rol
	 */
	public RolDTO getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(RolDTO rol) {
		this.rol = rol;
	}

	/**
	 * @return the inputNombreRol
	 */
	public String getInputNombreRol() {
		return inputNombreRol;
	}

	/**
	 * @param inputNombreRol the inputNombreRol to set
	 */
	public void setInputNombreRol(String inputNombreRol) {
		this.inputNombreRol = inputNombreRol;
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
	 * @return the rolBean
	 */
	public static String getRolBean() {
		return ROL_BEAN;
	}
	
	
}
