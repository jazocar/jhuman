package cl.jazocar.jselector.ibatis.callable;

import org.apache.ibatis.session.SqlSession;

public abstract interface GenericCallableDao<T> 
{
	
	public Integer genericCaller(SqlSession session, String function, Object parameter ) throws Exception;
	

}
