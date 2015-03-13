package cl.jazocar.jselector.dto;

public class EstructuraDTO extends ResponseDTO {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private String nombre;
	private String modeloOrganizacion;
	private int idLista;
	private int idClase;
	private String requerido;

	public EstructuraDTO() {
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

	public String getModeloOrganizacion() {
		return modeloOrganizacion;
	}

	public void setModeloOrganizacion(String modeloOrganizacion) {
		this.modeloOrganizacion = modeloOrganizacion;
	}

	public int getIdLista() {
		return idLista;
	}

	public void setIdLista(int idLista) {
		this.idLista = idLista;
	}

	public int getIdClase() {
		return idClase;
	}

	public void setIdClase(int idClase) {
		this.idClase = idClase;
	}

	public String getRequerido() {
		return requerido;
	}

	public void setRequerido(String requerido) {
		this.requerido = requerido;
	}

}
