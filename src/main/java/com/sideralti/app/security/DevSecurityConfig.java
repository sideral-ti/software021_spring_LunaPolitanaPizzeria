package com.sideralti.app.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

@Configuration
@Profile("dev")  // Solo se activa en perfil de desarrollo
public class DevSecurityConfig {

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring()
                .requestMatchers("/**");  // Ignora la seguridad para todas las rutas en desarrollo
    }
}