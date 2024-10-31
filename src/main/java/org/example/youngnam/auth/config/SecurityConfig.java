package org.example.youngnam.auth.config;

import lombok.RequiredArgsConstructor;
import org.example.youngnam.auth.exception.ExceptionHandlerFilter;
import org.example.youngnam.auth.exception.JwtAuthenticationEntryPoint;
import org.example.youngnam.auth.filter.JwtAuthenticationFilter;
import org.example.youngnam.auth.jwt.JwtProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtProvider jwtProvider;
    private final ExceptionHandlerFilter exceptionHandlerFilter;
    private final CorsConfig corsConfig;
    private static final String[] whiteList = {
            "/users/login",
            "/actuator/health",
            "/swagger-ui/**",
            "/error",
            "/v3/api-docs/**"
//            "/api/v1/member/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .cors(cors -> cors.configurationSource(corsConfig.corsConfigurationSource())) // CORS 설정 추가
                .csrf(AbstractHttpConfigurer::disable)
                .formLogin(AbstractHttpConfigurer::disable)
                .httpBasic(AbstractHttpConfigurer::disable)
                .sessionManagement(sessionManagementConfigurer ->
                        sessionManagementConfigurer
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .exceptionHandling(
                        exceptionHandlingConfigurer -> exceptionHandlingConfigurer.authenticationEntryPoint(jwtAuthenticationEntryPoint))
                .authorizeHttpRequests(
                        authorizationManagerRequestMatcherRegistry ->
                                authorizationManagerRequestMatcherRegistry
                                        .requestMatchers(whiteList).permitAll()
                                        .anyRequest()
                                        .authenticated())
                .addFilterBefore(new JwtAuthenticationFilter(jwtProvider), UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(exceptionHandlerFilter, JwtAuthenticationFilter.class)
                .build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return web -> web.ignoring().requestMatchers(whiteList);
    }
}
