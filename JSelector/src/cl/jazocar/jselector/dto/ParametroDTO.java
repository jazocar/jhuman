package cl.jazocar.jselector.dto;

public class ParametroDTO
  extends ResponseDTO
{
  private static final long serialVersionUID = 1L;
  private int id;
  private String nombre;
  private String descripcion;
  private int idTipoGrupo;
  
  public int getId()
  {
    return this.id;
  }
  
  public void setId(int id)
  {
    this.id = id;
  }
  
  public String getNombre()
  {
    return this.nombre;
  }
  
  public void setNombre(String nombre)
  {
    this.nombre = nombre;
  }
  
  public String getDescripcion()
  {
    return this.descripcion;
  }
  
  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }
  
  public int getIdTipoGrupo()
  {
    return this.idTipoGrupo;
  }
  
  public void setIdTipoGrupo(int idTipoGrupo)
  {
    this.idTipoGrupo = idTipoGrupo;
  }
}
