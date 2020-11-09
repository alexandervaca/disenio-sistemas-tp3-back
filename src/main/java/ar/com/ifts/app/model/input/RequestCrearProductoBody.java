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
	
	@NotNull(message = "El precio no puede ser nulo")
	private Long stock;
	
	private String imagen;

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

}
