package cl.jazocar.jselector.common.context;

public interface IJProcessContext 
{
	public <T, V> T lookup(V key);
	public <T, V> void bind(V key,  T value );
}
