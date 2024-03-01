package dev.dani.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private static final String[] AUTH_WHITELIST = {
            "/api/**",
    };
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize ->
                        authorize.anyRequest().permitAll() // Autoriser tous les accès à /api/**
                        //.anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                );
                //.httpBasic(httpSecurityHttpBasicConfigurer -> httpSecurityHttpBasicConfigurer.configure()); // Utiliser l'authentification HTTP Basic pour l'exemple (à adapter selon les besoins)
        return http.build();
    }
}