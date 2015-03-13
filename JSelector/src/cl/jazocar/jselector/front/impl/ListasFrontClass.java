package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.ListaDTO;
import cl.jazocar.jselector.dto.ParametroDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = "listasFrontClass")
@SessionScoped
public class ListasFrontClass extends AplicationAbstract {

	private List<ListaDTO>   listaListas;
	private ListaDTO         listaDto;
	public static List<SelectItem> listaParametros;
	
	private int id;
	private String valor;
	private String parametro;
	
	private boolean selected;
	
	public ListasFrontClass(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaListas = configJProcessService.selectLista();
		
		listaParametros = new ArrayList<SelectItem>();
		
		for(ParametroDTO parametro : configJProcessService.selectParametroByTipoParametro(7))
			listaParametros.add(new SelectItem(parametro.getId(), parametro.getNombre()));
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		listaDto = new ListaDTO();
		listaDto.setValor(valor.trim());
		listaDto.setIdParametro(Integer.parseInt(parametro));
		
		configJProcessService.insertLista(listaDto);
		resetObject();
		refreshList();
	}

	@Override
	public void updateObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		listaDto = new ListaDTO();
		listaDto.setId(id);
		listaDto.setValor(valor.trim());
		listaDto.setIdParametro(Integer.parseInt(parametro));
		
		configJProcessService.updateLista(listaDto);
		resetObject();
	}

	@Override
	public void deleteObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		listaDto = new ListaDTO();
		listaDto.setId(id);
		listaDto.setValor(valor);
		listaDto.setIdParametro(Integer.parseInt(parametro));
		
		configJProcessService.deleteLista(listaDto);
		resetObject();
	}

	@Override
	public void resetObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		resetObject();
	}

	@Override
	public void searchObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		listaDto = new ListaDTO();		
		listaDto.setValor(valor.trim());
		listaDto.setIdParametro(Integer.parseInt(parametro));
		listaListas = configJProcessService.searchLista(listaDto);
	}

	@Override
	public void resetObject() {
		// TODO Auto-generated method stub
		id = 0;
		valor = "";
		parametro = "-1";
		selected = false;
		listaListas = configJProcessService.selectLista();
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		listaDto = (ListaDTO) event.getObject();
		
		id = listaDto.getId();
		valor = listaDto.getValor();
		parametro = String.valueOf(listaDto.getIdParametro());
		
		selected = true;
	}

	public List<ListaDTO> getListaListas() {
		return listaListas;
	}

	public void setListaListas(List<ListaDTO> listaListas) {
		this.listaListas = listaListas;
	}

	public ListaDTO getListaDto() {
		return listaDto;
	}

	public void setListaDto(ListaDTO listaDto) {
		this.listaDto = listaDto;
	}

	public List<SelectItem> getListaParametros() {
		return listaParametros;
	}

	public void setListaParametros(List<SelectItem> listaParametros) {
		this.listaParametros = listaParametros;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getParametro() {
		return parametro;
	}

	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}
