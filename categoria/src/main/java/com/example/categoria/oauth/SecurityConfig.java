package com.example.categoria.oauth;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((oauthHttp) -> oauthHttp
                        .requestMatchers(HttpMethod.GET, "/authorized", "/login").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/categoria/**").hasAnyAuthority("SCOPE_read", "Scope_write")
                        .requestMatchers(HttpMethod.POST, "/api/categoria").hasAuthority("SCOPE_write")
                        .requestMatchers(HttpMethod.PUT,"/api/categoria/**").hasAuthority("SCOPE_write")
                        .requestMatchers(HttpMethod.DELETE, "/api/categoria/**").hasAuthority("SCOPE_write")
                        .anyRequest().authenticated())
                .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2Login((login)->login.loginPage("/oauth2/authorization/category"))
                .oauth2Client(Customizer.withDefaults())
                .oauth2ResourceServer(oauth2 ->oauth2
                        .jwt(Customizer.withDefaults()));
        return http.build();
    }
}
