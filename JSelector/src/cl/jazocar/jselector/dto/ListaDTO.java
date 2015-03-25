package cl.jazocar.jselector.dto;

public class ListaDTO extends ResponseDTO{

	private int    id;
	private String valor;
	private int    idParametro;
	private String codigoAdicional;
	
	public ListaDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public int getIdParametro() {
		return idParametro;
	}

	public void setIdParametro(int idParametro) {
		this.idParametro = idParametro;
	}

	public String getCodigoAdicional() {
		return codigoAdicional;
	}

	public void setCodigoAdicional(String codigoAdicional) {
		this.codigoAdicional = codigoAdicional;
	}
	
	
	
}
