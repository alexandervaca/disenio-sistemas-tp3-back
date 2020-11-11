package ar.com.ifts.app.model.output.dto;

import ar.com.ifts.app.model.Usuario;

public class UsuarioBuilder implements IBuilder<UsuarioDto>{
	
	private Usuario usuario;
	

	public UsuarioBuilder setUsuario(Usuario usuario) {
		this.usuario = usuario;
		return this;
	}

	@Override
	public UsuarioDto build() {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setIdUsuario(this.usuario.getIdUsuario());
		usuario.setNombre(this.usuario.getNombre());
		usuario.setMail(this.usuario.getMail());
		usuario.setCategoria(this.usuario.getCategoria());
		usuario.setPermiso(this.usuario.getPermisos());
		usuario.setHabilitado(this.usuario.isHabilitado());
		return usuario;
	}

}
