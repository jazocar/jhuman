/**
 * 
 */
package cl.jazocar.jselector.sys.dto;

import cl.jazocar.jselector.dto.ResponseDTO;

/**
 * @author Diablo
 *
 */
public class PanelDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String idPanel;
	private String idSubview;
	private String include;
	private String esFormulario;
	
	public PanelDTO(){
		
	}
	
	/**
	 * @param id
	 * @param idPanel
	 * @param idSubview
	 * @param include
	 */
	public PanelDTO(int id, String idPanel, String idSubview, String include, String esFormulario) {
		this.id = id;
		this.idPanel = idPanel;
		this.idSubview = idSubview;
		this.include = include;
		this.esFormulario = esFormulario;
	}
		
	
	/**
	 * @param idPanel
	 * @param idSubview
	 * @param include
	 */
	public PanelDTO(String idPanel, String idSubview, String include, String esFormulario) {
		this.idPanel = idPanel;
		this.idSubview = idSubview;
		this.include = include;
		this.esFormulario = esFormulario;
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
	 * @return the idPanel
	 */
	public String getIdPanel() {
		return idPanel;
	}
	/**
	 * @param idPanel the idPanel to set
	 */
	public void setIdPanel(String idPanel) {
		this.idPanel = idPanel;
	}
	/**
	 * @return the idSubview
	 */
	public String getIdSubview() {
		return idSubview;
	}
	/**
	 * @param idSubview the idSubview to set
	 */
	public void setIdSubview(String idSubview) {
		this.idSubview = idSubview;
	}
	/**
	 * @return the include
	 */
	public String getInclude() {
		return include;
	}
	/**
	 * @param include the include to set
	 */
	public void setInclude(String include) {
		this.include = include;
	}

	public String getEsFormulario() {
		return esFormulario;
	}

	public void setEsFormulario(String esFormulario) {
		this.esFormulario = esFormulario;
	}
	
	
	
	
}
