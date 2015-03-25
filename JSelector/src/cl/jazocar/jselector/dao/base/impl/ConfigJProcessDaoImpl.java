package cl.jazocar.jselector.dao.base.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSessionFactory;

import cl.jazocar.jselector.common.context.JProcessContextImpl;
import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dao.base.IConfigJProcessDao;
import cl.jazocar.jselector.dto.AFPDTO;
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
import cl.jazocar.jselector.exception.JProcessPersistenceException;
import cl.jazocar.jselector.ibatis.dao.MyBatisCommonDao;
import cl.jazocar.jselector.model.ConfigModel;
import cl.jazocar.jselector.sys.dto.MenuDTO;
import cl.jazocar.jselector.sys.dto.PanelDTO;
import cl.jazocar.jselector.sys.dto.RolDTO;
import cl.jazocar.jselector.sys.dto.RolProcesoDTO;
import cl.jazocar.jselector.sys.dto.SubmenuDTO;

public class ConfigJProcessDaoImpl extends MyBatisCommonDao implements IConfigJProcessDao {

	@Override
	protected SqlSessionFactory getSqlSessionFactory()
	{
	   return JProcessContextImpl.getInstance().lookup(IConstants.JPROCESS_PERSITENCE) ;
	}

	@Override
	public ConfigModel getConfigModel(String id) throws JProcessPersistenceException 
	{
		return genericSelectOne("mybatis.mtogen.SelectOneConfigModel", id);
	}

	@Override
	public List<ConfigModel> getConfigModelList() throws JProcessPersistenceException 
	{
		return genericSelect("mybatis.mtogen.SelectListConfigModel");
	}

	
	@Override
	public Integer insertUserProfileModel(String rut, int idProfile)
			throws JProcessPersistenceException {
		Map<String,String> map = new HashMap<String, String>();
		map.put("rut", rut );
		map.put("profile", Integer.toString(idProfile));
		return genericInsert("mybatis.mtogen.InsertUserProfile", map);
	}

	@Override
	public Integer updateUserProfileModel(String rut, int newProfile, int oldProfile)
			throws JProcessPersistenceException 
	{
		Map<String,String> map = new HashMap<String, String>();
		map.put("rut", rut );
		map.put("newProfile", Integer.toString(newProfile));
		map.put("oldProfile", Integer.toString(oldProfile));
		return genericUpdate( "mybatis.mtogen.UpdateUserProfile", map );
	}

	@Override
	public Integer deleteUserProfileModel(String rut, int profile)
			throws JProcessPersistenceException {
		Map<String,String> map = new HashMap<String, String>();
		map.put("rut", rut );
		map.put("profile", Integer.toString(profile));
		return genericDelete("mybatis.mtogen.DeleteUserProfile", map);
	}

	

	@Override
	public Integer insertMenu(String idMenu, String label) {
		// TODO Auto-generated method stub
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("id_menu", idMenu);
		hash.put("label", label);
		return genericInsert("mybatis.jselector.InsertjselectorInsertarMenu", hash);
	}

