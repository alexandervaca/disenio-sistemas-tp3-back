package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.dto.CompraProductoDto;

public class GetComprasProductoResponse extends Response {

	private List<CompraProductoDto> comprasProducto;

	public GetComprasProductoResponse(String status, String code, LocalDate date, List<CompraProductoDto> comprasProducto) {
		super(status, code, date);
		this.comprasProducto = comprasProducto;
	}
	
	public List<CompraProductoDto> getComprasProducto() {
		return comprasProducto;
	}

	public void setComprasProducto(List<CompraProductoDto> comprasProducto) {
		this.comprasProducto = comprasProducto;
	}
}
