/**
 * 
 */
package cl.jazocar.jselector.sys.front;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.front.AplicationAbstract;
import cl.jazocar.jselector.front.impl.UsuarioFrontBean;
import cl.jazocar.jselector.sys.dto.MenuDTO;
import cl.jazocar.jselector.sys.dto.PanelDTO;
import cl.jazocar.jselector.sys.dto.RolDTO;
import cl.jazocar.jselector.sys.dto.SubmenuDTO;

/**
 * @author Diablo
 * 
 */
@ManagedBean(name = "menuFrontBean")
@ApplicationScoped
public class MenuFrontBean extends AplicationAbstract{

	public static List<MenuDTO> listaMenu;
	public  List<MenuDTO> listaMenuTable;
	private List<SubmenuDTO> listaSubmenu;
	
	private List<SelectItem> itemsMenu;
	public static List<SelectItem> itemsPanel;

	private String inputIdMenu;
	private String inputLabel;
	private String inputOrder;
	
	/* Submenu  */
	private String selectedMenu;
	private String selectedPanel;
	private String inputSubmenuNombre;
	private String inputSubmenuEtiqueta;
	private String inputSubmenuOrder;
		
	private static MenuDTO menu;
	private static SubmenuDTO submenu;
	
	private boolean selected;
	private boolean selectedSubmenu;
	
	private boolean abrirPerfilarMenu;
	private boolean abrirPerfilarSubmenu;
	
	private List<SelectItem> firstRoles;
	private List<SelectItem> secondRoles;
	
	public MenuFrontBean(){
		listaMenu    = new ArrayList<MenuDTO>();
		listaSubmenu = new ArrayList<SubmenuDTO>();
		
		itemsMenu = new ArrayList<SelectItem>();
		itemsPanel = new ArrayList<SelectItem>();
		
		firstRoles  = new ArrayList<SelectItem>();
		secondRoles = new ArrayList<SelectItem>();
			
		listaMenuTable = new ArrayList<MenuDTO>();
		
		listaMenuTable = configJProcessService.selectMenu();

		obtenerLista();	
	}

	public void refreshMenuListener(ActionEvent e){
		obtenerLista();	
	}
	
	public void ingresarMenuListener(ActionEvent e){	
		if(!inputIdMenu.equals("") && !inputLabel.equals("")){
			configJProcessService.insertMenu(inputIdMenu, inputLabel);		
		obtenerLista();	
		limpiarCampos();
		listaMenu = configJProcessService.obtenerMenuPerfiladoByRol(UsuarioFrontBean.usuarioBean.getRol());
		}else{
			System.out.println("Campos Vacios");
		}
	}
	
	public void ingresarSubmenuListener(ActionEvent e){
		
		if(!inputSubmenuNombre.equals("") && !inputSubmenuEtiqueta.equals("")&& !selectedMenu.equals("-1") && !selectedPanel.equals("-1")){
			configJProcessService.insertSubmenu(inputSubmenuNombre, inputSubmenuEtiqueta, selectedPanel, Integer.parseInt(selectedMenu));
			obtenerLista();
			limpiarCamposSubmenu();
		}
	}
	
	public void modificarMenuListener(ActionEvent e){
		if(!inputIdMenu.equals("") && !inputLabel.equals("") && !inputOrder.equals("") ){
			configJProcessService.updateMenu(menu.getId(), inputIdMenu, inputLabel, Integer.parseInt(inputOrder));
			obtenerLista();	
			limpiarCampos();
		}else{
			System.out.println("Campos Nulos");
		}
	}
	
	public void modificarSubmenuListener(ActionEvent e){
		if(!inputSubmenuNombre.equals("") && !inputSubmenuEtiqueta.equals("")&& !selectedMenu.equals("-1") && !selectedPanel.equals("-1")){
			configJProcessService.updateSubmenu(submenu.getId(), inputSubmenuNombre, inputSubmenuEtiqueta, selectedPanel, Integer.parseInt(selectedMenu), Integer.parseInt(inputSubmenuOrder));
			obtenerLista();
			limpiarCamposSubmenu();
		}else{
			System.out.println("Campos Nulos");
		}
	}
	
	public void darBajaMenuListener(ActionEvent e){
		configJProcessService.deleteMenu(menu.getId());
		obtenerLista();
		limpiarCampos();
	}
	
	public void darBajaSubmenuListener(ActionEvent e){
		configJProcessService.deleteSubmenu(submenu.getId());
		obtenerLista();
		limpiarCamposSubmenu();
	}
	
	public void rowSelectionListener(SelectEvent event) {
		menu = (MenuDTO) event.getObject();
		
		inputIdMenu = menu.getIdMenu();
		inputLabel  = menu.getEtiqueta();
		inputOrder  = String.valueOf(menu.getOrder());
		
		selected = true;
	}
	
	public void rowSelectionSubmenuListener(SelectEvent event) {
		submenu = (SubmenuDTO) event.getObject();
		
		selectedMenu = String.valueOf(submenu.getIdMenu());
		selectedPanel        = submenu.getStackName();
		inputSubmenuNombre   = submenu.getIdSubmenu();
		inputSubmenuEtiqueta = submenu.getEtiqueta();		
		inputSubmenuOrder    = String.valueOf(submenu.getOrder());
		
		selectedSubmenu = true;
	}
	
