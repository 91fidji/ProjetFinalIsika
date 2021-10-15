package fr.isika.al9.microserviceUser.security.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.sun.org.apache.xml.internal.security.algorithms.SignatureAlgorithm;

import fr.isika.al9.microserviceUser.security.services.UserDetailsImpl;

@Component
public class JwtUtils {
	private static final Logger log = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${travelQuote.app.secret}")
	private String jwtSecret;
	
	@Value("${travelQuote.app.jwtExpirationMs}")
	private int jwtExpirationMs;

	public String generateJwtToken(Authentication authentication) {
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();
		return Jwts.builder()
				.setSubject((userPrincipal.getEmail()))
				.setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime()+jwtExpirationMs))
				.signinWith(SignatureAlgorithm.HS512, jwtSecret)
				.compact();
	}
	
	public String getUserEmailFromJwtToken() {
		return Jwts.parser().setSigninKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
	}

	public String getEmailFromJwtToken(String jwt) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigninKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch(Exception e) {
			log.error("Invalid JWT signature: {}", e.getMessage());
		}
		return false;
	}

}
