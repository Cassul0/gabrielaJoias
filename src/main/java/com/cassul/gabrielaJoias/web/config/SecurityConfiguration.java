package com.cassul.gabrielaJoias.web.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

import com.cassul.gabrielaJoias.service.UsuarioService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	private UsuarioService usuarioService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		return httpSecurity
				.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(configuracao -> {
					configuracao.requestMatchers("/h2-console/**").permitAll();
					configuracao.requestMatchers("/**").hasRole("ADMIN");
					configuracao.anyRequest().authenticated();
				})
				.formLogin(form -> {form
					.loginPage("/login")
					.successHandler(new AuthenticationSuccessHandler())
					.failureHandler(new SimpleUrlAuthenticationFailureHandler() {
					        @Override
					        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
					                AuthenticationException exception) throws IOException, ServletException {
					            String email = request.getParameter("username");
					            String error = exception.getMessage();
					            System.out.println("A failed login attempt with email: "
					                                + email + ". Reason: " + error);
					             
					            super.setDefaultFailureUrl("/login?error");
					            super.onAuthenticationFailure(request, response, exception);
					        }
					    })
					.permitAll();
				})
				.build();
	}
	
	@Bean
	public UserDetailsService userDetailsService() {
		return usuarioService;
	}
	
	@Bean 
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(usuarioService);
		provider.setPasswordEncoder(passwordEncoder());
		return provider;
	}
	
	@Bean public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder(); 
	}
	 
	
	/*
	 * protected void configureGlobal(AuthenticationManagerBuilder auth) throws
	 * Exception { auth .userDetailsService(usuarioService)
	 * .passwordEncoder(passwordEncoder()); }
	 */
}
