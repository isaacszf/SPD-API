package com.isaacszf.spd.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.isaacszf.spd.domain.manager.ManagerRepository;

@Service
public class AuthenticationService implements UserDetailsService {
  @Autowired
  private ManagerRepository managerRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return managerRepository.findByUsername(username);
  }
}
