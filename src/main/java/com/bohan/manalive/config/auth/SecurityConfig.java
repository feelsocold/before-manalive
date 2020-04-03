package com.bohan.manalive.config.auth;

import com.bohan.manalive.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity          // Spring Security 설정들을 활성화시킨다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    // URL 별 권한 관리를 설정하는 옵션의 시작점
                    .authorizeRequests()
                        .antMatchers("/", "/assets/**", "/custom/**", "/main", "/register", "/test",
                                "/h2-console/**", "/profile").permitAll()
                        .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                        .anyRequest().permitAll()
//                authenticated()
                .and()
                    .logout()
                     .logoutSuccessUrl("/")
                .and()
                 //OAuth2 로그인 기능에 대한 여러 설정의 진입점
                    .oauth2Login()
                        .userInfoEndpoint()
                            .userService(customOAuth2UserService);


    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}
