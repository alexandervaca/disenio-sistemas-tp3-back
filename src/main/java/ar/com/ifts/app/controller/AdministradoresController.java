package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.model.output.GetUsuariosResponse;

@RestController
@RequestMapping(value = "/api")
public class AdministradoresController extends UsuariosController{
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/administradores", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getAdministradores() {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de clientes exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), buildListUsuarioResponse(usuariosService.getAdministradores())));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping(value = "/usuarios", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getAllUsuarios(HttpServletRequest http) {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de usuarios exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), buildListUsuarioResponse(usuariosService.getAllUsuarios(http))));
	}
}
