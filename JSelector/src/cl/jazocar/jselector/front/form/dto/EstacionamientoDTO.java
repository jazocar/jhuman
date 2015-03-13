package cl.jazocar.jselector.front.form.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

public class EstacionamientoDTO extends ResponseDTO{

	private int id;
	private int idAntecedentesPropiedad;
	private String rolAvaluo1;
	private String rolAvaluo2;
	private String numero;
	/**
	 * 
	 */
	public EstacionamientoDTO() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdAntecedentesPropiedad() {
		return idAntecedentesPropiedad;
	}
	public void setIdAntecedentesPropiedad(int idAntecedentesPropiedad) {
		this.idAntecedentesPropiedad = idAntecedentesPropiedad;
	}
	public String getRolAvaluo1() {
		return rolAvaluo1;
	}
	public void setRolAvaluo1(String rolAvaluo1) {
		this.rolAvaluo1 = rolAvaluo1;
	}
	public String getRolAvaluo2() {
		return rolAvaluo2;
	}
	public void setRolAvaluo2(String rolAvaluo2) {
		this.rolAvaluo2 = rolAvaluo2;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
}
