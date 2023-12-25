package com.isaacszf.spd.domain.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isaacszf.spd.authentication.TokenService;
import com.isaacszf.spd.handlers.ApplicationException;


@RestController
@RequestMapping("/api/auth")
public class ManagerController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private ManagerRepository managerRepository;

  @Autowired
  private TokenService tokenService;

  @PostMapping("/add")
  public ResponseEntity<?> add(@RequestBody ManagerDTO data) {
    var encoder = new BCryptPasswordEncoder();
    String encryptedPassword = encoder.encode(data.getPassword());
    Manager manager = new Manager(data.getUsername(), encryptedPassword);

    try {
      managerRepository.save(manager);
      return ResponseEntity.ok("manager added");
    } catch (DataIntegrityViolationException e) {
      throw new ApplicationException("username already exists", HttpStatus.BAD_REQUEST);
    }
  }

  @PostMapping("/login")
  public ResponseEntity<String> login(@RequestBody ManagerDTO data) {
    var managerPassword = new UsernamePasswordAuthenticationToken(data.getUsername(), data.getPassword());

    try {
      var auth = authenticationManager.authenticate(managerPassword);
      var manager = (Manager) auth.getPrincipal();

      String token = tokenService.generateToken(manager);

      return ResponseEntity.ok(token);
    } catch (Exception e) {
      throw new ApplicationException("failed to authenticate", HttpStatus.FORBIDDEN);
    }
  }
}
