package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.model.output.GetUsuariosResponse;
import ar.com.ifts.app.services.UsuariosService;

@RestController
@RequestMapping(value = "/api")
public class UsuariosController {

	@Autowired
	private UsuariosService usuariosService;

	@GetMapping(value = "/proveedores", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getProveedores() {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de proveedores exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), usuariosService.getProveedores()));
	}
	
	@GetMapping(value = "/proveedores/{id}")
	public ResponseEntity<GetUsuariosResponse> getProveedoresPorCategoria(@PathVariable("id") Long idCategoria) {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de proveedores exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), usuariosService.getProveedoresByCategoria(idCategoria)));
	}
	
	@GetMapping(value = "/clientes", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getclientes() {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de clientes exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), usuariosService.getClientes()));
	}
	
	@GetMapping(value = "/administradores", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetUsuariosResponse> getAdministradores() {
		return ResponseEntity.ok(new GetUsuariosResponse("Consulta de clientes exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), usuariosService.getAdministradores()));
	}
}
