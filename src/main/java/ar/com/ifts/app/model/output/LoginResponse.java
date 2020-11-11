package ar.com.ifts.app.model.output;

import java.time.LocalDate;

public class LoginResponse extends Response{
	
	private String token;
	
	private String permiso;
	
	private String username;

	public LoginResponse(String status, String code, LocalDate date, String token, String permiso, String username) {
		super(status, code, date);
		this.token = token;
		this.permiso = permiso;
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getToken() {
		return token;
	}
	
	public String getPermiso() {
		return permiso;
	}

}
