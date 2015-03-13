package cl.jazocar.jselector.front.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.icefaces.ace.event.SelectEvent;
import org.icefaces.application.SessionExpiredException;

import cl.jazocar.jselector.common.connection.JProcessFactoryService;
import cl.jazocar.jselector.dao.service.IConfigJProcessService;
import cl.jazocar.jselector.dto.AreaDTO;
import cl.jazocar.jselector.dto.EmpresaDTO;
import cl.jazocar.jselector.dto.OrganizacionDTO;
import cl.jazocar.jselector.dto.SubareaDTO;
import cl.jazocar.jselector.dto.UsuarioDTO;
import cl.jazocar.jselector.sys.dto.RolDTO;
import cl.jazocar.jselector.sys.dto.RolProcesoDTO;
import cl.jazocar.jselector.sys.front.MenuFrontBean;
import cl.jazocar.jselector.util.EncrypterDecrypter;

import com.icesoft.faces.context.effects.BlindDown;
import com.icesoft.faces.context.effects.Effect;

@ManagedBean(name="usuarioFrontBean")
@SessionScoped
public class UsuarioFrontBean
{
  public static final String USUARIO_BEAN = "usuarioFrontBean";
  public static UsuarioDTO usuarioBean = null;
  private UsuarioDTO usuarioDto;
  private IConfigJProcessService configJProcessService;
  private List<UsuarioDTO> listaUsuarios;
  private List<SelectItem> listaOrg;
  private List<SelectItem> listaEmpresas;
  private List<SelectItem> listaArea;
  private List<SelectItem> listaSubarea;
  private List<SelectItem> listaRol;
  private List<SelectItem> listaRolProceso;
  private String inputUsuario;
  private String inputPassword;
  private String inputRepassword;
  private String inputNombre;
  private String inputRol;
  private String inputRolProceso;
  private String inputOrganizacion;
  private String inputEmpresa;
  private String inputArea;
  private String inputSubarea;
  private String selectedIndex;
  private boolean selected;
  private boolean lock;
  private boolean lockOut;
  private boolean mostrarBanco;
  private boolean esAdministrador;
  private boolean abrirPopup;
  private String usuario;
  private String clave;
  private String empresa;
  private String nombreUsuario;
  private BlindDown effectCustom;
  private static UsuarioDTO selectedUsuario;
  private int idUsuario;
  
  public UsuarioFrontBean()
  {
    this.configJProcessService = 
      ((IConfigJProcessService)JProcessFactoryService.getInstance().getService("CONF_JPROCESS_SERVICE", 
      IConfigJProcessService.class));
    
    this.listaOrg = new ArrayList();
    this.listaArea = new ArrayList();
    this.listaSubarea = new ArrayList();
    this.listaRol = new ArrayList();
    this.listaRolProceso = new ArrayList();
    this.listaEmpresas = new ArrayList();
    

    Iterator localIterator = this.configJProcessService.selectAllOrganizacion().iterator();
    while (localIterator.hasNext())
    {
      OrganizacionDTO org = (OrganizacionDTO)localIterator.next();
      this.listaOrg.add(new SelectItem(Integer.valueOf(org.getId()), org.getNombre()));
    }
    for (RolDTO rol : this.configJProcessService.selectAllRol()) {
      this.listaRol.add(new SelectItem(Integer.valueOf(rol.getId()), rol.getNombreRol()));
    }
    for (RolProcesoDTO rol : this.configJProcessService.selectAllRolProcesos()) {
      this.listaRolProceso.add(new SelectItem(Integer.valueOf(rol.getId()), rol.getNombre()));
    }
    this.listaUsuarios = this.configJProcessService.getAllUsuarios();
  }
  
