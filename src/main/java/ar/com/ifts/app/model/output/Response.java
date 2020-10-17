package ar.com.ifts.app.model.output;

import java.time.LocalDate;

public class Response implements IResponse {
	private String status;
	private String code;
	private LocalDate date;

	public Response(String status, String code, LocalDate date) {
		this.status = status;
		this.code = code;
		this.date = date;
	}

	@Override
	public String getStatus() {
		return status;
	}

	@Override
	public String getCode() {
		return code;
	}

	@Override
	public LocalDate getDate() {
		return date;
	}

}
