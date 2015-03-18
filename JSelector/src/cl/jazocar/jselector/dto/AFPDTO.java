package cl.jazocar.jselector.dto;

public class AFPDTO extends ResponseDTO{

	private int    id;
	private String codigo;
	private String glosa;
	
	public AFPDTO(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getGlosa() {
		return glosa;
	}

	public void setGlosa(String glosa) {
		this.glosa = glosa;
	}
}
