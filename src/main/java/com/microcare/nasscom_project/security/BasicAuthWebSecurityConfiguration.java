package com.microcare.nasscom_project.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class BasicAuthWebSecurityConfiguration {

  @Autowired
  private AppBasicAuthenticationEntryPoint authenticationEntryPoint;
  
  @Autowired
  UserDetailsService userDetailsService;
  @Bean
  public AuthenticationManager authManager(HttpSecurity http) throws Exception {
      return http.getSharedObject(AuthenticationManagerBuilder.class)
          .authenticationProvider(authProvider())
          .build();
  }
  @Bean
  public DaoAuthenticationProvider authProvider() {
      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
      authProvider.setUserDetailsService(userDetailsService);
      authProvider.setPasswordEncoder(encoder());
      return authProvider;
  }

  
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
    .authorizeHttpRequests
    (expressionInterceptUrlRegistry 
    -> expressionInterceptUrlRegistry
    .requestMatchers("/register/user*").permitAll()
    //.requestMatchers(HttpMethod.GET, ".order/**")
    .anyRequest().authenticated())
    
   /*.httpBasic(httpSecurityHttpBasicConfigurer 
    		-> httpSecurityHttpBasicConfigurer
    		.authenticationEntryPoint(authenticationEntryPoint));
       // .anyMatchers("/public").permitAll()
       // .requestMatchers("/product/**").permitAll()*/
        
     //.and()
        .httpBasic()
        .authenticationEntryPoint(authenticationEntryPoint);
   http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
    return http.build();
  }
  
  @Bean
  public PasswordEncoder encoder() {
      return new BCryptPasswordEncoder();
  }

  
}
