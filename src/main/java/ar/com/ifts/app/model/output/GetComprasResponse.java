package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.dto.CompraDto;

public class GetComprasResponse extends Response {

	private List<CompraDto> compras;

	public GetComprasResponse(String status, String code, LocalDate date, List<CompraDto> compras) {
		super(status, code, date);
		this.compras = compras;
	}
	
	public List<CompraDto> getCompras() {
		return compras;
	}

	public void setCompras(List<CompraDto> compras) {
		this.compras = compras;
	}
}
