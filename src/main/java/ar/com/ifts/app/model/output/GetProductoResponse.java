package ar.com.ifts.app.model.output;

import java.time.LocalDate;

import ar.com.ifts.app.model.Producto;

public class GetProductoResponse extends Response {

	private Producto producto;

	public GetProductoResponse(String status, String code, LocalDate date, Producto producto) {
		super(status, code, date);
		this.producto = producto;
	}
	
	public Producto getProducto() {
		return producto;
	}

	public void setProductos(Producto producto) {
		this.producto = producto;
	}
}
