package ar.com.ifts.app.model.output.dto;

import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.model.Permiso;

public class UsuarioResponseBuilder implements IBuilder<UsuarioResponseDto>{
	
	private Long idUsuario;
	
	private String nombre;
	
	private String mail;
	
	private Categoria categoria;
	
	private Permiso permiso;
	
	
	public UsuarioResponseBuilder setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
		return this;
	}

	public UsuarioResponseBuilder setNombre(String nombre) {
		this.nombre = nombre;
		return this;
	}

	public UsuarioResponseBuilder setMail(String mail) {
		this.mail = mail;
		return this;
	}

	public UsuarioResponseBuilder setCategoria(Categoria categoria) {
		this.categoria = categoria;
		return this;
	}

	public UsuarioResponseBuilder setPermiso(Permiso permiso) {
		this.permiso = permiso;
		return this;
	}

	@Override
	public UsuarioResponseDto build() {
		UsuarioResponseDto usuario = new UsuarioResponseDto();
		usuario.setIdUsuario(this.idUsuario);
		usuario.setNombre(this.nombre);
		usuario.setMail(this.mail);
		usuario.setCategoria(this.categoria);
		usuario.setPermiso(this.permiso);
		return usuario;
	}

}
