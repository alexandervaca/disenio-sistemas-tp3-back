package ar.com.ifts.app.model.input;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class RequestCrearProductoBody {

	@NotBlank(message = "La descripción no puede ser vacía.")
	private String descripcion;

	@NotNull(message = "El precio no puede ser nulo")
	@DecimalMin(value = "0.0")
	private BigDecimal precio;
	
	private String imagen;

	@NotNull(message = "El idCategoria no puede ser nulo.")
	private Long idUsuario;

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

}
