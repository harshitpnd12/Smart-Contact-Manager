package com.scm.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import lombok.var;

@Configuration
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails user1 = User
        .withUsername("admin123")
        .password("admin123")
        .roles("ADMIN", "USER")
        .build();

    UserDetails user2 = User
        .withUsername("Harshit")
        .password("Harshit")
        // .roles("ADMIN", "USER")
        .build();
    var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1, user2);
    return inMemoryUserDetailsManager;
  }
}
