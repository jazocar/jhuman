package cl.jazocar.jselector.common.context;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.ibatis.io.Resources;

public class PropertiesLoadServiceContext implements ILoadConfigurationService {

	@Override
	public void loadConfiguration(IJProcessContext context, String path, String key)
			throws Exception 
	{
		InputStream is = null;
		Properties prop = new Properties();
		try {
			is = Resources.getResourceAsStream(path);
			prop.load(is);
			context.bind( key, prop );
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				is.close();
			}
			catch (Exception e2) 
			{
				e2.printStackTrace();
			}
			finally {
				is = null;
			}
		}

	}

}
