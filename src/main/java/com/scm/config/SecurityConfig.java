package com.scm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.scm.services.impl.SecurityCustomUserDetailService;

@Configuration
public class SecurityConfig {

  @Autowired
  private SecurityCustomUserDetailService userDetailService;

  @Bean
  public DaoAuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
    daoAuthenticationProvider.setUserDetailsService(userDetailService);
    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthenticationProvider;
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    // configuration
    httpSecurity.authorizeHttpRequests(authorize -> {
      // authorize.requestMatchers("/home", "/register", "/login").permitAll();
      authorize.requestMatchers("/user/**").authenticated();
      authorize.anyRequest().permitAll();
    });

    httpSecurity.formLogin(formLogin -> {
      formLogin.loginPage("/login");
      formLogin.loginProcessingUrl("/authenticate");
      formLogin.successForwardUrl("/user/dashboard");
      formLogin.failureForwardUrl("/login?error=true");
      formLogin.usernameParameter("email");
      formLogin.passwordParameter("password");

    });

    return httpSecurity.build();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

}
