package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.dto.ProductoDto;

public class GetProductosResponse extends Response {

	private List<ProductoDto> productos;

	public GetProductosResponse(String status, String code, LocalDate date, List<ProductoDto> productos) {
		super(status, code, date);
		this.productos = productos;
	}
	
	public List<ProductoDto> getProductos() {
		return productos;
	}

	public void setProductos(List<ProductoDto> productos) {
		this.productos = productos;
	}
}
