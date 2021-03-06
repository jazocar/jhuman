package cl.jazocar.jselector.dao.service;

import java.util.List;

import cl.jazocar.jselector.front.form.dto.AntecedentesPropiedadDTO;
import cl.jazocar.jselector.front.form.dto.AvalDTO;
import cl.jazocar.jselector.front.form.dto.BodegaDTO;
import cl.jazocar.jselector.front.form.dto.EstacionamientoDTO;
import cl.jazocar.jselector.front.form.dto.FichaPersonalDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckAdjuntosDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaCheckDTO;
import cl.jazocar.jselector.front.form.dto.HipotecaDTO;
import cl.jazocar.jselector.front.form.dto.InformeLegalDTO;
import cl.jazocar.jselector.front.form.dto.RegistroBancarioDTO;
import cl.jazocar.jselector.front.form.dto.VendedorGaranteDTO;

public interface FormServiceInterface {
	
	//Ficha Personal.
	public Integer                insertFichaPersonal(FichaPersonalDTO fichaPersonal);
	public Integer  		      updateFichaPersonal(FichaPersonalDTO fichaPersonal);
	public Integer                deleteFichaPersonal(FichaPersonalDTO fichaPersonal);
	public Integer                selectNextIdFichaPersonal();
	public List<FichaPersonalDTO> selectFichaPersonal();
	public FichaPersonalDTO       selectFichaPersonalByIdEmpleado(int id);	

	//Registro Bancario.
		public Integer                   insertRegistroBancario(RegistroBancarioDTO registroBancario);
		public Integer  		         updateRegistroBancario(RegistroBancarioDTO registroBancario);
		public Integer                   deleteRegistroBancario(RegistroBancarioDTO registroBancario);
		public List<RegistroBancarioDTO> selectRegistroBancario();
		public RegistroBancarioDTO       selectRegistroBancarioById(int id);
		public RegistroBancarioDTO       selectRegistroBancarioByIdEmpleado(int id);
		
	//Informe Legal.
		public Integer               selectNextIdInformeLegal();
		public Integer               insertInformeLegal(InformeLegalDTO informeLegal);
		public Integer  		     updateInformeLegal(InformeLegalDTO informeLegal);
		public Integer               deleteInformeLegal(InformeLegalDTO informeLegal);
		public List<InformeLegalDTO> selectInformeLegal(InformeLegalDTO informeLegal);
		public List<InformeLegalDTO> searchInformeLegal(InformeLegalDTO informeLegal);
		public InformeLegalDTO       selectInformeLegalById(int idInformeLegal);
		
	//Hipoteca.
		public Integer               selectNextIdHipoteca();
		public Integer               insertHipoteca(HipotecaDTO hipoteca);
		public Integer  		     updateHipoteca(HipotecaDTO hipoteca);
		public Integer               deleteHipoteca(HipotecaDTO hipoteca);
		public HipotecaDTO           selectHipotecaByInformeLegal(int idInformeLegal);
		
	//Aval.
		public Integer               insertAval(AvalDTO aval);
		public Integer  		     updateAval(AvalDTO aval);
		public Integer               deleteAval(AvalDTO aval);
		public List<AvalDTO>     selectAvalByHipoteca(int idHipoteca);
	
	//Vendedor Garante
		public Integer               insertVendedorGarante(VendedorGaranteDTO vendedorGarante);
		public Integer  		     updateVendedorGarante(VendedorGaranteDTO vendedorGarante);
		public Integer               deleteVendedorGarante(VendedorGaranteDTO vendedorGarante);
		public List<VendedorGaranteDTO>     selectVendedorGaranteByHipoteca(int idHipoteca);
		
		//Antecedentes de la Propiedad.
		public Integer                            selectNextIdAntecedentesPropiedad();
		public Integer              			  insertAntecedentesPropiedad(AntecedentesPropiedadDTO antecedentePropiedad);
		public Integer  		    			  updateAntecedentesPropiedad(AntecedentesPropiedadDTO antecedentePropiedad);
		public Integer               			  deleteAntecedentesPropiedad(AntecedentesPropiedadDTO antecedentePropiedad);
		public List<AntecedentesPropiedadDTO>     selectAntecedentesPropiedadByHipoteca(int idHipoteca);
		
		//Bodega.
		public Integer           insertBodega(BodegaDTO bodega);
		public Integer  		 updateBodega(BodegaDTO bodega);
		public Integer           deleteBodega(BodegaDTO bodega);
		public List<BodegaDTO>   selectBodegaByAntecedentesPropiedad(int idAntecedentesPropiedad);
		
		//Estacionamiento.
		public Integer                    insertEstacionamiento(EstacionamientoDTO estacionamiento);
		public Integer  		          updateEstacionamiento(EstacionamientoDTO estacionamiento);
		public Integer                    deleteEstacionamiento(EstacionamientoDTO estacionamiento);
		public List<EstacionamientoDTO>   selectEstacionamientoByAntecedentesPropiedad(int idAntecedentesPropiedad);
		
		//Documentos Adjuntos.
		//Hipoteca
		public Integer                    insertDocAdjuntosHipoteca(HipotecaCheckDTO hipotecaCheck);
		public Integer  		          updateDocAdjuntosHipoteca(HipotecaCheckDTO hipotecaCheck);
		public Integer                    deleteDocAdjuntosHipoteca(HipotecaCheckDTO hipotecaCheck);
		public HipotecaCheckDTO           selectDocAdjuntosHipotecaByHipoteca(int idHipoteca);		
	
		public Integer                        insertDocAdjuntosHipotecaFile(HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos);
		public Integer  		              updateDocAdjuntosHipotecaFile(HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos);
		public Integer                        deleteDocAdjuntosHipotecaFile(HipotecaCheckAdjuntosDTO hipotecaCheckAdjuntos);
		public List<HipotecaCheckAdjuntosDTO> selectDocAdjuntosHipotecaFileByHipoteca(int idHipoteca);		

}
