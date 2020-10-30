package ar.com.ifts.app.model.input;

public class RequestObtenerUsuariosBody {

	private String categoria;

	private String permiso;
	
	public RequestObtenerUsuariosBody(String categoria, String permiso) {
		this.categoria = categoria;
		this.permiso = permiso;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getPermiso() {
		return permiso;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setPermiso(String permiso) {
		this.permiso = permiso;
	}
}
