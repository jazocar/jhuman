/**
 * 
 */
package cl.jazocar.jselector.front.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.dto.OrganizacionDTO;

/**
 * @author Diablo
 *
 */
@ManagedBean (name = OrganizacionFrontBean.ORGANIZACION_BEAN)
@SessionScoped
public class OrganizacionFrontBean {

	public static final String ORGANIZACION_BEAN = "organizacionFrontBean";
	public List<OrganizacionDTO> listaOrganizacion;
	
	private IConfigJProcessService configJProcessService;		
	private String nombreOrganizacion;	
	private OrganizacionDTO organizacion;	
	private boolean selected;	
	private int idOrganizacion;
	
	public OrganizacionFrontBean(){
		configJProcessService = JProcessFactoryService.getInstance().getService("CONF_JPROCESS_SERVICE", IConfigJProcessService.class );		
		listaOrganizacion = configJProcessService.selectAllOrganizacion();
	}
	
	public void insertOrganizacionListener(ActionEvent e){		
		organizacion = new OrganizacionDTO();
		organizacion.setNombre(nombreOrganizacion);
		configJProcessService.insertOrganizacion(organizacion);
		resetOrganizacion();
	}
	
	public void updateOrganizacionListener(ActionEvent e){	
		organizacion = new OrganizacionDTO();
		organizacion.setId(idOrganizacion);
		organizacion.setNombre(nombreOrganizacion);
		configJProcessService.updateOrganizacion(organizacion);
		resetOrganizacion();
	}
	
	public void deleteOrganizacionListener(ActionEvent e){	
		organizacion = new OrganizacionDTO();
		organizacion.setId(idOrganizacion);
		configJProcessService.deleteOrganizacion(organizacion);
		resetOrganizacion();
	}
	
	public void resetOrganizacionListener(ActionEvent e){
		resetOrganizacion();
	}
	
	public void resetOrganizacion(){
		nombreOrganizacion = "";
		idOrganizacion     = 0;
		listaOrganizacion = configJProcessService.selectAllOrganizacion();
		selected = false;
	}
	
	public void organizacionSelectListener(SelectEvent event) {
		organizacion = (OrganizacionDTO) event.getObject();		
		nombreOrganizacion = organizacion.getNombre();
		idOrganizacion     = organizacion.getId();
		selected = true;
	}

	/**
	 * @return the listaOrganizacion
	 */
	public List<OrganizacionDTO> getListaOrganizacion() {
		return listaOrganizacion;
	}

	/**
	 * @param listaOrganizacion the listaOrganizacion to set
	 */
	public void setListaOrganizacion(List<OrganizacionDTO> listaOrganizacion) {
		this.listaOrganizacion = listaOrganizacion;
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
	 * @return the nombreOrganizacion
	 */
	public String getNombreOrganizacion() {
		return nombreOrganizacion;
	}

	/**
	 * @param nombreOrganizacion the nombreOrganizacion to set
	 */
	public void setNombreOrganizacion(String nombreOrganizacion) {
		this.nombreOrganizacion = nombreOrganizacion;
	}

	/**
	 * @return the organizacion
	 */
	public OrganizacionDTO getOrganizacion() {
		return organizacion;
	}

	/**
	 * @param organizacion the organizacion to set
	 */
	public void setOrganizacion(OrganizacionDTO organizacion) {
		this.organizacion = organizacion;
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
	 * @return the idOrganizacion
	 */
	public int getIdOrganizacion() {
		return idOrganizacion;
	}

	/**
	 * @param idOrganizacion the idOrganizacion to set
	 */
	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	
}
