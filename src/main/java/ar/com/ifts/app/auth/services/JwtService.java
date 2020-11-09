package ar.com.ifts.app.auth.services;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtService {
	
	private static final String BEARER = "Bearer ";

	@Value("${jwt.key}")
	private String key;
	
	@Value("${jwt.expiration.miliseconds}")
	private Integer expirationMiliseconds;

	public String getUsernameFromToken(String token) {
		return getClaimsFromToken(token).getSubject();
	}
	
	public Date getExpirationFromToken(String token) {
		return getClaimsFromToken(token).getExpiration();
	}
	
	public Boolean isTokenExpired(String token) {
		return getExpirationFromToken(token).before(new Date());
	}
	
	private Claims getClaimsFromToken(String token) {
		String tokenWithoutBearer = deleteBearer(token);
		return Jwts.parser().setSigningKey(key).parseClaimsJws(tokenWithoutBearer).getBody();
	}
	
	public String deleteBearer(String token) {
		return token.replace(BEARER, "");
	}
	
	public String generateToken(UserDetails user) {
		if (!user.isEnabled()) {
			throw new DisabledException("Usuario deshabilitado. Por favor contacte con un administrador.");
		}
		Claims claims = Jwts.claims();
		claims.put("authorities", user.getAuthorities());
		claims.put("username", user.getUsername());
		
		Date createDate = new Date();
		Date expireDate = new Date(createDate.getTime() + expirationMiliseconds);
		
		String jwt = Jwts.builder()
		.setClaims(claims)
		.setSubject(user.getUsername())
		.setIssuedAt(createDate)
		.setExpiration(expireDate)
		.signWith(SignatureAlgorithm.HS512, key)
		.compact();
		
		return new StringBuilder(BEARER).append(jwt).toString();
	}
	
	public Boolean isValidToken(String token) {
		return token != null &&
				token.startsWith(BEARER);
	}
}
