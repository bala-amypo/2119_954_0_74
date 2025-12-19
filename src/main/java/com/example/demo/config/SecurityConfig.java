package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http
            // disable CSRF (needed for POST/PUT from Swagger & curl)
            .csrf(csrf -> csrf.disable())

            // enable CORS (uses your CorsConfig)
            .cors(cors -> {})

            // disable login form + basic auth
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable())

            // allow ALL requests
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            );

        return http.build();
    }
}
