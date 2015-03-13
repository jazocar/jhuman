package cl.jazocar.jselector.dao.service;

import java.util.List;

import javax.swing.table.TableModel;

import cl.jazocar.jselector.dto.AplicacionDTO;
import cl.jazocar.jselector.dto.AreaDTO;
import cl.jazocar.jselector.dto.CasoComentarioDTO;
import cl.jazocar.jselector.dto.CiudadDTO;
import cl.jazocar.jselector.dto.ComunaDTO;
import cl.jazocar.jselector.dto.CreacionDTO;
import cl.jazocar.jselector.dto.EmpresaDTO;
import cl.jazocar.jselector.dto.EstructuraDTO;
import cl.jazocar.jselector.dto.InstanciaDTO;
import cl.jazocar.jselector.dto.ListaDTO;
import cl.jazocar.jselector.dto.OrganizacionDTO;
import cl.jazocar.jselector.dto.ParametroDTO;
import cl.jazocar.jselector.dto.PendienteDTO;
import cl.jazocar.jselector.dto.RegionDTO;
import cl.jazocar.jselector.dto.SolicitudDTO;
import cl.jazocar.jselector.dto.SolicitudFormularioDTO;
import cl.jazocar.jselector.dto.SubareaDTO;
import cl.jazocar.jselector.dto.TareaConfiguracionDTO;
import cl.jazocar.jselector.dto.TareaDTO;
import cl.jazocar.jselector.dto.TipoParametroDTO;
import cl.jazocar.jselector.dto.UsuarioDTO;
import cl.jazocar.jselector.exception.JProcessBusinessException;
import cl.jazocar.jselector.model.ConfigModel;
import cl.jazocar.jselector.sys.dto.MenuDTO;
import cl.jazocar.jselector.sys.dto.PanelDTO;
import cl.jazocar.jselector.sys.dto.RolDTO;
import cl.jazocar.jselector.sys.dto.RolProcesoDTO;
import cl.jazocar.jselector.sys.dto.SubmenuDTO;

public interface IConfigJProcessService 
{
	public TableModel getTableModel(String id) throws JProcessBusinessException;	
	public List<TableModel> getTableModelList() throws JProcessBusinessException;	
	public List<ConfigModel> getConfigModelList() throws JProcessBusinessException;
	public ConfigModel getConfigModel(String configCode) throws JProcessBusinessException;
	public String getNameTableModel(String string)throws JProcessBusinessException;	
	public boolean addUserProfile(String user, int profile) throws JProcessBusinessException;	
	public boolean updateUserProfile(String user,int profile) throws JProcessBusinessException;	
	public boolean deleteUserProfile(String user, int profile) throws JProcessBusinessException;
	
	/* Usuarios  */
	
	public Integer insertUsuario(UsuarioDTO usuario);	
	public Integer updateUsuario(UsuarioDTO usuario);	
	public Integer deleteUsuario(UsuarioDTO usuario);	
	public List<UsuarioDTO> getAllUsuarios();	
	public List<UsuarioDTO> getAllUsuariosSoporte();	
	public List<UsuarioDTO> getAllUsuariosSoporteAsignacion();	
	public List<UsuarioDTO> getAllUsuariosActivos();	
	public Integer darBajaAltaUsuario(int id, String accion);	
	public UsuarioDTO getUsuario(int idUsuario);	
	public UsuarioDTO loginUsuario(String usuario, String password);	
	public Integer updatePasswordUsuario(UsuarioDTO usuario);
		
	/* Systema  */
	/* Menu */
	public Integer   insertMenu(String idMenu, String label);
	public Integer   updateMenu(int id, String idMenu, String label, int order);
	public Integer   deleteMenu(int id);
	public List<MenuDTO> selectMenu();
	public MenuDTO   selectMenuById(int id);
	public Integer   clearMenuRol(int idMenu);
	public Integer   addMenuRol(int idMenu, int idRol);
	public List<MenuDTO> obtenerMenuPerfiladoByRol(int rol);

	
	/* Submenu */
	public Integer insertSubmenu(String submenuId, String etiqueta, String stackName, int idMenu);
	public Integer updateSubmenu(int id, String submenuId, String etiqueta, String stackName, int idMenu, int order);
	public Integer deleteSubmenu(int id);
	public List<SubmenuDTO> selectAllSubmenu();
	public List<SubmenuDTO> selectSubmenuByMenu(int idMenu);
	
	/* Paneles */
	public Integer insertPanel(PanelDTO panel);
	public Integer updatePanel(PanelDTO panel);
	public Integer deletePanel(int id);
	public List<PanelDTO> selectAllPanel();
	public List<PanelDTO> selectAllPanelFormulario();
	public PanelDTO selectAllPanelFormularioByTarea(int idTarea, int idAplicacion, int idInstancia);
	
	/* Roles */
	public Integer insertRol(RolDTO rol);
	public Integer updateRol(RolDTO rol);
	public Integer deleteRol(int id);
	public List<RolDTO> selectAllRol();
	public RolDTO       selectRolById(int id);	
	public List<RolDTO> selectRolByMenu(int idMenu);
	
