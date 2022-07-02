package com.bikerent.config;

import com.bikerent.application.ports.outbound.UserOutboundPort;
import com.bikerent.application.services.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {

    @Bean
    public UserService userService(UserOutboundPort userOutboundPort) {
        return new UserService(userOutboundPort);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new Argon2PasswordEncoder();
    }

}
