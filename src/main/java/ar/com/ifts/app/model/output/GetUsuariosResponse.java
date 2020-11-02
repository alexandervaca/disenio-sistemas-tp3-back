package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.dto.UsuarioResponseDto;

public class GetUsuariosResponse extends Response {
	
	private List<UsuarioResponseDto> usuarios;

	public GetUsuariosResponse(String status, String code, LocalDate date, List<UsuarioResponseDto> usuarios) {
		super(status, code, date);
		this.usuarios = usuarios;
	}

	public List<UsuarioResponseDto> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioResponseDto> usuarios) {
		this.usuarios = usuarios;
	}

}
