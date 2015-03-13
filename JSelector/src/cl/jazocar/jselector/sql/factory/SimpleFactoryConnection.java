package cl.jazocar.jselector.sql.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import cl.jazocar.jselector.exception.JProcessPersistenceException;

public class SimpleFactoryConnection extends CommonFactoryConnection implements FactoryConnection {

	@Override
	public Connection getConnection() throws JProcessPersistenceException 
	{
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( getConfigModel().getUrl(), getConfigModel().getUsername(), getConfigModel().getPassword() );
		}
		catch (SQLException e) 
		{
			StringBuilder builder = new StringBuilder();
			builder.append("no se pudo obtener la conexion desde la siguiente configuracion :\n");
			builder.append("URL: [").append(getConfigModel().getUrl()).append("]\n");
			builder.append("Username: [").append(getConfigModel().getUsername()).append("]\n");
			builder.append("Password: [").append(getConfigModel().getPassword()).append("]\n");
			error(builder.toString(), e);
			throw new JProcessPersistenceException(builder.toString());
		}
		return conn;
	}

}
