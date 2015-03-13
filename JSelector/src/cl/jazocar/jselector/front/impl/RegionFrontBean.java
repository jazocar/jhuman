package cl.jazocar.jselector.front.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dto.RegionDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = IConstants.SYS_REGION_BEAN)
@SessionScoped
public class RegionFrontBean extends AplicationAbstract{

	private List<RegionDTO> listaRegion;
	private RegionDTO regionDto;
	
	private int idRegion;
	private String nombre;
	private String descripcion;
	
	private boolean selected;
	
	public RegionFrontBean(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaRegion = configJProcessService.selectRegiones();
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			regionDto = new RegionDTO();
			regionDto.setNombre(nombre);
			regionDto.setDescripcion(descripcion);
			
			configJProcessService.insertRegion(regionDto);
			resetObject();
		}catch(Exception ex){
			
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
		idRegion = 0;
		nombre   = "";
		descripcion = "";
		
		listaRegion = configJProcessService.selectRegiones();
		selected = false;
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		regionDto = (RegionDTO) event.getObject();
		
		idRegion    = regionDto.getId();
		nombre      = regionDto.getNombre();
		descripcion = regionDto.getDescripcion();
		
		selected = true;
	}

	public List<RegionDTO> getListaRegion() {
		return listaRegion;
	}

	public void setListaRegion(List<RegionDTO> listaRegion) {
		this.listaRegion = listaRegion;
	}

	public RegionDTO getRegionDto() {
		return regionDto;
	}

	public void setRegionDto(RegionDTO regionDto) {
		this.regionDto = regionDto;
	}

	public int getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	
	
}
