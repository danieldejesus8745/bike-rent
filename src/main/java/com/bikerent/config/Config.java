package com.bikerent.config;

import com.bikerent.application.ports.outbound.BikeOutboundPort;
import com.bikerent.application.ports.outbound.TokenOutboundPort;
import com.bikerent.application.ports.outbound.UserOutboundPort;
import com.bikerent.application.services.BikeService;
import com.bikerent.application.services.TokenService;
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
    public TokenService tokenService(TokenOutboundPort tokenOutboundPort) {
        return new TokenService(tokenOutboundPort);
    }

    @Bean
    public BikeService bikeService(BikeOutboundPort bikeOutboundPort) {
        return new BikeService(bikeOutboundPort);
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new Argon2PasswordEncoder();
    }

}
