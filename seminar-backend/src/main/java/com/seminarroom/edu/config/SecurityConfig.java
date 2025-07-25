
package com.seminarroom.edu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .cors() // ✅ ENABLE CORS here
                .and()
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                         
                                 "/api/auth/**",
        "/api/courses/**",
        "/api/modules/**",
        "/api/modules/reading-materials/**",
        "/api/modules/video-lectures/**",
        "/api/modules/assignments/**",
        "/api/user/me",
        "/api/user/update",
          "/api/progress/**"
                              
                        ).permitAll()
                        .anyRequest().permitAll()

                )
                .httpBasic(); // or .formLogin() if using session auth

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
