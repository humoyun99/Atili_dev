package com.example.atili.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
@EnableWebSecurity
public class SpringSecurtyUtil {
    @Bean
    public AuthenticationProvider authenticationProvider() {
        // authentication (login,password)
        return null;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // authorization (ROLE)
        http.authorizeHttpRequests((c) ->
                c.requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("/api/v1/news/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/v1/region/lang").permitAll()
                        .requestMatchers("/api/v1/attach/**").permitAll()
                        .requestMatchers("/api/v1/attach/admin/**").hasAnyRole("ADMIN", "MODERATOR")
                        .requestMatchers("/api/v1/region/admin", "/api/v1/region/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
        ).httpBasic(Customizer.withDefaults());

        http.csrf(AbstractHttpConfigurer::disable).cors(AbstractHttpConfigurer::disable);
        return http.build();
    }

    return null;
}
