package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.sys.dto.RolProcesoDTO;

@ManagedBean(name = IConstants.SYS_ROL_PROCESO_BEAN)
@SessionScoped
public class RolProcesoFrontBean extends AplicationAbstract {

	private List<RolProcesoDTO> listaRolProceso;
	private RolProcesoDTO rolProcesoDto;

	private int id;
	private String nombre;
	private String descripcion;
	private boolean selected;

	public RolProcesoFrontBean() {
		// TODO Auto-generated constructor stub
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaRolProceso = configJProcessService.selectAllRolProcesos();
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			rolProcesoDto = new RolProcesoDTO();
			rolProcesoDto.setNombre(nombre);
			rolProcesoDto.setDescripcion(descripcion);
			configJProcessService.insertRolProceso(rolProcesoDto);
			resetObject();
		} catch (Exception ex) {

		}
	}

	@Override
	public void updateObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		try {

			resetObject();
		} catch (Exception ex) {

		}
	}

	@Override
	public void deleteObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		try{
			
			resetObject();
		}catch(Exception ex){
			
		}
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
		id = 0;
		nombre = "";
		descripcion = "";
		listaRolProceso = configJProcessService.selectAllRolProcesos();
		selected = false;
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		rolProcesoDto = (RolProcesoDTO) event.getObject();
		
		id = rolProcesoDto.getId();
		nombre = rolProcesoDto.getNombre();
		descripcion = rolProcesoDto.getDescripcion();
		
		selected = true;
	}

	public List<RolProcesoDTO> getListaRolProceso() {
		return listaRolProceso;
	}

	public void setListaRolProceso(List<RolProcesoDTO> listaRolProceso) {
		this.listaRolProceso = listaRolProceso;
	}

	public RolProcesoDTO getRolProcesoDto() {
		return rolProcesoDto;
	}

	public void setRolProcesoDto(RolProcesoDTO rolProcesoDto) {
		this.rolProcesoDto = rolProcesoDto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
