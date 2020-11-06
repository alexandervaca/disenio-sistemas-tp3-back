package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;



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
