/**
 * 
 */
package cl.jazocar.jselector.front;

import javax.faces.event.ActionEvent;

import org.icefaces.ace.event.SelectEvent;

/**
 * @author Diablo
 *
 */
public interface AplicationInterface {

    public void init();
	
	public void insertObjectListener(ActionEvent e);
	public void updateObjectListener(ActionEvent e);
	public void deleteObjectListener(ActionEvent e);
	public void resetObjectListener(ActionEvent e);
	public void searchObjectListener(ActionEvent e);
	
	public void resetObject();
	
	public void objectSelectListener(SelectEvent event);
}
