package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.exception.CreateException;
import ar.com.ifts.app.model.input.RequestProductoBody;
import ar.com.ifts.app.model.output.GetProductosResponse;
import ar.com.ifts.app.model.output.ProductoResponse;
import ar.com.ifts.app.services.ProductosService;

@RestController
@RequestMapping(value = "/api")
public class ProductosController {

	@Autowired
	private ProductosService productosService;

	@GetMapping(value = "/productos", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<GetProductosResponse> obtenerProductos() {
		return ResponseEntity.ok(new GetProductosResponse("Consulta de productos exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now(), productosService.getProductos()));
	}

	@PostMapping(value = "/productos", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<ProductoResponse> crearProducto(@Valid @RequestBody RequestProductoBody requestProductoBody) throws CreateException {

		productosService.create(requestProductoBody);

		return ResponseEntity.ok(new ProductoResponse("Creacion de producto exitosa.", String.valueOf(OK.ordinal()),
				LocalDate.now()));
	}
}
