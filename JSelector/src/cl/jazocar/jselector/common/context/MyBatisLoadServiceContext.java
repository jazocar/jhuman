package cl.jazocar.jselector.common.context;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

public class MyBatisLoadServiceContext implements ILoadConfigurationService 
{
	Logger logger = Logger.getLogger(MyBatisLoadServiceContext.class);
	
	@Override
	public void loadConfiguration(IJProcessContext context, String path, String key)
			throws Exception
	{
		InputStream is = null;
		try {
			logger.info("Configurando MybAtis [" +path + "] key ["+ key+"]");
			is = Resources.getResourceAsStream(path);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			context.bind(key , sqlSessionFactory);
			logger.info("Configurando Realizada [" +path + "] key ["+ key+"]");
		}
		catch (Exception e) {
			logger.error("Se produjo un problema al crear el SQLSessionFactory  [" +path + "] key ["+ key+"]" , e);
		}
		finally {
			try {
				is.close();
			}
			catch (Exception e2) 
			{
				logger.error("Se provoco un problema al cerrar el archivo de lectura [" +path + "]", e2 );
			}
			finally {
				is = null;
			}
		}

	}

}