  public void insertUsuarioListener(ActionEvent e)
  {
    try
    {
      if (this.inputPassword.equals(this.inputRepassword))
      {
        this.usuarioDto = new UsuarioDTO();
        this.usuarioDto.setUsuario(this.inputUsuario);
        this.usuarioDto.setPassword(EncrypterDecrypter.encrypt(this.inputPassword));
        this.usuarioDto.setRol(Integer.parseInt(this.inputRol));
        this.usuarioDto.setRolProceso(Integer.parseInt(this.inputRolProceso));
        this.usuarioDto.setNombre(this.inputNombre);
        this.usuarioDto.setOrganizacion(Integer.parseInt(this.inputOrganizacion));
        this.usuarioDto.setIdEmpresa(Integer.parseInt(this.inputEmpresa));
        this.usuarioDto.setArea(Integer.parseInt(this.inputArea));
        this.usuarioDto.setSubarea(Integer.parseInt(this.inputSubarea));
        this.configJProcessService.insertUsuario(this.usuarioDto);
        resetUsuario();
      }
      else
      {
        System.out.println("Las password deben coincidir");
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void updateUsuarioListener(ActionEvent e)
  {
    try
    {
      if (this.inputPassword.equals(this.inputRepassword))
      {
        this.usuarioDto = new UsuarioDTO();
        this.usuarioDto.setId(this.idUsuario);
        this.usuarioDto.setUsuario(this.inputUsuario);
        this.usuarioDto.setRol(Integer.parseInt(this.inputRol));
        this.usuarioDto.setRolProceso(Integer.parseInt(this.inputRolProceso));
        this.usuarioDto.setNombre(this.inputNombre);
        this.usuarioDto.setOrganizacion(Integer.parseInt(this.inputOrganizacion));
        this.usuarioDto.setIdEmpresa(Integer.parseInt(this.inputEmpresa));
        this.usuarioDto.setArea(Integer.parseInt(this.inputArea));
        this.usuarioDto.setSubarea(Integer.parseInt(this.inputSubarea));
        this.configJProcessService.updateUsuario(this.usuarioDto);
        resetUsuario();
      }
      else
      {
        System.out.println("Las password deben coincidir");
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void deleteUsuarioListener(ActionEvent e)
  {
    try
    {
      if (this.inputPassword.equals(this.inputRepassword))
      {
        this.usuarioDto = new UsuarioDTO();
        this.usuarioDto.setId(this.idUsuario);
        
        this.configJProcessService.deleteUsuario(this.usuarioDto);
        resetUsuario();
      }
      else
      {
        System.out.println("Las password deben coincidir");
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void resetUsuarioListener(ActionEvent e)
  {
    resetUsuario();
  }
  
  public void resetUsuario()
  {
    this.inputUsuario = "";
    this.inputPassword = "";
    this.inputRepassword = "";
    this.inputNombre = "";
    this.inputRol = "-1";
    this.inputRolProceso = "-1";
    this.inputOrganizacion = "-1";
    this.inputEmpresa = "-1";
    this.inputArea = "-1";
    this.inputSubarea = "-1";
    
    this.listaUsuarios = this.configJProcessService.getAllUsuarios();
    this.selected = false;
  }
  
  public void usuarioSelectListener(SelectEvent event)
  {
    try
    {
      this.usuarioDto = ((UsuarioDTO)event.getObject());
      
      this.inputUsuario = this.usuarioDto.getUsuario();
      this.inputPassword = 
        EncrypterDecrypter.decrypt(this.usuarioDto.getPassword());
      this.inputRepassword = this.usuarioDto.getPassword();
      this.inputNombre = this.usuarioDto.getNombre();
      this.inputRol = String.valueOf(this.usuarioDto.getRol());
      this.inputRolProceso = String.valueOf(this.usuarioDto.getRolProceso());
      this.inputOrganizacion = String.valueOf(this.usuarioDto.getOrganizacion());
      this.inputArea = String.valueOf(this.usuarioDto.getArea());
      this.inputSubarea = String.valueOf(this.usuarioDto.getSubarea());
      this.idUsuario = this.usuarioDto.getId();
      this.inputEmpresa = String.valueOf(this.usuarioDto.getIdEmpresa());
      this.selected = true;
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void loginUsuarioListener(ActionEvent e)
  {
    try
    {
      if ((this.usuario != null) && (!this.usuario.equals("")))
      {
        if (!this.clave.equals(""))
        {
          UsuarioDTO usuario = this.configJProcessService.loginUsuario(
            this.usuario, EncrypterDecrypter.encrypt(this.clave));
          if (usuario != null)
          {
            if (usuario.getEstado() == 3)
            {
              this.empresa = "";
              this.clave = "";
            }
            else
            {
              usuarioBean = new UsuarioDTO();
              usuarioBean.setId(usuario.getId());
              usuarioBean.setUsuario(this.usuario);
              usuarioBean.setPassword(this.clave);
              usuarioBean.setRol(usuario.getRol());
              usuarioBean.setOrganizacion(usuario
                .getOrganizacion());
              usuarioBean.setIdEmpresa(usuario.getIdEmpresa());
              
              this.lockOut = true;
              this.nombreUsuario = usuario.getNombre();
              
              MenuFrontBean.listaMenu = this.configJProcessService
                .obtenerMenuPerfiladoByRol(usuario.getRol());
              if ((usuarioBean.getRol() == 1) || 
                (usuarioBean.getRol() == 2)) {
                this.esAdministrador = true;
              } else {
                this.esAdministrador = false;
              }
              ToDoFrontBean.listaSolicitud = 
                this.configJProcessService.selectAllSolicitudesPendientesByRol(usuarioBean
                .getRol(), usuarioBean.getOrganizacion(), usuarioBean.getIdEmpresa());
              
              BusquedaFrontBean.listaSolicitud = this.configJProcessService.selectSolicitudesByUser(usuarioBean);
              BusquedaFrontBean.cantidad = BusquedaFrontBean.listaSolicitud.size();
              ToDoFrontBean.selected = false;
              NavigationBean.selectedPanel = "inicioPanel";
            }
          }
          else
          {
            this.usuario = "";
            this.clave = "";
          }
        }
        else
        {
          this.usuario = "";
          this.clave = "";
        }
      }
      else
      {
        this.usuario = "";
        this.clave = "";
      }
    }
    catch (Exception ex)
    {
      ex.printStackTrace();
    }
  }
  
  public void limpiarLoginListener(ActionEvent e)
  {
    limpiarLogin();
  }
  
  public void limpiarLogin()
  {
    this.usuario = "";
    this.clave = "";
  }
  
  public void changeOrganizacion(ValueChangeEvent event)
  {
    String option = event.getNewValue().toString();
    this.listaArea = new ArrayList();
    this.listaEmpresas = new ArrayList();
    if (option.equals("Banco")) {
      this.mostrarBanco = true;
    } else {
      this.mostrarBanco = false;
    }
    Iterator localIterator = this.configJProcessService.selectAreasByOrganizacion(Integer.parseInt(option)).iterator();
    while (localIterator.hasNext())
    {
      AreaDTO area = (AreaDTO)localIterator.next();
      this.listaArea.add(new SelectItem(Integer.valueOf(area.getId()), area.getNombre()));
    }
    for (EmpresaDTO empresa : this.configJProcessService.selectEmpresasByOrganizacion(Integer.parseInt(option))) {
      this.listaEmpresas.add(new SelectItem(Integer.valueOf(empresa.getId()), empresa.getNombre()));
    }
  }
  
  public void changeArea(ValueChangeEvent event)
  {
    String option = event.getNewValue().toString();
    if (!option.equals("-1"))
    {
      this.listaSubarea = new ArrayList();
      

      Iterator localIterator = this.configJProcessService.selectSubareasByArea(Integer.parseInt(option)).iterator();
      while (localIterator.hasNext())
      {
        SubareaDTO subarea = (SubareaDTO)localIterator.next();
        this.listaSubarea.add(new SelectItem(Integer.valueOf(subarea.getId()), subarea
          .getNombre()));
      }
    }
  }
  
  public void ajax(AjaxBehaviorEvent e)
  {
    System.out.println("ajax(AjaxBehaviorEvent)");
  }
  
  public void logoutUsuarioListener(ActionEvent e)
  {
    try
    {
      this.lockOut = false;
      this.usuario = "";
      this.clave = "";
      usuarioBean = null;
      this.selectedIndex = "0";
    }
    catch (SessionExpiredException localSessionExpiredException) {}
  }
  
  public void closeLoginUsuarioListener(ActionEvent e)
  {
    this.lock = false;
    this.usuario = "";
    this.clave = "";
  }
  
  public void openLoginListener(ActionEvent e)
  {
    this.lock = true;
  }
  
  public Effect getEffectCustom()
  {
    return this.effectCustom;
  }
  
  public void setEffectCustom(BlindDown effectCustom)
  {
    this.effectCustom = effectCustom;
  }
  
  public UsuarioDTO getUsuarioBean()
  {
    return usuarioBean;
  }
  
  public void setUsuarioBean(UsuarioDTO usuarioBean)
  {
    usuarioBean = usuarioBean;
  }
  
  public List<UsuarioDTO> getListaUsuarios()
  {
    return this.listaUsuarios;
  }
  
  public void setListaUsuarios(List<UsuarioDTO> listaUsuarios)
  {
    this.listaUsuarios = listaUsuarios;
  }
  
  public String getUsuario()
  {
    return this.usuario;
  }
  
  public void setUsuario(String usuario)
  {
    this.usuario = usuario;
  }
  
  public String getClave()
  {
    return this.clave;
  }
  
  public void setClave(String clave)
  {
    this.clave = clave;
  }
  
  public boolean isLock()
  {
    return this.lock;
  }
  
  public void setLock(boolean lock)
  {
    this.lock = lock;
  }
  
  public boolean isLockOut()
  {
    return this.lockOut;
  }
  
  public void setLockOut(boolean lockOut)
  {
    this.lockOut = lockOut;
  }
  
  public String getInputUsuario()
  {
    return this.inputUsuario;
  }
  
  public String getInputNombre()
  {
    return this.inputNombre;
  }
  
  public String getEmpresa()
  {
    return this.empresa;
  }
  
  public void setEmpresa(String empresa)
  {
    this.empresa = empresa;
  }
  
  public String getNombreUsuario()
  {
    return this.nombreUsuario;
  }
  
  public void setNombreUsuario(String nombreUsuario)
  {
    this.nombreUsuario = nombreUsuario;
  }
  
  public static UsuarioDTO getSelectedUsuario()
  {
    return selectedUsuario;
  }
  
  public static void setSelectedUsuario(UsuarioDTO selectedUsuario)
  {
    selectedUsuario = selectedUsuario;
  }
  
  public boolean isSelected()
  {
    return this.selected;
  }
  
  public void setSelected(boolean isSelected)
  {
    this.selected = isSelected;
  }
  
  public boolean isAbrirPopup()
  {
    return this.abrirPopup;
  }
  
  public void setAbrirPopup(boolean abrirPopup)
  {
    this.abrirPopup = abrirPopup;
  }
  
  public boolean isMostrarBanco()
  {
    return this.mostrarBanco;
  }
  
  public void setMostrarBanco(boolean mostrarBanco)
  {
    this.mostrarBanco = mostrarBanco;
  }
  
  public boolean isEsAdministrador()
  {
    return this.esAdministrador;
  }
  
  public void setEsAdministrador(boolean esAdministrador)
  {
    this.esAdministrador = esAdministrador;
  }
  
  public List<SelectItem> getListaOrg()
  {
    return this.listaOrg;
  }
  
  public void setListaOrg(List<SelectItem> listaOrg)
  {
    this.listaOrg = listaOrg;
  }
  
  public List<SelectItem> getListaArea()
  {
    return this.listaArea;
  }
  
  public void setListaArea(List<SelectItem> listaArea)
  {
    this.listaArea = listaArea;
  }
  
  public List<SelectItem> getListaSubarea()
  {
    return this.listaSubarea;
  }
  
  public void setListaSubarea(List<SelectItem> listaSubarea)
  {
    this.listaSubarea = listaSubarea;
  }
  
  public List<SelectItem> getListaRol()
  {
    return this.listaRol;
  }
  
  public void setListaRol(List<SelectItem> listaRol)
  {
    this.listaRol = listaRol;
  }
  
  public UsuarioDTO getUsuarioDto()
  {
    return this.usuarioDto;
  }
  
  public void setUsuarioDto(UsuarioDTO usuarioDto)
  {
    this.usuarioDto = usuarioDto;
  }
  
  public String getInputPassword()
  {
    return this.inputPassword;
  }
  
  public void setInputPassword(String inputPassword)
  {
    this.inputPassword = inputPassword;
  }
  
  public String getInputRepassword()
  {
    return this.inputRepassword;
  }
  
  public void setInputRepassword(String inputRepassword)
  {
    this.inputRepassword = inputRepassword;
  }
  
  public String getInputRol()
  {
    return this.inputRol;
  }
  
  public void setInputRol(String inputRol)
  {
    this.inputRol = inputRol;
  }
  
  public String getInputOrganizacion()
  {
    return this.inputOrganizacion;
  }
  
  public void setInputOrganizacion(String inputOrganizacion)
  {
    this.inputOrganizacion = inputOrganizacion;
  }
  
  public String getInputArea()
  {
    return this.inputArea;
  }
  
  public void setInputArea(String inputArea)
  {
    this.inputArea = inputArea;
  }
  
  public String getInputSubarea()
  {
    return this.inputSubarea;
  }
  
  public void setInputSubarea(String inputSubarea)
  {
    this.inputSubarea = inputSubarea;
  }
  
  public void setInputUsuario(String inputUsuario)
  {
    this.inputUsuario = inputUsuario;
  }
  
  public void setInputNombre(String inputNombre)
  {
    this.inputNombre = inputNombre;
  }
  
  public List<SelectItem> getListaRolProceso()
  {
    return this.listaRolProceso;
  }
  
  public void setListaRolProceso(List<SelectItem> listaRolProceso)
  {
    this.listaRolProceso = listaRolProceso;
  }
  
  public String getInputRolProceso()
  {
    return this.inputRolProceso;
  }
  
  public void setInputRolProceso(String inputRolProceso)
  {
    this.inputRolProceso = inputRolProceso;
  }
  
  public String getInputEmpresa()
  {
    return this.inputEmpresa;
  }
  
  public void setInputEmpresa(String inputEmpresa)
  {
    this.inputEmpresa = inputEmpresa;
  }
  
  public List<SelectItem> getListaEmpresas()
  {
    return this.listaEmpresas;
  }
  
  public void setListaEmpresas(List<SelectItem> listaEmpresas)
  {
    this.listaEmpresas = listaEmpresas;
  }
  
  public String getSelectedIndex()
  {
    return this.selectedIndex;
  }
  
  public void setSelectedIndex(String selectedIndex)
  {
    this.selectedIndex = selectedIndex;
  }
}
