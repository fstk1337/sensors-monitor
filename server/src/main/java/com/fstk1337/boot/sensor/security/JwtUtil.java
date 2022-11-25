package com.fstk1337.boot.sensor.security;

import com.fstk1337.boot.sensor.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static java.util.Base64.getDecoder;

@Service
@Slf4j
public class JwtUtil {
    @Value("${boot.sensor.jwt.secret}")
    private String SECRET_KEY;
    @Value("${boot.sensor.jwt.expire}")
    private int EXPIRE_MS;

    public String generateToken(User userDetails) {
        HashMap<String, Object> claims = new HashMap<>();
        String role = userDetails.getAuthorities().iterator().next().getAuthority();
        log.info(role);
        claims.put("role", role);
        return createToken(claims, userDetails.getUsername());
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        String decodedKey = new String(getDecoder().decode(SECRET_KEY));
        return Jwts.parser().setSigningKey(decodedKey).parseClaimsJws(token).getBody().getSubject();
    }

    private String createToken(Map<String, Object> claims, String subject) {
        String decodedKey = new String(getDecoder().decode(SECRET_KEY));
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_MS))
                .signWith(SignatureAlgorithm.HS256, decodedKey)
                .compact();
    }

    private boolean isTokenExpired(String token) {
        String decodedKey = new String(getDecoder().decode(SECRET_KEY));
        Date expiration = Jwts.parser().setSigningKey(decodedKey).parseClaimsJws(token).getBody().getExpiration();
        return expiration.before(new Date());
    }

}
