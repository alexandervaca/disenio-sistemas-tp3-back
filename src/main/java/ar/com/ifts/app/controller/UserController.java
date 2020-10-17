package ar.com.ifts.app.controller;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.time.LocalDate;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import ar.com.ifts.app.auth.services.JwtService;
import ar.com.ifts.app.auth.services.UserDetailServiceImpl;
import ar.com.ifts.app.exception.RegisterException;
import ar.com.ifts.app.model.input.RequestLoginBody;
import ar.com.ifts.app.model.input.RequestRegisterBody;
import ar.com.ifts.app.model.output.LoginResponse;
import ar.com.ifts.app.model.output.RegisterResponse;

@RestController
@RequestMapping(value = "/api")
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtService jwtService;

	@Autowired
	private UserDetailServiceImpl userDetailService;

	@PostMapping(value = "/login",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginResponse> login(@Valid @RequestBody RequestLoginBody requestLoginBody)
			throws JsonProcessingException {
		String username = requestLoginBody.getUsername();
		String password = requestLoginBody.getPassword();
		
		this.authenticate(username, password);

		UserDetails user = userDetailService.loadUserByUsername(username);

		String token = jwtService.generateToken(user);

		return ResponseEntity
				.ok(new LoginResponse("Logín exitoso", String.valueOf(OK.ordinal()), LocalDate.now(), token));
	}
	
	@PostMapping(value = "/register",consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RequestRegisterBody requestRegisterBody) throws RegisterException {
		
		userDetailService.registerUser(requestRegisterBody);
		
		return ResponseEntity.ok(new RegisterResponse("Registro exitoso", String.valueOf(OK.ordinal()), LocalDate.now()));
	}

	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}
}
