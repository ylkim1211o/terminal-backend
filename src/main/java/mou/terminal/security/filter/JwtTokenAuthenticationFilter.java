package mou.terminal.security.filter;

import lombok.RequiredArgsConstructor;
import mou.terminal.security.domain.JwtAuthToken;
import mou.terminal.security.provider.JwtTokenProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {

    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {

            String strJwtToken = getJwtFromHeader(request);

            if(strJwtToken != null) {

                JwtAuthToken jwtToken = jwtTokenProvider.createAuthToken(strJwtToken);

                Authentication authentication = jwtTokenProvider.authentication(jwtToken);

                SecurityContextHolder.getContext().setAuthentication(authentication);

            }
        }
        catch (Exception e){

        }

        filterChain.doFilter(request,response);

    }

    private String getJwtFromHeader(HttpServletRequest request){

        String value = request.getHeader("Authorization");

        if (StringUtils.hasText(value) && value.startsWith("Bearer ")) {
            return value.substring(7, value.length());
        }
        return null;
    }
}


