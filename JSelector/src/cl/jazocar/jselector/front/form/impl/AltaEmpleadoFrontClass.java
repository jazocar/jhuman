package cl.jazocar.jselector.front.form.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.ListaDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean(name = "altaEmpleadoFrontClass")
@SessionScoped
public class AltaEmpleadoFrontClass extends AplicationAbstract {
	
	private String chkDiscapacitado;
	private boolean mostrarFirmas;
	
	public static List<SelectItem> listaEmpresa;
	private List<SelectItem>       listaCajaCompensacion;
	public static List<SelectItem> listaEstadoCivil;
	public static List<SelectItem> listaBancos;
	public static List<SelectItem> listaNivelEstudios;
	private List<SelectItem>       listaMutual;
	private List<SelectItem>       listaEstamento;
	private List<SelectItem>       listaCategoriaAdministracion;
	private List<SelectItem>       listaSubCategoriaAdministracion;
	
	private boolean abrirAdministracion;
	private boolean abrirEducacion;
	private boolean abrirSalud;
	
	public AltaEmpleadoFrontClass(){
		init();
	}
	
	public void init() {
		
		listaEstadoCivil      = new ArrayList<SelectItem>();
		listaBancos           = new ArrayList<SelectItem>();
		listaNivelEstudios    = new ArrayList<SelectItem>();
		listaEmpresa          = new ArrayList<SelectItem>();
		listaCajaCompensacion = new ArrayList<SelectItem>();
		listaMutual           = new ArrayList<SelectItem>();
		listaEstamento        = new ArrayList<SelectItem>();
		listaCategoriaAdministracion = new ArrayList<SelectItem>();
		listaSubCategoriaAdministracion = new ArrayList<SelectItem>();
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(8))
			listaEmpresa.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(23))
			listaCajaCompensacion.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(13))
			listaEstamento.add(new SelectItem(lista.getId(), lista.getValor()));		
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(24))
			listaMutual.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(49))
			listaEstadoCivil.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(50))
			listaBancos.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(51))
			listaNivelEstudios.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(10))
			listaCategoriaAdministracion.add(new SelectItem(lista.getId(), lista.getValor()));
		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(11))
			listaSubCategoriaAdministracion.add(new SelectItem(lista.getId(), lista.getValor()));
		
		
	}

	public void insertObjectListener(ActionEvent e) {
		this.mostrarFirmas = true;
	}

	public void updateObjectListener(ActionEvent e) {
	}

	public void deleteObjectListener(ActionEvent e) {
	}

	public void resetObjectListener(ActionEvent e) {
		resetObject();
	}

	public void searchObjectListener(ActionEvent e) {
	}

	public void resetObject() {
		this.chkDiscapacitado = "false";

		this.mostrarFirmas = false;
	}

	public void objectSelectListener(SelectEvent event) {
	}

	
	public void changeModeloNegocio(ValueChangeEvent event){
		String valor = event.getNewValue().toString();
		
		abrirAdministracion = false;
		abrirEducacion      = false;
		abrirSalud          = false;
		
		if(valor.equals("A")){
			abrirAdministracion = true;
		}else if(valor.equals("E")){
			abrirEducacion      = true;
		}else if(valor.equals("S")){
			abrirSalud          = true;
		}
	}
	
	
	public String getChkDiscapacitado() {
		return this.chkDiscapacitado;
	}

	public void setChkDiscapacitado(String chkDiscapacitado) {
		this.chkDiscapacitado = chkDiscapacitado;
	}

	public boolean isMostrarFirmas() {
		return this.mostrarFirmas;
	}

	public void setMostrarFirmas(boolean mostrarFirmas) {
		this.mostrarFirmas = mostrarFirmas;
	}

	public List<SelectItem> getListaEstadoCivil() {
		return listaEstadoCivil;
	}

	public void setListaEstadoCivil(List<SelectItem> listaEstadoCivil) {
		this.listaEstadoCivil = listaEstadoCivil;
	}

	public List<SelectItem> getListaBancos() {
		return listaBancos;
	}

	public void setListaBancos(List<SelectItem> listaBancos) {
		this.listaBancos = listaBancos;
	}

	public List<SelectItem> getListaNivelEstudios() {
		return listaNivelEstudios;
	}

	public void setListaNivelEstudios(List<SelectItem> listaNivelEstudios) {
		this.listaNivelEstudios = listaNivelEstudios;
	}

	public boolean isAbrirAdministracion() {
		return abrirAdministracion;
	}

	public void setAbrirAdministracion(boolean abrirAdministracion) {
		this.abrirAdministracion = abrirAdministracion;
	}

	public boolean isAbrirEducacion() {
		return abrirEducacion;
	}

	public void setAbrirEducacion(boolean abrirEducacion) {
		this.abrirEducacion = abrirEducacion;
	}

	public boolean isAbrirSalud() {
		return abrirSalud;
	}

	public void setAbrirSalud(boolean abrirSalud) {
		this.abrirSalud = abrirSalud;
	}

	public List<SelectItem> getListaEmpresa() {
		return listaEmpresa;
	}

	public void setListaEmpresa(List<SelectItem> listaEmpresa) {
		this.listaEmpresa = listaEmpresa;
	}

	public List<SelectItem> getListaCajaCompensacion() {
		return listaCajaCompensacion;
	}

	public void setListaCajaCompensacion(List<SelectItem> listaCajaCompensacion) {
		this.listaCajaCompensacion = listaCajaCompensacion;
	}

	public List<SelectItem> getListaMutual() {
		return listaMutual;
	}

	public void setListaMutual(List<SelectItem> listaMutual) {
		this.listaMutual = listaMutual;
	}

	public List<SelectItem> getListaEstamento() {
		return listaEstamento;
	}

	public void setListaEstamento(List<SelectItem> listaEstamento) {
		this.listaEstamento = listaEstamento;
	}

	public List<SelectItem> getListaCategoriaAdministracion() {
		return listaCategoriaAdministracion;
	}

	public void setListaCategoriaAdministracion(
			List<SelectItem> listaCategoriaAdministracion) {
		this.listaCategoriaAdministracion = listaCategoriaAdministracion;
	}

	public List<SelectItem> getListaSubCategoriaAdministracion() {
		return listaSubCategoriaAdministracion;
	}

	public void setListaSubCategoriaAdministracion(
			List<SelectItem> listaSubCategoriaAdministracion) {
		this.listaSubCategoriaAdministracion = listaSubCategoriaAdministracion;
	}	

	
}