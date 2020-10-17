package ar.com.ifts.app.model.input;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class RequestLoginBody {
	
	
	@NotBlank(message = "El username no puede ser vacio")
	@Size(max = 60, message = "El username no puede contener más de 30 caracteres")
	private String username;
	
	@NotBlank(message = "La password no puede ser vacia")
	@Size(max = 60, message = "La password no puede contener más de 60 caracteres")
	private String password;

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
