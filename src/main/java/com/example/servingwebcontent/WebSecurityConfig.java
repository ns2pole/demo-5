package com.example.servingwebcontent;

import com.example.servingwebcontent.Handler.MyAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig {
        public class SecurityConfig {

                @Bean
                public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                        http.formLogin(login -> login
                                .loginProcessingUrl("/login")
                                .loginPage("/")
                                .failureUrl("/")
                                .permitAll()
                        ).logout(logout -> logout
                                .logoutSuccessUrl("/")
                        ).authorizeHttpRequests(authz -> authz
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .mvcMatchers("/").permitAll()
                                .mvcMatchers("/users").hasRole("ADMIN")
                                .mvcMatchers("/divisions").hasRole("ADMIN")
                                .mvcMatchers("/masterWorkPlaces").hasRole("ADMIN")
                                .anyRequest().authenticated()
                        ).formLogin().successHandler(new MyAuthenticationSuccessHandler());
                        return http.build();
                }

                @Bean
                public PasswordEncoder passwordEncoder() {
                        return new BCryptPasswordEncoder();
                }
        }       
}