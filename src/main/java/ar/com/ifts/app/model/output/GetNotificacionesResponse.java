package ar.com.ifts.app.model.output;

import java.time.LocalDate;
import java.util.List;

import ar.com.ifts.app.model.output.dto.NotificacionDto;

public class GetNotificacionesResponse extends Response{
	
	private List<NotificacionDto> notificaciones;

	public GetNotificacionesResponse(String status, String code, LocalDate date, List<NotificacionDto> notificaciones) {
		super(status, code, date);
		this.notificaciones = notificaciones;
	}

	public List<NotificacionDto> getNotificaciones() {
		return notificaciones;
	}

	public void setNotificacion(List<NotificacionDto> notificaciones) {
		this.notificaciones = notificaciones;
	}

}
