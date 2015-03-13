package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.dto.ParametroDTO;
import cl.jazocar.jselector.dto.TipoParametroDTO;
import cl.jazocar.jselector.front.AplicationAbstract;

@ManagedBean(name="parametrosFrontBean")
@SessionScoped
public class ParametrosFrontBean
  extends AplicationAbstract
{
  private List<ParametroDTO> listaParametro;
  public static List<SelectItem> listaTipoParametro;
  private ParametroDTO parametroDto;
  private int id;
  private String nombre;
  private String descripcion;
  private String selectedTipoParametro;
  private boolean selected;
  
  public ParametrosFrontBean()
  {
    init();
  }
  
  public void init()
  {
    this.listaParametro = configJProcessService.selectParametro();
    
    listaTipoParametro = new ArrayList<SelectItem>();
    for (TipoParametroDTO tipoParametro : configJProcessService.selectTipoParametro()) 
       listaTipoParametro.add(new SelectItem(Integer.valueOf(tipoParametro.getId()), tipoParametro.getNombre()));
    
  }
  
  public void insertObjectListener(ActionEvent e)
  {
    this.parametroDto = new ParametroDTO();
    this.parametroDto.setNombre(this.nombre);
    this.parametroDto.setDescripcion(this.descripcion);
    this.parametroDto.setIdTipoGrupo(Integer.parseInt(this.selectedTipoParametro));
    configJProcessService.insertParametro(this.parametroDto);
    resetObject();
    refreshList();
  }
  
  public void updateObjectListener(ActionEvent e)
  {
    this.parametroDto = new ParametroDTO();
    this.parametroDto.setId(this.id);
    this.parametroDto.setNombre(this.nombre);
    this.parametroDto.setDescripcion(this.descripcion);
    this.parametroDto.setIdTipoGrupo(Integer.parseInt(this.selectedTipoParametro));
    configJProcessService.updateParametro(this.parametroDto);
    resetObject();
  }
  
  public void deleteObjectListener(ActionEvent e)
  {
    this.parametroDto = new ParametroDTO();
    this.parametroDto.setId(this.id);
    this.parametroDto.setNombre(this.nombre);
    this.parametroDto.setDescripcion(this.descripcion);
    this.parametroDto.setIdTipoGrupo(Integer.parseInt(this.selectedTipoParametro));
    configJProcessService.deleteParametro(this.parametroDto);
    resetObject();
  }
  
  public void resetObjectListener(ActionEvent e)
  {
    resetObject();
  }
  
  public void resetObject()
  {
    this.id = 0;
    this.nombre = "";
    this.descripcion = "";
    this.selectedTipoParametro = "-1";
    this.selected = false;
    this.listaParametro = configJProcessService.selectParametro();
    this.listaTipoParametro = new ArrayList();
    for (TipoParametroDTO tipoParametro : configJProcessService.selectTipoParametro()) {
      this.listaTipoParametro.add(new SelectItem(Integer.valueOf(tipoParametro.getId()), tipoParametro.getNombre()));
    }
  }
  
  public void objectSelectListener(SelectEvent event)
  {
    this.parametroDto = ((ParametroDTO)event.getObject());
    this.id = this.parametroDto.getId();
    this.nombre = this.parametroDto.getNombre();
    this.descripcion = this.parametroDto.getDescripcion();
    this.selectedTipoParametro = String.valueOf(this.parametroDto.getIdTipoGrupo());
    
    this.selected = true;
  }
  
  public List<ParametroDTO> getListaParametro()
  {
    return this.listaParametro;
  }
  
  public void setListaParametro(List<ParametroDTO> listaParametro)
  {
    this.listaParametro = listaParametro;
  }
  
  public List<SelectItem> getListaTipoParametro()
  {
    return this.listaTipoParametro;
  }
  
  public void setListaTipoParametro(List<SelectItem> listaTipoParametro)
  {
    this.listaTipoParametro = listaTipoParametro;
  }
  
  public ParametroDTO getParametroDto()
  {
    return this.parametroDto;
  }
  
  public void setParametroDto(ParametroDTO parametroDto)
  {
    this.parametroDto = parametroDto;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getNombre()
  {
    return this.nombre;
  }
  
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  
  public String getDescripcion()
  {
    return this.descripcion;
  }
  
  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }
  
  public String getSelectedTipoParametro()
  {
    return this.selectedTipoParametro;
  }
  
  public void setSelectedTipoParametro(String selectedTipoParametro)
  {
    this.selectedTipoParametro = selectedTipoParametro;
  }
  
  public boolean isSelected(){
    return this.selected;
  }
  
  public void setSelected(boolean selected){
    this.selected = selected;
  }
  
  public void searchObjectListener(ActionEvent e) {	  
	   parametroDto = new ParametroDTO();
	   parametroDto.setNombre(nombre);
	   parametroDto.setDescripcion(descripcion);
	   parametroDto.setIdTipoGrupo(Integer.parseInt(selectedTipoParametro));
	   listaParametro = configJProcessService.searchParametro(parametroDto);
  }
}