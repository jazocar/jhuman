/**
 * 
 */
package cl.jazocar.jselector.sys.front;

/* MPL License text (see http://www.mozilla.org/MPL/) */

import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.component.paneltabset.TabChangeListener;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AbortProcessingException;

import java.io.Serializable;

/**
 * The StaticTabSetBean class is a backing bean for the TabbedPane showcase
 * demonstration and is used to store the various states of the the
 * ice:panelTabSet component. These states are visibility, tab selection and tab
 * placement.
 * 
 * @since 0.3.0
 */

@ManagedBean(name = "staticTabSetFrontBean")
@ApplicationScoped
public class StaticTabSetFrontBean implements TabChangeListener, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * The demo contains three tabs and thus we need three variables to store
	 * their respective rendered states.
	 */
	private boolean tabbedTareas;
	private boolean tabbedCasos;
	private boolean tabbedAplicaciones;

	// selected tab index
	private String selectedIndex = "0";

	/**
	 * Tabbed placement, possible values are "top" and "bottom", the default is
	 * "bottom".
	 */
	private String tabPlacement = "top";	
	
	/**
	 * @return the tabbedTareas
	 */
	public boolean isTabbedTareas() {
		return tabbedTareas;
	}

	/**
	 * @param tabbedTareas the tabbedTareas to set
	 */
	public void setTabbedTareas(boolean tabbedTareas) {
		this.tabbedTareas = tabbedTareas;
	}

	/**
	 * @return the tabbedCasos
	 */
	public boolean isTabbedCasos() {
		return tabbedCasos;
	}

	/**
	 * @param tabbedCasos the tabbedCasos to set
	 */
	public void setTabbedCasos(boolean tabbedCasos) {
		this.tabbedCasos = tabbedCasos;
	}

	/**
	 * @return the tabbedAplicaciones
	 */
	public boolean isTabbedAplicaciones() {
		return tabbedAplicaciones;
	}

	/**
	 * @param tabbedAplicaciones the tabbedAplicaciones to set
	 */
	public void setTabbedAplicaciones(boolean tabbedAplicaciones) {
		this.tabbedAplicaciones = tabbedAplicaciones;
	}

	public String getTabPlacement() {
		return tabPlacement;
	}

	public void setTabPlacement(String tabPlacement) {
		this.tabPlacement = tabPlacement;
	}

	public String getSelectedIndex() {
		return selectedIndex;
	}

	public void setSelectedIndex(String selectedIndex) {
		this.selectedIndex = selectedIndex;
	}

	public void setSelectedIndex(int selectedIndex) {
		this.selectedIndex = String.valueOf(selectedIndex);
	}

	public int getFocusIndex() {
		int focusIndex = 0;
		try {
			focusIndex = Integer.parseInt(selectedIndex);
		} catch (NumberFormatException nfe) {
			// do nothing
		}
		return focusIndex;
	}

	public void setFocusIndex(int index) {
		selectedIndex = String.valueOf(index);
	}

	/**
	 * Called when the table binding's tab focus changes.
	 * 
	 * @param tabChangeEvent
	 *            used to set the tab focus.
	 * @throws AbortProcessingException
	 *             An exception that may be thrown by event listeners to
	 *             terminate the processing of the current event.
	 */
	public void processTabChange(TabChangeEvent tabChangeEvent)
			throws AbortProcessingException {
		// only used to show TabChangeListener usage.
	}
}