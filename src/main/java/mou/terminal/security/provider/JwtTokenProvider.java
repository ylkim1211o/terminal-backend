package mou.terminal.security.provider;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import mou.terminal.security.domain.JwtAuthToken;
import mou.terminal.security.exception.TokenValidFailedException;
//import mou.terminal.web.domain.mysql.user.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

public class JwtTokenProvider {

    private final Key key;
    private static final String AUTHORITIES_KEY = "role";

    public JwtTokenProvider(String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public JwtAuthToken createAuthToken(String id, Date exprieDate) {
        return new JwtAuthToken(id, exprieDate, key);
    }

    public JwtAuthToken createAuthToken(String id, String role, Date exprieDate) {
        return new JwtAuthToken(id, role, exprieDate, key);
    }

    public JwtAuthToken createAuthToken(String token) {
        return new JwtAuthToken(token, key);
    }

    public Authentication authentication(JwtAuthToken jwtAuthToken){

        if (jwtAuthToken.validate()){
            Claims claims = jwtAuthToken.getTokenClaims();
            Collection<? extends GrantedAuthority> authorities =
                    Arrays.stream(new String[]{claims.get(AUTHORITIES_KEY).toString()})
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            return new UsernamePasswordAuthenticationToken(new User(claims.getSubject(),"",authorities),jwtAuthToken,authorities);
        }
        else {
            throw new TokenValidFailedException();
        }

    }


}
