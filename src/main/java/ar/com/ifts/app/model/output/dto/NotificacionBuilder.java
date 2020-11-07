package ar.com.ifts.app.model.output.dto;

import ar.com.ifts.app.model.Notificacion;

public class NotificacionBuilder implements IBuilder<NotificacionDto> {

	private Notificacion notificacion;

	public NotificacionBuilder setNotificacion(Notificacion notificacion) {
		this.notificacion = notificacion;
		return this;
	}

	@Override
	public NotificacionDto build() {
		NotificacionDto notificacion = new NotificacionDto();
		notificacion.setIdCompra(this.notificacion.getCompra().getIdCompra());
		notificacion.setIdComprador(this.notificacion.getCompra().getUsuario().getIdUsuario());
		notificacion.setMessage(this.notificacion.getMessage());
		notificacion.setNombreComprador(this.notificacion.getCompra().getUsuario().getNombre());
		notificacion.setIdProveedor(this.notificacion.getUsuario().getIdUsuario());
		return notificacion;
	}

}
