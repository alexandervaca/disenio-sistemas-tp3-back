package ar.com.ifts.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "notificaciones")
public class Notificacion {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long idNotificacion;
	
	@OneToOne
	@JoinColumn(name = "id_compra")
	private Compra compra;
	
	// Este usuario hace referencia al proveedor
	@OneToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	private String message;
	
	public Notificacion() { }

	public Notificacion(Compra compra, Usuario usuario, String message) {
		this.compra = compra;
		this.usuario = usuario;
		this.message = message;
	}

	public Long getIdNotificacion() {
		return idNotificacion;
	}

	public void setIdNotificacion(Long idNotificacion) {
		this.idNotificacion = idNotificacion;
	}

	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
