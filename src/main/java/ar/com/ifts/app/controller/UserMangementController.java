package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ifts.app.auth.services.JwtService;
import ar.com.ifts.app.auth.services.UserDetailServiceImpl;
import ar.com.ifts.app.exception.UserDetailServiceImplException;
import ar.com.ifts.app.model.input.RequestLoginBody;
import ar.com.ifts.app.model.input.RequestRegisterBody;
import ar.com.ifts.app.model.output.LoginResponse;
import ar.com.ifts.app.model.output.RegisterResponse;
import ar.com.ifts.app.model.output.Response;

@RestController
@RequestMapping(value = "/api")
public class UserMangementController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@PostMapping(value = "/login",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody RequestLoginBody requestLoginBody) {
		String username = requestLoginBody.getUsername();
		String password = requestLoginBody.getPassword();
		
		this.authenticate(username, password);

		UserDetails user = userDetailService.loadUserByUsername(username);

		String token = jwtService.generateToken(user);

		return ResponseEntity
				.ok(new LoginResponse("Logín exitoso", String.valueOf(OK.ordinal()),
						LocalDate.now(), token, user.getAuthorities().toString(), user.getUsername()));
	}
	
	@PostMapping(value = "/register",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RequestRegisterBody requestRegisterBody) throws UserDetailServiceImplException {
		
		userDetailService.registerUser(requestRegisterBody);
		
		return ResponseEntity.ok(new RegisterResponse("Registro exitoso", String.valueOf(OK.ordinal()), LocalDate.now()));
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping(value = "/cambio/estado/{id}")
	public ResponseEntity<Response> habilitarDeshabilitarUsuario(@PathVariable("id") Long idUsuario) throws UserDetailServiceImplException {
		boolean habilitado = userDetailService.habilitarDeshabilitarUsuario(idUsuario);
		String msj = (habilitado) ? "Se habilitó el usuario correctamente." : "Se deshabilitó el usuario correctamente.";
		return ResponseEntity.ok(new Response(msj, String.valueOf(OK.ordinal()), LocalDate.now()));
	}

	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
