package cl.jazocar.jselector.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesService {

    private static PropertiesService propertiesService;
    private Properties prop;
    
    private PropertiesService(){
    	try{
    	prop = new Properties();
    	InputStream is = PropertiesService.class.getResourceAsStream("/properties/jselector.properties");
    	prop.load(is);
    	is.close();
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    }
    
    public String getValue(String propertieName){
    	return prop.getProperty(propertieName);
    }
    
    
    public static PropertiesService getInstance(){
    	if(propertiesService == null){
    		propertiesService = new PropertiesService();
    	}
    	return propertiesService;
    }
}
