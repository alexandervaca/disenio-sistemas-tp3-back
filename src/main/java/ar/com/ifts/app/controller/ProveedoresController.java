package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.exception.UsuarioServiceException;
import ar.com.ifts.app.model.output.GetUsuariosResponse;

@RestController
@RequestMapping(value = "/api")
public class ProveedoresController extends UsuariosController {

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROVEEDOR') or hasRole('ROLE_CLIENTE')")
	@GetMapping(value = "/proveedores", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getProveedores() {
		return ResponseEntity
				.ok(new GetUsuariosResponse("Consulta de proveedores exitosa.", String.valueOf(OK.ordinal()),
						LocalDate.now(), buildListUsuarioResponse(usuariosService.getProveedores())));
	}

	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROVEEDOR') or hasRole('ROLE_CLIENTE')")
	@GetMapping(value = "/proveedores/{id}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getProveedoresPorCategoria(@PathVariable("id") Long idCategoria)
			throws UsuarioServiceException {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de proveedor exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), buildListUsuarioResponse(usuariosService.getProveedoresByCategoria(idCategoria))));
	}
}
