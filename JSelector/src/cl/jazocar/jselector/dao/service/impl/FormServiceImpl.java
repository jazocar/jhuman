package cl.jazocar.jselector.dao.service.impl;

import java.util.List;

import cl.jazocar.jselector.dao.base.FormDaoInterface;
import cl.jazocar.jselector.dao.service.FormServiceInterface;
import cl.jazocar.jselector.front.form.dto.BodegaDTO;
import cl.jazocar.jselector.front.form.dto.AntecedentesPropiedadDTO;
import cl.jazocar.jselector.front.form.dto.AvalDTO;
import cl.jazocar.jselector.front.form.dto.EstacionamientoDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckAdjuntosDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaDTO;
import cl.jazocar.jselector.front.form.dto.InformeLegalDTO;
import cl.jazocar.jselector.front.form.dto.VendedorGaranteDTO;

public class FormServiceImpl implements FormServiceInterface {

	private FormDaoInterface formDao;

	public FormDaoInterface getFormDao() {
		return formDao;
	}

	public void setFormDao(FormDaoInterface formDao) {
		this.formDao = formDao;
	}

	@Override
	public Integer insertInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return formDao.insertInformeLegal(informeLegal);
	}

	@Override
	public Integer updateInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return formDao.updateInformeLegal(informeLegal);
	}

	@Override
	public Integer deleteInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return formDao.deleteInformeLegal(informeLegal);
	}

	@Override
	public List<InformeLegalDTO> selectInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return formDao.selectInformeLegal(informeLegal);
	}

	@Override
	public List<InformeLegalDTO> searchInformeLegal(InformeLegalDTO informeLegal) {
		// TODO Auto-generated method stub
		return formDao.searchInformeLegal(informeLegal);
	}

	@Override
	public InformeLegalDTO selectInformeLegalById(int idInformeLegal) {
		// TODO Auto-generated method stub
		return formDao.selectInformeLegalById(idInformeLegal);
	}

	@Override
	public Integer selectNextIdInformeLegal() {
		// TODO Auto-generated method stub
		return formDao.selectNextIdInformeLegal();
	}

	@Override
	public Integer selectNextIdHipoteca() {
		// TODO Auto-generated method stub
		return formDao.selectNextIdHipoteca();
	}

	@Override
	public Integer insertHipoteca(HipotecaDTO hipoteca) {
		// TODO Auto-generated method stub		
		return formDao.insertHipoteca(hipoteca);
	}

	@Override
	public Integer updateHipoteca(HipotecaDTO hipoteca) {
		// TODO Auto-generated method stub
		return formDao.updateHipoteca(hipoteca);
	}

	@Override
	public Integer deleteHipoteca(HipotecaDTO hipoteca) {
		// TODO Auto-generated method stub
		return formDao.deleteHipoteca(hipoteca);
	}

	@Override
	public HipotecaDTO selectHipotecaByInformeLegal(int idInformeLegal) {
		// TODO Auto-generated method stub
		return formDao.selectHipotecaByInformeLegal(idInformeLegal);
	}

	@Override
	public Integer insertAval(AvalDTO aval) {
		// TODO Auto-generated method stub
		return formDao.insertAval(aval);
	}

	@Override
	public Integer updateAval(AvalDTO aval) {
		// TODO Auto-generated method stub
		return formDao.updateAval(aval);
	}

	@Override
	public Integer deleteAval(AvalDTO aval) {
		// TODO Auto-generated method stub
		return formDao.deleteAval(aval);
	}

	@Override
	public List<AvalDTO> selectAvalByHipoteca(int idHipoteca) {
		// TODO Auto-generated method stub
		return formDao.selectAvalByHipoteca(idHipoteca);
	}

	@Override
	public Integer insertVendedorGarante(VendedorGaranteDTO vendedorGarante) {
		// TODO Auto-generated method stub
		return formDao.insertVendedorGarante(vendedorGarante);
	}

	@Override
	public Integer updateVendedorGarante(VendedorGaranteDTO vendedorGarante) {
		// TODO Auto-generated method stub
		return formDao.updateVendedorGarante(vendedorGarante);
	}

	@Override
	public Integer deleteVendedorGarante(VendedorGaranteDTO vendedorGarante) {
		// TODO Auto-generated method stub
		return formDao.deleteVendedorGarante(vendedorGarante);
	}

	@Override
	public List<VendedorGaranteDTO> selectVendedorGaranteByHipoteca(int idHipoteca) {
		// TODO Auto-generated method stub
		return formDao.selectVendedorGaranteByHipoteca(idHipoteca);
	}

	@Override
	public Integer selectNextIdAntecedentesPropiedad() {
		// TODO Auto-generated method stub
		return formDao.selectNextIdAntecedentesPropiedad();
	}

	@Override
	public Integer insertAntecedentesPropiedad(
			AntecedentesPropiedadDTO antecedentePropiedad) {
		// TODO Auto-generated method stub
		formDao.insertAntecedentesPropiedad(antecedentePropiedad);
		
		for(EstacionamientoDTO est : antecedentePropiedad.getListaEstacionamientos()){
			est.setIdAntecedentesPropiedad(antecedentePropiedad.getId());
			insertEstacionamiento(est);
		}
		
		for(BodegaDTO bod : antecedentePropiedad.getListaBodegas()){
			bod.setIdAntecedentesPropiedad(antecedentePropiedad.getId());
			insertBodega(bod);
		}
		return 0;
	}

	@Override
	public Integer updateAntecedentesPropiedad(
			AntecedentesPropiedadDTO antecedentePropiedad) {
		// TODO Auto-generated method stub
		return formDao.updateAntecedentesPropiedad(antecedentePropiedad);
	}

	@Override
	public Integer deleteAntecedentesPropiedad(
			AntecedentesPropiedadDTO antecedentePropiedad) {
		// TODO Auto-generated method stub
		return formDao.deleteAntecedentesPropiedad(antecedentePropiedad);
	}

	@Override
	public List<AntecedentesPropiedadDTO> selectAntecedentesPropiedadByHipoteca(
			int idHipoteca) {
		// TODO Auto-generated method stub
		List<AntecedentesPropiedadDTO> lista = formDao.selectAntecedentesPropiedadByHipoteca(idHipoteca);
		
		for(AntecedentesPropiedadDTO ap : lista){
			 ap.setListaBodegas(selectBodegaByAntecedentesPropiedad(ap.getId()));
			 ap.setListaEstacionamientos(selectEstacionamientoByAntecedentesPropiedad(ap.getId()));
		}				
		return lista;
	}

	@Override
	public Integer insertBodega(BodegaDTO bodega) {
		// TODO Auto-generated method stub
		return formDao.insertBodega(bodega);
	}

	@Override
	public Integer updateBodega(BodegaDTO bodega) {
		// TODO Auto-generated method stub
		return formDao.updateBodega(bodega);
	}

	@Override
	public Integer deleteBodega(BodegaDTO bodega) {
		// TODO Auto-generated method stub
		return formDao.deleteBodega(bodega);
	}

	@Override
	public List<BodegaDTO> selectBodegaByAntecedentesPropiedad(
			int idAntecedentesPropiedad) {
		// TODO Auto-generated method stub
		return formDao.selectBodegaByAntecedentesPropiedad(idAntecedentesPropiedad);
	}

	@Override
	public Integer insertEstacionamiento(EstacionamientoDTO estacionamiento) {
		// TODO Auto-generated method stub
		return formDao.insertEstacionamiento(estacionamiento);
	}

	@Override
	public Integer updateEstacionamiento(EstacionamientoDTO estacionamiento) {
		// TODO Auto-generated method stub
		return formDao.updateEstacionamiento(estacionamiento);
	}

	@Override
	public Integer deleteEstacionamiento(EstacionamientoDTO estacionamiento) {
		// TODO Auto-generated method stub
		return formDao.deleteEstacionamiento(estacionamiento);
	}

	@Override
	public List<EstacionamientoDTO> selectEstacionamientoByAntecedentesPropiedad(
			int idAntecedentesPropiedad) {
		// TODO Auto-generated method stub
		return formDao.selectEstacionamientoByAntecedentesPropiedad(idAntecedentesPropiedad);
	}

	@Override
	public Integer insertDocAdjuntosHipoteca(HipotecaCheckDTO hipotecaCheck) {
		// TODO Auto-generated method stub
		return formDao.insertDocAdjuntosHipoteca(hipotecaCheck);
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
		return formDao.selectDocAdjuntosHipotecaByHipoteca(idHipoteca);
	}

	@Override
	public Integer insertDocAdjuntosHipotecaFile(
			HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos) {
		// TODO Auto-generated method stub
		return formDao.insertDocAdjuntosHipotecaFile(hipotecaCheckAdjuntos);
	}

	@Override
	public Integer updateDocAdjuntosHipotecaFile(
			HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos) {
		// TODO Auto-generated method stub
		return formDao.updateDocAdjuntosHipotecaFile(hipotecaCheckAdjuntos);
	}

	@Override
	public Integer deleteDocAdjuntosHipotecaFile(
			HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos) {
		// TODO Auto-generated method stub
		return formDao.deleteDocAdjuntosHipotecaFile(hipotecaCheckAdjuntos);
	}

	@Override
	public List<HipotecaCheckAdjuntosDTO> selectDocAdjuntosHipotecaFileByHipoteca(
			int idHipoteca) {
		// TODO Auto-generated method stub
		return formDao.selectDocAdjuntosHipotecaFileByHipoteca(idHipoteca);
	}
	
	
	
}
