/**
 * 
 */
package cl.jazocar.jselector.dto;

/**
 * @author Diablo
 *
 */
public class ProveedorDTO extends ResponseDTO{

	private int id;
	private String rut;
	private String razonSocial;
	private String nombre;
	private String direccion;
	private String numero;
	private String pais;
	private String region;
	private String comuna;
	private String cPostal;
	private String telefono;
	private String movil;
	private String email;
	private String website;
	
	/**
	 * 
	 */
	public ProveedorDTO() {
	}
	
	
	/**
	 * @param rut
	 * @param razonSocial
	 * @param nombre
	 * @param direccion
	 * @param numero
	 * @param pais
	 * @param region
	 * @param comuna
	 * @param cPostal
	 * @param telefono
	 * @param movil
	 * @param email
	 * @param website
	 */
	public ProveedorDTO(String rut, String razonSocial, String nombre,
			String direccion, String numero, String pais, String region,
			String comuna, String cPostal, String telefono, String movil,
			String email, String website) {
		this.rut = rut;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.pais = pais;
		this.region = region;
		this.comuna = comuna;
		this.cPostal = cPostal;
		this.telefono = telefono;
		this.movil = movil;
		this.email = email;
		this.website = website;
	}
	
	/**
	 * @param id
	 * @param rut
	 * @param razonSocial
	 * @param nombre
	 * @param direccion
	 * @param numero
	 * @param pais
	 * @param region
	 * @param comuna
	 * @param cPostal
	 * @param telefono
	 * @param movil
	 * @param email
	 * @param website
	 */
	public ProveedorDTO(int id, String rut, String razonSocial,
			String nombre, String direccion, String numero, String pais,
			String region, String comuna, String cPostal, String telefono,
			String movil, String email, String website) {
		this.id = id;
		this.rut = rut;
		this.razonSocial = razonSocial;
		this.nombre = nombre;
		this.direccion = direccion;
		this.numero = numero;
		this.pais = pais;
		this.region = region;
		this.comuna = comuna;
		this.cPostal = cPostal;
		this.telefono = telefono;
		this.movil = movil;
		this.email = email;
		this.website = website;
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
	 * @return the rut
	 */
	public String getRut() {
		return rut;
	}
	/**
	 * @param rut the rut to set
	 */
	public void setRut(String rut) {
		this.rut = rut;
	}
	/**
	 * @return the razonSocial
	 */
	public String getRazonSocial() {
		return razonSocial;
	}
	/**
	 * @param razonSocial the razonSocial to set
	 */
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
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
	 * @return the numero
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
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
	 * @return the cPostal
	 */
	public String getcPostal() {
		return cPostal;
	}
	/**
	 * @param cPostal the cPostal to set
	 */
	public void setcPostal(String cPostal) {
		this.cPostal = cPostal;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the movil
	 */
	public String getMovil() {
		return movil;
	}
	/**
	 * @param movil the movil to set
	 */
	public void setMovil(String movil) {
		this.movil = movil;
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
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}
	/**
	 * @param website the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
	
}
