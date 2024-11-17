package com.skillconnect;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .cors() // Enable CORS
            .and()
            .csrf().disable() // Disable CSRF for now (you may want to configure this more securely later)
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/v1/**").permitAll() // Allow all requests to your API paths
                .anyRequest().authenticated() // Require authentication for other paths
            );

        return http.build();
    }

    @Bean
    public CorsFilter corsFilter() {
    	 UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:3000");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);
       
        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }
}
