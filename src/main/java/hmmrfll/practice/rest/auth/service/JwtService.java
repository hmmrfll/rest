package hmmrfll.practice.rest.auth.service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;


public interface JwtService {
    String generateToken(UserDetails userDetails);
    String generateToken(Map<String, Objects> extractClaims, UserDetails userDetails);
    String extractUsername(String token);
    <T> T extractClaims(String token, Function<Claims, T> claimResolver);
    Claims extractAllClaims(String token);
    Key getSignInKey();
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
    Date extractExpired(String token);
}
