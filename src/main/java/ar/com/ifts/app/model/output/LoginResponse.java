package ar.com.ifts.app.model.output;

import java.time.LocalDate;

public class LoginResponse extends Response{
	
	private String token;

	public LoginResponse(String status, String code, LocalDate date, String token) {
		super(status, code, date);
		this.token = token;
	}
	
	public String getToken() {
		return token;
	}

}
