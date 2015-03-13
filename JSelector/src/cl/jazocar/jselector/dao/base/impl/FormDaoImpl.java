package cl.jazocar.jselector.dao.base.impl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import cl.jazocar.jselector.common.context.JProcessContextImpl;
import cl.jazocar.jselector.constants.IConstants;
import cl.jazocar.jselector.dao.base.FormDaoInterface;
import cl.jazocar.jselector.front.form.dto.AntecedentesPropiedadDTO;
import cl.jazocar.jselector.front.form.dto.AvalDTO;
import cl.jazocar.jselector.front.form.dto.BodegaDTO;
import cl.jazocar.jselector.front.form.dto.EstacionamientoDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckAdjuntosDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaDTO;
import cl.jazocar.jselector.front.form.dto.InformeLegalDTO;
import cl.jazocar.jselector.front.form.dto.VendedorGaranteDTO;
import cl.jazocar.jselector.ibatis.dao.MyBatisCommonDao;

public class FormDaoImpl  extends MyBatisCommonDao  implements FormDaoInterface {

	@Override
	protected SqlSessionFactory getSqlSessionFactory() {
		// TODO Auto-generated method stub
		 return JProcessContextImpl.getInstance().lookup(IConstants.FORM_PERSITENCE) ;
	}

	@Override
	public Integer insertInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", informeLegal.getId());
		hash.put("id_solicitud", informeLegal.getIdSolicitud());
		hash.put("tipo_cliente", informeLegal.getTipoCliente());
		hash.put("id_banco", informeLegal.getIdBanco());
		hash.put("sucursal", informeLegal.getSucursal());
		hash.put("telefono", informeLegal.getTelefono());
		hash.put("ejecutivo", informeLegal.getEjecutivo());
		hash.put("email", informeLegal.getEmail());
		hash.put("fecha", informeLegal.getFecha());
		hash.put("aut_cargo_cta_cte", informeLegal.getAutCargoCtaCte());
		hash.put("sucursal_provision", informeLegal.getSucursalProvision());
		hash.put("fondos_cta_n", informeLegal.getFondosCtaN());
		hash.put("monto", informeLegal.getMonto());
		hash.put("rut", informeLegal.getRut());
		hash.put("numero_cliente", informeLegal.getNumeroCliente());
		hash.put("nombre", informeLegal.getNombre());
		hash.put("apellido_paterno", informeLegal.getApellidoPaterno());
		hash.put("apellido_materno", informeLegal.getApellidoMaterno());
		hash.put("estado_civil", informeLegal.getEstadoCivil());
		hash.put("telefono_cliente", informeLegal.getTelefonoCliente());
		hash.put("email_cliente", informeLegal.getEmailCliente());
		hash.put("razon_social", informeLegal.getRazonSocial());		
		return genericInsert("mybatis.form.InsertInformeLegal", hash);
	}

	@Override
	public Integer updateInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InformeLegalDTO> selectInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.form.SelectInformeLegal");
	}

	@Override
	public List<InformeLegalDTO> searchInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InformeLegalDTO selectInformeLegalById(int idInformeLegal) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.form.SelectInformeLegalById", idInformeLegal);
	}

	@Override
	public Integer selectNextIdInformeLegal() {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.form.SelectNextIdInformeLegal");
	}

	@Override
	public Integer selectNextIdHipoteca() {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.form.SelectNextIdHipoteca");
	}

	@Override
	public Integer insertHipoteca(HipotecaDTO hipoteca) {
		// TODO Auto-generated method stub
		// #{id_informe_legal}, #{datos_operacion}, #{titulos_estudiados}
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", hipoteca.getId());
		hash.put("id_informe_legal", hipoteca.getIdInformeLegal());
		hash.put("datos_operacion", hipoteca.getDatosOperacion());
		hash.put("titulos_estudiados", hipoteca.getTitulosEstudiados());
		return genericInsert("mybatis.form.InsertHipoteca", hash);
	}

	@Override
	public Integer updateHipoteca(HipotecaDTO hipoteca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteHipoteca(HipotecaDTO hipoteca) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HipotecaDTO selectHipotecaByInformeLegal(int idInformeLegal) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.form.SelectHipotecaByInformeLegal", idInformeLegal);
	}

	@Override
	public Integer insertAval(AvalDTO aval) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id_hipoteca", aval.getIdHipoteca());
		hash.put("nombre", aval.getNombre());
		hash.put("rut", aval.getRut());
		return genericInsert("mybatis.form.InsertAval", hash);
	}

	@Override
	public Integer updateAval(AvalDTO aval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteAval(AvalDTO aval) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AvalDTO> selectAvalByHipoteca(int idHipoteca) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.form.SelectAvalByHipoteca", idHipoteca);
	}

	@Override
	public Integer insertVendedorGarante(VendedorGaranteDTO vendedorGarante) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id_hipoteca", vendedorGarante.getIdHipoteca());
		hash.put("nombre", vendedorGarante.getNombre());
		hash.put("rut", vendedorGarante.getRut());
		return genericInsert("mybatis.form.InsertVendedorGarante", hash);
	}

	@Override
	public Integer updateVendedorGarante(VendedorGaranteDTO vendedorGarante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteVendedorGarante(VendedorGaranteDTO vendedorGarante) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<VendedorGaranteDTO> selectVendedorGaranteByHipoteca(int idHipoteca) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.form.SelectVendedorGaranteByHipoteca", idHipoteca);
	}

	@Override
	public Integer selectNextIdAntecedentesPropiedad() {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.form.SelectNextIdAntecedentesPropiedad");
	}

	@Override
	public Integer insertAntecedentesPropiedad(
			AntecedentesPropiedadDTO antecedentePropiedad) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id", antecedentePropiedad.getId());
		hash.put("id_hipoteca", antecedentePropiedad.getIdHipoteca());
		hash.put("av_calle", antecedentePropiedad.getAvCalle());
		hash.put("numero", antecedentePropiedad.getNumero());
		hash.put("depto_casa_numero", antecedentePropiedad.getDeptoCasaNumero());
		hash.put("id_region", antecedentePropiedad.getIdRegion());
		hash.put("id_comuna", antecedentePropiedad.getIdComuna());
		hash.put("id_ciudad", antecedentePropiedad.getIdCiudad());
		hash.put("propiedad_hipotecada", antecedentePropiedad.getPropiedadHipotecada());
		hash.put("acreedor_hipotecario", antecedentePropiedad.getAcreedorHipotecario());
		hash.put("rol_avaluo1", antecedentePropiedad.getRolAvaluo1());
		hash.put("rol_avaluo2", antecedentePropiedad.getRolAvaluo2());
		return genericInsert("mybatis.form.InsertAntecedentesPropiedad", hash);
	}

	@Override
	public Integer updateAntecedentesPropiedad(
			AntecedentesPropiedadDTO antecedentePropiedad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteAntecedentesPropiedad(
			AntecedentesPropiedadDTO antecedentePropiedad) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AntecedentesPropiedadDTO> selectAntecedentesPropiedadByHipoteca(
			int idHipoteca) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.form.SelectAntecendentesPropiedadByHipoteca", idHipoteca);
	}

	@Override
	public Integer insertBodega(BodegaDTO bodega) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id_hipoteca", bodega.getIdAntecedentesPropiedad());
		hash.put("rol_avaluo1", bodega.getRolAvaluo1());
		hash.put("rol_avaluo2", bodega.getRolAvaluo2());
		hash.put("numero", bodega.getNumero());
		return genericInsert("mybatis.form.InsertBodega", hash);
	}

	@Override
	public Integer updateBodega(BodegaDTO bodega) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteBodega(BodegaDTO bodega) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BodegaDTO> selectBodegaByAntecedentesPropiedad(
			int idAntecedentesPropiedad) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.form.SelectBodegasByAntecedentesPropiedad", idAntecedentesPropiedad);
	}

	@Override
	public Integer insertEstacionamiento(EstacionamientoDTO estacionamiento) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id_hipoteca", estacionamiento.getIdAntecedentesPropiedad());
		hash.put("rol_avaluo1", estacionamiento.getRolAvaluo1());
		hash.put("rol_avaluo2", estacionamiento.getRolAvaluo2());
		hash.put("numero", estacionamiento.getNumero());
		return genericInsert("mybatis.form.InsertEstacionamiento", hash);
	}

	@Override
	public Integer updateEstacionamiento(EstacionamientoDTO estacionamiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteEstacionamiento(EstacionamientoDTO estacionamiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EstacionamientoDTO> selectEstacionamientoByAntecedentesPropiedad(
			int idAntecedentesPropiedad) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.form.SelectEstacionamientosByAntecedentesPropiedad", idAntecedentesPropiedad);
	}

	@Override
	public Integer insertDocAdjuntosHipoteca(HipotecaCheckDTO hipotecaCheck) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id_hipoteca", hipotecaCheck.getIdHipoteca());		
		hash.put("1", hipotecaCheck.getTasacion());
		hash.put("2", hipotecaCheck.getInsDomVig());
		hash.put("3", hipotecaCheck.getCertMatSol());
		hash.put("4", hipotecaCheck.getCertHipGrav());
		hash.put("5", hipotecaCheck.getPersEscPoder());
		hash.put("6", hipotecaCheck.getCertAfecUtil());
		hash.put("7", hipotecaCheck.getInfExpServiu());
		hash.put("8", hipotecaCheck.getEscPropCli());
		hash.put("9", hipotecaCheck.getOtrosDoc());
		return genericInsert("mybatis.form.InsertCheckHipoteca", hash);
	}

	@Override
	public Integer updateDocAdjuntosHipoteca(HipotecaCheckDTO hipotecaCheck) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteDocAdjuntosHipoteca(HipotecaCheckDTO hipotecaCheck) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HipotecaCheckDTO selectDocAdjuntosHipotecaByHipoteca(
			int idHipoteca) {
		// TODO Auto-generated method stub
		return genericSelectOne("mybatis.form.SelectDocAdjuntosHipotecaByHipoteca", idHipoteca);
	}

	@Override
	public Integer insertDocAdjuntosHipotecaFile(
			HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos) {
		// TODO Auto-generated method stub
		HashMap<String, Object> hash = new HashMap<String, Object>();
		hash.put("id_hipoteca", hipotecaCheckAdjuntos.getIdHipoteca());
		hash.put("nombre", hipotecaCheckAdjuntos.getNombre());
		hash.put("ruta", hipotecaCheckAdjuntos.getRuta());
		return genericInsert("mybatis.form.InsertChkHipotecaAdjuntos", hash);
	}

	@Override
	public Integer updateDocAdjuntosHipotecaFile(
			HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer deleteDocAdjuntosHipotecaFile(
			HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HipotecaCheckAdjuntosDTO> selectDocAdjuntosHipotecaFileByHipoteca(
			int idHipoteca) {
		// TODO Auto-generated method stub
		return genericSelect("mybatis.form.SelectChkHipotecaAdjuntosByHipoteca", idHipoteca);
	}

}
