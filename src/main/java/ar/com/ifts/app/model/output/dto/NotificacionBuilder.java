package ar.com.ifts.app.model.output.dto;

import java.math.BigDecimal;

public class NotificacionBuilder implements IBuilder<NotificacionResponseDto>{

	private Long idCompra;

	private Long idComprador;

	private String nombreComprador;

	private BigDecimal totalCompra;
	
	private String message;

	
	public NotificacionBuilder setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
		return this;
	}


	public NotificacionBuilder setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
		return this;
	}


	public NotificacionBuilder setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
		return this;
	}


	public NotificacionBuilder setTotalCompra(BigDecimal totalCompra) {
		this.totalCompra = totalCompra;
		return this;
	}


	public NotificacionBuilder setMessage(String message) {
		this.message = message;
		return this;
	}


	@Override
	public NotificacionResponseDto build() {
		NotificacionResponseDto notificacion = new NotificacionResponseDto();
		notificacion.setIdCompra(this.idCompra);
		notificacion.setIdComprador(this.idComprador);
		notificacion.setMessage(this.message);
		notificacion.setNombreComprador(this.nombreComprador);
		notificacion.setTotalCompra(this.totalCompra);
		return notificacion;
	}

}
