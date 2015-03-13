package cl.jazocar.jselector.front.impl;

/*
 * Version: MPL 1.1/GPL 2.0/LGPL 2.1
 *
 * "The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations under
 * the License.
 *
 * The Original Code is ICEfaces 1.5 open source software code, released
 * November 5, 2006. The Initial Developer of the Original Code is ICEsoft
 * Technologies Canada, Corp. Portions created by ICEsoft are Copyright (C)
 * 2004-2006 ICEsoft Technologies Canada, Corp. All Rights Reserved.
 *
 * Contributor(s): _____________________.
 *
 * Alternatively, the contents of this file may be used under the terms of
 * the GNU Lesser General Public License Version 2.1 or later (the "LGPL"
 * License), in which case the provisions of the LGPL License are
 * applicable instead of those above. If you wish to allow use of your
 * version of this file only under the terms of the LGPL License and not to
 * allow others to use your version of this file under the MPL, indicate
 * your decision by deleting the provisions above and replace them with
 * the notice and other provisions required by the LGPL License. If you do
 * not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the LGPL License."
 *
 */


import java.util.HashMap;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import cl.jazocar.jselector.constants.IConstants;

import com.icesoft.faces.component.menubar.MenuItems;

import common.Logger;


/**
 * <p>The NavigationBean class is responsible for storing the state of the two
 * panel stacks which display dynamic content.  </p>
 *
 * @since 0.3.0
 */

@ManagedBean (name = IConstants.NAVIGATION_BEAN)
@SessionScoped
public class NavigationBean {

    public static String selectedPanel = "inicioPorHacerPanel";
    private Logger logger = Logger.getLogger(NavigationBean.class);
    private static NavigationBean navigation;
    private MenuItems manyMenu;
    private String param; 
    
    public NavigationBean() {
    	 	
	}

	public String getSelectedPanel() {
        return selectedPanel;
    }

    @SuppressWarnings("static-access")
	public void setSelectedPanel(String selectedPanel) {
        this.selectedPanel = selectedPanel;
    }

    public void navigationComentariosChange(ActionEvent event){
    	selectedPanel = "consultarSolicitud";
    	logger.info("selectedPanel: " + selectedPanel);
    }
    
	public void navigationStackChange(ActionEvent event){
        // get from the context panel stack item to show as well
        // as the title associated with the link.
        FacesContext context = FacesContext.getCurrentInstance();
        @SuppressWarnings("rawtypes")
		Map map = context.getExternalContext().getRequestParameterMap();       	
        String selected = (String) map.get("stackName");         
                
        selectedPanel = selected;
        logger.info("selectedPanel: " + selectedPanel);       
    }	
	
	 public void algo(ActionEvent e){
	 }
	
	public void navigationStackChangeParam(ActionEvent event, String key, String stackName)
	{
		Map<String,String> map=new HashMap<String, String>();
		map.put(key, stackName);
		 selectedPanel = (String) map.get(key);
		 System.out.println("selectedPanel: " + selectedPanel);
		// logger.info("selectedPanel: " + selectedPanel);
	}


	/**
	 * @return the navigation
	 */
	public static NavigationBean getNavigation() {
		return navigation;
	}

	/**
	 * @param navigation the navigation to set
	 */
	public static void setNavigation(NavigationBean navigation) {
		NavigationBean.navigation = navigation;
	}

	/**
	 * @return the manyMenu
	 */
	public MenuItems getManyMenu() {
		return manyMenu;
	}

	/**
	 * @param manyMenu the manyMenu to set
	 */
	public void setManyMenu(MenuItems manyMenu) {
		this.manyMenu = manyMenu;
	}

	/**
	 * @return the param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * @param param the param to set
	 */
	public void setParam(String param) {
		this.param = param;
	}
	
}
