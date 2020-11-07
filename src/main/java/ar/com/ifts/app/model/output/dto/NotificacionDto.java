package ar.com.ifts.app.model.output.dto;

public class NotificacionDto {

	private Long idCompra;

	private Long idComprador;
	
	private Long idProveedor;

	private String nombreComprador;
	
	private String message;

	public Long getIdCompra() {
		return idCompra;
	}

	public void setIdCompra(Long idCompra) {
		this.idCompra = idCompra;
	}

	public Long getIdComprador() {
		return idComprador;
	}

	public void setIdComprador(Long idComprador) {
		this.idComprador = idComprador;
	}

	public String getNombreComprador() {
		return nombreComprador;
	}

	public void setNombreComprador(String nombreComprador) {
		this.nombreComprador = nombreComprador;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(Long idProveedor) {
		this.idProveedor = idProveedor;
	}
}
