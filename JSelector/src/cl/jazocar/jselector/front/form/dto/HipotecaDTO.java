package cl.jazocar.jselector.front.form.dto;

import java.util.List;

import cl.jazocar.jselector.dto.ResponseDTO;

public class HipotecaDTO extends ResponseDTO{

	private static final long serialVersionUID = 1L;
	private int id;
	private int idInformeLegal;
	private String datosOperacion;
	private String titulosEstudiados;	
	private List<VendedorGaranteDTO> listaVendedorGarante;
	private List<AvalDTO>            listaAval;
	
	public HipotecaDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdInformeLegal() {
		return idInformeLegal;
	}

	public void setIdInformeLegal(int idInformeLegal) {
		this.idInformeLegal = idInformeLegal;
	}

	public String getDatosOperacion() {
		return datosOperacion;
	}

	public void setDatosOperacion(String datosOperacion) {
		this.datosOperacion = datosOperacion;
	}

	public String getTitulosEstudiados() {
		return titulosEstudiados;
	}

	public void setTitulosEstudiados(String titulosEstudiados) {
		this.titulosEstudiados = titulosEstudiados;
	}

	public List<VendedorGaranteDTO> getListaVendedorGarante() {
		return listaVendedorGarante;
	}

	public void setListaVendedorGarante(
			List<VendedorGaranteDTO> listaVendedorGarante) {
		this.listaVendedorGarante = listaVendedorGarante;
	}

	public List<AvalDTO> getListaAval() {
		return listaAval;
	}

	public void setListaAval(List<AvalDTO> listaAval) {
		this.listaAval = listaAval;
	}	
	
}

