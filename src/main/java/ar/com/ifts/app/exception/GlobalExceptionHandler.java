package ar.com.ifts.app.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Alex
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, NOT_FOUND);
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> illegalArgumentExceptionHandler(IllegalArgumentException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UserDetailServiceImplException.class)
	public ResponseEntity<?> userDetailServiceImplExceptionHandler(UserDetailServiceImplException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotificacionesServiceException.class)
	public ResponseEntity<?> notificacionesServiceExceptionHandler(NotificacionesServiceException ex,
			WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(UsuarioServiceException.class)
	public ResponseEntity<?> usuarioServiceExceptionHandler(UsuarioServiceException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(ProductosServiceException.class)
	public ResponseEntity<?> productosServiceExceptionHandler(ProductosServiceException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(CompraServiceException.class)
	public ResponseEntity<?> compraServiceExceptionHandler(CompraServiceException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return this.globleExcpetionHandlerReturn(errorDetails, INTERNAL_SERVER_ERROR);
	}

	public ResponseEntity<?> globleExcpetionHandlerReturn(ErrorDetails errorDetails, HttpStatus status) {
		return new ResponseEntity<>(errorDetails, status);
	}
}
