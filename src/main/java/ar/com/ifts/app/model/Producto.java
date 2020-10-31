package ar.com.ifts.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "productos")
public class Producto implements Serializable {

	private static final long serialVersionUID = 3509031737098683587L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long idProducto;

	private String descProducto;

	private BigDecimal precio;

	@OneToOne
    @JoinColumn(name="producto_categoria_id")
	private Categoria categoria;

	public Producto() {}

	public Producto(String descProducto, BigDecimal precio, Categoria categoria) {
		this.descProducto = descProducto;
		this.precio = precio;
		this.categoria = categoria;
	}

	public Long getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Long idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescProducto() {
		return descProducto;
	}
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getPrecio() {
		return precio;
	}
	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}
}