	/* Roles de Proceso */
	public Integer insertRolProceso(RolProcesoDTO rol);
	public Integer updateRolProceso(RolProcesoDTO rol);
	public Integer deleteRolProceso(int id);
	public List<RolProcesoDTO> selectAllRolProcesos();
	public RolProcesoDTO       selectRolProcesoById(int id);	
	
	/* Tarea */
	
	public Integer insertTarea(TareaDTO tarea);
	public Integer updateTarea(TareaDTO tarea);
	public Integer deleteTarea(TareaDTO tarea);
	public List<TareaDTO> selectAllTarea();
	public TareaDTO selectTareaById(int id);
	
	/* Aplicacion  */
	public Integer insertAplicacion(AplicacionDTO aplicacion);
	public Integer updateAplicacion(AplicacionDTO aplicacion);
	public Integer deleteAplicacion(AplicacionDTO aplicacion);
	public List<AplicacionDTO> selectAllAplicacion();
	public AplicacionDTO selectAplicacionById(int id);
	public AplicacionDTO selectAplicacionBusquedaById(int id);
	public Integer updateInicioFinAplicacion(int id);
	
	/* Organizacion */
	public OrganizacionDTO getOrganizacionById(int id);
	public Integer insertOrganizacion(OrganizacionDTO organizacion);
	public Integer updateOrganizacion(OrganizacionDTO organizacion);
	public Integer deleteOrganizacion(OrganizacionDTO organizacion);
	public List<OrganizacionDTO> selectAllOrganizacion();
	
	/* Creación  */
	public Integer selectNextIdCreacion();
	public Integer insertCreacion(CreacionDTO creacion);
	public Integer updateCreacion(CreacionDTO creacion);
	public Integer deleteCreacion(CreacionDTO creacion);
	public List<CreacionDTO> selectAllCreacion();
	public CreacionDTO selectCreacionById(int id);
	public List<CreacionDTO> selectCreacionByIdAplicacion(int idAplicacion);
	public CreacionDTO selectCreacionByTareaInicial(int idTarea, int idAplicacion);
	public Integer cerrarCreacion(int idPendiente);
	public Integer despacharCreacion(int idTarea, int idAplicacion, int rol);
	
	/* Solicitudes */
	public Integer insertSolicitud(SolicitudDTO solicitud);
	public Integer desistirSolicitud(SolicitudDTO solicitud);
	public Integer eliminarSolicitud(SolicitudDTO solicitud);
	public List<SolicitudDTO> selectAllSolicitudes();
	public List<SolicitudDTO> selectAllSolicitudesByRol(int idRol);
	public List<SolicitudDTO> selectAllSolicitudesPendientesByRol(int idRol, int idOrganizacion, int idEmpresa);
	public List<SolicitudDTO> selectAllSolicitudesByCliente(int idCliente);
	public SolicitudDTO selectSolicitudById(int idSolicitud);
	public int selectNewSolicitudId();
	public TareaDTO selectTareaActualBySolicitudId(int idSolicitud);
	public Integer cerrarSolicitud(int idSolicitud);
	public Integer asignarResponsable(int idUsuario, int idSolicitud);
	public Integer liberarResponsable(int idUsuario, int idSolicitud);
	public List<SolicitudDTO> searchSolicitudesByFields(SolicitudDTO solicitud, UsuarioDTO usuario);
	
	public List<SolicitudDTO> selectSolicitudesByUser(UsuarioDTO usuario);
	
	/* Solicitud Formularios.  */
	public Integer                 insertSolicitudFormulario(SolicitudFormularioDTO solicitudFormulario);
	public Integer                 updateSolicitudFormulario(SolicitudFormularioDTO solicitudFormulario);
	public SolicitudFormularioDTO  selectSolicitudFormulario(int idSolicitud, int idTarea);
	
	/* Solicitud Comentarios  */
	public Integer insertSolicitudComentario(int solicitudId, String usuario, String comentario);
	public List<CasoComentarioDTO> selectComentariosBySolicitud(int idSolicitud);	
	
	/* Pendientes */
	public Integer insertPendiente(PendienteDTO pendiente);
	public List<PendienteDTO> selectAllPendientes();
	public List<PendienteDTO> selectAllPendientesByRol(int idRol);
	public List<PendienteDTO> selectAllPendientesBySolicitud(int idSolicitud);
	public PendienteDTO       selectPendientesById(int id);
	public PendienteDTO       selectPendientesBySolicitud(int id);
	
	/* Tarea Configuracion  */
	public Integer  insertTareaConfiguracion(TareaConfiguracionDTO configuracion);
	public Integer  updateTareaConfiguracion(TareaConfiguracionDTO configuracion);
	public Integer  deleteTareaConfiguracion(TareaConfiguracionDTO configuracion);
	public List<TareaConfiguracionDTO> selectTareaConfiguracion();
	public List<TareaConfiguracionDTO> selectTareaConfiguracionByTarea(int idTarea);
	public TareaConfiguracionDTO selectTareaConfiguracionById(int id);
	
