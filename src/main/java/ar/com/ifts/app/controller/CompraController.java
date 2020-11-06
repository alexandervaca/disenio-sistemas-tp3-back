package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.exception.CompraException;
import ar.com.ifts.app.model.input.RequestRealizarCompraBody;
import ar.com.ifts.app.model.output.Response;
import ar.com.ifts.app.services.CompraService;

@RestController
@RequestMapping(value = "/api")
public class CompraController {
	
	@Autowired
	private CompraService compraService;

	@PostMapping(value = "/compra", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> crearProducto(
			@Valid @RequestBody RequestRealizarCompraBody requestRealizarCompraBody) throws CompraException {
		compraService.realizarCompra(requestRealizarCompraBody);
		return ResponseEntity.ok(
				new Response("Se realizó la compra correctamente.", String.valueOf(OK.ordinal()), LocalDate.now()));
	}
}
