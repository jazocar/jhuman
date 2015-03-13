package cl.jazocar.jselector.dao.service.impl;

import com.enterprisedt.util.debug.Logger;

public class CommonJProcessService
{
	private Logger log = Logger.getLogger(getClass());
	
	protected void error(String message, Throwable t)
	{
		log.error(message, t);
	}

	protected void error(String message)
	{
		log.error(message);
	}
}
