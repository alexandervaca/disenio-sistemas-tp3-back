package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.model.output.GetCategoriasResponse;
import ar.com.ifts.app.services.CategoriasService;

@RestController
@RequestMapping(value = "/api")
public class CategoriasController {

	@Autowired
	private CategoriasService categoriasService;

	@GetMapping(value = "/categorias", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetCategoriasResponse> obtenerCategorias() {
		return ResponseEntity.ok(new GetCategoriasResponse("Consulta de categorias exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), categoriasService.getCategorias()));
	}
}
