package ar.com.ifts.app.model.output.dto;

import java.time.format.DateTimeFormatter;

import ar.com.ifts.app.model.Compra;

public class CompraBuilder implements IBuilder<CompraDto> {

	private Compra compra;

	public CompraBuilder setCompra(Compra compra) {
		this.compra = compra;
		return this;
	}

	@Override
	public CompraDto build() {
		CompraDto compraDto = new CompraDto();
		compraDto.setIdCompra(compra.getIdCompra());
		compraDto.setPrecioTotal(compra.getPrecioTotal());
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		compraDto.setFechaCompra(compra.getFechaCompra().format(formatter));
		return compraDto;
	}

}
