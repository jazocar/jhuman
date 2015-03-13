package cl.jazocar.jselector.dto;

public class InstanciaDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	private int id;
	private int idAplicacion;
	private String nombreInstancia;
	private int idOrganizacion;
	private int idEmpresa;
	private int idTareaInicial;
	private int idTareaFinal;
	
	/**
	 * 
	 */
	public InstanciaDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdAplicacion() {
		return idAplicacion;
	}

	public void setIdAplicacion(int idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

	public String getNombreInstancia() {
		return nombreInstancia;
	}

	public void setNombreInstancia(String nombreInstancia) {
		this.nombreInstancia = nombreInstancia;
	}

	public int getIdOrganizacion() {
		return idOrganizacion;
	}

	public void setIdOrganizacion(int idOrganizacion) {
		this.idOrganizacion = idOrganizacion;
	}

	public int getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public int getIdTareaInicial() {
		return idTareaInicial;
	}

	public void setIdTareaInicial(int idTareaInicial) {
		this.idTareaInicial = idTareaInicial;
	}

	public int getIdTareaFinal() {
		return idTareaFinal;
	}

	public void setIdTareaFinal(int idTareaFinal) {
		this.idTareaFinal = idTareaFinal;
	}
	
	
	
}
