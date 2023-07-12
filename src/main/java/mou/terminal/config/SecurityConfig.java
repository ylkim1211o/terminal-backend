package mou.terminal.config;

import lombok.RequiredArgsConstructor;
import mou.terminal.security.handler.OAuth2AuthenticationFailHandler;
import mou.terminal.security.handler.OAuth2AuthenticationSuccessHandler;
import mou.terminal.security.properties.OauthProperties;
import mou.terminal.security.provider.JwtTokenProvider;
import mou.terminal.security.service.OauthUserInfoService;
import mou.terminal.web.repository.mysql.auth.UserRefreshTokenRepo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity(debug = true)
@RequiredArgsConstructor
public class SecurityConfig {

    private final OauthUserInfoService oauthUserInfoService;
    private final OauthProperties oauthProperties;
    private final JwtTokenProvider jwtTokenProvider;
    private final UserRefreshTokenRepo userRefreshTokenRepo;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception{

        http
                .cors()
                .and()
                .csrf().disable()
                .authorizeHttpRequests()
//                .mvcMatchers("/favicon.ico").permitAll()
                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .successHandler((request, response, authentication) -> {
//                    response.sendRedirect("/login/success");})
//                .failureHandler((request, response, exception) -> {
//                    response.sendRedirect("/login/fail");
//                })
                .and()
                .oauth2Login()
//                .loginPage("/login/aa")
                .authorizationEndpoint()
                .baseUri("/oauth2/authorization")
                .and()
                .redirectionEndpoint()
                .baseUri("/*/oauth2/code/*")
                .and()
                .userInfoEndpoint()
                .userService(oauthUserInfoService)
                .and()
                .successHandler(new OAuth2AuthenticationSuccessHandler(this.jwtTokenProvider,this.oauthProperties,this.userRefreshTokenRepo))
                .failureHandler(new OAuth2AuthenticationFailHandler());

        return http.build();
    }



    @Bean
    public UserDetailsService userDetailsServicez(){

        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("1234")
                .roles("ADMIN","USER")
                .build();

        return new InMemoryUserDetailsManager(user,admin);
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource(){

        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("http://localhost:3000");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource src = new UrlBasedCorsConfigurationSource();
        src.registerCorsConfiguration("/**",corsConfiguration);

        return src;

    }

}
