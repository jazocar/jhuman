/**
 * 
 */
package cl.jazocar.jselector.dto;

import java.util.Date;

/**
 * @author Jazocar Soluciones Informaticas
 * @fecha 10-07-2013
 * @version 1.0.0
 * @description
 */
public class UsuarioDTO extends ResponseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int     id;
	private String  usuario;
	private String  password;
	private int     rol;
	private int     rolProceso;
	private Date    fechaCreacion;
	private int     estado;
	private String  nombre;
	private String  lenguaje;
	private boolean darBaja;
	private boolean darAlta;
	private int     organizacion;
	private int     idEmpresa;
	private int     area;
	private int     subarea;
	
	public UsuarioDTO() {

	}

	

	/**
	 * @return the usuario
	 */
	public String getEmpresa() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setEmpresa(String empresa) {
		this.usuario = empresa;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the lenguaje
	 */
	public String getLenguaje() {
		return lenguaje;
	}

	/**
	 * @param lenguaje
	 *            the lenguaje to set
	 */
	public void setLenguaje(String lenguaje) {
		this.lenguaje = lenguaje;
	}

	/**
	 * @return the rol
	 */
	public int getRol() {
		return rol;
	}

	/**
	 * @param rol
	 *            the rol to set
	 */
	public void setRol(int rol) {
		this.rol = rol;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario
	 *            the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	/**
	 * @return the fechaCreacion
	 */
	public Date getFechaCreacion() {
		return fechaCreacion;
	}

	/**
	 * @param fechaCreacion
	 *            the fechaCreacion to set
	 */
	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	/**
	 * @return the estado
	 */
	public int getEstado() {
		return estado;
	}

	/**
	 * @param estado
	 *            the estado to set
	 */
	public void setEstado(int estado) {
		this.estado = estado;
	}

	/**
	 * @return the darBaja
	 */
	public boolean isDarBaja() {
		return darBaja;
	}

	/**
	 * @param darBaja
	 *            the darBaja to set
	 */
	public void setDarBaja(boolean darBaja) {
		this.darBaja = darBaja;
	}

	/**
	 * @return the darAlta
	 */
	public boolean isDarAlta() {
		return darAlta;
	}

	/**
	 * @param darAlta
	 *            the darAlta to set
	 */
	public void setDarAlta(boolean darAlta) {
		this.darAlta = darAlta;
	}

	/**
	 * @return the organizacion
	 */
	public int getOrganizacion() {
		return organizacion;
	}

	/**
	 * @param organizacion the organizacion to set
	 */
	public void setOrganizacion(int organizacion) {
		this.organizacion = organizacion;
	}



	/**
	 * @return the area
	 */
	public int getArea() {
		return area;
	}



	/**
	 * @param area the area to set
	 */
	public void setArea(int area) {
		this.area = area;
	}



	/**
	 * @return the subarea
	 */
	public int getSubarea() {
		return subarea;
	}
	
	/**
	 * @param subarea the subarea to set
	 */
	public void setSubarea(int subarea) {
		this.subarea = subarea;
	}

	public int getRolProceso() {
		return rolProceso;
	}

	public void setRolProceso(int rolProceso) {
		this.rolProceso = rolProceso;
	}
	
	public int getIdEmpresa() {
		return idEmpresa;
	}



	public void setIdEmpresa(int idEmpresa) {
		this.idEmpresa = idEmpresa;
	}
	
	
	

}
