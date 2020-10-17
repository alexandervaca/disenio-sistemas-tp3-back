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

	public RequestRegisterBody(String username, String password, String permiso, String mail) {
		this.username = username;
		this.password = password;
		this.permiso = permiso;
		this.mail = mail;
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
}
