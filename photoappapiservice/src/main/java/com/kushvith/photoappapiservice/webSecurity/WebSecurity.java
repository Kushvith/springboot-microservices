package com.kushvith.photoappapiservice.webSecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import com.kushvith.photoappapiservice.service.userService;

import jakarta.ws.rs.HttpMethod;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class WebSecurity {
    private userService userservice;
    @Bean
    protected SecurityFilterChain configure(HttpSecurity http) throws Exception{
       AuthenticationManagerBuilder authenticationManagerBuilder =
         http.getSharedObject(AuthenticationManagerBuilder.class);
        //  authenticationManagerBuilder.userDetailsService(userservice);
        AuthenticationManager authenticationManager = authenticationManagerBuilder.build();
        http
            .csrf(csrf -> csrf.disable()) // Disable CSRF protection for simplicity
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers(HttpMethod.POST, "/user").permitAll()
                    .anyRequest().authenticated()
            )
            .addFilter(new AuthenticationFilter(authenticationManager))
            .authenticationManager(authenticationManager)
            .formLogin(form -> form
                .loginPage("/login")
                .permitAll()
            ).httpBasic(httpbasic -> {})
            
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();

        
    }
}
