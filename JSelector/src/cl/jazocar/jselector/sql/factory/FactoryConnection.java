package cl.jazocar.jselector.sql.factory;

import java.sql.Connection;

import cl.jazocar.jselector.exception.JProcessPersistenceException;
import cl.jazocar.jselector.model.ConfigModel;

public interface FactoryConnection 
{
	public void setConfigModel(ConfigModel configModel);
	
	public Connection getConnection() throws JProcessPersistenceException ;
}
