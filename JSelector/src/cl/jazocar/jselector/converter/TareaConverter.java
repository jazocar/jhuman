/**
 * 
 */
package cl.jazocar.jselector.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;

/**
 * @author Diablo
 *
 */
@FacesConverter(value = "tareaConverter")
public class TareaConverter implements Converter{

	private IConfigJProcessService configJProcessService;	
	
	public TareaConverter(){
		configJProcessService = JProcessFactoryService.getInstance().getService("CONF_JPROCESS_SERVICE", IConfigJProcessService.class );
	}
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2)
			throws ConverterException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value)
			throws ConverterException {
		// TODO Auto-generated method stub
		if(value == null || value.toString().equals("-1") || value.toString().equals("0") || value.toString().equals(""))
			return "N/A";
		else
			return configJProcessService.selectTareaById(Integer.parseInt(value.toString())).getNombre();	
		
	}

}
