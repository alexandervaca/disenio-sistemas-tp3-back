package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.exception.UsuarioServiceException;
import ar.com.ifts.app.model.output.GetUsuarioResponse;
import ar.com.ifts.app.services.UsuariosService;

@RestController
@RequestMapping(value = "/api")
public class UsuarioController extends UsuariosController{
	
	@Autowired
	private UsuariosService usuariosService;

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROVEEDOR') or hasRole('ROLE_CLIENTE')")
	@GetMapping(value = "/usuario", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuarioResponse> getUsuario(HttpServletRequest http) throws UsuarioServiceException {
		return ResponseEntity.ok(new GetUsuarioResponse("Consulta de usuario exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), buildUsuarioResponse(usuariosService.getUsuario(http))));
	}
}
