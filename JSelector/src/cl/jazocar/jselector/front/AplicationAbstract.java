package cl.jazocar.jselector.front;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.model.SelectItem;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.FormServiceInterface;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.dto.ListaDTO;
import cl.jazocar.jselector.dto.ParametroDTO;
import cl.jazocar.jselector.dto.TipoParametroDTO;
import cl.jazocar.jselector.front.form.impl.AltaEmpleadoFrontClass;
import cl.jazocar.jselector.front.impl.EstructuraFrontBean;
import cl.jazocar.jselector.front.impl.ListasFrontClass;
import cl.jazocar.jselector.front.impl.ParametrosFrontBean;

import com.icesoft.faces.context.effects.BlindDown;
import com.icesoft.faces.context.effects.Effect;

public abstract class AplicationAbstract implements AplicationInterface {

	public static IConfigJProcessService configJProcessService;
	public static FormServiceInterface formService;

	public Effect panelEffect;

	public AplicationAbstract() {
		configJProcessService = JProcessFactoryService.getInstance()
				.getService("CONF_JPROCESS_SERVICE",
						IConfigJProcessService.class);

		formService = JProcessFactoryService.getInstance().getService(
				"jselector_FORM_SERVICE", FormServiceInterface.class);
	}

	public Effect getPanelEffect() {
		return panelEffect;
	}

	public void setPanelEffect(Effect panelEffect) {
		this.panelEffect = panelEffect;
	}

	public String fireEffect() {
		panelEffect = new BlindDown();
		return null;
	}
	
	public void refreshList(){
		
		//Listas.
		ListasFrontClass.listaParametros = new ArrayList<SelectItem>();		
		for(ParametroDTO parametro : configJProcessService.selectParametroByTipoParametro(7))
			ListasFrontClass.listaParametros.add(new SelectItem(parametro.getId(), parametro.getNombre()));
		
		//Estructuras.
		EstructuraFrontBean.listaListas = new ArrayList<SelectItem>();
		EstructuraFrontBean.listaClase  = new ArrayList<SelectItem>();		
		for(ParametroDTO parametro : configJProcessService.selectParametroByTipoParametro(7))
			EstructuraFrontBean.listaListas.add(new SelectItem(parametro.getId(), parametro.getNombre()));		
		for(ParametroDTO parametro : configJProcessService.selectParametroByTipoParametro(1))
			EstructuraFrontBean.listaClase.add(new SelectItem(parametro.getId(), parametro.getNombre()));
		
		//Parametros.
		ParametrosFrontBean.listaTipoParametro = new ArrayList();
	    for (TipoParametroDTO tipoParametro : configJProcessService.selectTipoParametro()) 
	    	ParametrosFrontBean.listaTipoParametro.add(new SelectItem(Integer.valueOf(tipoParametro.getId()), tipoParametro.getNombre()));	    
	    
	    //Alta Empleado.
	    AltaEmpleadoFrontClass.listaEstadoCivil = new ArrayList<SelectItem>();
	    AltaEmpleadoFrontClass.listaBancos      = new ArrayList<SelectItem>();
	    AltaEmpleadoFrontClass.listaNivelEstudios = new ArrayList<SelectItem>();
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(49))
			AltaEmpleadoFrontClass.listaEstadoCivil.add(new SelectItem(lista.getId(), lista.getValor()));		
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(50))
			AltaEmpleadoFrontClass.listaBancos.add(new SelectItem(lista.getId(), lista.getValor()));
		for(ListaDTO lista : configJProcessService.selectListaByIdParametro(51))
			AltaEmpleadoFrontClass.listaNivelEstudios.add(new SelectItem(lista.getId(), lista.getValor()));
		
		
	}

	public static class UploadedFile implements Serializable {

		private static final long serialVersionUID = 1L;
		private String name;
		private String size;
		private String contentType;
		private String info;
		private String path;
		private File file;

		public UploadedFile(String name, String size, String contentType,
				String info, String path, File file) {
			this.name = name;
			this.size = size;
			this.contentType = contentType;
			this.info = info;
			this.path = path;
			this.file = file;
		}

		public String getName() {
			return name;
		}

		public String getSize() {
			return size;
		}

		public String getContentType() {
			return contentType;
		}

		public String getInfo() {
			return info;
		}

		public String getPath() {
			return path;
		}

		public File getFile() {
			return file;
		}
	}
}
