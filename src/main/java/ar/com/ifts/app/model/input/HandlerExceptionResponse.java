package ar.com.ifts.app.model.input;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.Response;



public class HandlerExceptionResponse extends Response {
	
	private List<String> msgsError;
	
	public HandlerExceptionResponse(String status, String code, LocalDate date, List<String> msgsError) {
		super(status, code, date);
		this.msgsError = msgsError;
	}

	public List<String> getMsgsError() {
		return msgsError;
	}

}
