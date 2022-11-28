package com.example.servingwebcontent;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class WebSecurityConfig {
        public class SecurityConfig {

                @Bean
                public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
                        http.formLogin(login -> login
                                .loginProcessingUrl("/login")
                                .loginPage("/loginForm")
                                .defaultSuccessUrl("/attendanceList")
                                .failureUrl("/login?error")
                                .permitAll()
                        ).logout(logout -> logout
                                .logoutSuccessUrl("/")
                        ).authorizeHttpRequests(authz -> authz
                                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()
                                .mvcMatchers("/").permitAll()
                                .mvcMatchers("/general").hasRole("GENERAL")
                                .mvcMatchers("/admin").hasRole("ADMIN")
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