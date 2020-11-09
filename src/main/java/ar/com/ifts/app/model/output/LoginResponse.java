package ar.com.ifts.app.model.output;

import java.time.LocalDate;

public class LoginResponse extends Response{
	
	private String token;
	
	private String permiso;

	public LoginResponse(String status, String code, LocalDate date, String token, String permiso) {
		super(status, code, date);
		this.token = token;
		this.permiso = permiso;
	}
	
	public String getToken() {
		return token;
	}
	
	public String getPermiso() {
		return permiso;
	}

}
