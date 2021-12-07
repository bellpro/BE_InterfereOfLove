package com.example.loveadviser.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 스프링 Security 지원을 가능하게 함
@EnableGlobalMethodSecurity(securedEnabled = true) // @Secured 어노테이션 활성화
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public BCryptPasswordEncoder encodePassword() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) {
        web
                .ignoring()
                .antMatchers("/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        // 아래처럼 하면 해당되는 URL에 대해서만 무시, 위처럼 하면 다 무시.
//                .ignoringAntMatchers("/user/**").ignoringAntMatchers("/api/write")
//                .ignoringAntMatchers("/api/sign_up/check_dup").ignoringAntMatchers("/user/signup");

        http.authorizeRequests()
//                 회원 관리 처리 API 전부를 login 없이 허용
                .antMatchers("/user/**").permitAll()
                .antMatchers("/signup").permitAll()
                .antMatchers("/user/signup").permitAll()
                .antMatchers("/login/**").permitAll()
                .antMatchers("/api/**").permitAll()
                // Swagger
                .antMatchers("/swagger-ui.html", "/swagger/**", "/swagger-resources/**", "/webjars/**", "/v2/api-docs").permitAll()
                // 그 외 어떤 요청이든 '인증'
                .anyRequest().authenticated()
                .and()
                    // [로그인 기능]
                    .formLogin()
                    // 로그인 처리 후 성공 시 URL
                    .defaultSuccessUrl("/")
                    // 로그인 처리 (POST /user/login)
                    .loginProcessingUrl("/user/login")
                    .permitAll()
                .and()
                    // [로그아웃 기능]
                    .logout()
                    // 로그아웃 요청 처리 URL
                    .logoutUrl("/user/logout")
                    .permitAll()
                .and()
                    // "접근 불가" 페이지 URL 설정
                    .exceptionHandling()
                    .accessDeniedPage("/forbidden.html");
    }
}