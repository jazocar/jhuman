package cl.jazocar.jselector.front.impl;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean (name = "inicioBean")
public class InicioFrontBean {

	private String texto;
	
	@PostConstruct
	public void init(){
		texto = "Hola Mundo";
	}
	
	public void cambiarTextoListener(ActionEvent e){
		texto = "Chao Mundo";
	}
	
	public void cambiarTextoDosListener(ActionEvent e){
		texto = "Hola Mundo";
	}

	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	
}
