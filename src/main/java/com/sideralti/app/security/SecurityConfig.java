package com.sideralti.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.Customizer;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Deshabilitamos CSRF para simplificar
                .authorizeHttpRequests(auth -> auth
                        // Permitir acceso a recursos estáticos
                        .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                        // Rutas públicas específicas
                        .requestMatchers("/", "/index", "/productos/**").permitAll()
                        // Cualquier otra ruta requiere autenticación
                        .anyRequest().authenticated()
                )
                // Configuración básica de formulario de login
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                // Configuración de logout
                .logout(logout -> logout
                        .permitAll()
                        .logoutSuccessUrl("/")
                );

        return http.build();
    }
}