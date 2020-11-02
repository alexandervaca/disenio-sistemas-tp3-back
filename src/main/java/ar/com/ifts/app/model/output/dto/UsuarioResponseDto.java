package ar.com.ifts.app.model.output.dto;

import ar.com.ifts.app.model.Categoria;
import ar.com.ifts.app.model.Permiso;

public class UsuarioResponseDto {
	private Long idUsuario;

	private String nombre;

	private String mail;

	private Categoria categoria;

	private Permiso permiso;

	public Long getIdUsuario() {
		return idUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMail() {
		return mail;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Permiso getPermiso() {
		return permiso;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public void setPermiso(Permiso permiso) {
		this.permiso = permiso;
	}
}
