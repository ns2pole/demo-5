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
                        );
                        return http.build();
                }

                @Bean
                public PasswordEncoder passwordEncoder() {
                        return new BCryptPasswordEncoder();
                }
        }
//        // URLパス毎に制御
//        @Override
//        public void configure(HttpSecurity http) throws Exception{
//                http
//                .authorizeRequests()
//                .antMatchers("/js/**", "/css/**", "/loginForm").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/loginForm")
//                .loginProcessingUrl("/login")
//                .failureUrl("/loginForm?error=true")
//                .and()
//                .logout()
//                .permitAll();
//        }
//
//        // ユーザ情報の取得
//        @Override
//        public void configure(AuthenticationManagerBuilder auth) throws Exception{
//                auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//        }
//
//        // パスワードハッシュ化する
//        public BCryptPasswordEncoder passwordEncoder() {
//                BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
//                return bcpe;
//        }
        
}