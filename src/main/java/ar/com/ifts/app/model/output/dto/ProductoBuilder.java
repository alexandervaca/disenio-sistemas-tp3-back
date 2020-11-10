package ar.com.ifts.app.model.output.dto;

import ar.com.ifts.app.model.Producto;

public class ProductoBuilder implements IBuilder<ProductoDto> {

	private Producto producto;

	public ProductoBuilder setProducto(Producto producto) {
		this.producto = producto;
		return this;
	}

	@Override
	public ProductoDto build() {
		ProductoDto producto = new ProductoDto();
		producto.setIdProducto(this.producto.getIdProducto());
		producto.setDescProducto(this.producto.getDescProducto());
		producto.setPrecio(this.producto.getPrecio());
		producto.setStock(this.producto.getStock());
		producto.setImagen(this.producto.getImagen());
		producto.setIdProveedor(this.producto.getUsuario().getIdUsuario());
		producto.setHabilitado(this.producto.isHabilitado());
		return producto;
	}

}
