package cl.jazocar.jselector.dto;

import java.util.Date;

public class ProductoDTO extends ResponseDTO  {


	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String codigo;
	private String codigoEAN;
	private String estadoProducto;
	private String descripcion;
	private int valorNeto;
	private int porcGanancia;
	private String afectoIva;
	private int subValor;
	private int valorTotal;
	private String procedencia;
	private String unidadMedida;
	private String cantUnidadMedida;
	private int stockMaximo;
	private int stockMinimo;
	private int stockCritico;
	private String categoria;
	private String subCategoria;
	private Date fechaCreacion;
	private String estado;
	private int    stock;
	private String marca;
	
	private int    valorStock;
	
	
	
	
	/**
	 * @param codigo
	 * @param codigoEAN
	 * @param estadoProducto
	 * @param descripcion
	 * @param valorNeto
	 * @param afectoIva
	 * @param valorTotal
	 * @param procedencia
	 * @param unidadMedida
	 * @param cantUnidadMedida
	 * @param stockMaximo
	 * @param stockMinimo
	 * @param stockCritico
	 * @param categoria
	 * @param subCategoria
	 * @param estado
	 */
	public ProductoDTO(String codigo, String codigoEAN, String estadoProducto,
			String descripcion, int valorNeto, int porcGanancia, String afectoIva, String procedencia, String unidadMedida,
			String cantUnidadMedida, int stockMaximo, int stockMinimo,
			int stockCritico, String categoria, String subCategoria, String marca) {
		this.codigo = codigo;
		this.codigoEAN = codigoEAN;
		this.estadoProducto = estadoProducto;
		this.descripcion = descripcion;
		this.valorNeto = valorNeto;
		this.porcGanancia = porcGanancia;
		this.afectoIva = afectoIva;
		this.procedencia = procedencia;
		this.unidadMedida = unidadMedida;
		this.cantUnidadMedida = cantUnidadMedida;
		this.stockMaximo = stockMaximo;
		this.stockMinimo = stockMinimo;
		this.stockCritico = stockCritico;
		this.categoria = categoria;
		this.subCategoria = subCategoria;		
		this.marca		  = marca;
	}
	
	
	public ProductoDTO(int id, String codigo, String codigoEAN, String estadoProducto,
			String descripcion, int valorNeto, int porcGanancia, String afectoIva, String procedencia, String unidadMedida,
			String cantUnidadMedida, int stockMaximo, int stockMinimo,
			int stockCritico, String categoria, String subCategoria, String marca) {
		this.id     = id;
		this.codigo = codigo;
		this.codigoEAN = codigoEAN;
		this.estadoProducto = estadoProducto;
		this.descripcion = descripcion;
		this.valorNeto = valorNeto;
		this.porcGanancia = porcGanancia;
		this.afectoIva = afectoIva;
		this.procedencia = procedencia;
		this.unidadMedida = unidadMedida;
		this.cantUnidadMedida = cantUnidadMedida;
		this.stockMaximo = stockMaximo;
		this.stockMinimo = stockMinimo;
		this.stockCritico = stockCritico;
		this.categoria = categoria;
		this.subCategoria = subCategoria;		
		this.marca		  = marca;
	}
	/**
	 * @param id
	 * @param codigo
	 * @param codigoEAN
	 * @param estadoProducto
	 * @param descripcion
	 * @param valorNeto
	 * @param afectoIva
	 * @param valorTotal
	 * @param procedencia
	 * @param unidadMedida
	 * @param cantUnidadMedida
	 * @param stockMaximo
	 * @param stockMinimo
	 * @param stockCritico
	 * @param categoria
	 * @param subCategoria
	 * @param fechaCreacion
	 * @param estado
	 */
	public ProductoDTO(int id, String codigo, String codigoEAN,
			String estadoProducto, String descripcion, int valorNeto, int porcGanancia, int subValor,
			String afectoIva, int valorTotal, String procedencia,
			String unidadMedida, String cantUnidadMedida, int stockMaximo,
			int stockMinimo, int stockCritico, String categoria,
			String subCategoria, Date fechaCreacion, String estado, int stock, String marca) {
		this.id = id;
		this.codigo = codigo;
		this.codigoEAN = codigoEAN;
		this.estadoProducto = estadoProducto;
		this.descripcion = descripcion;
		this.valorNeto = valorNeto;
		this.porcGanancia = porcGanancia;
		this.subValor = subValor;
		this.afectoIva = afectoIva;
		this.valorTotal = valorTotal;
		this.procedencia = procedencia;
		this.unidadMedida = unidadMedida;
		this.cantUnidadMedida = cantUnidadMedida;
		this.stockMaximo = stockMaximo;
		this.stockMinimo = stockMinimo;
		this.stockCritico = stockCritico;
		this.categoria = categoria;
		this.subCategoria = subCategoria;
		this.fechaCreacion = fechaCreacion;
		this.estado = estado;
		this.stock = stock;
		this.marca = marca;
	}
	/**
	 * 
	 */
	public ProductoDTO() {
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
	 * @return the codigoEAN
	 */
	public String getCodigoEAN() {
		return codigoEAN;
	}
	/**
	 * @param codigoEAN the codigoEAN to set
	 */
	public void setCodigoEAN(String codigoEAN) {
		this.codigoEAN = codigoEAN;
	}
	/**
	 * @return the estadoProducto
	 */
	public String getEstadoProducto() {
		return estadoProducto;
	}
	/**
	 * @param estadoProducto the estadoProducto to set
	 */
	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the valorNeto
	 */
	public int getValorNeto() {
		return valorNeto;
	}
	/**
	 * @param valorNeto the valorNeto to set
	 */
	public void setValorNeto(int valorNeto) {
		this.valorNeto = valorNeto;
	}
	/**
	 * @return the afectoIva
	 */
	public String getAfectoIva() {
		return afectoIva;
	}
	/**
	 * @param afectoIva the afectoIva to set
	 */
	public void setAfectoIva(String afectoIva) {
		this.afectoIva = afectoIva;
	}
	/**
	 * @return the valorTotal
	 */
	public int getValorTotal() {
		return valorTotal;
	}
	/**
	 * @param valorTotal the valorTotal to set
	 */
	public void setValorTotal(int valorTotal) {
		this.valorTotal = valorTotal;
	}
	/**
	 * @return the procedencia
	 */
	public String getProcedencia() {
		return procedencia;
	}
	/**
	 * @param procedencia the procedencia to set
	 */
	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}
	/**
	 * @return the unidadMedida
	 */
	public String getUnidadMedida() {
		return unidadMedida;
	}
	/**
	 * @param unidadMedida the unidadMedida to set
	 */
	public void setUnidadMedida(String unidadMedida) {
		this.unidadMedida = unidadMedida;
	}
	/**
	 * @return the cantUnidadMedida
	 */
	public String getCantUnidadMedida() {
		return cantUnidadMedida;
	}
	/**
	 * @param cantUnidadMedida the cantUnidadMedida to set
	 */
	public void setCantUnidadMedida(String cantUnidadMedida) {
		this.cantUnidadMedida = cantUnidadMedida;
	}
	/**
	 * @return the stockMaximo
	 */
	public int getStockMaximo() {
		return stockMaximo;
	}
	/**
	 * @param stockMaximo the stockMaximo to set
	 */
	public void setStockMaximo(int stockMaximo) {
		this.stockMaximo = stockMaximo;
	}
	/**
	 * @return the stockMinimo
	 */
	public int getStockMinimo() {
		return stockMinimo;
	}
	/**
	 * @param stockMinimo the stockMinimo to set
	 */
	public void setStockMinimo(int stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	/**
	 * @return the stockCritico
	 */
	public int getStockCritico() {
		return stockCritico;
	}
	/**
	 * @param stockCritico the stockCritico to set
	 */
	public void setStockCritico(int stockCritico) {
		this.stockCritico = stockCritico;
	}
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the subCategoria
	 */
	public String getSubCategoria() {
		return subCategoria;
	}
	/**
	 * @param subCategoria the subCategoria to set
	 */
	public void setSubCategoria(String subCategoria) {
		this.subCategoria = subCategoria;
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
	 * @return the stock
	 */
	public int getStock() {
		return stock;
	}
	/**
	 * @param stock the stock to set
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}
	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}


	/**
	 * @return the porcGanancia
	 */
	public int getPorcGanancia() {
		return porcGanancia;
	}


	/**
	 * @param porcGanancia the porcGanancia to set
	 */
	public void setPorcGanancia(int porcGanancia) {
		this.porcGanancia = porcGanancia;
	}


	/**
	 * @return the subValor
	 */
	public int getSubValor() {
		return subValor;
	}


	/**
	 * @param subValor the subValor to set
	 */
	public void setSubValor(int subValor) {
		this.subValor = subValor;
	}


	/**
	 * @return the valorStock
	 */
	public int getValorStock() {
		return valorStock;
	}


	/**
	 * @param valorStock the valorStock to set
	 */
	public void setValorStock(int valorStock) {
		this.valorStock = valorStock;
	}
	
	
	
}
