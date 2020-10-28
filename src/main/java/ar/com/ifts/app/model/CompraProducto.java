package ar.com.ifts.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras_detalle")
public class CompraProducto {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long idCompraDetalle;

	@OneToOne
	@JoinColumn(name = "id_producto")
	private Producto producto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_compra")
	private Compra compra;

	private Integer cantProducto;

	private BigDecimal precioProducto;

	public Long getIdCompraDetalle() {
		return idCompraDetalle;
	}
	public void setIdCompraDetalle(Long idCompraDetalle) {
		this.idCompraDetalle = idCompraDetalle;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Integer getCantProducto() {
		return cantProducto;
	}
	public void setCantProducto(Integer cantProducto) {
		this.cantProducto = cantProducto;
	}
	public BigDecimal getPrecioProducto() {
		return precioProducto;
	}
	public void setPrecioProducto(BigDecimal precioProducto) {
		this.precioProducto = precioProducto;
	}
	public Compra getCompra() {
		return compra;
	}
	public void setCompra(Compra compra) {
		this.compra = compra;
	}
}
