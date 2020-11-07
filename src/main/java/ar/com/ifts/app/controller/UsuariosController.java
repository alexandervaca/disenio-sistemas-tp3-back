package ar.com.ifts.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.ifts.app.model.Usuario;
import ar.com.ifts.app.model.output.dto.UsuarioBuilder;
import ar.com.ifts.app.model.output.dto.UsuarioDto;
import ar.com.ifts.app.services.UsuariosService;

public class UsuariosController {

	@Autowired
	UsuariosService usuariosService;

	public UsuarioDto buildUsuarioResponse(Usuario usuario) {
		return new UsuarioBuilder().setUsuario(usuario).build();
	}
	
	public List<UsuarioDto> buildListUsuarioResponse(List<Usuario> usuarios) {
		return usuarios.stream().map(elem -> buildUsuarioResponse(elem)).collect(Collectors.toList());
	}
}
