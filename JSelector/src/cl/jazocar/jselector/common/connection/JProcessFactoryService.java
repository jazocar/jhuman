package cl.jazocar.jselector.common.connection;

import org.springframework.beans.factory.BeanFactory;

import cl.jazocar.jselector.common.context.JProcessContextImpl;
import cl.jazocar.jselector.constants.IConstants;

import com.enterprisedt.util.debug.Logger;

public class JProcessFactoryService
{
	private static JProcessFactoryService instance;
	
	private JProcessFactoryService()
	{
		
	}
	
	public static JProcessFactoryService getInstance()
	{
		if(instance == null)
		{
			instance = new JProcessFactoryService();
		}
		return instance;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T getService(String key, Class<T> requiredType)
	{
		T obj = null;
		try {
			BeanFactory beanFactory = JProcessContextImpl.getInstance().lookup(IConstants.JPROCESS_SERVICE_FACTORY);
			if(requiredType != null)
			{
				obj = beanFactory.getBean( key, requiredType );
			}
			else {
				obj = (T) beanFactory.getBean( key);
			}
			
		}
		catch (Exception e) 
		{
			Logger.getLogger(getClass()).error("Se produjo un error al recuperara el servicio ["+key+"] class["+requiredType+"]",e);
		}
		return obj;
	}
	
	
	public <T> T getService(String key)
	{
		return getService(key, null);
	}
}
