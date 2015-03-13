/**
 * 
 */
package cl.jazocar.jselector.dto;

/**
 * @author Diablo
 *
 */
public class TareaConfiguracionDTO extends ResponseDTO{


	private static final long serialVersionUID = 1L;
	private int    id;
	private int    idTarea;
	private String checkOption;
	private boolean  seleccionado;
	private boolean requerido;
	
	
	/**
	 * 
	 */
	public TareaConfiguracionDTO() {
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
	 * @return the idTarea
	 */
	public int getIdTarea() {
		return idTarea;
	}
	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(int idTarea) {
		this.idTarea = idTarea;
	}
	/**
	 * @return the checkOption
	 */
	public String getCheckOption() {
		return checkOption;
	}
	/**
	 * @param checkOption the checkOption to set
	 */
	public void setCheckOption(String checkOption) {
		this.checkOption = checkOption;
	}
	/**
	 * @return the requerido
	 */
	public boolean isRequerido() {
		return requerido;
	}
	/**
	 * @param requerido the requerido to set
	 */
	public void setRequerido(boolean requerido) {
		this.requerido = requerido;
	}
	/**
	 * @return the seleccionado
	 */
	public boolean isSeleccionado() {
		return seleccionado;
	}
	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}


	
}
