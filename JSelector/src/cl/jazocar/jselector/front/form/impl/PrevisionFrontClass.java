package cl.jazocar.jselector.front.form.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.CiudadDTO;
import cl.jazocar.jselector.dto.ListaDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = "previsionFrontClass")
@SessionScoped
public class PrevisionFrontClass extends AplicationAbstract {
	
	private List<SelectItem> listaInstitucionSalud;
	private List<SelectItem> listaMonedaPactada;
	private List<SelectItem> listaAFP;
	private List<SelectItem> listaJubilacion;
	
	public PrevisionFrontClass(){
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

		listaInstitucionSalud = new ArrayList<SelectItem>();
		listaMonedaPactada    = new ArrayList<SelectItem>();
		listaAFP              = new ArrayList<SelectItem>();
		listaJubilacion       = new ArrayList<SelectItem>();
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(22))
			listaInstitucionSalud.add(new SelectItem(lista.getId(), lista.getValor()));	
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(57))
			listaMonedaPactada.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(58))
			listaAFP.add(new SelectItem(lista.getId(), lista.getValor()));		
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(59))
			listaJubilacion.add(new SelectItem(lista.getId(), lista.getValor()));	
		
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

	public List<SelectItem> getListaInstitucionSalud() {
		return listaInstitucionSalud;
	}

	public void setListaInstitucionSalud(List<SelectItem> listaInstitucionSalud) {
		this.listaInstitucionSalud = listaInstitucionSalud;
	}

	public List<SelectItem> getListaMonedaPactada() {
		return listaMonedaPactada;
	}

	public void setListaMonedaPactada(List<SelectItem> listaMonedaPactada) {
		this.listaMonedaPactada = listaMonedaPactada;
	}

	public List<SelectItem> getListaAFP() {
		return listaAFP;
	}

	public void setListaAFP(List<SelectItem> listaAFP) {
		this.listaAFP = listaAFP;
	}

	public List<SelectItem> getListaJubilacion() {
		return listaJubilacion;
	}

	public void setListaJubilacion(List<SelectItem> listaJubilacion) {
		this.listaJubilacion = listaJubilacion;
	}
	
}
