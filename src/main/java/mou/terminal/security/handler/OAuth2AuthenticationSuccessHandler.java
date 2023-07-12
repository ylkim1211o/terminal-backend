package mou.terminal.security.handler;

import lombok.RequiredArgsConstructor;
import mou.terminal.security.domain.JwtAuthToken;
import mou.terminal.security.properties.OauthProperties;
import mou.terminal.security.provider.JwtTokenProvider;
import mou.terminal.security.userInfo.GoogleUserInfo;
import mou.terminal.util.CookieUtil;
import mou.terminal.web.domain.mysql.auth.UserRefreshToken;
import mou.terminal.web.repository.mysql.auth.UserRefreshTokenRepo;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtTokenProvider jwtTokenProvider;
    private final OauthProperties oauthProperties;
    private final UserRefreshTokenRepo userRefreshTokenRepo;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String targetUrl = determineTargetUrl(request, response, authentication);
        if (response.isCommitted()) {
            logger.debug("Response has already been committed. Unable to redirect to " + targetUrl);
            return;
        }

        super.clearAuthenticationAttributes(request);
        getRedirectStrategy().sendRedirect(request, response, this.processSuccess(request,response,authentication));

    }

    private String processSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication){

    // target 정하기

        GoogleUserInfo googleUserInfo = new GoogleUserInfo(((OidcUser) authentication.getPrincipal()).getAttributes());

        Date now = new Date();

        JwtAuthToken accessToken = this.jwtTokenProvider.createAuthToken(googleUserInfo.getId(),"ROLE_USER",
                new Date(now.getTime() + oauthProperties.getTokenExpire()));

        JwtAuthToken refreshToken = this.jwtTokenProvider.createAuthToken(oauthProperties.getTokenSecrete()
                ,new Date(now.getTime() + oauthProperties.getRefreshTokenExpire())
        );

        UserRefreshToken userRefreshToken =  this.userRefreshTokenRepo.findByUserId(googleUserInfo.getId());

        if(userRefreshToken!= null) {
            userRefreshToken.setRefreshToken(refreshToken.getToken());
        }
        else {
            userRefreshToken = new UserRefreshToken(googleUserInfo.getId(), refreshToken.getToken());
            this.userRefreshTokenRepo.saveAndFlush(userRefreshToken);
        }

        int cookieMaxAge = (int) (oauthProperties.getRefreshTokenExpire() / 60);

        CookieUtil.deleteCookie(request, response, "refresh_token");
        CookieUtil.addCookie(response, "refresh_token", refreshToken.getToken(), cookieMaxAge);

        return UriComponentsBuilder.fromUriString("/success")
                .queryParam("token",accessToken.getToken()  )
                .build().toUriString();
    }

}
