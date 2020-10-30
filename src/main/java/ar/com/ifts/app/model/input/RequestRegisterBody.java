package ar.com.ifts.app.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestRegisterBody {

	@NotBlank(message = "El usuuario no puede ser vacío.")
	@Size(min = 5, max = 30, message = "El nombre de usuario debe contener al menos 5 y máximo 30 caracteres.")
	private String username;
	
	@NotBlank(message = "La contraseña no puede ser vacío.")
	@Size(min = 5, max = 30, message = "La contraseña debe contener al menos 5 y máximo 30 caracteres.")
	private String password;
	
	@NotBlank
	private String permiso;
	
	@NotBlank(message = "El mail no puede ser vacío.")
	@Size(min = 5, max = 30, message = "El mail debe contener al menos 5 y máximo 30 caracteres.")
	private String mail;
	
	private Long idCategoria;
	
	@NotBlank(message = "El nombre no puede ser vacío.")
	@Size(min = 5, max = 30, message = "El nombre debe contener al menos 5 y máximo 90 caracteres.")
	private String nombre;

	public RequestRegisterBody(String username, String password, String permiso, String mail, Long idCategoria, String nombre) {
		this.username = username;
		this.password = password;
		this.permiso = permiso;
		this.mail = mail;
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Long getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Long idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
