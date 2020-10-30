package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.Usuario;

public class GetUsuariosResponse extends Response {
	
	private List<Usuario> usuarios;

	public GetUsuariosResponse(String status, String code, LocalDate date, List<Usuario> usuarios) {
		super(status, code, date);
		this.usuarios = usuarios;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
