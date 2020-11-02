package ar.com.ifts.app.exception;

public class UsuarioNoExistenteException extends Exception{

	private static final long serialVersionUID = 4114277423083061870L;

	public UsuarioNoExistenteException() {
		super("Usuario no existente.");
	}
}
