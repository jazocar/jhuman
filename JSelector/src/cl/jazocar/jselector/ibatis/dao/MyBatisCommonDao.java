package cl.jazocar.jselector.ibatis.dao;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;

import cl.jazocar.jselector.ibatis.callable.DeleteCallableDao;
import cl.jazocar.jselector.ibatis.callable.GenericCallableDao;
import cl.jazocar.jselector.ibatis.callable.InsertCallableDao;
import cl.jazocar.jselector.ibatis.callable.UpdateCallableDao;



/**
 * @author Christian Alvarado
 * @version 1.0
 * @created 28-nov-2012 16:56:02
 */
public abstract class  MyBatisCommonDao 
{
	private Logger logger_ = Logger.getLogger(getClass());
	
	public MyBatisCommonDao()
	{

	}

	public void debug(String mesage){
		logger_.debug(mesage);
	}

	public void error(String mesage){
		logger_.error(mesage);
	}

	public void error(String message, Exception e)
	{
		logger_.error(message, e);
	}

	public SqlSession getSqlSession() throws Exception
	{
		SqlSession session = null;
		try 
		{
			SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
			session = sqlSessionFactory.openSession();
		}
		catch (Exception e) 
		{
			error("SE produjo un problema al Recurperar la conexion [" + e.getMessage()+ "]", e);
			throw e;
		}
		return session;
	}

    protected abstract SqlSessionFactory getSqlSessionFactory();

	private <T> Integer genericCall( GenericCallableDao<T> genericCallable, String function, Object paramObject )
	{
    	Integer ret = null;
    	SqlSession session = null;
		try {
			session = getSqlSession();
			ret = genericCallable.genericCaller(session, function, paramObject);
			session.commit();
		}
		catch ( Exception e ) 
		{
			error("function ["+function+"] parameter["+paramObject+"] ", e);
		}
		finally {
			if(session != null)
			{
				session.close();
			}
		}
		return ret;
	}
	
	public Integer genericInsert(String function, Object paramObject )
	{
		return genericCall( new InsertCallableDao<Integer>() , function, paramObject);
	}
	
	public Integer genericDelete(String function, Object paramObject )
	{
		return genericCall( new DeleteCallableDao<Integer>() , function, paramObject);
	}
	
	public Integer genericUpdate(String function, Object paramObject )
	{
		return genericCall( new UpdateCallableDao<Integer>() , function, paramObject);
	}
	
	protected <T> T genericSelectOne(String function)
	{
		return genericSelectOne(function, null);
	}
	
	protected <T> T genericSelectOne(String function, Object parameter)
	{
		SqlSession session = null;
		T ret = null;
		try {
			session = getSqlSession();
			ret = session.selectOne( function, parameter );
		}
		catch ( Exception e ) 
		{
			error("function ["+function+"] parameter["+parameter+"] ", e);
			throw new RuntimeException(e);
		}
		finally {
			if(session != null)
			{
				session.close();
			}
		}
		return ret;
	}
	
	protected <T> List<T> genericSelect(String function)
	{
		return genericSelect(function, null);
	}
	
	protected <T> List<T> genericSelect(String function, Object parameter)
	{
		SqlSession session = null;
		List<T> ret = null;
		try {
			session = getSqlSession();
			ret = session.selectList( function, parameter );
		}
		catch (Exception e) 
		{
			error("function ["+function+"] parameter["+parameter+"] ", e);
		}
		finally {
			if(session != null)
			{
				session.close();
			}
		}
		return ret;
	}
}