package com.example.demo.config;

import java.util.Collections;
import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;


import jakarta.servlet.http.HttpServletRequest;

@Configuration
@EnableWebSecurity
public class AppConfig {
	@Bean //only after annotating with bean the spring security will use this method
	SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http.sessionManagement(
				management -> management.sessionCreationPolicy( // what this does is it does not store anything in the server and while renderng the jwt is stored in the header and local storage that is why?
						
						SessionCreationPolicy.STATELESS)).authorizeHttpRequests(Authorize -> Authorize.requestMatchers("/api/**").authenticated().anyRequest().permitAll())
		.addFilterBefore(new jwtValidator(), BasicAuthenticationFilter.class)
//		//.httpBasic().and()
		.csrf(csrf -> csrf.disable()).cors(cors->cors.configurationSource(corsConfigurationSource()));		
		return http.build();
	}
	
	private CorsConfigurationSource corsConfigurationSource() {
		// TODO Auto-generated method stub
		return new CorsConfigurationSource() {
			
			@Override
			public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
				CorsConfiguration cfg = new CorsConfiguration();
				cfg.setAllowedOrigins(Arrays.asList(
						"http://localhost:3000/",
						"http://localhost:3001/",
						"http://localhost:3002/")); // set the frontend url
				cfg.setAllowedMethods(Collections.singletonList("*"));
				cfg.setAllowCredentials(true);
				cfg.setAllowedHeaders(Collections.singletonList("*"));
				cfg.setExposedHeaders(Arrays.asList(
						"Authorization"));
				cfg.setMaxAge(3600L);
				
				return cfg;
			}
		};
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
