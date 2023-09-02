package uchuca.web.security.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    private static final String KEY = "uchuca";
    private static final long EXPIRATION_TIME = 86400000;
    public String generateToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);

        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date()).setExpiration(expiryDate).
                signWith(SignatureAlgorithm.HS256, KEY).compact();
    }


    public boolean validateToken(String token, UserDetails userDetails) {

        return userDetails.getUsername().equals(extracUsername(token)) && !isTokenExpired(token);

    }


    public boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    public String extracUsername(String token) {
        return getClaims(token).getSubject();
    }


    private Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }

}
