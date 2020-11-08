package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.model.output.GetUsuariosResponse;

@RestController
@RequestMapping(value = "/api")
public class ClientesController extends UsuariosController{
	
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_PROVEEDOR')")
	@GetMapping(value = "/clientes", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getclientes() {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de clientes exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), buildListUsuarioResponse(usuariosService.getClientes())));
	}
}
