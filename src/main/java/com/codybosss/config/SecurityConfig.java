package com.codybosss.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authz -> authz
                .requestMatchers("/public/**").permitAll() // Allow access to /public/** URLs without authentication
                .anyRequest().authenticated() // Require authentication for all other requests
            )
            .formLogin(form -> form // Configuring form-based login
                .loginPage("/login") // Custom login page (optional)
                .permitAll() // Allow everyone to see the login page
            );
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withDefaultPasswordEncoder() // Set up a user with default password encoder
            .username("user") // Username: user
            .password("password") // Password: password
            .roles("USER") // Role: USER
            .build());
        return manager;
    }
}
