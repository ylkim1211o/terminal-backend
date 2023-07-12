package mou.terminal.security.domain;

import io.jsonwebtoken.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;

@Slf4j
@Getter
@RequiredArgsConstructor
public class JwtAuthToken {

    private final String token;
    private final Key key;

    public JwtAuthToken(String id, Date expire, Key key){
        this.key = key;
        this.token = createAuthToken(id,expire);

    }

    public JwtAuthToken(String id, String role, Date expire, Key key){
        this.key = key;
        this.token = createAuthToken(id,role,expire);
    }

    private String createAuthToken(String id, Date expire) {
        return Jwts.builder()
                .setSubject(id)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(expire)
                .compact();
    }

    private String createAuthToken(String id, String role, Date exprieDate) {

        log.error("[ABC] key is "+key);

        return Jwts.builder()
                .setSubject(id)
                .claim("role", role)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(exprieDate)
                .compact();
    }

    public boolean validate() {
        return this.getTokenClaims() != null;
    }

    public Claims getTokenClaims() {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SecurityException e) {
            log.info("Invalid JWT signature.");
        } catch (MalformedJwtException e) {
            log.info("Invalid JWT token.");
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
        } catch (UnsupportedJwtException e) {
            log.info("Unsupported JWT token.");
        } catch (IllegalArgumentException e) {
            log.info("JWT token compact of handler are invalid.");
        }
        return null;
    }

    public Claims getExpiredTokenClaims() {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            log.info("Expired JWT token.");
            return e.getClaims();
        }
        return null;
    }

}
