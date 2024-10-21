package com.scm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

@Configuration
public class SecurityConfig {

  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    return daoAuthenticationProvider;
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
