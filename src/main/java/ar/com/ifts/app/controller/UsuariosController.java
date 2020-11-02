package ar.com.ifts.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.model.output.dto.UsuarioResponseBuilder;
import ar.com.ifts.app.model.output.dto.UsuarioResponseDto;
import ar.com.ifts.app.services.UsuariosService;

public class UsuariosController {

	@Autowired
	UsuariosService usuariosService;

	public UsuarioResponseDto buildUsuarioResponse(Usuario usuario) {
		return new UsuarioResponseBuilder()
				.setIdUsuario(usuario.getIdUsuario())
				.setMail(usuario.getMail())
				.setNombre(usuario.getNombre())
				.setCategoria(usuario.getCategoria())
				.setPermiso(usuario.getPermisos())
				.build();
	}
	
	public List<UsuarioResponseDto> buildListUsuarioResponse(List<Usuario> usuarios) {
		return usuarios.stream().map(elem -> buildUsuarioResponse(elem)).collect(Collectors.toList());
	}
}
