/**
 * 
 */
package cl.jazocar.jselector.sys.dto;

import java.util.List;

import cl.jazocar.jselector.dto.ResponseDTO;

/**
 * @author Diablo
 *
 */
public class MenuDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String idMenu;
	private String etiqueta;
	private String estado;
	private int    order;
	private List<SubmenuDTO> listaSubmenu;
	private String rendered;
	
	public MenuDTO(){
		
	}
	
		
	/**
	 * @param mensaje
	 * @param estado
	 * @param id
	 * @param idMenu
	 * @param etiqueta
	 */
	public MenuDTO( int id, String idMenu,
			String etiqueta, String rendered) {
		this.id = id;
		this.idMenu = idMenu;
		this.etiqueta = etiqueta;
		this.rendered = rendered;
	}
	/**
	 * @param id
	 * @param idMenu
	 * @param etiqueta
	 * @param estado
	 */
	public MenuDTO(int id, String idMenu, String etiqueta, String estado, String rendered) {
		this.id = id;
		this.idMenu = idMenu;
		this.etiqueta = etiqueta;
		this.estado = estado;
		this.rendered = rendered;
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
	 * @return the idMenu
	 */
	public String getIdMenu() {
		return idMenu;
	}
	/**
	 * @param idMenu the idMenu to set
	 */
	public void setIdMenu(String idMenu) {
		this.idMenu = idMenu;
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
	 * @return the listaSubmenu
	 */
	public List<SubmenuDTO> getListaSubmenu() {
		return listaSubmenu;
	}
	/**
	 * @param listaSubmenu the listaSubmenu to set
	 */
	public void setListaSubmenu(List<SubmenuDTO> listaSubmenu) {
		this.listaSubmenu = listaSubmenu;
	}
	/**
	 * @return the rendered
	 */
	public String getRendered() {
		return rendered;
	}
	/**
	 * @param rendered the rendered to set
	 */
	public void setRendered(String rendered) {
		this.rendered = rendered;
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
