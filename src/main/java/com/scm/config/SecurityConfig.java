package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.scm.services.impl.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {

  @Autowired
  private SecurityCustomUserDetailService userDetailService;

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    // daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  // @Bean
  // public UserDetailsService userDetailsService() {
  // UserDetails user1 = User
  // .withDefaultPasswordEncoder()
  // .username("admin123")
  // .password("admin123")
  // .roles("ADMIN", "USER")
  // .build();

  // UserDetails user2 = User
  // .withDefaultPasswordEncoder()
  // .username("Harshit")+
  // .password("Harshit")
  // // .roles("ADMIN", "USER")
  // .build();
  // var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1,
  // user2);
  // return inMemoryUserDetailsManager;
  // }
}
