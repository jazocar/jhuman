package cl.jazocar.jselector.converter;


import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;

@FacesConverter("parametroConverter")
public class ParametroConverter
  implements Converter
{
  private IConfigJProcessService configJProcessService;
  
  public ParametroConverter()
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
    return this.configJProcessService.selectParametroById(Integer.parseInt(value.toString())).getNombre();
  }
}
