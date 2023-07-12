package mou.terminal.config;

import mou.terminal.security.provider.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JwtConfig {

    @Value("${jwt.secret}")
    private String secret;

    @Bean
    public JwtTokenProvider jwtProvider() {
        return new JwtTokenProvider(secret);
    }
}