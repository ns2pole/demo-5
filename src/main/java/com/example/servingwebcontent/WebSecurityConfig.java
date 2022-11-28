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
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

        private MyUserService userService;
        
        @Autowired
        public WebSecurityConfig (MyUserService userService) {
                this.userService = userService;
        }
        
        // URLパス毎に制御
        @Override
        public void configure(HttpSecurity http) throws Exception{
                http
                .authorizeRequests()
                .antMatchers("/js/**", "/css/**", "/loginForm").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/attendanceList", true)
                .failureUrl("/loginForm?error=true")
                        .and()
                .logout()
                .permitAll();
        }
        
        // ユーザ情報の取得
        @Override
        public void configure(AuthenticationManagerBuilder auth) throws Exception{
                auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
        }
        
        // パスワードハッシュ化する
        public BCryptPasswordEncoder passwordEncoder() {
                BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
                return bcpe;
        }
        
        @Bean
        public UserDetailsService userDetailsService() {
                PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
                User.UserBuilder userBuilder = User.builder().passwordEncoder(encoder::encode);
                UserDetails user = userBuilder.username("user").password("password")
                                        .roles("USER").build();
                UserDetails admin = userBuilder.username("admin").password("password")
                                        .roles("ADMIN").build();
                return new InMemoryUserDetailsManager(user, admin);
        }
}