package ar.com.ifts.app.model.output;

import java.time.LocalDate;

public interface IResponse {
	
	public String getStatus();
	
	public String getCode();
	
	public LocalDate getDate();
}
