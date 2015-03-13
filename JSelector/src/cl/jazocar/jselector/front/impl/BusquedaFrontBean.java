package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dto.AplicacionDTO;
import cl.jazocar.jselector.dto.SolicitudDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = IConstants.SYS_BUSQUEDA_BEAN)
@SessionScoped
public class BusquedaFrontBean extends AplicationAbstract{

	public static List<SolicitudDTO> listaSolicitud;
	private SolicitudDTO solicitudDto;
	
	private List<SelectItem> listaAplicaciones;
	
	private String aplicacion;
	private Date   inicio;
	private Date   fin;
	private String estado;
	
	public static int cantidad;
	
	private boolean selected;

	public BusquedaFrontBean(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		listaSolicitud = new ArrayList<SolicitudDTO>();		
		listaAplicaciones = new ArrayList<SelectItem>();
		
		for(AplicacionDTO app : configJProcessService.selectAllAplicacion())
			listaAplicaciones.add(new SelectItem(app.getId(), app.getAplicacion()));
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
		resetObject();
	}

	@Override
	public void searchObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		solicitudDto = new SolicitudDTO();
		solicitudDto.setIdAplicacion(Integer.parseInt(aplicacion));
		solicitudDto.setEstado(estado);
		solicitudDto.setFechaInicio(inicio);
		solicitudDto.setFechaFin(fin);
		listaSolicitud  = configJProcessService.searchSolicitudesByFields(solicitudDto, UsuarioFrontBean.usuarioBean);
		cantidad = listaSolicitud.size();
	}

	@Override
	public void resetObject() {
		// TODO Auto-generated method stub
		aplicacion = "-1";
		inicio = new Date();
		fin = new Date();
		estado = "-1";
		selected = false;
		listaSolicitud = configJProcessService.selectSolicitudesByUser(UsuarioFrontBean.usuarioBean);
		cantidad = listaSolicitud.size();
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		solicitudDto = (SolicitudDTO) event.getObject();
		
		aplicacion  = String.valueOf(solicitudDto.getIdAplicacion());
		inicio      = solicitudDto.getFechaInicio();
		fin         = solicitudDto.getFechaFin();
		estado      = solicitudDto.getEstado();
	}

	public List<SolicitudDTO> getListaSolicitud() {
		return listaSolicitud;
	}

	public void setListaSolicitud(List<SolicitudDTO> listaSolicitud) {
		this.listaSolicitud = listaSolicitud;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFin() {
		return fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public SolicitudDTO getSolicitudDto() {
		return solicitudDto;
	}

	public void setSolicitudDto(SolicitudDTO solicitudDto) {
		this.solicitudDto = solicitudDto;
	}

	public List<SelectItem> getListaAplicaciones() {
		return listaAplicaciones;
	}

	public void setListaAplicaciones(List<SelectItem> listaAplicaciones) {
		this.listaAplicaciones = listaAplicaciones;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
}
