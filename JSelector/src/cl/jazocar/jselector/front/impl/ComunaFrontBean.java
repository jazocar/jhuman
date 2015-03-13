package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dto.CiudadDTO;
import cl.jazocar.jselector.dto.ComunaDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = IConstants.SYS_COMUNA_BEAN)
@SessionScoped
public class ComunaFrontBean extends AplicationAbstract{
	
	private List<SelectItem> listaProvincias;
	private List<ComunaDTO>  listaComunas;
	private ComunaDTO        comunaDto;
	
	private int idComuna;
	private String nombre;
	private String descripcion;
	private String idProvincia;
	
	private boolean selected;
	
	public ComunaFrontBean(){
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		listaProvincias = new ArrayList<SelectItem>();
		
		for(CiudadDTO ciudad : configJProcessService.selectCiudades())
			listaProvincias.add(new SelectItem(ciudad.getId(), ciudad.getNombre()));
		
		listaComunas = new ArrayList<ComunaDTO>();
		listaComunas = configJProcessService.selectComunas();
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
		try{
			comunaDto = new ComunaDTO();
			comunaDto.setNombre(nombre);
			comunaDto.setDescripcion(descripcion);
			comunaDto.setIdProvincia(Integer.parseInt(idProvincia));
			configJProcessService.insertComuna(comunaDto);
			resetObject();
		}catch(Exception ex){
			ex.printStackTrace();
		}
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
		resetObject();
	}

	@Override
	public void searchObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetObject() {
		// TODO Auto-generated method stub
		idComuna = 0;
	    nombre = "";
	    descripcion = "";
	    idProvincia = "-1";
	    
	    selected = false;
	    listaComunas = configJProcessService.selectComunas();
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		comunaDto = (ComunaDTO) event.getObject();
		idComuna = comunaDto.getId();
		idProvincia = String.valueOf(comunaDto.getIdProvincia());
		nombre      = comunaDto.getNombre();
		descripcion = comunaDto.getDescripcion();
		
		selected = true;
	}

	public List<SelectItem> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<SelectItem> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public List<ComunaDTO> getListaComunas() {
		return listaComunas;
	}

	public void setListaComunas(List<ComunaDTO> listaComunas) {
		this.listaComunas = listaComunas;
	}

	public ComunaDTO getComunaDto() {
		return comunaDto;
	}

	public void setComunaDto(ComunaDTO comunaDto) {
		this.comunaDto = comunaDto;
	}

	public int getIdComuna() {
		return idComuna;
	}

	public void setIdComuna(int idComuna) {
		this.idComuna = idComuna;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(String idProvincia) {
		this.idProvincia = idProvincia;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}	
	
}
