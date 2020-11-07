package ar.com.ifts.app.model.output;

import java.time.LocalDate;

import ar.com.ifts.app.model.output.dto.ProductoDto;

public class GetProductoResponse extends Response {

	private ProductoDto producto;

	public GetProductoResponse(String status, String code, LocalDate date, ProductoDto producto) {
		super(status, code, date);
		this.producto = producto;
	}
	
	public ProductoDto getProducto() {
		return producto;
	}

	public void setProductos(ProductoDto producto) {
		this.producto = producto;
	}
}
