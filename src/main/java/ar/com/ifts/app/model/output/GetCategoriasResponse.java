package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.Categoria;

public class GetCategoriasResponse extends Response{
	
	List<Categoria> categorias;

	public GetCategoriasResponse(String status, String code, LocalDate date, List<Categoria> categorias) {
		super(status, code, date);
		this.categorias = categorias;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
}
