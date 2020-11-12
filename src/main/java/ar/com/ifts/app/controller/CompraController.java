package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.exception.CompraServiceException;
import ar.com.ifts.app.model.input.RequestRealizarCompraBody;
import ar.com.ifts.app.model.output.GetComprasProductoResponse;
import ar.com.ifts.app.model.output.GetComprasResponse;
import ar.com.ifts.app.model.output.Response;
import ar.com.ifts.app.model.output.dto.CompraBuilder;
import ar.com.ifts.app.model.output.dto.CompraProductoBuilder;
import ar.com.ifts.app.services.CompraService;

@RestController
@RequestMapping(value = "/api")
public class CompraController {
	
	@Autowired
	private CompraService compraService;

	@PreAuthorize("hasRole('ROLE_CLIENTE')")
	@PostMapping(value = "/compra", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> realizarCompra(
			@Valid @RequestBody RequestRealizarCompraBody requestRealizarCompraBody) throws CompraServiceException {
		compraService.realizarCompra(requestRealizarCompraBody);
		return ResponseEntity.ok(
				new Response("Se realizó la compra correctamente.", String.valueOf(OK.ordinal()), LocalDate.now()));
	}

	@PreAuthorize("hasRole('ROLE_CLIENTE')")
	@GetMapping(value = "/compras", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetComprasResponse> obtenerCompras(HttpServletRequest http) throws CompraServiceException {
		return ResponseEntity.ok(new GetComprasResponse("Consulta de compras exitosa.",
				String.valueOf(OK.ordinal()), LocalDate.now(), compraService.getComprasByCliente(http).stream()
						.map(elem -> new CompraBuilder().setCompra(elem).build()).collect(Collectors.toList())));
	}

	@PreAuthorize("hasRole('ROLE_CLIENTE') or hasRole('ROLE_PROVEEDOR')")
	@GetMapping(value = "/compras/detalle/{idCompra}", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetComprasProductoResponse> obtenerComprasDetalle(@PathVariable("idCompra") Long idCompra) throws CompraServiceException {
		return ResponseEntity.ok(new GetComprasProductoResponse("Consulta de compras detalle exitosa.",
				String.valueOf(OK.ordinal()), LocalDate.now(), compraService.getComprasProductoByIdCompra(idCompra).stream()
						.map(elem -> new CompraProductoBuilder().setCompraProducto(elem).build()).collect(Collectors.toList())));
	}
}
