package ar.com.ifts.app.exception;

public class CategoriaNoExistenteException extends Exception{

	private static final long serialVersionUID = 3982962150460518674L;

	public CategoriaNoExistenteException() {
		super("Categoría no existente.");
	}
}
