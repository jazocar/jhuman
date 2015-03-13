package cl.jazocar.jselector.util;

import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;



@ManagedBean
public class SolicitudConverterUtils implements Converter {
 
    public String getEstadoAsString(String value){    		
    	if (value.equals("Cerrado")) {
			value = "<font color=\"#FF0000\">" + value
					+ "</FONT>";
		} else if (value.equals("Abierta")) {
			value = "<font color=\"#3EA055\">" + value
					+ "</FONT>";
		} else if (value.equals("Desistida")) {
			value = "<font color=\"#0000FF\">" + value
					+ "</FONT>";
		}
           return value.toString();
    }

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2)
			throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

}
