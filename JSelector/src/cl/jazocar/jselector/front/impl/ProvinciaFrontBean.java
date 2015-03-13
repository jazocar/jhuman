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
import cl.jazocar.jselector.dto.RegionDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean ( name = IConstants.SYS_PROVINCIA_BEAN)
@SessionScoped
public class ProvinciaFrontBean extends AplicationAbstract{
	
	private List<CiudadDTO> listaProvincias;
	private CiudadDTO ciudadDto;
	
	private List<SelectItem> listaRegiones;
	
	private int    idProvincia;
	private String nombre;
	private String descripcion;
	private String idRegion;
	
	private boolean selected;
	
	public ProvinciaFrontBean(){
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaRegiones = new ArrayList<SelectItem>();
		
		for(RegionDTO region : configJProcessService.selectRegiones())
			listaRegiones.add(new SelectItem(region.getId(), region.getNombre()));
		
		listaProvincias = configJProcessService.selectCiudades();
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			ciudadDto = new CiudadDTO();
			ciudadDto.setNombre(nombre);
			ciudadDto.setDescripcion(descripcion);
			ciudadDto.setIdRegion(Integer.parseInt(idRegion));
			configJProcessService.insertCiudad(ciudadDto);
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
		
		idProvincia = 0;
		nombre = "";
		descripcion = "";
		idRegion    = "-1";
		
		selected = false;
		listaProvincias = configJProcessService.selectCiudades();
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		ciudadDto = (CiudadDTO) event.getObject();
		idProvincia = ciudadDto.getId();
		nombre      = ciudadDto.getNombre();
		descripcion = ciudadDto.getDescripcion();
		idRegion    = String.valueOf(ciudadDto.getIdRegion());
		
		selected = true;
	}

	public List<CiudadDTO> getListaProvincias() {
		return listaProvincias;
	}

	public void setListaProvincias(List<CiudadDTO> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	public CiudadDTO getCiudadDto() {
		return ciudadDto;
	}

	public void setCiudadDto(CiudadDTO ciudadDto) {
		this.ciudadDto = ciudadDto;
	}

	public List<SelectItem> getListaRegiones() {
		return listaRegiones;
	}

	public void setListaRegiones(List<SelectItem> listaRegiones) {
		this.listaRegiones = listaRegiones;
	}

	public int getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
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

	public String getIdRegion() {
		return idRegion;
	}

	public void setIdRegion(String idRegion) {
		this.idRegion = idRegion;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}
