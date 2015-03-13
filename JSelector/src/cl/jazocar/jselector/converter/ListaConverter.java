package cl.jazocar.jselector.converter;


import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.dto.TipoParametroDTO;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("listaConverter")
public class ListaConverter
  implements Converter
{
  private IConfigJProcessService configJProcessService;
  
  public ListaConverter()
  {
    this.configJProcessService = 
      ((IConfigJProcessService)JProcessFactoryService.getInstance().getService("CONF_JPROCESS_SERVICE", 
      IConfigJProcessService.class));
  }
  
  public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
    throws ConverterException
  {
    return null;
  }
  
  public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
    throws ConverterException
  {
    return configJProcessService.selectListaById(Integer.parseInt(value.toString())).getValor();
  }
}
