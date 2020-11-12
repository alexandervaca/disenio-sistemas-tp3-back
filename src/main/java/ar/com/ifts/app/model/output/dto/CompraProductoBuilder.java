package ar.com.ifts.app.model.output.dto;

import ar.com.ifts.app.model.CompraProducto;

public class CompraProductoBuilder implements IBuilder<CompraProductoDto> {

	private CompraProducto compraProducto;

	public CompraProductoBuilder setCompraProducto(CompraProducto compraProducto) {
		this.compraProducto = compraProducto;
		return this;
	}

	@Override
	public CompraProductoDto build() {
		CompraProductoDto compraProductoDto = new CompraProductoDto();
		compraProductoDto.setIdCompraDetalle(compraProducto.getIdCompraDetalle());
		compraProductoDto.setDescProducto(compraProducto.getProducto().getDescProducto());
		compraProductoDto.setCantProducto(compraProducto.getCantProducto());
		compraProductoDto.setPrecio(compraProducto.getProducto().getPrecio());
		return compraProductoDto;
	}

}
