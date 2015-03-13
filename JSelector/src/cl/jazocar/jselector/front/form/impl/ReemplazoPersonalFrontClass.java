package cl.jazocar.jselector.front.form.impl;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = "reemplazoPersonalFrontClass")
@SessionScoped
public class ReemplazoPersonalFrontClass extends AplicationAbstract{
	
	private String  selectedCategoria;
	
	private boolean categoriaA;
	private boolean categoriaB;
	private boolean categoriaC;
	private boolean categoriaD;
	private boolean categoriaE;
	private boolean categoriaF;
	
	private boolean mostrarFirmas;
	
	private boolean mostrarPopUp;
	private String  mensajePopUp;
	
	public ReemplazoPersonalFrontClass(){
		init();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		boolean validacion = validationForm();
			
		if(validacion){
				this.mostrarFirmas = true;
		}				
		else
				mostrarPopUp = true;
		
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
		
	}

	@Override
	public void resetObject() {
		// TODO Auto-generated method stub
		mostrarFirmas = false;
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean validationForm(){
		boolean estado = true;
		if(selectedCategoria.equals("-1")){
			mensajePopUp = "Debe seleccionar una categoría";
			estado = false;
		}
		
		return estado;
	}
	
	public void changeCategoriaListener(ValueChangeEvent evnt){
		String valor = evnt.getNewValue().toString();
		
		categoriaA = false;
		categoriaB = false;
		categoriaC = false;
		categoriaD = false;
		categoriaE = false;
		categoriaF = false;
		
		if(valor.equals("A")){
			categoriaA = true;
		}else if(valor.equals("B")){
			categoriaB = true;
		}else if(valor.equals("C")){
			categoriaC = true;
		}else if(valor.equals("D")){
			categoriaD = true;
		}else if(valor.equals("E")){
			categoriaE = true;
		}else if(valor.equals("F")){
			categoriaF = true;
		}
	}
	
	public void cerrarPopUpListener(ActionEvent e){
		mensajePopUp = "";
		mostrarPopUp = false;
	}
	

	public boolean isCategoriaA() {
		return categoriaA;
	}

	public void setCategoriaA(boolean categoriaA) {
		this.categoriaA = categoriaA;
	}

	public boolean isCategoriaB() {
		return categoriaB;
	}

	public void setCategoriaB(boolean categoriaB) {
		this.categoriaB = categoriaB;
	}

	public boolean isCategoriaC() {
		return categoriaC;
	}

	public void setCategoriaC(boolean categoriaC) {
		this.categoriaC = categoriaC;
	}

	public boolean isCategoriaD() {
		return categoriaD;
	}

	public void setCategoriaD(boolean categoriaD) {
		this.categoriaD = categoriaD;
	}

	public boolean isCategoriaE() {
		return categoriaE;
	}

	public void setCategoriaE(boolean categoriaE) {
		this.categoriaE = categoriaE;
	}

	public boolean isCategoriaF() {
		return categoriaF;
	}

	public void setCategoriaF(boolean categoriaF) {
		this.categoriaF = categoriaF;
	}

	public boolean isMostrarFirmas() {
		return mostrarFirmas;
	}

	public void setMostrarFirmas(boolean mostrarFirmas) {
		this.mostrarFirmas = mostrarFirmas;
	}

	public String getSelectedCategoria() {
		return selectedCategoria;
	}

	public void setSelectedCategoria(String selectedCategoria) {
		this.selectedCategoria = selectedCategoria;
	}

	public boolean isMostrarPopUp() {
		return mostrarPopUp;
	}

	public void setMostrarPopUp(boolean mostrarPopUp) {
		this.mostrarPopUp = mostrarPopUp;
	}

	public String getMensajePopUp() {
		return mensajePopUp;
	}

	public void setMensajePopUp(String mensajePopUp) {
		this.mensajePopUp = mensajePopUp;
	}
	
}
