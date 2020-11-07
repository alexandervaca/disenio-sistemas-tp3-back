package ar.com.ifts.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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

	private Long cantProducto;

	private Long idCompra;

	private BigDecimal subtotal;
	
	public CompraProducto() {}

	public CompraProducto( Producto producto, Long idCompra, Long cantProducto, BigDecimal subtotal) {
		this.producto = producto;
		this.idCompra = idCompra;
		this.cantProducto = cantProducto;
		this.subtotal = subtotal;
	}

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

	public Long getCantProducto() {
		return cantProducto;
	}

	public void setCantProducto(Long cantProducto) {
		this.cantProducto = cantProducto;
	}

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}
}
