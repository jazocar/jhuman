package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.EstructuraDTO;
import cl.jazocar.jselector.dto.ParametroDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = "estructuraFrontBean")
@SessionScoped
public class EstructuraFrontBean extends AplicationAbstract {
	
	public static List<SelectItem> listaListas;
	public static List<SelectItem> listaClase;
	private List<EstructuraDTO> listaEstructura;
	
	private EstructuraDTO estructura;
	
	//Atributos del formulario
	private String nombre;
	private String modelo;
	private String lista;
	private String clase;
	private String requerido;
	
	private boolean selected;

	public EstructuraFrontBean() {
		init();
	}

	public void init() {
		
		listaEstructura = configJProcessService.selectEstructura();
		
		listaListas = new ArrayList<SelectItem>();
		listaClase  = new ArrayList<SelectItem>();
		
		for(ParametroDTO parametro : configJProcessService.selectParametroByTipoParametro(7))
			listaListas.add(new SelectItem(parametro.getId(), parametro.getNombre()));
		
		for(ParametroDTO parametro : configJProcessService.selectParametroByTipoParametro(1))
			listaClase.add(new SelectItem(parametro.getId(), parametro.getNombre()));
	}

	public void insertObjectListener(ActionEvent e) {
	}

	public void updateObjectListener(ActionEvent e) {
	}

	public void deleteObjectListener(ActionEvent e) {
	}

	public void resetObjectListener(ActionEvent e) {
		resetObject();
	}

	public void searchObjectListener(ActionEvent e) {
		
		estructura = new EstructuraDTO();
		estructura.setNombre(nombre.trim());
		estructura.setModeloOrganizacion(modelo);
		estructura.setIdLista(Integer.parseInt(lista));
		estructura.setIdClase(Integer.parseInt(clase));
		estructura.setRequerido(requerido);
		listaEstructura = configJProcessService.searchEstructura(estructura);
	}

	public void resetObject() {
		nombre = "";
		modelo = "-1";
		lista  =  "-1";
		clase  = "-1";
		requerido = "Si";
		selected = false;
		listaEstructura = configJProcessService.selectEstructura();
	}

	public void objectSelectListener(SelectEvent event) {
		
		estructura = (EstructuraDTO) event.getObject();
		nombre = estructura.getNombre();
		modelo = estructura.getModeloOrganizacion();
		lista  = String.valueOf(estructura.getIdLista());
		clase  = String.valueOf(estructura.getIdClase());
		requerido = estructura.getRequerido();
		selected = true;
	}

	public List<EstructuraDTO> getListaEstructura() {
		return listaEstructura;
	}

	public void setListaEstructura(List<EstructuraDTO> listaEstructura) {
		this.listaEstructura = listaEstructura;
	}

	public List<SelectItem> getListaListas() {
		return listaListas;
	}

	public void setListaListas(List<SelectItem> listaListas) {
		this.listaListas = listaListas;
	}

	public List<SelectItem> getListaClase() {
		return listaClase;
	}

	public void setListaClase(List<SelectItem> listaClase) {
		this.listaClase = listaClase;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public EstructuraDTO getEstructura() {
		return estructura;
	}

	public void setEstructura(EstructuraDTO estructura) {
		this.estructura = estructura;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getLista() {
		return lista;
	}

	public void setLista(String lista) {
		this.lista = lista;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getRequerido() {
		return requerido;
	}

	public void setRequerido(String requerido) {
		this.requerido = requerido;
	}

	
	
}
