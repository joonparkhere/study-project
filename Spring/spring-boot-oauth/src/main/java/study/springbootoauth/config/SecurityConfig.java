package study.springbootoauth.config;

import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import study.springbootoauth.domain.Role;
import study.springbootoauth.service.CustomOAuth2UserService;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable()
//                .headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated();

        http.logout()
                .logoutSuccessUrl("/");

        http.oauth2Login()
                .userInfoEndpoint().userService(customOAuth2UserService);
    }
}
