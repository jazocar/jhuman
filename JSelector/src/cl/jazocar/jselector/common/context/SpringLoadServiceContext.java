package cl.jazocar.jselector.common.context;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringLoadServiceContext implements ILoadConfigurationService
{
	public void loadConfiguration(IJProcessContext context, String path, String key ) throws Exception 
	{
		try {
			BeanFactory beanFactory = new ClassPathXmlApplicationContext( path );
			context.bind( key, beanFactory);
			Logger.getLogger(getClass()).info
			( "TERMINO -  Configuracion de Servicios SPRING" );
		} 
		catch ( Exception e ) 
		{
			Logger.getLogger(SpringLoadServiceContext.class).error( e );
			throw new Exception("Se produjo un problema al enlazar los servicios al contexto de la aplicacion",e);
		}
	}
	
}
