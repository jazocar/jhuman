package cl.jazocar.jselector.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

@FacesConverter("modeloNegocioConverter")
public class ModeloNegocioConverter
  implements Converter
{
    
  public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
    throws ConverterException
  {
    return null;
  }
  
  public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
    throws ConverterException
  {
	  String resultado = "";
	  if(value.toString().equals("ADMIN")){
		  resultado = "Administración";
	  }else if(value.toString().equals("EDUC")){
		  resultado = "Educación";
	  }
	  else if(value.toString().equals("SALU")){
		  resultado = "Salud";
	  }
    return resultado;
  }
}
