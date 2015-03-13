/**
 * 
 */
package cl.jazocar.jselector.sys.front;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.sys.dto.PanelDTO;
import cl.jazocar.jselector.util.PropertiesService;

/**
 * @author Diablo
 * 
 */
@ManagedBean(name = "panelFrontBean")
@ApplicationScoped
public class PanelFrontBean extends AplicationAbstract{

	private List<PanelDTO> listaPanel;
	
	private String panelId;
	private String panelSubviewId;
	private String include;	
	private String esFormulario;
	
	private static PanelDTO panel;
	private boolean selected;
	
	public PanelFrontBean(){
		listaPanel = new ArrayList<PanelDTO>();
		listaPanel = configJProcessService.selectAllPanel();
		selected = false;
	}
	
	
	public void panelInsertListener(ActionEvent e) {
		try{
		PanelDTO panel = null;
		panel = new PanelDTO(panelId, panelId+"Sub", include, esFormulario);
		
		ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		String realPath=(String) servletContext.getRealPath("/");
		String[] tempFile = include.split("/");
		realPath +="WEB-INF/includes/panels/"+tempFile[0];
		
		File ruta = new File(realPath);
		File archivo = new File(realPath+"/"+tempFile[1]);
		
		if(!ruta.exists()){
			ruta.mkdirs();
			if(!archivo.exists()){
				archivo.createNewFile();				
				PrintWriter pw = null;
				FileWriter fichero = null;				
				fichero = new FileWriter(archivo);
				pw = new PrintWriter(fichero);
				pw.println(IConstants.CONTENIDO_ARCHIVO_BASE);				
				pw.close();
			}			
		}else{
			if(!archivo.exists()){
				archivo.createNewFile();				
				PrintWriter pw = null;
				FileWriter fichero = null;				
				fichero = new FileWriter(archivo);
				pw = new PrintWriter(fichero);
				pw.println(IConstants.CONTENIDO_ARCHIVO_BASE);				
				pw.close();
			}
		}
		
		
		
		//Creación en el proyecto fuente.
		File rutaFuente    = new File(PropertiesService.getInstance().getValue("development.path")+tempFile[0]);
		File archivoFuente = new File(rutaFuente+"/"+tempFile[1]);
		if(!rutaFuente.exists()){
			rutaFuente.mkdirs();
			if(!archivoFuente.exists()){
				archivoFuente.createNewFile();				
				PrintWriter pw = null;
				FileWriter fichero = null;				
				fichero = new FileWriter(archivoFuente);
				pw = new PrintWriter(fichero);
				pw.println(IConstants.CONTENIDO_ARCHIVO_BASE);				
				pw.close();
			}			
		}else{
			if(!archivoFuente.exists()){
				archivoFuente.createNewFile();				
				PrintWriter pw = null;
				FileWriter fichero = null;				
				fichero = new FileWriter(archivoFuente);
				pw = new PrintWriter(fichero);
				pw.println(IConstants.CONTENIDO_ARCHIVO_BASE);				
				pw.close();
			}
		}		
		
		// Insertamos el registro.
		configJProcessService.insertPanel(panel);
		
		MenuFrontBean.actualizarListaPaneles(configJProcessService.selectAllPanel());

		// Limpiamos los campos
		panelReset();

		// Refrescamos los valores de la Lista de Productos para mostrar el
		// nuevo producto agregado.
		listaPanel = configJProcessService.selectAllPanel();		
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

	
	
	public void panelUpdateListener(ActionEvent e) {
		System.out.println("Update");
		if (panel != null) {
			
			panel = new PanelDTO(panel.getId(), panelId, panelSubviewId, include, esFormulario);
			
			// Actualizamos el Registro
			configJProcessService.updatePanel(panel);
			// Limpiamos los campos
			panelReset();
			// Refrescamos los valores de la Lista de Proveedores para mostrar el
			// nuevo proveedor agregado.
			listaPanel = configJProcessService.selectAllPanel();
		} else {
			System.out.println("Objeto nulo");
		}
	}

	public void panelDeleteListener(ActionEvent e) {
		System.out.println("Eliminando");
		if (panel != null) {
			configJProcessService.deletePanel(panel.getId());
			// Limpiamos los campos
			panelReset();
			// Refrescamos los valores de la Lista de Proveedores para mostrar el
			// nuevo proveedor  agregado.
			listaPanel = configJProcessService.selectAllPanel();
		}else {
			System.out.println("Objeto nulo");
		}
	}

	public void panelResetListener(ActionEvent e) {
		panelReset();
	}

	public void panelReset(){
		panelId            = "";
		panelSubviewId     = "";
		include            = "";	
		esFormulario       = "N";
		
		selected = false;
		panel = null;
	}
	
	public void panelSelectListener(SelectEvent event) {
		panel = (PanelDTO) event.getObject();

		panelId            = panel.getIdPanel();
		panelSubviewId     = panel.getIdSubview();
		include            = panel.getInclude();	
		esFormulario       = panel.getEsFormulario();
		
		selected = true;
		
	}
	
	public void refreshPanelListener(ActionEvent e){
		listaPanel = configJProcessService.selectAllPanel();	
	}
	
	/**
	 * @return the listaPanel
	 */
	public List<PanelDTO> getListaPanel() {
		return listaPanel;
	}
	/**
	 * @param listaPanel the listaPanel to set
	 */
	public void setListaPanel(List<PanelDTO> listaPanel) {
		this.listaPanel = listaPanel;
	}
	/**
	 * @return the panelId
	 */
	public String getPanelId() {
		return panelId;
	}
	/**
	 * @param panelId the panelId to set
	 */
	public void setPanelId(String panelId) {
		this.panelId = panelId;
	}
	/**
	 * @return the panelSubviewId
	 */
	public String getPanelSubviewId() {
		return panelSubviewId;
	}
	/**
	 * @param panelSubviewId the panelSubviewId to set
	 */
	public void setPanelSubviewId(String panelSubviewId) {
		this.panelSubviewId = panelSubviewId;
	}
	/**
	 * @return the include
	 */
	public String getInclude() {
		return include;
	}
	/**
	 * @param include the include to set
	 */
	public void setInclude(String include) {
		this.include = include;
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


	public String getEsFormulario() {
		return esFormulario;
	}


	public void setEsFormulario(String esFormulario) {
		this.esFormulario = esFormulario;
	}


	@Override
	public void init() {
		// TODO Auto-generated method stub
		
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
	
	
	
}
