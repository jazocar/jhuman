package cl.jazocar.jselector.servlet;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.common.connection.ServicesConnection;
import cl.jazocar.jselector.common.context.ILoadConfigurationService;
import cl.jazocar.jselector.common.context.JProcessContextImpl;
import cl.jazocar.jselector.common.context.Log4jLoadServiceContext;
import cl.jazocar.jselector.common.context.MyBatisLoadServiceContext;
import cl.jazocar.jselector.common.context.PropertiesLoadServiceContext;
import cl.jazocar.jselector.common.context.SpringLoadServiceContext;
import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.model.ConfigModel;

/*
 * Servlet implementation class ConfigServlet
 * Servlet que inicia las configuraciones del sistema 
 */
public class ConfigServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConfigServlet()
	{
		super();
	}

	/**
	 * Iniciador de los servicios del sistema
	 * prueba
	 */
	public void init() throws ServletException
	{
		try {
			loadConfiguration(new PropertiesLoadServiceContext(), "properties/jselector.properties", IConstants.JPROCESS_PROPERTIES);
			loadConfiguration(new Log4jLoadServiceContext(), "properties/logger.xml", null);
			loadConfiguration(new MyBatisLoadServiceContext(), "cl/jazocar/jselector/mybatis/jprocess_config.xml", IConstants.JPROCESS_PERSITENCE);
			loadConfiguration(new MyBatisLoadServiceContext(), "cl/jazocar/jselector/mybatis/form_config.xml", IConstants.FORM_PERSITENCE);
			loadConfiguration(new SpringLoadServiceContext(), "cl/jazocar/jselector/services/service_definition.xml", IConstants.JPROCESS_SERVICE_FACTORY);
			
			loadEnviroment();
			loadDriver();
			
		} 
		catch (Exception e) 
		{
			Logger.getLogger(getClass()).error( "TERMINO -  Configuracion de Persistencia HIBERNATE" );
			throw new ServletException(e);
		}
	}
	
	private void loadEnviroment() 
	{
		Properties properties = JProcessContextImpl.getInstance().lookup(IConstants.JPROCESS_PROPERTIES);
		String enviroment = properties.getProperty("enviroment");
		String valueAmbiente = "localhost".equalsIgnoreCase(enviroment) ? "1":"0";
		ServicesConnection.setAmbiente(valueAmbiente);
	}

	private void loadDriver() 
	{
		IConfigJProcessService iConfigjselectorService = JProcessFactoryService.getInstance().getService("CONF_BACKUP_SERVICE", IConfigJProcessService.class );
		try {
			//List<ConfigModel> configModelList2 = configBackupService.getConfigModelList();
			
			ConfigModel configModelBackup = new ConfigModel();
			configModelBackup.setDriver("org.postgresql.Driver");
			configModelBackup.setJndi("java:comp/env/jdbc/backup");
			configModelBackup.setUrl("jdbc:postgresql://localhost:5432/backup");
			configModelBackup.setUsername("postgres");
			configModelBackup.setPassword("postgres");
			configModelBackup.setSchemaName("backup");
			
			List<ConfigModel> configModelList = new ArrayList<ConfigModel>();
			configModelList.add(configModelBackup);
			
			if(configModelList != null)
			{
				Set<String> driverSet = new HashSet<String>();
				for (ConfigModel configModel : configModelList) 
				{
					if( (configModel.getJndi() == null || configModel.getJndi().trim().length() == 0) && configModel.getDriver() != null && configModel.getDriver().trim().length() > 0)
					{
						driverSet.add( configModel.getDriver() );
					}
				}
				for (String driver : driverSet)
				{
					DriverManager.registerDriver ( (Driver) Class.forName(driver).newInstance() );
				}
			}
		} catch (Exception e) {
			Logger.getLogger(getClass()).error("Se produjo un error al cargar los drivers",e);
		}
		
	}

	private void loadConfiguration( ILoadConfigurationService service, String path, String key )
	{
		try {
			service.loadConfiguration(JProcessContextImpl.getInstance(), path, key);
		} 
		catch (Exception e) 
		{
			Logger.getLogger(getClass()).error("Se produjo un error en los servicios de sincronizacion", e);
		}
	}
}
