package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.dto.NotificacionResponseDto;

public class GetNotificacionesResponse extends Response{
	
	private List<NotificacionResponseDto> notificaciones;

	public GetNotificacionesResponse(String status, String code, LocalDate date, List<NotificacionResponseDto> notificaciones) {
		super(status, code, date);
		this.notificaciones = notificaciones;
	}

	public List<NotificacionResponseDto> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificacion(List<NotificacionResponseDto> notificaciones) {
		this.notificaciones = notificaciones;
	}

}
