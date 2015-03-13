// Decompiled by DJ v3.4.4.74 Copyright 2003 Atanas Neshkov  Date: 12/11/2008 12:52:33 p.m.
// Home Page : http://members.fortunecity.com/neshkov/dj.html  - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   ServicesConnection.java

package cl.jazocar.jselector.common.connection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Locale;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class ServicesConnection
{
	private static Logger log = Logger.getLogger(ServicesConnection.class);
	private static DataSource ds = null;
	private static String ambiente = null;
	
    public static DataSource getDataSource(String key)
    {
    	log.debug("Inicio JNDI");
        String name = "jdbc/" + key;
        try
        {
        	log.debug("Ambientex [0=WebSphere] / 1=Tomcat] = [ " + getAmbiente() + "]");
            if ( getAmbiente().equals( "1" ) )
            {
                name = "java:comp/env/" + name;
            } 
            Context initCtx = new InitialContext();
            ds = (DataSource)initCtx.lookup(name);
            log.debug("  - carga DataSource");
        }
        catch(NamingException e)
        {
            log.error("Problem looking up [" + name + "]= [" + e.getMessage() + "]", e);
        }
        log.debug("Fin JNDI");
        return ds;
    }

    public static Connection getConnection(String key)
    {
    	Locale.setDefault(Locale.US);
        Connection conn = null;
        try
        {
        	log.debug("ServicesConnection.getConnection(String key) Key=" + key);
            DataSource ds = getDataSource(key);
            if(ds != null)
            {
                conn = ds.getConnection();
            }
        }	
        catch(SQLException e)
        {
            log.error("Problem SQLException " + key + ":" + e.getMessage(), e );
        }
        finally {
        	if(conn == null)
			{
				Logger.getLogger( ServicesConnection.class ).error( "Fallo al pedir por primera vez la conexion" );
				try {
					ds = getDataSource(key);
					if(ds != null)
					{
						conn = ds.getConnection();
						Logger.getLogger( ServicesConnection.class ).debug( "Se obtuvo Conexion por segunda vez : " + (conn != null));
					}
				} catch (SQLException e) {
					Logger.getLogger( ServicesConnection.class ).error( "Problem SQLException 2 " + key + ":" + e.getMessage(), e );
				}
			}
        }
        return conn;
    }

    public static String getAmbiente(){
        return ambiente;
    }

	public static void setAmbiente(String ambiente) {
		ServicesConnection.ambiente = ambiente;
	}
    
    
}