package com.example.filedemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
     @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.passwordEncoder(NoOpPasswordEncoder.getInstance())
		.withUser("hara").password("test").roles("USER").and().
		withUser("bapi").password("get").roles("ADMIN");
	}
	
	
	
	 // @Override
	  //protected void configure(HttpSecurity httpSecurity) throws Exception {
	  
	  //httpSecurity
	  //.authorizeRequests()
	 //.antMatchers("/uploadFile")
	 //.anyRequest()
	 //.authenticated()
	 //.permitAll()
	 //.fullyAuthenticated().
	 //.and()
		//.formLogin().loginPage("/login").permitAll();
	 
		/*
		 * httpSecurity.csrf().disable() .logout(). logoutRequestMatcher(new
		 * AntPathRequestMatcher("/logout")) .logoutSuccessUrl("/login");
		 */
	 //}
     
     @Override
     protected void configure(HttpSecurity http) throws Exception {
         http
                 .csrf().disable()
                 .authorizeRequests()
                 .antMatchers("/static/**", "/registration", "/movies/**").permitAll()
                 .anyRequest().authenticated()
                 .and()
                 .formLogin()
                 .defaultSuccessUrl("/indx", true)
                 .loginPage("/login")
                 .permitAll()
                 .and()
                 .logout().invalidateHttpSession(true)
                 .clearAuthentication(true)
                 .permitAll();
     }
     
     
     
	 
	
	
}
