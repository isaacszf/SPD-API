package com.isaacszf.spd.authentication;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.isaacszf.spd.domain.manager.ManagerRepository;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TokenFilter extends OncePerRequestFilter {
  @Autowired
  private TokenService tokenService;

  @Autowired
  private ManagerRepository managerRepository;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
        String token;
        
        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
          try {
            token = authHeader.replace("Bearer ", "");

            var subject = tokenService.getSubject(token);
            var manager = managerRepository.findByUsername(subject);
            var auth = new UsernamePasswordAuthenticationToken(manager, null, manager.getAuthorities());
            
            SecurityContextHolder.getContext().setAuthentication(auth);
          } catch (AccessDeniedException | JWTDecodeException | TokenExpiredException e) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Access Denied");

            return;
          }
        }

        filterChain.doFilter(request, response);
  }
}
