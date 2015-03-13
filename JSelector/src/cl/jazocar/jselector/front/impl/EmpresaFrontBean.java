package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dto.EmpresaDTO;
import cl.jazocar.jselector.dto.OrganizacionDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = IConstants.SYS_EMPRESAS_BEAN)
@SessionScoped
public class EmpresaFrontBean extends AplicationAbstract{
	
	private List<EmpresaDTO> listaEmpresas;	
	private List<SelectItem> listaOrganizacion;
	
	private EmpresaDTO empresaDto;
	
	private int idEmpresa;
	private String nombre;
	private String descripcion;
	private String idOrganizacion;
	
	public boolean selected;
	
	public EmpresaFrontBean(){
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaOrganizacion = new ArrayList<SelectItem>();
		
		listaEmpresas = configJProcessService.selectEmpresas();
		
		for(OrganizacionDTO org : configJProcessService.selectAllOrganizacion())
			listaOrganizacion.add(new SelectItem( org.getId(), org.getNombre()));
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			empresaDto = new EmpresaDTO();
			empresaDto.setNombre(nombre);
			empresaDto.setDescripcion(descripcion);
			empresaDto.setIdOrganizacion(Integer.parseInt(idOrganizacion));
			
			configJProcessService.insertEmpresa(empresaDto);
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
		
		nombre = "";
		descripcion = "";
		idOrganizacion = "-1";
		
		listaEmpresas = configJProcessService.selectEmpresas();
		selected = false;
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		empresaDto = (EmpresaDTO) event.getObject();		
		idEmpresa      = empresaDto.getId();
		nombre         = empresaDto.getNombre();
		descripcion    = empresaDto.getDescripcion();
		idOrganizacion = String.valueOf(empresaDto.getIdOrganizacion());		
		selected = true;
	}

	
	
	//Getters Setters.	

	public List<SelectItem> getListaOrganizacion() {
		return listaOrganizacion;
	}

	public void setListaOrganizacion(List<SelectItem> listaOrganizacion) {
		this.listaOrganizacion = listaOrganizacion;
	}

	public List<EmpresaDTO> getListaEmpresas() {
		return listaEmpresas;
	}

	public void setListaEmpresas(List<EmpresaDTO> listaEmpresas) {
		this.listaEmpresas = listaEmpresas;
	}

	public EmpresaDTO getEmpresaDto() {
		return empresaDto;
	}

	public void setEmpresaDto(EmpresaDTO empresaDto) {
		this.empresaDto = empresaDto;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
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

	public String getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(String idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}		
	
	
	
}
