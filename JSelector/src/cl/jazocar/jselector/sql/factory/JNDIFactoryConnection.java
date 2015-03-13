package cl.jazocar.jselector.sql.factory;

import java.sql.Connection;

import cl.jazocar.jselector.common.connection.ServicesConnection;
import cl.jazocar.jselector.exception.JProcessPersistenceException;

public class JNDIFactoryConnection extends CommonFactoryConnection implements FactoryConnection 
{

	@Override
	public Connection getConnection() throws JProcessPersistenceException 
	{
		Connection cnn = ServicesConnection.getConnection( getConfigModel() .getJndi() );
		if(cnn == null)
		{
			error("No se pudo obtener la conexión desde el JNDI [" + getConfigModel() .getJndi() + "]");
			throw new JProcessPersistenceException("No se pudo obtener la conexión desde el JNDI [" + getConfigModel() .getJndi() + "]");
		}
		return cnn;
	}

}
