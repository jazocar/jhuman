package cl.jazocar.jselector.dto;

public class SolicitudFormularioDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	private int id;
	private int idSolicitud;
	private int idTarea;
	private int idPanel;
	private String estado;
	
	public SolicitudFormularioDTO() {
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdSolicitud() {
		return idSolicitud;
	}
	public void setIdSolicitud(int idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	public int getIdTarea() {
		return idTarea;
	}
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	public int getIdPanel() {
		return idPanel;
	}
	public void setIdPanel(int idPanel) {
		this.idPanel = idPanel;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
