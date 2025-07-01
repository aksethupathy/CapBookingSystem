package ObjecjClass;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTToken {

	private String secret ="SethuCabBookingService";
	private long expiry = 1000 * 60 * 60;
	
	public String GenerateToket(String email)
	{
		
	
			return Jwts.builder()
					.setSubject(email)
					.setIssuedAt(new Date())
					.setExpiration(new Date(System.currentTimeMillis() +expiry))
					.signWith(SignatureAlgorithm.HS256,secret).compact();
	}
			  public String extractUsername(String token) {
			        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
			    }

			    public boolean validateToken(String token, String email) {
			        return extractUsername(token).equals(email);
			    }
		 
		 
		
	}

