package cl.jazocar.jselector.front.report.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.front.form.dto.FichaPersonalDTO;

@ManagedBean (name = "repFuncionariosFrontClass")
@SessionScoped
public class RepFuncionariosFrontClass extends AplicationAbstract {
	
	private List<FichaPersonalDTO> listaFichaPersonal;
	
	public RepFuncionariosFrontClass(){
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaFichaPersonal = formService.selectFichaPersonal();
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

	public List<FichaPersonalDTO> getListaFichaPersonal() {
		return listaFichaPersonal;
	}

	public void setListaFichaPersonal(List<FichaPersonalDTO> listaFichaPersonal) {
		this.listaFichaPersonal = listaFichaPersonal;
	}
	
	

}
