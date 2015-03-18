package cl.jazocar.jselector.front.impl;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.AFPDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean (name = "afpFrontClass")
@SessionScoped
public class AFPFrontClass extends AplicationAbstract {

	private List<AFPDTO> listaAfp;
	private AFPDTO afpDto;
	
	private int id;
	private String codigo;
	private String glosa;
	
	private boolean selected;
	
	public AFPFrontClass(){
		init();
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
		listaAfp = configJProcessService.selectAFP();
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		afpDto = new AFPDTO();
		afpDto.setCodigo(codigo);
		afpDto.setGlosa(glosa);
		configJProcessService.insertAFP(afpDto);
		resetObject();
	}

	@Override
	public void updateObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		afpDto = new AFPDTO();
		afpDto.setId(id);
		afpDto.setCodigo(codigo);
		afpDto.setGlosa(glosa);
		configJProcessService.updateAFP(afpDto);
		resetObject();
	}

	@Override
	public void deleteObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		afpDto = new AFPDTO();
		afpDto.setId(id);
		afpDto.setCodigo(codigo);
		afpDto.setGlosa(glosa);
		configJProcessService.deleteAFP(afpDto);
		resetObject();
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
		id = 0;
		codigo = "";
		glosa  = "";
		selected = false;
		listaAfp = configJProcessService.selectAFP();
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		afpDto = (AFPDTO) event.getObject();		
		id = afpDto.getId();
		codigo = afpDto.getCodigo();
		glosa  = afpDto.getGlosa();		
		selected = true;
	}

	public List<AFPDTO> getListaAfp() {
		return listaAfp;
	}

	public void setListaAfp(List<AFPDTO> listaAfp) {
		this.listaAfp = listaAfp;
	}

	public AFPDTO getAfpDto() {
		return afpDto;
	}

	public void setAfpDto(AFPDTO afpDto) {
		this.afpDto = afpDto;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	
	
}
