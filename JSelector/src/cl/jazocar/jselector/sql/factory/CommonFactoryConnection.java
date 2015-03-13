package cl.jazocar.jselector.sql.factory;

import org.apache.log4j.Logger;

import cl.jazocar.jselector.model.ConfigModel;

public class CommonFactoryConnection 
{
	private Logger logger = Logger.getLogger(getClass());
	
	private ConfigModel configModel;

	public ConfigModel getConfigModel() {
		return configModel;
	}

	public void setConfigModel(ConfigModel configModel) {
		this.configModel = configModel;
	}
	
	public void error(Object message)
	{
		logger.error( message );
	}
	
	public void error(Object message, Throwable throwable)
	{
		logger.error( message, throwable );
	}
	
	public void info(String message)
	{
		logger.info( message );
	}
	
	public void debug(Object message)
	{
		logger.debug( message );
	}
	
	public void debug(Object message, Throwable throwable)
	{
		logger.debug( message, throwable );
	}
	
	
}
