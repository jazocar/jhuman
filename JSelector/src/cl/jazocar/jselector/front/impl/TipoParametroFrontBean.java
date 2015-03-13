package cl.jazocar.jselector.front.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.TipoParametroDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean(name = "tipoParametroFrontBean")
@SessionScoped
public class TipoParametroFrontBean extends AplicationAbstract {
	private List<TipoParametroDTO> listaTipoParametro;
	private TipoParametroDTO tipoParametro;
	private int id;
	private String nombre;
	private String descripcion;
	private boolean selected;

	public TipoParametroFrontBean() {
		init();
	}

	public void init() {
		this.listaTipoParametro = configJProcessService.selectTipoParametro();
	}

	public void insertObjectListener(ActionEvent e) {
		this.tipoParametro = new TipoParametroDTO();
		this.tipoParametro.setNombre(this.nombre.trim());
		this.tipoParametro.setDescripcion(this.descripcion.trim());
		configJProcessService.insertTipoParametro(this.tipoParametro);
		resetObject();
	}

	public void updateObjectListener(ActionEvent e) {
		this.tipoParametro = new TipoParametroDTO();
		this.tipoParametro.setId(this.id);
		this.tipoParametro.setNombre(this.nombre.trim());
		this.tipoParametro.setDescripcion(this.descripcion.trim());
		configJProcessService.updateTipoParametro(this.tipoParametro);
		resetObject();
	}

	public void deleteObjectListener(ActionEvent e) {
		this.tipoParametro = new TipoParametroDTO();
		this.tipoParametro.setId(this.id);
		this.tipoParametro.setNombre(this.nombre);
		this.tipoParametro.setDescripcion(this.descripcion);
		configJProcessService.deleteTipoParametro(this.tipoParametro);
		resetObject();
	}

	public void resetObjectListener(ActionEvent e) {
		resetObject();
	}

	public void searchObjectListener(ActionEvent e) {
		tipoParametro = new TipoParametroDTO();
		tipoParametro.setNombre(nombre.trim());
		tipoParametro.setDescripcion(descripcion.trim());
		listaTipoParametro = configJProcessService.searchTipoParametro(tipoParametro);
	}

	public void resetObject() {
		this.id = 0;
		this.nombre = "";
		this.descripcion = "";
		this.listaTipoParametro = configJProcessService.selectTipoParametro();
		this.selected = false;
	}

	public void objectSelectListener(SelectEvent event) {
		this.tipoParametro = ((TipoParametroDTO) event.getObject());
		this.id = this.tipoParametro.getId();
		this.nombre = this.tipoParametro.getNombre();
		this.descripcion = this.tipoParametro.getDescripcion();
		this.selected = true;
	}

	public List<TipoParametroDTO> getListaTipoParametro() {
		return this.listaTipoParametro;
	}

	public void setListaTipoParametro(List<TipoParametroDTO> listaTipoParametro) {
		this.listaTipoParametro = listaTipoParametro;
	}

	public TipoParametroDTO getTipoParametro() {
		return this.tipoParametro;
	}

	public void setTipoParametro(TipoParametroDTO tipoParametro) {
		this.tipoParametro = tipoParametro;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public boolean isSelected() {
		return this.selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
