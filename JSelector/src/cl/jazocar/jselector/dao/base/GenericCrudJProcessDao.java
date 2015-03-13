package cl.jazocar.jselector.dao.base;

import java.util.Map;

import javax.swing.table.TableModel;

import cl.jazocar.jselector.exception.JProcessPersistenceException;
import cl.jazocar.jselector.sql.factory.FactoryConnection;

public interface GenericCrudJProcessDao 
{
	public boolean add( TableModel tableModel, String[] dataArray, FactoryConnection factoryConection) throws JProcessPersistenceException ;
	
	public boolean update( TableModel tableModel , Map<String, String> valuesMap, Map<String, String> primaryKey, FactoryConnection factoryConection ) throws JProcessPersistenceException;
		
	public boolean delete( TableModel tableModel, Map<String, String> primaryKey, FactoryConnection factoryConection) throws JProcessPersistenceException; 
	
	public Map<String, String> getDataRow(TableModel tableModel, Map<String, String> primaryKey, FactoryConnection JProcess) throws JProcessPersistenceException;
	
	public int getNumberFromSQL( FactoryConnection factoryConnection, String sqlString) throws JProcessPersistenceException;

}
