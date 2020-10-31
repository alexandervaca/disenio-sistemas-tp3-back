package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.Producto;

public class GetProductosResponse extends Response {

	private List<Producto> productos;

	public GetProductosResponse(String status, String code, LocalDate date, List<Producto> productos) {
		super(status, code, date);
		this.productos = productos;
	}
	
	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
}
