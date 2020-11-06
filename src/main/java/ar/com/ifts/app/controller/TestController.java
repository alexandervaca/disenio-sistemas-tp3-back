package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ar.com.ifts.app.model.output.Response;

@RestController
@RequestMapping(value = "/api")
public class TestController {

	@GetMapping(value = "/test", produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<Response> login() throws JsonProcessingException {

		return ResponseEntity
				.ok(new Response("Test exitoso", String.valueOf(OK.ordinal()), LocalDate.now()));
	}
	
}
