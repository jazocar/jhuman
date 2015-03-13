/**
 * 
 */
package cl.jazocar.jselector.sys.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

/**
 * @author Diablo
 *
 */
public class SubmenuDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int    id;
	private String idSubmenu;
	private String etiqueta;
	private String stackName;
	private int    idMenu;
	private String estado;
	private int    order;

	public SubmenuDTO(){
		
	}
	
	
	/**
	 * @param mensaje
	 * @param estado
	 * @param id
	 * @param idSubmenu
	 * @param etiqueta
	 * @param stackName
	 * @param idMenu
	 */
	public SubmenuDTO(int id, String idSubmenu,
			String etiqueta, String stackName, int idMenu) {
		this.id = id;
		this.idSubmenu = idSubmenu;
		this.etiqueta = etiqueta;
		this.stackName = stackName;
		this.idMenu = idMenu;
	}
	/**
	 * @return the stackName
	 */
	public String getStackName() {
		return stackName;
	}
	/**
	 * @param stackName the stackName to set
	 */
	public void setStackName(String stackName) {
		this.stackName = stackName;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the idSubmenu
	 */
	public String getIdSubmenu() {
		return idSubmenu;
	}
	/**
	 * @param idSubmenu the idSubmenu to set
	 */
	public void setIdSubmenu(String idSubmenu) {
		this.idSubmenu = idSubmenu;
	}
	/**
	 * @return the etiqueta
	 */
	public String getEtiqueta() {
		return etiqueta;
	}
	/**
	 * @param etiqueta the etiqueta to set
	 */
	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}
	/**
	 * @return the idMenu
	 */
	public int getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}


	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}


	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}
		
}

