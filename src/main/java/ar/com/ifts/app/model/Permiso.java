package ar.com.ifts.app.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "permisos")
public class Permiso implements Serializable{

	private static final long serialVersionUID = 2315253695636048534L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long idPermiso;
	
	private String descPermiso;

	public Long getIdPermiso() {
		return idPermiso;
	}

	public void setIdPermiso(Long idPermiso) {
		this.idPermiso = idPermiso;
	}

	public String getDescPermiso() {
		return descPermiso;
	}

	public void setDescPermiso(String descPermiso) {
		this.descPermiso = descPermiso;
	}

}