	@Override
	public Integer updateMenu(int id, String idMenu, String label, int order) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", id);
		hash.put("id_menu", idMenu);
		hash.put("label", label);
		hash.put("order", order);
		return genericUpdate("mybatis.jselector.UpdatejselectorModificarMenu", hash);
	}

	@Override
	public Integer deleteMenu(int id) {
		// TODO Auto-generated method stub
		return genericUpdate("mybatis.jselector.UpdateSystemJProcessDaBajaMenu", id);
	}

	@Override
	public List<MenuDTO> selectMenu() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessMenu");
	}

	@Override
	public Integer insertSubmenu(String submenuId, String etiqueta,
			String stackName, int idMenu) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("name_id", submenuId);
		hash.put("etiqueta", etiqueta);
		hash.put("stack_name", stackName);
		hash.put("menu_id", idMenu);
		return genericInsert("mybatis.jselector.InsertSystemJProcessSubmenu", hash);
	}

	@Override
	public Integer updateSubmenu(int id, String submenuId, String etiqueta,
			String stackName, int idMenu, int order) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", id);
		hash.put("submenu_id", submenuId);
		hash.put("etiqueta", etiqueta);
		hash.put("stack_name", stackName);
		hash.put("menu_id", idMenu);
		hash.put("order", order);
		return genericUpdate("mybatis.jselector.UpdateSystemJProcessModificarSubmenu", hash);
	}

	@Override
	public Integer deleteSubmenu(int id) {
		// TODO Auto-generated method stub
		return genericUpdate("mybatis.jselector.UpdateSystemJProcessDaBajaSubMenu", id);
	}

	@Override
	public List<SubmenuDTO> selectAllSubmenu() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessAllSubmenu");
	}

	@Override
	public List<SubmenuDTO> selectSubmenuByMenu(int idMenu) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessSubmenu", idMenu);
	}

	@Override
	public Integer insertPanel(PanelDTO panel) {
		// TODO Auto-generated method stub
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("panel_id", panel.getIdPanel());
		hash.put("subview_id", panel.getIdSubview());
		hash.put("include", panel.getInclude());
		hash.put("es_formulario", panel.getEsFormulario());
		return genericInsert("mybatis.jselector.InsertSystemJProcessPanel", hash);
	}

	@Override
	public Integer updatePanel(PanelDTO panel) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", panel.getId());
		hash.put("panel_id", panel.getIdPanel());
		hash.put("subview_id", panel.getIdSubview());
		hash.put("include", panel.getInclude());
		hash.put("es_formulario", panel.getEsFormulario());
		return genericUpdate("mybatis.jselector.UpdateSystemJProcessPanel", hash);
	}

	@Override
	public Integer deletePanel(int id) {
		// TODO Auto-generated method stub
		return genericDelete("mybatis.jselector.DeleteSystemJProcessPanel", id);
	}

	@Override
	public List<PanelDTO> selectAllPanel() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessPanel");
	}

	@Override
	public Integer insertRol(RolDTO rol) {
		// TODO Auto-generated method stub
		HashMap<String,String> hash = new HashMap<String, String>();
		hash.put("valor", rol.getNombreRol());
		return genericInsert("mybatis.jselector.InsertSystemJProcessRol", hash);
	}

	@Override
	public Integer updateRol(RolDTO rol) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("valor", rol.getNombreRol());
		hash.put("id", rol.getId());
		return genericUpdate("mybatis.jselector.UpdateSystemJProcessRol", hash);
	}

	@Override
	public Integer deleteRol(int id) {
		// TODO Auto-generated method stub
		return genericUpdate("mybatis.jselector.DeleteSystemJProcessRol", id);
	}

	@Override
	public List<RolDTO> selectAllRol() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessRoles");
	}

	@Override
	public List<MenuDTO> obtenerMenuPerfiladoByRol(int rol) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessMenuPerfilado", rol);
	}

	@Override
	public List<MenuDTO> obtenerMenuPerfiladoByRolOposite(int rol) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessMenuPerfilado", rol);
	}

	@Override
	public List<RolDTO> selectRolByMenu(int idMenu) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSystemJProcessRolByMenu", idMenu);
	}

	@Override
	public Integer clearMenuRol(int idMenu) {
		// TODO Auto-generated method stub
		return genericDelete("mybatis.jselector.DeleteSystemJProcessMenuRol", idMenu);
	}

	@Override
	public Integer addMenuRol(int idMenu, int idRol) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id_menu", idMenu);
		hash.put("id_rol", idRol);
		return genericInsert("mybatis.jselector.InsertSystemJProcessMenuRol", hash);
	}
	

	@Override
	public Integer insertUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("usuario", usuario.getUsuario());
		hash.put("password", usuario.getPassword());
		hash.put("rol", usuario.getRol());
		hash.put("nombre", usuario.getNombre());
		hash.put("area", usuario.getArea());
		hash.put("subarea", usuario.getSubarea());
		hash.put("organizacion", usuario.getOrganizacion());
		hash.put("rol_proceso", usuario.getRolProceso());		
		hash.put("empresa", usuario.getIdEmpresa());
		return genericInsert("mybatis.jselector.InsertJProcessUsers", hash);
	}

	@Override
	public Integer updateUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", usuario.getId());
		hash.put("usuario", usuario.getUsuario());
		hash.put("nombre", usuario.getNombre());
		hash.put("rol", usuario.getRol());
		hash.put("estado", usuario.getEstado());
		hash.put("organizacion", usuario.getOrganizacion());
		hash.put("area", usuario.getArea());
		hash.put("subarea", usuario.getSubarea());		
		hash.put("rol_proceso", usuario.getRolProceso());		
		hash.put("empresa", usuario.getIdEmpresa());
		return genericUpdate("mybatis.jselector.UpdatejselectorModificarUsuario", hash);
	}

	@Override
	public Integer deleteUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id", usuario.getId());
		return genericUpdate("mybatis.jselector.UpdateDeleteUsuario", hash);
	}

	@Override
	public List<UsuarioDTO> getAllUsuarios() {
		// TODO Auto-generated method stub  
		return genericSelect("mybatis.jselector.SelectJProcessAllUsers");
	}

	@Override
	public List<UsuarioDTO> getAllUsuariosSoporte() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectJProcessAllUsersSoporte");
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
		return genericSelectOne("mybatis.jselector.SelectUsuario", idUsuario);
	}

	@Override
	public UsuarioDTO loginUsuario(String usuario, String password) {
		// TODO Auto-generated method stub
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("usuario", usuario);
		hash.put("password", password);
		return genericSelectOne("mybatis.jselector.SelectJProcessLoginUsuario", hash);
	}

	@Override
	public Integer updatePasswordUsuario(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertTarea(TareaDTO tarea) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("nombre", tarea.getNombre());
		hash.put("descripcion", tarea.getDescripcion());
		hash.put("prioridad", tarea.getPrioridad());
		hash.put("tipo_tarea", tarea.getTipoTarea());
		hash.put("organizacion", tarea.getIdOrganizacion());
		hash.put("tipo_duracion", tarea.getTipoDuracion());
		hash.put("duracion", tarea.getDuracion());
		hash.put("tipo_asignacion", tarea.getTipoAsignacion());
		hash.put("rol", tarea.getIdRolAsignacion());
		hash.put("tiene_formulario", tarea.getTieneFormulario());
		return genericInsert("mybatis.jselector.InsertTarea", hash);
	}

	@Override
	public Integer updateTarea(TareaDTO tarea) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", tarea.getId());
		hash.put("nombre", tarea.getNombre());
		hash.put("descripcion", tarea.getDescripcion());
		hash.put("prioridad", tarea.getPrioridad());
		hash.put("tipo_tarea", tarea.getTipoTarea());
		hash.put("organizacion", tarea.getIdOrganizacion());
		hash.put("tipo_duracion", tarea.getTipoDuracion());
		hash.put("duracion", tarea.getDuracion());
		hash.put("tipo_asignacion", tarea.getTipoAsignacion());
		hash.put("rol", tarea.getIdRolAsignacion());
		hash.put("tiene_formulario", tarea.getTieneFormulario());
		return genericInsert("mybatis.jselector.UpdateTarea", hash);
	}

	@Override
	public Integer deleteTarea(TareaDTO tarea) {
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id", tarea.getId());
		return genericInsert("mybatis.jselector.DeleteTarea", hash);
	}

	@Override
	public List<TareaDTO> selectAllTarea() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectTareas");
	}

	@Override
	public TareaDTO selectTareaById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectTareaById", id);
	}

	@Override
	public OrganizacionDTO getOrganizacionById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectOrganizacionById", id);
	}

	@Override
	public Integer insertOrganizacion(OrganizacionDTO organizacion) {
		// TODO Auto-generated method stub
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("valor", organizacion.getNombre());
		return genericInsert("mybatis.jselector.InsertOrganizacion", hash);
	}

	@Override
	public Integer updateOrganizacion(OrganizacionDTO organizacion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", organizacion.getId());
		hash.put("valor", organizacion.getNombre());
		return genericUpdate("mybatis.jselector.UpdateOrganizacion", hash);
	}

	@Override
	public Integer deleteOrganizacion(OrganizacionDTO organizacion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", organizacion.getId());
		return genericDelete("mybatis.jselector.DeleteOrganizacion", hash);
	}

	@Override
	public List<OrganizacionDTO> selectAllOrganizacion() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectOrganizacion");
	}

	@Override
	public RolDTO selectRolById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectRolById", id);
	}

	@Override
	public Integer insertAplicacion(AplicacionDTO aplicacion) {
		// TODO Auto-generated method stub
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("aplicacion", aplicacion.getAplicacion());
		hash.put("descripcion", aplicacion.getDescripcion());
		hash.put("version", aplicacion.getVersion());
		return genericInsert("mybatis.jselector.InsertAplicacion", hash);
	}

	@Override
	public Integer updateAplicacion(AplicacionDTO aplicacion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("aplicacion", aplicacion.getAplicacion());
		hash.put("descripcion", aplicacion.getDescripcion());
		hash.put("version", aplicacion.getVersion());
		hash.put("id", aplicacion.getId());
		return genericUpdate("mybatis.jselector.UpdateAplicacion", hash);
	}

	@Override
	public Integer deleteAplicacion(AplicacionDTO aplicacion) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id", aplicacion.getId());
		return genericDelete("mybatis.jselector.DeleteAplicacion", hash);
	}

	@Override
	public List<AplicacionDTO> selectAllAplicacion() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectAplicacion");
	}

	@Override
	public AplicacionDTO selectAplicacionById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectAplicacionById", id);
	}

	@Override
	public Integer insertCreacion(CreacionDTO creacion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", creacion.getId());
		hash.put("aplicacion", creacion.getIdAplicacion());
		hash.put("inicio", creacion.getIdTareaInicio());
		hash.put("exito", creacion.getIdTareaExito());
		hash.put("condicional", creacion.getEsCondicional());
		hash.put("rechazo", creacion.getIdTareaRechazo());
		hash.put("tipo_destino", creacion.getTipoDestino());
		return genericInsert("mybatis.jselector.InsertCreacion", hash);
	}

	@Override
	public Integer updateCreacion(CreacionDTO creacion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", creacion.getId());
		hash.put("aplicacion", creacion.getIdAplicacion());
		hash.put("inicio", creacion.getIdTareaInicio());
		hash.put("exito", creacion.getIdTareaExito());
		hash.put("condicional", creacion.getEsCondicional());
		hash.put("rechazo", creacion.getIdTareaRechazo());
		hash.put("tipo_destino", creacion.getTipoDestino());		
		return genericUpdate("mybatis.jselector.UpdateCreacion", hash);
	}

	@Override
	public Integer deleteCreacion(CreacionDTO creacion) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id", creacion.getId());
		return genericDelete("mybatis.jselector.UpdateCreacion", hash);
	}

	@Override
	public List<CreacionDTO> selectAllCreacion() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectCreacion");
	}

	@Override
	public List<CreacionDTO> selectCreacionByIdAplicacion(int idAplicacion) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectCreacionByAplicacion", idAplicacion);
	}

	@Override
	public CreacionDTO selectCreacionById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectCreacionById", id);
	}

	@Override
	public Integer updateInicioFinAplicacion(int id) {
		// TODO Auto-generated method stub
		return genericUpdate("mybatis.jselector.UpdateAplicacionInicioFin", id);
	}

	@Override
	public Integer insertSolicitud(SolicitudDTO solicitud) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", solicitud.getId());
		hash.put("aplicacion", solicitud.getIdAplicacion());
		hash.put("empresa", solicitud.getIdEmpresa());
		return genericInsert("mybatis.jselector.InsertSolicitud", hash);
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
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id_rol", idRol);
		hash.put("id_organizacion", idOrganizacion);
		hash.put("id_empresa", idEmpresa);
		return genericSelect("mybatis.jselector.SelectSolicitudesPendientesPorRol", hash);
	}

	@Override
	public SolicitudDTO selectSolicitudById(int idSolicitud) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectSolicitudById", idSolicitud);
	}

	@Override
	public Integer insertPendiente(PendienteDTO pendiente) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("solicitud", pendiente.getIdSolicitud());
		hash.put("tarea", pendiente.getIdTarea());
		hash.put("rol", pendiente.getIdRol());
		return genericInsert("mybatis.jselector.InsertPendiente", hash);
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
		return genericSelectOne("mybatis.jselector.SelectPendienteById");
	}

	@Override
	public int selectNewSolicitudId() {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectNewSolicitudId");
	}

	@Override
	public TareaDTO selectTareaActualBySolicitudId(int idSolicitud) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectTareaActualBySolicitudId", idSolicitud);
	}

	@Override
	public Integer insertSolicitudComentario(int solicitudId, String usuario,
			String comentario) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("solicitud", solicitudId);
		hash.put("usuario", usuario);
		hash.put("comentario", comentario);
		return genericInsert("mybatis.jselector.InsertSolicitudComentario", hash);
	}

	@Override
	public List<CasoComentarioDTO> selectComentariosBySolicitud(int idSolicitud) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectComentariosBySolicitud", idSolicitud);
	}

	@Override
	public CreacionDTO selectCreacionByTareaInicial(int idTarea, int idAplicacion) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("tarea", idTarea);
		hash.put("aplicacion", idAplicacion);
		return genericSelectOne("mybatis.jselector.SelectCreacionByTarea", hash);
	}

	@Override
	public Integer cerrarCreacion(int idPendiente) {
		// TODO Auto-generated method stub
		return genericUpdate("mybatis.jselector.UpdateCerrarCreacion", idPendiente);
	}

	@Override
	public Integer despacharCreacion(int idTarea, int idSolicitud, int idRol) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new  HashMap<String, Integer>();
		hash.put("tarea", idTarea);
		hash.put("solicitud", idSolicitud);
		hash.put("rol", idRol);
		return genericInsert("mybatis.jselector.InsertDespacharCreacion", hash);
	}

	@Override
	public Integer cerrarSolicitud(int idSolicitud) {
		// TODO Auto-generated method stub
		return genericUpdate("mybatis.jselector.UpdateCerrarSolicitud", idSolicitud);
	}

	@Override
	public PendienteDTO selectPendientesBySolicitud(int id) {
		// TODO Auto-generated method stub
	   return genericSelectOne("mybatis.jselector.SelectPendienteBySolicitud", id);
	}

	@Override
	public Integer asignarResponsable(int idUsuario, int idSolicitud) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("usuario", idUsuario);
		hash.put("solicitud", idSolicitud);
		return genericUpdate("mybatis.jselector.UpdateAsignarResponsableSolicitud", hash);
	}

	@Override
	public Integer liberarResponsable(int idUsuario, int idSolicitud) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("usuario", idUsuario);
		hash.put("solicitud", idSolicitud);
		return genericUpdate("mybatis.jselector.UpdateLiberarResponsableSolicitud", hash);
	}

	@Override
	public Integer insertTareaConfiguracion(TareaConfiguracionDTO configuracion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("tarea", configuracion.getIdTarea());
		hash.put("option", configuracion.getCheckOption());
		hash.put("requerido", configuracion.isRequerido());
		return genericInsert("mybatis.jselector.InsertTareaConfiguracion", hash);
	}

	@Override
	public Integer updateTareaConfiguracion(TareaConfiguracionDTO configuracion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", configuracion.getId());		
		hash.put("tarea", configuracion.getIdTarea());
		hash.put("option", configuracion.getCheckOption());
		hash.put("requerido", configuracion.isRequerido());
		return genericUpdate("mybatis.jselector.UpdateTareaConfiguracion", hash);
	}

	@Override
	public Integer deleteTareaConfiguracion(TareaConfiguracionDTO configuracion) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", configuracion.getId());
		return genericInsert("mybatis.jselector.DeleteTareaConfiguracion", hash);
	}

	@Override
	public List<TareaConfiguracionDTO> selectTareaConfiguracion() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectTareaConfiguracion");
	}

	@Override
	public List<TareaConfiguracionDTO> selectTareaConfiguracionByTarea(
			int idTarea) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectTareaConfiguracionByTarea", idTarea);
	}

	@Override
	public TareaConfiguracionDTO selectTareaConfiguracionById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectTareaConfiguracionById", id);
	}

	@Override
	public Integer insertArea(AreaDTO area) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("organizacion", area.getIdOrganizacion());
     	hash.put("nombre", area.getNombre());
		hash.put("descripcion", area.getDescripcion());
		return genericInsert("mybatis.jselector.InsertArea", hash);
	}

	@Override
	public Integer updateArea(AreaDTO area) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", area.getId());
		hash.put("organizacion", area.getIdOrganizacion());
     	hash.put("nombre", area.getNombre());
		hash.put("descripcion", area.getDescripcion());
		return genericUpdate("mybatis.jselector.UpdateArea", hash);
	}

	@Override
	public Integer deleteArea(AreaDTO area) {
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", area.getId());
		return genericUpdate("mybatis.jselector.DeleteArea", hash);
	}

	@Override
	public List<AreaDTO> selectAreas() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectAreas");
	}

	@Override
	public List<AreaDTO> selectAreasByOrganizacion(int idOrganizacion) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectAreasByOrganizacion", idOrganizacion);
	}

	@Override
	public AreaDTO selectAreaById(int idArea) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectAreaById", idArea);
	}

	@Override
	public Integer insertSubarea(SubareaDTO subarea) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("area", subarea.getIdArea());
		hash.put("nombre", subarea.getNombre());
		hash.put("descripcion", subarea.getDescripcion());
		return genericInsert("mybatis.jselector.InsertSubarea", hash);
	}

	@Override
	public Integer updateSubarea(SubareaDTO subarea) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", subarea.getId());
		hash.put("area", subarea.getIdArea());
		hash.put("nombre", subarea.getNombre());
		hash.put("descripcion", subarea.getDescripcion());
		return genericUpdate("mybatis.jselector.UpdateSubarea", hash);
	}

	@Override
	public Integer deleteSubarea(SubareaDTO subarea) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", subarea.getId());
		return genericDelete("mybatis.jselector.DeleteSubarea", hash);
	}

	@Override
	public List<SubareaDTO> selectSubareas() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSubareas");
	}

	@Override
	public List<SubareaDTO> selectSubareasByArea(int idArea) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectSubareaByArea", idArea);
	}

	@Override
	public SubareaDTO selectSubareaById(int idSubarea) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectSubareaById", idSubarea);
	}

	@Override
	public List<PanelDTO> selectAllPanelFormulario() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectPanelFormulario");
	}

	@Override
	public PanelDTO selectAllPanelFormularioByTarea(int idTarea, int idAplicacion, int idInstancia) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("tarea", idTarea);
		hash.put("aplicacion", idAplicacion);
		hash.put("instancia", idInstancia);
		return genericSelectOne("mybatis.jselector.SelectPanelFormularioByTarea", hash);
	}

	@Override
	public Integer insertSolicitudFormulario(
			SolicitudFormularioDTO solicitudFormulario) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id_solicitud",  solicitudFormulario.getIdSolicitud());
		map.put("id_tarea",  solicitudFormulario.getIdTarea());
		map.put("id_panel",  solicitudFormulario.getIdPanel());		
		return genericInsert("mybatis.jselector.InsertSolicitudFormulario", map);
	}

	@Override
	public SolicitudFormularioDTO selectSolicitudFormulario(int idSolicitud,
			int idTarea) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id_solicitud", idSolicitud);
		hash.put("id_tarea", idTarea);
		return genericSelectOne("mybatis.jselector.SelectSolicitudFormulario", hash);
	}

	@Override
	public Integer updateSolicitudFormulario(
			SolicitudFormularioDTO solicitudFormulario) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id_solicitud", solicitudFormulario.getIdSolicitud());
		hash.put("id_tarea", solicitudFormulario.getIdTarea());
		
		return genericUpdate("mybatis.jselector.UpdateSolicitudFormulario", hash);
	}

	@Override
	public void insertPersona(String rut, String nombre) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer insertEmpresa(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("nombre", empresa.getNombre());
		hash.put("descripcion", empresa.getDescripcion());
		hash.put("organizacion", empresa.getIdOrganizacion());
		return genericInsert("mybatis.jselector.InsertEmpresa", hash);
	}

	@Override
	public Integer updateEmpresa(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteEmpresa(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpresaDTO> selectEmpresas() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectEmpresas");
	}

	@Override
	public EmpresaDTO selectEmpresaById(int idEmpresa) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectEmpresaById", idEmpresa);
	}

	@Override
	public List<EmpresaDTO> searchEmpresas(EmpresaDTO empresa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpresaDTO> selectEmpresasByOrganizacion(int idOrganizacion) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectEmpresasByOrganizacion", idOrganizacion);
	}

	@Override
	public Integer insertRegion(RegionDTO region) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("nombre", region.getNombre());
		hash.put("descripcion", region.getDescripcion());
		return genericInsert("mybatis.jselector.InsertRegion", hash);
	}

	@Override
	public Integer updateRegion(RegionDTO region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteRegion(RegionDTO region) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RegionDTO> selectRegiones() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectRegiones");
	}

	@Override
	public RegionDTO selectRegionById(int idRegion) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectRegionById", idRegion);
	}

	@Override
	public Integer insertCiudad(CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("nombre", ciudad.getNombre());
		hash.put("descripcion", ciudad.getDescripcion());
		hash.put("region", ciudad.getIdRegion());
		return genericInsert("mybatis.jselector.InsertCiudad", hash);
	}

	@Override
	public Integer updateCiudad(CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteCiudad(CiudadDTO ciudad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CiudadDTO> selectCiudades() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectCiudades");
	}

	@Override
	public List<CiudadDTO> selectCiudadesByRegion(int idRegion) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectCiudadesByRegion", idRegion);
	}

	@Override
	public CiudadDTO selectCiudadById(int idCiudad) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectCiudadById", idCiudad);
	}

	@Override
	public Integer insertComuna(ComunaDTO comuna) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("nombre", comuna.getNombre());
		hash.put("descripcion", comuna.getDescripcion());
		hash.put("provincia", comuna.getIdProvincia());
		return genericInsert("mybatis.jselector.InsertComuna", hash);
	}

	@Override
	public Integer updateComuna(ComunaDTO comuna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteComuna(ComunaDTO comuna) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ComunaDTO> selectComunas() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectComunas");
	}

	@Override
	public List<ComunaDTO> selectComunasByProvincia(int idProvincia) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectComunasByProvincia", idProvincia);
	}

	@Override
	public ComunaDTO selectComunaById(int idComuna) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectComunaById", idComuna);
	}

	@Override
	public Integer insertRolProceso(RolProcesoDTO rol) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("nombre", rol.getNombre());
		hash.put("descripcion", rol.getDescripcion());
		return genericInsert("mybatis.jselector.InsertRolProceso", hash);
	}

	@Override
	public Integer updateRolProceso(RolProcesoDTO rol) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteRolProceso(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RolProcesoDTO> selectAllRolProcesos() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectRolProcesos");
	}

	@Override
	public RolProcesoDTO selectRolProcesoById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectRolProcesoById", id);
	}

	@Override
	public List<SolicitudDTO> selectSolicitudesByUser(UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("empresa", usuario.getIdEmpresa());
		hash.put("organizacion", usuario.getOrganizacion());
		return genericSelect("mybatis.jselector.SelectSolicitudesByUser", hash);
	}

	@Override
	public List<SolicitudDTO> searchSolicitudesByFields(SolicitudDTO solicitud, UsuarioDTO usuario) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("aplicacion", solicitud.getIdAplicacion());
		hash.put("estado", solicitud.getEstado());
		hash.put("inicio", solicitud.getFechaInicio());
		hash.put("fin", solicitud.getFechaFin());
		hash.put("empresa", usuario.getIdEmpresa());
		hash.put("organizacion", usuario.getOrganizacion());
		return genericSelect("mybatis.jselector.SearchSolicitudesByFields", hash);
	}

	@Override
	public Integer insertInstancia(InstanciaDTO instancia) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id",               instancia.getId());
		hash.put("id_aplicacion",    instancia.getIdAplicacion());
		hash.put("id_empresa", 	     instancia.getIdEmpresa());
		hash.put("id_organizacion",  instancia.getIdOrganizacion());
		hash.put("id_tarea_inicial", instancia.getIdTareaInicial());
		hash.put("id_tarea_final",   instancia.getIdTareaFinal());
		hash.put("nombre_instancia", instancia.getNombreInstancia());
		return genericInsert("mybatis.jselector.InsertInstancia", hash);
	}

	@Override
	public Integer updateInstancia(InstanciaDTO instancia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteInstancia(InstanciaDTO instancia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InstanciaDTO> selectInstancia() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectInstancia");
	}

	@Override
	public List<InstanciaDTO> selectInstanciaByAplicacion(int idAplicacion) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectInstanciaByFlujo", idAplicacion);
	}

	@Override
	public InstanciaDTO selectInstanciaById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectInstanciaById", id);
	}

	@Override
	public InstanciaDTO selectInstanciaByEmpresaAplicacion(int idEmpresa, int idAplicacion) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> hash = new HashMap<String, Integer>();
		hash.put("id_empresa", idEmpresa);
		hash.put("id_aplicacion", idAplicacion);
		return genericSelectOne("mybatis.jselector.SelectInstanciaByEmpresaAplicacion", hash);
	}

	@Override
	public MenuDTO selectMenuById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectMenuById", id);
	}

	@Override
	public AplicacionDTO selectAplicacionBusquedaById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectAplicacionBusquedaById", id);
	}

	@Override
	public Integer selectNextIdCreacion() {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectNextIdCreacion");
	}

	@Override
	public Integer selectIdNextInstancia() {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectNextIdInstancia");
	}

	
	  public Integer insertTipoParametro(TipoParametroDTO tipoParametro)
	  {
	    HashMap<String, Object> hash = new HashMap();
	    hash.put("nombre", tipoParametro.getNombre());
	    hash.put("descripcion", tipoParametro.getDescripcion());
	    return genericInsert("mybatis.jselector.InsertTipoParametro", hash);
	  }
	  
	  public Integer updateTipoParametro(TipoParametroDTO tipoParametro)
	  {
	    HashMap<String, Object> hash = new HashMap();
	    hash.put("id", Integer.valueOf(tipoParametro.getId()));
	    hash.put("nombre", tipoParametro.getNombre());
	    hash.put("descripcion", tipoParametro.getDescripcion());
	    return genericUpdate("mybatis.jselector.UpdateTipoParametro", hash);
	  }
	  
	  public Integer deleteTipoParametro(TipoParametroDTO tipoParametro)
	  {
	    HashMap<String, Object> hash = new HashMap();
	    hash.put("id", Integer.valueOf(tipoParametro.getId()));
	    hash.put("nombre", tipoParametro.getNombre());
	    hash.put("descripcion", tipoParametro.getDescripcion());
	    return genericDelete("mybatis.jselector.DeleteTipoParametro", hash);
	  }
	  
	  public List<TipoParametroDTO> selectTipoParametro()
	  {
	    return genericSelect("mybatis.jselector.SelectTipoParametro");
	  }
	  
	  public TipoParametroDTO selectTipoParametroById(int id)
	  {
	    return (TipoParametroDTO)genericSelectOne("mybatis.jselector.SelectTipoParametroById", Integer.valueOf(id));
	  }
	  
	  public Integer insertParametro(ParametroDTO parametro)
	  {
	    HashMap<String, Object> hash = new HashMap();
	    hash.put("nombre", parametro.getNombre());
	    hash.put("descripcion", parametro.getDescripcion());
	    hash.put("tipo_parametro", Integer.valueOf(parametro.getIdTipoGrupo()));
	    return genericInsert("mybatis.jselector.InsertParametro", hash);
	  }
	  
	  public Integer updateParametro(ParametroDTO parametro)
	  {
	    HashMap<String, Object> hash = new HashMap();
	    hash.put("id", Integer.valueOf(parametro.getId()));
	    hash.put("nombre", parametro.getNombre());
	    hash.put("descripcion", parametro.getDescripcion());
	    hash.put("tipo_parametro", Integer.valueOf(parametro.getIdTipoGrupo()));
	    return genericUpdate("mybatis.jselector.UpdateParametro", hash);
	  }
	  
	  public Integer deleteParametro(ParametroDTO parametro)
	  {
	    HashMap<String, Object> hash = new HashMap();
	    hash.put("id", Integer.valueOf(parametro.getId()));
	    hash.put("nombre", parametro.getNombre());
	    hash.put("descripcion", parametro.getDescripcion());
	    hash.put("tipo_parametro", Integer.valueOf(parametro.getIdTipoGrupo()));
	    return genericDelete("mybatis.jselector.DeleteParametro", hash);
	  }
	  
	  public List<ParametroDTO> selectParametro()
	  {
	    return genericSelect("mybatis.jselector.SelectParametro");
	  }
	  
	  public ParametroDTO selectParametroById(int id)
	  {
	    return (ParametroDTO)genericSelectOne("mybatis.jselector.SelectParametroById", Integer.valueOf(id));
	  }
	  
	  public List<ParametroDTO> selectParametroByTipoParametro(int idTipoParametro)
	  {
	    return genericSelect("mybatis.jselector.SelectParametroByTipoParametro", Integer.valueOf(idTipoParametro));
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
		return genericSelect("mybatis.jselector.SelectEstructura");
	}

	@Override
	public EstructuraDTO selectEstructuraById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer insertLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("valor", listaDTO.getValor());
		hash.put("parametro", listaDTO.getIdParametro());
		hash.put("codigo", listaDTO.getCodigoAdicional());
		return genericInsert("mybatis.jselector.InsertLista", hash);
	}

	@Override
	public Integer updateLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", listaDTO.getId());
		hash.put("valor", listaDTO.getValor());
		hash.put("parametro", listaDTO.getIdParametro());
		hash.put("codigo", listaDTO.getCodigoAdicional());
		return genericUpdate("mybatis.jselector.UpdateLista", hash);
	}

	@Override
	public Integer deleteLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", listaDTO.getId());
		hash.put("valor", listaDTO.getValor());
		hash.put("parametro", listaDTO.getIdParametro());
		hash.put("codigo", listaDTO.getCodigoAdicional());
		return genericDelete("mybatis.jselector.DeleteLista", hash);
	}

	@Override
	public List<ListaDTO> selectLista() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectLista");
	}

	@Override
	public ListaDTO selectListaById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectListaById", id);
	}

	@Override
	public List<ListaDTO> selectListaByIdParametro(int id) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectListaByIdParametro", id);
	}

	@Override
	public List<ListaDTO> searchLista(ListaDTO listaDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("valor", listaDTO.getValor());
		hash.put("parametro", listaDTO.getIdParametro());
		hash.put("codigo", listaDTO.getCodigoAdicional());
		return genericSelect("mybatis.jselector.SearchLista", hash);
	}

	@Override
	public List<TipoParametroDTO> searchTipoParametro(
			TipoParametroDTO paramTipoParametroDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
	    hash.put("nombre", paramTipoParametroDTO.getNombre());
	    hash.put("descripcion", paramTipoParametroDTO.getDescripcion());
	    return genericSelect("mybatis.jselector.SearchTipoParametro", hash);
	}

	@Override
	public List<ParametroDTO> searchParametro(ParametroDTO parametro) {
		// TODO Auto-generated method stub
		 HashMap<String, Object> hash = new HashMap<String, Object>();
	    hash.put("nombre", parametro.getNombre());
	    hash.put("descripcion", parametro.getDescripcion());
	    hash.put("tipo_parametro", Integer.valueOf(parametro.getIdTipoGrupo()));
	    return genericSelect("mybatis.jselector.SearchParametro", hash);
	}

	@Override
	public List<EstructuraDTO> searchEstructura(EstructuraDTO estructuraDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("nombre", estructuraDTO.getNombre());
		hash.put("modelo", estructuraDTO.getModeloOrganizacion());
		hash.put("lista", estructuraDTO.getIdLista());
		hash.put("clase", estructuraDTO.getIdClase());
		hash.put("requerido", estructuraDTO.getRequerido());
		return genericSelect("mybatis.jselector.SearchEstructura", hash);
	}

	@Override
	public Integer insertAFP(AFPDTO afpDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("codigo", afpDTO.getCodigo());
		hash.put("glosa", afpDTO.getGlosa());
		return genericInsert("mybatis.jselector.InsertAFP", hash);
	}

	@Override
	public Integer updateAFP(AFPDTO afpDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", afpDTO.getId());
		hash.put("codigo", afpDTO.getCodigo());
		hash.put("glosa", afpDTO.getGlosa());
		return genericUpdate("mybatis.jselector.UpdateAFP", hash);
	}

	@Override
	public Integer deleteAFP(AFPDTO afpDTO) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", afpDTO.getId());
		return genericDelete("mybatis.jselector.DeleteAFP", hash);
	}

	@Override
	public List<AFPDTO> selectAFP() {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.jselector.SelectAFP");
	}

	@Override
	public AFPDTO selectAFPById(int id) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.jselector.SelectAFPById", id);
	}

	@Override
	public List<AFPDTO> searchAFP(AFPDTO afpDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
