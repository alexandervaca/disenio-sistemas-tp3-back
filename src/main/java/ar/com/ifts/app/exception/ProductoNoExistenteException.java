package ar.com.ifts.app.exception;

public class ProductoNoExistenteException extends Exception {

	private static final long serialVersionUID = 1567547586673396691L;

	public ProductoNoExistenteException() {
		super("Producto no existente.");
	}
}
