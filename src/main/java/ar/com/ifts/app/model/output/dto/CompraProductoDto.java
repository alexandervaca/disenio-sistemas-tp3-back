package ar.com.ifts.app.model.output.dto;

import java.math.BigDecimal;

public class CompraProductoDto {
	private Long idCompraDetalle;
	private String descProducto;
	private Long cantProducto;
	private BigDecimal precio;

	public Long getIdCompraDetalle() {
		return idCompraDetalle;
	}
	public void setIdCompraDetalle(Long idCompraDetalle) {
		this.idCompraDetalle = idCompraDetalle;
	}
	public String getDescProducto() {
		return descProducto;
	}
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}
	public Long getCantProducto() {
		return cantProducto;
	}
	public void setCantProducto(Long cantProducto) {
		this.cantProducto = cantProducto;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}
