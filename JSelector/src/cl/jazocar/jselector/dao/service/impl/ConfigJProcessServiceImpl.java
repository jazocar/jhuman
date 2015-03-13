package cl.jazocar.jselector.dao.service.impl;

import java.util.Date;
import java.util.List;

import javax.swing.table.TableModel;

import org.apache.ibatis.session.SqlSessionFactory;

import cl.jazocar.jselector.common.context.JProcessContextImpl;
import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dao.base.IConfigJProcessDao;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
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
import cl.jazocar.jselector.ibatis.dao.MyBatisCommonDao;
import cl.jazocar.jselector.model.ConfigModel;
import cl.jazocar.jselector.sys.dto.MenuDTO;
import cl.jazocar.jselector.sys.dto.PanelDTO;
import cl.jazocar.jselector.sys.dto.RolDTO;
import cl.jazocar.jselector.sys.dto.RolProcesoDTO;
import cl.jazocar.jselector.sys.dto.SubmenuDTO;

public class ConfigJProcessServiceImpl extends MyBatisCommonDao implements IConfigJProcessService 
{
	private IConfigJProcessDao configJProcessDao;
		
	
	/**
	 * @return the configBackupDao
	 */
	public IConfigJProcessDao getConfigJProcessDao() {
		return configJProcessDao;
	}

	/**
	 * @param iConfigBackupDao the configBackupDao to set
	 */
	public void setConfigJProcessDao(IConfigJProcessDao iConfigJProcessDao) {
		this.configJProcessDao = iConfigJProcessDao;
	}