	/* Áreas */
	public Integer insertArea(AreaDTO area);
	public Integer updateArea(AreaDTO area);
	public Integer deleteArea(AreaDTO area);
	public List<AreaDTO> selectAreas();
	public List<AreaDTO> selectAreasByOrganizacion(int idOrganizacion);
	public AreaDTO selectAreaById(int idArea);
	
	/* Sub Áreas */
	public Integer insertSubarea(SubareaDTO subarea);
	public Integer updateSubarea(SubareaDTO subarea);
	public Integer deleteSubarea(SubareaDTO subarea);
	public List<SubareaDTO> selectSubareas();
	public List<SubareaDTO> selectSubareasByArea(int idArea);
	public SubareaDTO selectSubareaById(int idSubarea);
	
	//Empresas.
	public Integer 			insertEmpresa(EmpresaDTO empresa);
	public Integer 			updateEmpresa(EmpresaDTO empresa);
	public Integer 			deleteEmpresa(EmpresaDTO empresa);
	public List<EmpresaDTO> selectEmpresas();
	public EmpresaDTO       selectEmpresaById(int idEmpresa);
	public List<EmpresaDTO> selectEmpresasByOrganizacion(int idOrganizacion);
	public List<EmpresaDTO> searchEmpresas(EmpresaDTO empresa);
	
	//Región.
	public Integer 			insertRegion(RegionDTO region);
	public Integer 			updateRegion(RegionDTO region);
	public Integer 			deleteRegion(RegionDTO region);
	public List<RegionDTO>  selectRegiones();
	public RegionDTO        selectRegionById(int idRegion);
	
	//Ciudad
	public Integer 			insertCiudad(CiudadDTO ciudad);
	public Integer 			updateCiudad(CiudadDTO ciudad);
	public Integer 			deleteCiudad(CiudadDTO ciudad);
	public List<CiudadDTO>  selectCiudades();
	public List<CiudadDTO>  selectCiudadesByRegion(int idRegion);
	public CiudadDTO        selectCiudadById(int idCiudad);
	
	//Comuna
	public Integer 			insertComuna(ComunaDTO comuna);
	public Integer 			updateComuna(ComunaDTO comuna);
	public Integer 			deleteComuna(ComunaDTO comuna);
	public List<ComunaDTO>  selectComunas();
	public List<ComunaDTO>  selectComunasByProvincia(int idProvincia);
	public ComunaDTO        selectComunaById(int idProvincia);
	
	//Instancia Aplicacion. 
	public Integer            selectIdNextInstancia(); 
	public Integer            insertInstancia(InstanciaDTO instancia);
	public Integer            updateInstancia(InstanciaDTO instancia);
	public Integer            deleteInstancia(InstanciaDTO instancia);
	public List<InstanciaDTO> selectInstancia();
	public List<InstanciaDTO> selectInstanciaByAplicacion(int idAplicacion);
	public InstanciaDTO       selectInstanciaById(int id);
	public InstanciaDTO       selectInstanciaByEmpresaAplicacion(int idEmpresa, int idAplicacion);
	
	
	  public  Integer insertTipoParametro(TipoParametroDTO paramTipoParametroDTO);	  
	  public  Integer updateTipoParametro(TipoParametroDTO paramTipoParametroDTO);	  
	  public  Integer deleteTipoParametro(TipoParametroDTO paramTipoParametroDTO);	  
	  public  List<TipoParametroDTO> selectTipoParametro();
	  public  List<TipoParametroDTO> searchTipoParametro(TipoParametroDTO paramTipoParametroDTO);
	  public  TipoParametroDTO selectTipoParametroById(int paramInt);	
	  
	  public  Integer insertParametro(ParametroDTO paramParametroDTO);	  
	  public  Integer updateParametro(ParametroDTO paramParametroDTO);	  
	  public  Integer deleteParametro(ParametroDTO paramParametroDTO);	  
	  public  List<ParametroDTO> selectParametro();	 
	  public  List<ParametroDTO> searchParametro(ParametroDTO paramParametroDTO);	
	  public  List<ParametroDTO> selectParametroByTipoParametro(int paramInt);	  
	  public  ParametroDTO selectParametroById(int paramInt);
	  
	  
	  public  Integer insertEstructura(EstructuraDTO estructuraDTO);	  
	  public  Integer updateEstructura(EstructuraDTO estructuraDTO);	  
	  public  Integer deleteEstructura(EstructuraDTO paramTipoParametroDTO);	  
	  public  List<EstructuraDTO> selectEstructura();	
	  public  List<EstructuraDTO> searchEstructura(EstructuraDTO estructuraDTO);	
	  public  EstructuraDTO selectEstructuraById(int id);	
	  
	  public  Integer        insertLista(ListaDTO listaDTO);	  
	  public  Integer        updateLista(ListaDTO listaDTO);	  
	  public  Integer        deleteLista(ListaDTO listaDTO);	  
	  public  List<ListaDTO> selectLista();	  
	  public  ListaDTO       selectListaById(int id);
	  public  List<ListaDTO> selectListaByIdParametro(int id);
	  public  List<ListaDTO> searchLista(ListaDTO listaDTO);	 
	  
	  
	  
}
