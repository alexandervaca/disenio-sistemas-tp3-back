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
	
	private Long stock;
	
	private String imagen;
	
	private boolean habilitado;

	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	public Producto() {
	}

	public Producto(String descProducto, BigDecimal precio, Long stock, String imagen, Usuario usuario, boolean habilitado) {
		this.descProducto = descProducto;
		this.precio = precio;
		this.stock = stock;
		this.imagen = imagen;
		this.usuario = usuario;
		this.habilitado = habilitado;
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

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Long getStock() {
		return stock;
	}

	public void setStock(Long stock) {
		this.stock = stock;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}
}
