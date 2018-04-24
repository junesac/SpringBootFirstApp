package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.inMemoryAuthentication().withUser("sachin").password("{noop}password").roles("USER");
    auth.inMemoryAuthentication().withUser("admin").password("{noop}password").roles("ADMIN");
    auth.inMemoryAuthentication().withUser("dba").password("{noop}password").roles("MANAGER");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.authorizeRequests().antMatchers("/activity/**")
        .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')").antMatchers("/info/**")
        .access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')").and().csrf().disable()
        .httpBasic();
    // .formLogin();

  }

}
