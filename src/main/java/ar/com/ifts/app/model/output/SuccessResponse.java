package ar.com.ifts.app.model.output;

import static org.springframework.http.HttpStatus.OK;

import java.time.LocalDate;
import java.util.List;

public class SuccessResponse extends Response {
	private List<String> messages;

	public SuccessResponse(List<String> messages) {
		super(OK.getReasonPhrase(), String.valueOf(OK.ordinal()), LocalDate.now());
		this.messages = messages;
	}

	public List<String> getMessages() {
		return messages;
	}

}