	public void limpiarCamposListener(ActionEvent e){
		limpiarCampos();
	}
	
	public void limpiarCampos(){
		inputIdMenu = "";
		inputLabel  = "";
		inputOrder  = "";
		selected    = false;
		listaMenu = configJProcessService.obtenerMenuPerfiladoByRol(UsuarioFrontBean.usuarioBean.getRol());
	}
	
	
	public void limpiarCamposSubmenuListener(ActionEvent e){
		limpiarCamposSubmenu();
	}
	
	public void limpiarCamposSubmenu(){
		selectedMenu = "-1";
		selectedPanel = "-1";
		inputSubmenuEtiqueta= "";
		inputSubmenuNombre = "";
		inputSubmenuOrder = "";
		selectedSubmenu =  false;
		listaMenu = configJProcessService.obtenerMenuPerfiladoByRol(UsuarioFrontBean.usuarioBean.getRol());
	}
	
	public void obtenerLista(){		
		
		listaMenuTable = configJProcessService.selectMenu();
		listaSubmenu   = configJProcessService.selectAllSubmenu();
	
		
		itemsMenu = new ArrayList<SelectItem>();
		itemsPanel = new ArrayList<SelectItem>();
		
		for (MenuDTO menu : configJProcessService.selectMenu())
			itemsMenu.add(new SelectItem( menu.getId(), menu.getEtiqueta()));
			
		for(PanelDTO panel : configJProcessService.selectAllPanel())
			itemsPanel.add(new SelectItem( panel.getIdPanel(), panel.getIdPanel()));
		
	}
	
	public static void actualizarListaPaneles(List<PanelDTO> listaPaneles){
		itemsPanel = new ArrayList<SelectItem>();			
		for(PanelDTO panel : listaPaneles)
			itemsPanel.add(new SelectItem( panel.getIdPanel(), panel.getIdPanel()));		
	}
	
	public boolean existeEnListaDeRoles(int idRol){
		boolean estado = false;		
		for(RolDTO rol : configJProcessService.selectRolByMenu(menu.getId())){
			if(rol.getId() == idRol)
				estado = true;			
		}		
		return estado;
	}
	
	public void abrirPerfilarMenuListener(ActionEvent e){
		firstRoles  = new ArrayList<SelectItem>();
		secondRoles = new ArrayList<SelectItem>();
		
		List<RolDTO> lista = configJProcessService.selectAllRol();

		for(RolDTO rol : lista){
			if(existeEnListaDeRoles(rol.getId()))
				secondRoles.add(new SelectItem(rol.getId(), rol.getNombreRol()));
			else
				firstRoles.add(new SelectItem(rol.getId(), rol.getNombreRol()));			
		}			
		abrirPerfilarMenu = true;		
	}
	
	public void modificarMenuRolProfile(ActionEvent e){
		configJProcessService.clearMenuRol(menu.getId());
		
		for(SelectItem item: secondRoles){
			configJProcessService.addMenuRol(menu.getId(), Integer.parseInt(item.getValue().toString()));
		}
		obtenerLista();
		abrirPerfilarMenu = false;
		listaMenu = configJProcessService.obtenerMenuPerfiladoByRol(UsuarioFrontBean.usuarioBean.getRol());
	}
	
	public void cerrarPerfilarMenuListener(ActionEvent e){
		abrirPerfilarMenu = false;
	}
	
	/**
	 * @return the listaMenu
	 */
	public List<MenuDTO> getListaMenu() {
		return listaMenu;
	}

