package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.demo.security.ApplicationUserRole.*;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class ApplicationSecutityConfig {

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ApplicationSecutityConfig(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests((authz) ->
                        authz
                        .requestMatchers("index.html","/").permitAll()
                        .requestMatchers("/api/**").hasRole(STUDENT.name())
                        .anyRequest().authenticated()
                )
                .httpBasic(withDefaults());
        return http.build();
    }

    @Bean
    UserDetailsService customUserDetailsService() {

        UserDetails someoneUser = User.builder()
                .username("Someone")
                .password(passwordEncoder.encode("password"))
                .roles(STUDENT.name())
                .build();

        UserDetails someAdminUser = User.builder()
                .username("Some Admin User")
                .password(passwordEncoder.encode("password123"))
                .roles(ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(
                someoneUser,
                someAdminUser
        );
    }

}
