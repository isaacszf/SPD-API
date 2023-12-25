package com.isaacszf.spd.authentication;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.isaacszf.spd.domain.manager.Manager;
import com.isaacszf.spd.handlers.ApplicationException;

@Service
public class TokenService {
  @Value("${api.jwt.secret}")
  private String secret;
  private final String ISSUER = "spd-api"; 

  public String getSubject(String token) throws ApplicationException {
      return JWT.require(Algorithm.HMAC256(secret))
        .withIssuer(ISSUER)
        .build()
        .verify(token)
        .getSubject();  
  }

  public String generateToken(Manager manager) {
    return JWT.create()
      .withIssuer(ISSUER)
      .withSubject(manager.getUsername())
      .withClaim("id", manager.getId().toString())
      .withExpiresAt(this.generateExpirationDate(60 * 5))
      .sign(Algorithm.HMAC256(secret));
  }

  private Instant generateExpirationDate(int minutes) {
    return LocalDateTime.now().plusMinutes(minutes).toInstant(ZoneOffset.of("-03:00"));
  }
}
