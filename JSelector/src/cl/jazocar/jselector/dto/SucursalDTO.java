/**
 * 
 */
package cl.jazocar.jselector.dto;

import java.util.Date;

/**
 * @author Diablo
 *
 */
public class SucursalDTO extends ResponseDTO {
	
	private int id;
	private String codigo;
	private String nombre;
	private String direccion;
	private String pais;
	private String region;
	private String comuna;
	private String horarioLv;
	private String horarioSab;
	private String horarioDom;
	private String telefono1;
	private String telefono2;
	private String email;
	private String estado;
	private Date   fechaCreacion;
	
	
	
	
	/**
	 * @param mensaje
	 * @param estado
	 * @param id
	 * @param codigo
	 * @param nombre
	 * @param direccion
	 * @param pais
	 * @param region
	 * @param comuna
	 * @param horarioLv
	 * @param horarioSab
	 * @param horarioDom
	 * @param telefono1
	 * @param telefono2
	 * @param email
	 */
	public SucursalDTO(int id, String codigo,
			String nombre, String direccion, String pais, String region,
			String comuna, String horarioLv, String horarioSab,
			String horarioDom, String telefono1, String telefono2, String email) {
		
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
		this.region = region;
		this.comuna = comuna;
		this.horarioLv = horarioLv;
		this.horarioSab = horarioSab;
		this.horarioDom = horarioDom;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.email = email;
	}
	/**
	 * @param codigo
	 * @param nombre
	 * @param direccion
	 * @param pais
	 * @param region
	 * @param comuna
	 * @param horarioLv
	 * @param horarioSab
	 * @param horarioDom
	 * @param telefono1
	 * @param telefono2
	 * @param email
	 */
	public SucursalDTO(String codigo, String nombre, String direccion,
			String pais, String region, String comuna, String horarioLv,
			String horarioSab, String horarioDom, String telefono1,
			String telefono2, String email) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
		this.region = region;
		this.comuna = comuna;
		this.horarioLv = horarioLv;
		this.horarioSab = horarioSab;
		this.horarioDom = horarioDom;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.email = email;
	}
	/**
	 * @param id
	 * @param codigo
	 * @param nombre
	 * @param direccion
	 * @param pais
	 * @param region
	 * @param comuna
	 * @param horarioLv
	 * @param horarioSab
	 * @param horarioDom
	 * @param telefono1
	 * @param telefono2
	 * @param email
	 * @param estado
	 * @param fechaCreacion
	 */
	public SucursalDTO(int id, String codigo, String nombre, String direccion,
			String pais, String region, String comuna, String horarioLv,
			String horarioSab, String horarioDom, String telefono1,
			String telefono2, String email, String estado, Date fechaCreacion) {
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.pais = pais;
		this.region = region;
		this.comuna = comuna;
		this.horarioLv = horarioLv;
		this.horarioSab = horarioSab;
		this.horarioDom = horarioDom;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.email = email;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the comuna
	 */
	public String getComuna() {
		return comuna;
	}
	/**
	 * @param comuna the comuna to set
	 */
	public void setComuna(String comuna) {
		this.comuna = comuna;
	}
	/**
	 * @return the horarioLv
	 */
	public String getHorarioLv() {
		return horarioLv;
	}
	/**
	 * @param horarioLv the horarioLv to set
	 */
	public void setHorarioLv(String horarioLv) {
		this.horarioLv = horarioLv;
	}
	/**
	 * @return the horarioSab
	 */
	public String getHorarioSab() {
		return horarioSab;
	}
	/**
	 * @param horarioSab the horarioSab to set
	 */
	public void setHorarioSab(String horarioSab) {
		this.horarioSab = horarioSab;
	}
	/**
	 * @return the horarioDom
	 */
	public String getHorarioDom() {
		return horarioDom;
	}
	/**
	 * @param horarioDom the horarioDom to set
	 */
	public void setHorarioDom(String horarioDom) {
		this.horarioDom = horarioDom;
	}
	/**
	 * @return the telefono1
	 */
	public String getTelefono1() {
		return telefono1;
	}
	/**
	 * @param telefono1 the telefono1 to set
	 */
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	/**
	 * @return the telefono2
	 */
	public String getTelefono2() {
		return telefono2;
	}
	/**
	 * @param telefono2 the telefono2 to set
	 */
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * @param fechaCreacion the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	
	

}