	@Override
	public TableModel getTableModel(String id) throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TableModel> getTableModelList() throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ConfigModel> getConfigModelList() throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.mtogen.SelectListConfigModel");
	}

	@Override
	public ConfigModel getConfigModel(String configCode)
			throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNameTableModel(String string) throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addUserProfile(String user, int profile)
			throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserProfile(String user, int profile)
			throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserProfile(String user, int profile)
			throws JProcessBusinessException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected SqlSessionFactory getSqlSessionFactory() {
		// TODO Auto-generated method stub
		return JProcessContextImpl.getInstance().lookup(IConstants.JPROCESS_PERSITENCE) ;
	}
	

	@Override
	public Integer insertMenu(String idMenu, String label) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertMenu(idMenu, label);
	}

	@Override
	public Integer updateMenu(int id, String idMenu, String label, int order) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateMenu(id, idMenu, label, order);
	}

	@Override
	public Integer deleteMenu(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteMenu(id);
	}

	@Override
	public List<MenuDTO> selectMenu() {
		// TODO Auto-generated method stub
		
		List<MenuDTO> listaMenu = configJProcessDao.selectMenu();		
		
		for(MenuDTO menu : listaMenu){			
			menu.setListaSubmenu(configJProcessDao.selectSubmenuByMenu(menu.getId()));
		}		
		return listaMenu;
	}

	@Override
	public Integer insertSubmenu(String submenuId, String etiqueta,
			String stackName, int idMenu) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertSubmenu(submenuId, etiqueta, stackName, idMenu);
	}

	@Override
	public Integer updateSubmenu(int id, String submenuId, String etiqueta,
			String stackName, int idMenu, int order) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateSubmenu(id, submenuId, etiqueta, stackName, idMenu, order);
	}

	@Override
	public Integer deleteSubmenu(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteSubmenu(id);
	}

	@Override
	public List<SubmenuDTO> selectAllSubmenu() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllSubmenu();
	}

	@Override
	public List<SubmenuDTO> selectSubmenuByMenu(int idMenu) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectSubmenuByMenu(idMenu);
	}

	@Override
	public Integer insertPanel(PanelDTO panel) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertPanel(panel);
	}

	@Override
	public Integer updatePanel(PanelDTO panel) {
		// TODO Auto-generated method stub
		return configJProcessDao.updatePanel(panel);
	}

	@Override
	public Integer deletePanel(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.deletePanel(id);
	}

	@Override
	public List<PanelDTO> selectAllPanel() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllPanel();
	}

	@Override
	public Integer insertRol(RolDTO rol) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertRol(rol);
	}

	@Override
	public Integer updateRol(RolDTO rol) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateRol(rol);
	}

	@Override
	public Integer deleteRol(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteRol(id);
	}

	@Override
	public List<RolDTO> selectAllRol() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllRol();
	}

	@Override
	public List<MenuDTO> obtenerMenuPerfiladoByRol(int rol) {
		// TODO Auto-generated method stub
		List<MenuDTO> listaMenu = configJProcessDao.obtenerMenuPerfiladoByRol(rol);		
		
		for(MenuDTO menu : listaMenu){			
			menu.setListaSubmenu(configJProcessDao.selectSubmenuByMenu(menu.getId()));
		}	
		return listaMenu;
	}

	@Override
	public List<RolDTO> selectRolByMenu(int idMenu) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectRolByMenu(idMenu);
	}

	@Override
	public Integer clearMenuRol(int idMenu) {
		// TODO Auto-generated method stub
		return configJProcessDao.clearMenuRol(idMenu);
	}

	@Override
	public Integer addMenuRol(int idMenu, int idRol) {
		// TODO Auto-generated method stub
		return configJProcessDao.addMenuRol(idMenu, idRol);
	}
	
	@Override
	public Integer insertUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertUsuario(usuario);
	}

	@Override
	public Integer updateUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateUsuario(usuario);
	}

	@Override
	public Integer deleteUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteUsuario(usuario);
	}

	@Override
	public List<UsuarioDTO> getAllUsuarios() {
		// TODO Auto-generated method stub
		return configJProcessDao.getAllUsuarios();
	}

	@Override
	public List<UsuarioDTO> getAllUsuariosSoporte() {
		// TODO Auto-generated method stub
		return configJProcessDao.getAllUsuariosSoporte();
	}

	@Override
	public List<UsuarioDTO> getAllUsuariosSoporteAsignacion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UsuarioDTO> getAllUsuariosActivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer darBajaAltaUsuario(int id, String accion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO getUsuario(int idUsuario) {
		// TODO Auto-generated method stub
		return configJProcessDao.getUsuario(idUsuario);
	}

	@Override
	public UsuarioDTO loginUsuario(String usuario, String password) {
		// TODO Auto-generated method stub
		return configJProcessDao.loginUsuario(usuario, password);
	}

	@Override
	public Integer updatePasswordUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertTarea(TareaDTO tarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertTarea(tarea);
	}

	@Override
	public Integer updateTarea(TareaDTO tarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateTarea(tarea);
	}

	@Override
	public Integer deleteTarea(TareaDTO tarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteTarea(tarea);
	}

	@Override
	public List<TareaDTO> selectAllTarea() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllTarea();
	}

	@Override
	public TareaDTO selectTareaById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectTareaById(id);
	}

	@Override
	public OrganizacionDTO getOrganizacionById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.getOrganizacionById(id);
	}

	@Override
	public Integer insertOrganizacion(OrganizacionDTO organizacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertOrganizacion(organizacion);
	}

	@Override
	public Integer updateOrganizacion(OrganizacionDTO organizacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateOrganizacion(organizacion);
	}

	@Override
	public Integer deleteOrganizacion(OrganizacionDTO organizacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteOrganizacion(organizacion);
	}

	@Override
	public List<OrganizacionDTO> selectAllOrganizacion() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllOrganizacion();
	}

	@Override
	public RolDTO selectRolById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectRolById(id);
	}

	@Override
	public Integer insertAplicacion(AplicacionDTO aplicacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertAplicacion(aplicacion);
	}

	@Override
	public Integer updateAplicacion(AplicacionDTO aplicacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateAplicacion(aplicacion);
	}

	@Override
	public Integer deleteAplicacion(AplicacionDTO aplicacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteAplicacion(aplicacion);
	}

	@Override
	public List<AplicacionDTO> selectAllAplicacion() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllAplicacion();
	}

	@Override
	public AplicacionDTO selectAplicacionById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAplicacionById(id);
	}

	@Override
	public Integer insertCreacion(CreacionDTO creacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertCreacion(creacion);
	}

	@Override
	public Integer updateCreacion(CreacionDTO creacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateCreacion(creacion);
	}

	@Override
	public Integer deleteCreacion(CreacionDTO creacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteCreacion(creacion);
	}

	@Override
	public List<CreacionDTO> selectAllCreacion() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllCreacion();
	}

	@Override
	public List<CreacionDTO> selectCreacionByIdAplicacion(int idAplicacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectCreacionByIdAplicacion(idAplicacion);
	}

	@Override
	public CreacionDTO selectCreacionById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateInicioFinAplicacion(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateInicioFinAplicacion(id);
	}

	@Override
	public Integer insertSolicitud(SolicitudDTO solicitud) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertSolicitud(solicitud);
	}

	@Override
	public Integer desistirSolicitud(SolicitudDTO solicitud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer eliminarSolicitud(SolicitudDTO solicitud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitudDTO> selectAllSolicitudes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitudDTO> selectAllSolicitudesByRol(int idRol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SolicitudDTO> selectAllSolicitudesPendientesByRol(int idRol, int idOrganizacion, int idEmpresa) {
		// TODO Auto-generated method stub
		List<SolicitudDTO> lista = configJProcessDao.selectAllSolicitudesPendientesByRol(idRol, idOrganizacion, idEmpresa);
		
		for(SolicitudDTO solicitud : lista){
			//System.out.println(compararFechas(solicitud.getFechaFin()));
			if(compararFechas(solicitud.getFechaFin()).equals("menor")){
				solicitud.setColorEstado("red");
			}else if(compararFechas(solicitud.getFechaFin()).equals("mayor")){
				solicitud.setColorEstado("green");
			}			
		}		
		return lista;
	}

	@Override
	public SolicitudDTO selectSolicitudById(int idSolicitud) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectSolicitudById(idSolicitud);
	}

	@Override
	public Integer insertPendiente(PendienteDTO pendiente) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertPendiente(pendiente);
	}

	@Override
	public List<PendienteDTO> selectAllPendientes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PendienteDTO> selectAllPendientesByRol(int idRol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PendienteDTO> selectAllPendientesBySolicitud(int idSolicitud) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PendienteDTO selectPendientesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectNewSolicitudId() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectNewSolicitudId();
	}

	@Override
	public TareaDTO selectTareaActualBySolicitudId(int idSolicitud) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectTareaActualBySolicitudId(idSolicitud);
	}

	@Override
	public Integer insertSolicitudComentario(int solicitudId, String usuario,
			String comentario) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertSolicitudComentario(solicitudId, usuario, comentario);
	}

	@Override
	public List<CasoComentarioDTO> selectComentariosBySolicitud(int idSolicitud) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectComentariosBySolicitud(idSolicitud);
	}

	@Override
	public CreacionDTO selectCreacionByTareaInicial(int idTarea,
			int idAplicacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectCreacionByTareaInicial(idTarea, idAplicacion);
	}

	@Override
	public Integer cerrarCreacion(int idPendiente) {
		// TODO Auto-generated method stub
		return configJProcessDao.cerrarCreacion(idPendiente);
	}

	@Override
	public Integer despacharCreacion(int idTarea, int idAplicacion, int rol) {
		// TODO Auto-generated method stub
		return configJProcessDao.despacharCreacion(idTarea, idAplicacion, rol);
	}

	@Override
	public Integer cerrarSolicitud(int idSolicitud) {
		// TODO Auto-generated method stub
		return configJProcessDao.cerrarSolicitud(idSolicitud);
	}

	@Override
	public PendienteDTO selectPendientesBySolicitud(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectPendientesBySolicitud(id);
	}

	@Override
	public Integer asignarResponsable(int idUsuario, int idSolicitud) {
		// TODO Auto-generated method stub
		return configJProcessDao.asignarResponsable(idUsuario, idSolicitud);
	}

	@Override
	public Integer liberarResponsable(int idUsuario, int idSolicitud) {
		// TODO Auto-generated method stub
		return configJProcessDao.liberarResponsable(idUsuario, idSolicitud);
	}

	@Override
	public Integer insertTareaConfiguracion(TareaConfiguracionDTO configuracion) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertTareaConfiguracion(configuracion);
	}

	@Override
	public Integer updateTareaConfiguracion(TareaConfiguracionDTO configuracion) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateTareaConfiguracion(configuracion);
	}

	@Override
	public Integer deleteTareaConfiguracion(TareaConfiguracionDTO configuracion) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteTareaConfiguracion(configuracion);
	}

	@Override
	public List<TareaConfiguracionDTO> selectTareaConfiguracion() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectTareaConfiguracion();
	}

	@Override
	public List<TareaConfiguracionDTO> selectTareaConfiguracionByTarea(
			int idTarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectTareaConfiguracionByTarea(idTarea);
	}

	@Override
	public TareaConfiguracionDTO selectTareaConfiguracionById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectTareaConfiguracionById(id);
	}

	@Override
	public Integer insertArea(AreaDTO area) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertArea(area);
	}

	@Override
	public Integer updateArea(AreaDTO area) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateArea(area);
	}

	@Override
	public Integer deleteArea(AreaDTO area) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteArea(area);
	}

	@Override
	public List<AreaDTO> selectAreas() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAreas();
	}

	@Override
	public List<AreaDTO> selectAreasByOrganizacion(int idOrganizacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAreasByOrganizacion(idOrganizacion);
	}

	@Override
	public AreaDTO selectAreaById(int idArea) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAreaById(idArea);
	}

	@Override
	public Integer insertSubarea(SubareaDTO subarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertSubarea(subarea);
	}

	@Override
	public Integer updateSubarea(SubareaDTO subarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateSubarea(subarea);
	}

	@Override
	public Integer deleteSubarea(SubareaDTO subarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteSubarea(subarea);
	}

	@Override
	public List<SubareaDTO> selectSubareas() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectSubareas();
	}

	@Override
	public List<SubareaDTO> selectSubareasByArea(int idArea) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectSubareasByArea(idArea);
	}

	@Override
	public SubareaDTO selectSubareaById(int idSubarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectSubareaById(idSubarea);
	}

	@Override
	public List<PanelDTO> selectAllPanelFormulario() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllPanelFormulario();
	}

	@Override
	public PanelDTO selectAllPanelFormularioByTarea(int idTarea, int idAplicacion, int idInstancia) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllPanelFormularioByTarea(idTarea, idAplicacion, idInstancia);
	}
	
	private String compararFechas(Date fecha) { 	 
		  String resultado="";
		  try {
		   /**Obtenemos las fechas enviadas en el formato a comparar*/
		  
		   Date fechaActual = new Date();	  
		    
		    if ( fecha.before(fechaActual) ){
		        resultado= "menor";
		    }else if(fecha.after(fechaActual)){
		    	 resultado= "mayor";
		    }	
		    	
		  } catch (Exception e) {
		   System.out.println("Se Produjo un Error!!!  "+e.getMessage());
		  }  
		  return resultado;
	 }

	@Override
	public Integer insertSolicitudFormulario(
			SolicitudFormularioDTO solicitudFormulario) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertSolicitudFormulario(solicitudFormulario);
	}

	@Override
	public SolicitudFormularioDTO selectSolicitudFormulario(int idSolicitud,
			int idTarea) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectSolicitudFormulario(idSolicitud, idTarea);
	}

	@Override
	public Integer updateSolicitudFormulario(
			SolicitudFormularioDTO solicitudFormulario) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateSolicitudFormulario(solicitudFormulario);
	}

	@Override
	public List<SolicitudDTO> selectAllSolicitudesByCliente(int idCliente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertEmpresa(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertEmpresa(empresa);
	}

	@Override
	public Integer updateEmpresa(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateEmpresa(empresa);
	}

	@Override
	public Integer deleteEmpresa(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteEmpresa(empresa);
	}

	@Override
	public List<EmpresaDTO> selectEmpresas() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectEmpresas();
	}

	@Override
	public EmpresaDTO selectEmpresaById(int idEmpresa) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectEmpresaById(idEmpresa);
	}

	@Override
	public List<EmpresaDTO> searchEmpresas(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		return configJProcessDao.searchEmpresas(empresa);
	}

	@Override
	public List<EmpresaDTO> selectEmpresasByOrganizacion(int idOrganizacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectEmpresasByOrganizacion(idOrganizacion);
	}

	@Override
	public Integer insertRegion(RegionDTO region) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertRegion(region);
	}

	@Override
	public Integer updateRegion(RegionDTO region) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateRegion(region);
	}

	@Override
	public Integer deleteRegion(RegionDTO region) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteRegion(region);
	}

	@Override
	public List<RegionDTO> selectRegiones() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectRegiones();
	}

	@Override
	public RegionDTO selectRegionById(int idRegion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectRegionById(idRegion);
	}

	@Override
	public Integer insertCiudad(CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertCiudad(ciudad);
	}

	@Override
	public Integer updateCiudad(CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateCiudad(ciudad);
	}

	@Override
	public Integer deleteCiudad(CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteCiudad(ciudad);
	}

	@Override
	public List<CiudadDTO> selectCiudades() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectCiudades();
	}

	@Override
	public List<CiudadDTO> selectCiudadesByRegion(int idRegion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectCiudadesByRegion(idRegion);
	}

	@Override
	public CiudadDTO selectCiudadById(int idCiudad) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectCiudadById(idCiudad);
	}

	@Override
	public Integer insertComuna(ComunaDTO comuna) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertComuna(comuna);
	}

	@Override
	public Integer updateComuna(ComunaDTO comuna) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateComuna(comuna);
	}

	@Override
	public Integer deleteComuna(ComunaDTO comuna) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteComuna(comuna);
	}

	@Override
	public List<ComunaDTO> selectComunas() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectComunas();
	}

	@Override
	public List<ComunaDTO> selectComunasByProvincia(int idProvincia) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectComunasByProvincia(idProvincia);
	}

	@Override
	public ComunaDTO selectComunaById(int idProvincia) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectComunaById(idProvincia);
	}

	@Override
	public Integer insertRolProceso(RolProcesoDTO rol) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertRolProceso(rol);
	}

	@Override
	public Integer updateRolProceso(RolProcesoDTO rol) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateRolProceso(rol);
	}

	@Override
	public Integer deleteRolProceso(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteRolProceso(id);
	}

	@Override
	public List<RolProcesoDTO> selectAllRolProcesos() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAllRolProcesos();
	}

	@Override
	public RolProcesoDTO selectRolProcesoById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectRolProcesoById(id);
	}

	@Override
	public List<SolicitudDTO> selectSolicitudesByUser(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectSolicitudesByUser(usuario);
	}

	@Override
	public List<SolicitudDTO> searchSolicitudesByFields(SolicitudDTO solicitud, UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		if(solicitud.getEstado().equals("-1"))
			solicitud.setEstado(null);
		return configJProcessDao.searchSolicitudesByFields(solicitud, usuario);
	}

	@Override
	public Integer insertInstancia(InstanciaDTO instancia) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertInstancia(instancia);
	}

	@Override
	public Integer updateInstancia(InstanciaDTO instancia) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateInstancia(instancia);
	}

	@Override
	public Integer deleteInstancia(InstanciaDTO instancia) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteInstancia(instancia);
	}

	@Override
	public List<InstanciaDTO> selectInstancia() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectInstancia();
	}

	@Override
	public List<InstanciaDTO> selectInstanciaByAplicacion(int idAplicacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectInstanciaByAplicacion(idAplicacion);
	}

	@Override
	public InstanciaDTO selectInstanciaById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectInstanciaById(id);
	}

	@Override
	public InstanciaDTO selectInstanciaByEmpresaAplicacion(int idEmpresa, int idAplicacion) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectInstanciaByEmpresaAplicacion(idEmpresa, idAplicacion);
	}

	@Override
	public MenuDTO selectMenuById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectMenuById(id);
	}

	@Override
	public AplicacionDTO selectAplicacionBusquedaById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectAplicacionBusquedaById(id);
	}

	@Override
	public Integer selectNextIdCreacion() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectNextIdCreacion();
	}

	@Override
	public Integer selectIdNextInstancia() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectIdNextInstancia();
	}

	@Override
	public Integer insertTipoParametro(TipoParametroDTO paramTipoParametroDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertTipoParametro(paramTipoParametroDTO);
	}

	@Override
	public Integer updateTipoParametro(TipoParametroDTO paramTipoParametroDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateTipoParametro(paramTipoParametroDTO);
	}

	@Override
	public Integer deleteTipoParametro(TipoParametroDTO paramTipoParametroDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteTipoParametro(paramTipoParametroDTO);
	}

	@Override
	public List<TipoParametroDTO> selectTipoParametro() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectTipoParametro();
	}

	@Override
	public TipoParametroDTO selectTipoParametroById(int paramInt) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectTipoParametroById(paramInt);
	}

	@Override
	public Integer insertParametro(ParametroDTO paramParametroDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertParametro(paramParametroDTO);
	}

	@Override
	public Integer updateParametro(ParametroDTO paramParametroDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateParametro(paramParametroDTO);
	}

	@Override
	public Integer deleteParametro(ParametroDTO paramParametroDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteParametro(paramParametroDTO);
	}

	@Override
	public List<ParametroDTO> selectParametro() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectParametro();
	}

	@Override
	public List<ParametroDTO> selectParametroByTipoParametro(int paramInt) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectParametroByTipoParametro(paramInt);
	}

	@Override
	public ParametroDTO selectParametroById(int paramInt) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectParametroById(paramInt);
	}

	@Override
	public Integer insertEstructura(EstructuraDTO estructuraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer updateEstructura(EstructuraDTO estructuraDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteEstructura(EstructuraDTO paramTipoParametroDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstructuraDTO> selectEstructura() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectEstructura();
	}

	@Override
	public EstructuraDTO selectEstructuraById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.insertLista(listaDTO);
	}

	@Override
	public Integer updateLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.updateLista(listaDTO);
	}

	@Override
	public Integer deleteLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		return configJProcessDao.deleteLista(listaDTO);
	}

	@Override
	public List<ListaDTO> selectLista() {
		// TODO Auto-generated method stub
		return configJProcessDao.selectLista();
	}

	@Override
	public ListaDTO selectListaById(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectListaById(id);
	}

	@Override
	public List<ListaDTO> selectListaByIdParametro(int id) {
		// TODO Auto-generated method stub
		return configJProcessDao.selectListaByIdParametro(id);
	}

	@Override
	public List<ListaDTO> searchLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		if(listaDTO.getValor().equals(""))
			listaDTO.setValor(null);
		else
			listaDTO.setValor(listaDTO.getValor().toUpperCase());
		
		return configJProcessDao.searchLista(listaDTO);
	}

	@Override
	public List<TipoParametroDTO> searchTipoParametro(
			TipoParametroDTO paramTipoParametroDTO) {
		// TODO Auto-generated method stub
		if(paramTipoParametroDTO.getNombre().equals(""))
			paramTipoParametroDTO.setNombre(null);
		else
			paramTipoParametroDTO.setNombre(paramTipoParametroDTO.getNombre().toUpperCase());
		if(paramTipoParametroDTO.getDescripcion().equals(""))
			paramTipoParametroDTO.setDescripcion(null);
		else
			paramTipoParametroDTO.setDescripcion(paramTipoParametroDTO.getDescripcion().toUpperCase());
		
		return configJProcessDao.searchTipoParametro(paramTipoParametroDTO);
	}

	@Override
	public List<ParametroDTO> searchParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		if(parametro.getNombre().equals(""))
			parametro.setNombre(null);
		else
			parametro.setNombre(parametro.getNombre().toUpperCase());
		if(parametro.getDescripcion().equals(""))
			parametro.setDescripcion(null);
		else
			parametro.setDescripcion(parametro.getDescripcion().toUpperCase());
		
		return configJProcessDao.searchParametro(parametro);
	}

	@Override
	public List<EstructuraDTO> searchEstructura(EstructuraDTO estructuraDTO) {
		// TODO Auto-generated method stub
		if(estructuraDTO.getNombre().equals(""))
			estructuraDTO.setNombre(null);
		else
			estructuraDTO.setNombre(estructuraDTO.getNombre().toUpperCase());
		if(estructuraDTO.getRequerido().equals("-1"))
			estructuraDTO.setRequerido(null);
		if(estructuraDTO.getModeloOrganizacion().equals("-1"))
			estructuraDTO.setModeloOrganizacion(null);
		return configJProcessDao.searchEstructura(estructuraDTO);
	}
}