	/**
	 * @param listaMenu
	 *            the listaMenu to set
	 */
	public void setListaMenu(List<MenuDTO> listaMenu) {
		this.listaMenu = listaMenu;
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
	 * @return the selected
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * @param selected the selected to set
	 */
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	/**
	 * @return the inputIdMenu
	 */
	public String getInputIdMenu() {
		return inputIdMenu;
	}

	/**
	 * @param inputIdMenu the inputIdMenu to set
	 */
	public void setInputIdMenu(String inputIdMenu) {
		this.inputIdMenu = inputIdMenu;
	}

	/**
	 * @return the inputLabel
	 */
	public String getInputLabel() {
		return inputLabel;
	}

	/**
	 * @param inputLabel the inputLabel to set
	 */
	public void setInputLabel(String inputLabel) {
		this.inputLabel = inputLabel;
	}

	/**
	 * @return the inputOrder
	 */
	public String getInputOrder() {
		return inputOrder;
	}

	/**
	 * @param inputOrder the inputOrder to set
	 */
	public void setInputOrder(String inputOrder) {
		this.inputOrder = inputOrder;
	}

	/**
	 * @return the itemsMenu
	 */
	public List<SelectItem> getItemsMenu() {
		return itemsMenu;
	}

	/**
	 * @param itemsMenu the itemsMenu to set
	 */
	public void setItemsMenu(List<SelectItem> itemsMenu) {
		this.itemsMenu = itemsMenu;
	}

	/**
	 * @return the menu
	 */
	public static MenuDTO getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public static void setMenu(MenuDTO menu) {
		MenuFrontBean.menu = menu;
	}

	/**
	 * @return the selectedMenu
	 */
	public String getSelectedMenu() {
		return selectedMenu;
	}

	/**
	 * @param selectedMenu the selectedMenu to set
	 */
	public void setSelectedMenu(String selectedMenu) {
		this.selectedMenu = selectedMenu;
	}

	/**
	 * @return the itemsPanel
	 */
	public List<SelectItem> getItemsPanel() {
		return itemsPanel;
	}

	/**
	 * @param itemsPanel the itemsPanel to set
	 */
	public void setItemsPanel(List<SelectItem> itemsPanel) {
		this.itemsPanel = itemsPanel;
	}

	/**
	 * @return the selectedPanel
	 */
	public String getSelectedPanel() {
		return selectedPanel;
	}

	/**
	 * @param selectedPanel the selectedPanel to set
	 */
	public void setSelectedPanel(String selectedPanel) {
		this.selectedPanel = selectedPanel;
	}

	/**
	 * @return the submenu
	 */
	public static SubmenuDTO getSubmenu() {
		return submenu;
	}

	/**
	 * @param submenu the submenu to set
	 */
	public static void setSubmenu(SubmenuDTO submenu) {
		MenuFrontBean.submenu = submenu;
	}

	/**
	 * @return the selectedSubmenu
	 */
	public boolean isSelectedSubmenu() {
		return selectedSubmenu;
	}

	/**
	 * @param selectedSubmenu the selectedSubmenu to set
	 */
	public void setSelectedSubmenu(boolean selectedSubmenu) {
		this.selectedSubmenu = selectedSubmenu;
	}

	/**
	 * @return the inputSubmenuNombre
	 */
	public String getInputSubmenuNombre() {
		return inputSubmenuNombre;
	}

	/**
	 * @param inputSubmenuNombre the inputSubmenuNombre to set
	 */
	public void setInputSubmenuNombre(String inputSubmenuNombre) {
		this.inputSubmenuNombre = inputSubmenuNombre;
	}

	/**
	 * @return the inputSubmenuEtiqueta
	 */
	public String getInputSubmenuEtiqueta() {
		return inputSubmenuEtiqueta;
	}

	/**
	 * @param inputSubmenuEtiqueta the inputSubmenuEtiqueta to set
	 */
	public void setInputSubmenuEtiqueta(String inputSubmenuEtiqueta) {
		this.inputSubmenuEtiqueta = inputSubmenuEtiqueta;
	}

	/**
	 * @return the inputSubmenuOrder
	 */
	public String getInputSubmenuOrder() {
		return inputSubmenuOrder;
	}

	/**
	 * @param inputSubmenuOrder the inputSubmenuOrder to set
	 */
	public void setInputSubmenuOrder(String inputSubmenuOrder) {
		this.inputSubmenuOrder = inputSubmenuOrder;
	}

	/**
	 * @return the abrirPerfilarMenu
	 */
	public boolean isAbrirPerfilarMenu() {
		return abrirPerfilarMenu;
	}

	/**
	 * @param abrirPerfilarMenu the abrirPerfilarMenu to set
	 */
	public void setAbrirPerfilarMenu(boolean abrirPerfilarMenu) {
		this.abrirPerfilarMenu = abrirPerfilarMenu;
	}

	/**
	 * @return the abrirPerfilarSubmenu
	 */
	public boolean isAbrirPerfilarSubmenu() {
		return abrirPerfilarSubmenu;
	}

	/**
	 * @param abrirPerfilarSubmenu the abrirPerfilarSubmenu to set
	 */
	public void setAbrirPerfilarSubmenu(boolean abrirPerfilarSubmenu) {
		this.abrirPerfilarSubmenu = abrirPerfilarSubmenu;
	}

	/**
	 * @return the firstRoles
	 */
	public List<SelectItem> getFirstRoles() {
		return firstRoles;
	}

	/**
	 * @param firstRoles the firstRoles to set
	 */
	public void setFirstRoles(List<SelectItem> firstRoles) {
		this.firstRoles = firstRoles;
	}

	/**
	 * @return the secondRoles
	 */
	public List<SelectItem> getSecondRoles() {
		return secondRoles;
	}

	/**
	 * @param secondRoles the secondRoles to set
	 */
	public void setSecondRoles(List<SelectItem> secondRoles) {
		this.secondRoles = secondRoles;
	}

	/**
	 * @return the listaMenuTable
	 */
	public List<MenuDTO> getListaMenuTable() {
		return listaMenuTable;
	}

	/**
	 * @param listaMenuTable the listaMenuTable to set
	 */
	public void setListaMenuTable(List<MenuDTO> listaMenuTable) {
		this.listaMenuTable = listaMenuTable;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insertObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void searchObjectListener(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resetObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void objectSelectListener(SelectEvent event) {
		// TODO Auto-generated method stub
		
	}			
	
	
	
}
