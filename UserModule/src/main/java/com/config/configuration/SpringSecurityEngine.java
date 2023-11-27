package com.config.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SpringSecurityEngine{
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
//	@Bean
//	public UserDetailsService getDetailsService() {
//		return new CustomUserDetailsService();
//	}
	
//	@Bean
//	public DaoAuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
//		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
//		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
//		return daoAuthenticationProvider;
//	}
//	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeHttpRequests()
//		.requestMatchers("/").permitAll().anyRequest().authenticated();
//		return http.build();
        

		
        
		http.authorizeHttpRequests ((requests) ->
		requests.requestMatchers (new AntPathRequestMatcher("/")).permitAll()
		.anyRequest().authenticated())
		
		.csrf(csrf -> csrf.disable())
		.httpBasic(withDefaults()); 
		return http.build();
        
        
//		http.authorizeHttpRequests((requests) ->
//	    requests
//	        .requestMatchers(new AntPathRequestMatcher("/")).permitAll()
//	        .requestMatchers("/welcome").hasRole("ADMIN")
//	        .anyRequest().authenticated())
//	    .csrf(csrf -> csrf.disable())
//	    .httpBasic(withDefaults()); 
//	return http.build();
        
        


//	http.authorizeHttpRequests((requests) ->
//    requests
//    	.requestMatchers(new AntPathRequestMatcher("/")).hasRole("USER")
//        .requestMatchers(new AntPathRequestMatcher("/welcome")).hasRole("ADMIN")
//        .anyRequest().authenticated())
//    	.csrf().disable()
//    	.httpBasic(withDefaults()); 
//	return http.build();

	}
	
}
