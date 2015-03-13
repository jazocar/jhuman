package cl.jazocar.jselector.common.context;

import java.util.HashMap;
import java.util.Map;

public class JProcessContextImpl implements IJProcessContext
{

	private static JProcessContextImpl instance = null;
	private Map contextMap;
	
	private JProcessContextImpl(){
		contextMap = new HashMap();
	}
	
	public static JProcessContextImpl getInstance()
	{
		if(instance == null)
		{
			instance = new JProcessContextImpl();
		}
		return instance;
	}
	
	public <T, V> T lookup(V key)
	{
		T ret = (T) this.contextMap.get( key );
		if( ret == null )
		{
			throw new IllegalArgumentException(key.toString());
		}
		return ret;
	}
	
	public <T, V> void bind(V key,  T value )
	{
		contextMap.put(key, value);
	}
	
}
