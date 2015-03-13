package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dto.AplicacionDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = IConstants.SYS_INSTANCIA_BEAN)
@SessionScoped
public class InstanciaFrontClass extends AplicationAbstract{

	private List<AplicacionDTO> listaAplicacion;
	private List<SelectItem>    listaAplicacionSelect;
	
	
	
	public InstanciaFrontClass(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		listaAplicacion = configJProcessService.selectAllAplicacion();
		
		listaAplicacionSelect = new ArrayList<SelectItem>();
		
		for(AplicacionDTO aplicacion : listaAplicacion)
			listaAplicacionSelect.add(new SelectItem(aplicacion.getId(), aplicacion.getAplicacion()));
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

	public List<AplicacionDTO> getListaAplicacion() {
		return listaAplicacion;
	}

	public void setListaAplicacion(List<AplicacionDTO> listaAplicacion) {
		this.listaAplicacion = listaAplicacion;
	}

	public List<SelectItem> getListaAplicacionSelect() {
		return listaAplicacionSelect;
	}

	public void setListaAplicacionSelect(List<SelectItem> listaAplicacionSelect) {
		this.listaAplicacionSelect = listaAplicacionSelect;
	}
	
	
	
	

}
