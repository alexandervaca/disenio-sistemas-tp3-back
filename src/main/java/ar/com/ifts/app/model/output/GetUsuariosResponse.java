package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.dto.UsuarioDto;

public class GetUsuariosResponse extends Response {
	
	private List<UsuarioDto> usuarios;

	public GetUsuariosResponse(String status, String code, LocalDate date, List<UsuarioDto> usuarios) {
		super(status, code, date);
		this.usuarios = usuarios;
	}

	public List<UsuarioDto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioDto> usuarios) {
		this.usuarios = usuarios;
	}

}
