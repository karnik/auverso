package de.karnik.auverso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class BasicAuthConfiguration
    extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
    auth
        .inMemoryAuthentication()
        .withUser("user")
        .password("{noop}password")
        .roles("USER");
  }

  @Override
  protected void configure(HttpSecurity http)
      throws Exception {
    http.csrf().disable()
        .authorizeRequests()
        .antMatchers("/login").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .httpBasic();
  }

}