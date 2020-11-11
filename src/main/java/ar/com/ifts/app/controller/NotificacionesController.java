package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;

import java.time.LocalDate;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.exception.NotificacionesServiceException;
import ar.com.ifts.app.model.output.GetNotificacionesResponse;
import ar.com.ifts.app.model.output.dto.NotificacionBuilder;
import ar.com.ifts.app.services.NotificacionesService;

@RestController
@RequestMapping(value = "/api")
public class NotificacionesController {

	@Autowired
	private NotificacionesService notificacionesService;

	@PreAuthorize("hasRole('ROLE_PROVEEDOR')")
	@GetMapping(value = "/notificaciones")
	public ResponseEntity<GetNotificacionesResponse> getProveedoresPorCategoria(HttpServletRequest http) throws NotificacionesServiceException {
		return ResponseEntity.ok()
				.body(new GetNotificacionesResponse("Consulta de notificaciones exitosa.", String.valueOf(OK.ordinal()),
						LocalDate.now(),
						notificacionesService.obtenerNotificacionesPorProveedor(http).stream()
								.map(elem -> new NotificacionBuilder().setNotificacion(elem).build())
								.collect(Collectors.toList())));
	}
}
