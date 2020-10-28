package ar.com.ifts.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "compras")
public class Compra implements Serializable {

	private static final long serialVersionUID = 8074875453781738002L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long idCompra;

	@OneToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	private LocalDateTime fechaCompra;

	private BigDecimal precioTotal = BigDecimal.ZERO;

	@OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CompraProducto> productosComprados = new ArrayList<CompraProducto>();

	public LocalDateTime getFechaCompra() {
		return fechaCompra;
	}
	public void setFechaCompra(LocalDateTime fechaCompra) {
		this.fechaCompra = fechaCompra;
	}
	public BigDecimal getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(BigDecimal precioTotal) {
		this.precioTotal = precioTotal;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Long getIdCompra() {
		return idCompra;
	}
	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}
	public void addProducto(CompraProducto compraProducto) {
		this.productosComprados.add(compraProducto);
		compraProducto.setCompra(this);
		precioTotal = precioTotal.add(compraProducto.getPrecioProducto());
	}
	public void removeProducto(CompraProducto compraProducto) {
		this.productosComprados.remove(compraProducto);
		compraProducto.setCompra(null);
	}
	public List<CompraProducto> getProductosComprados() {
		return productosComprados;
	}
	public void setProductosComprados(List<CompraProducto> productosComprados) {
		this.productosComprados = productosComprados;
	}
}
