package cl.jazocar.jselector.common.context;

import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;

public class Log4jLoadServiceContext implements ILoadConfigurationService {

	@Override
	public void loadConfiguration(IJProcessContext context, String path, String key) throws Exception 
	{
		InputStream is= null;
		try {
			is = Resources.getResourceAsStream(path);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
		    Document ret = builder.parse(is);
			DOMConfigurator.configure(ret.getDocumentElement());
			Logger.getLogger(getClass()).info( "Configuracion de Log Efectuada con exito en el path " + path );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(	is!= null	){
					is.close();
				}
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
