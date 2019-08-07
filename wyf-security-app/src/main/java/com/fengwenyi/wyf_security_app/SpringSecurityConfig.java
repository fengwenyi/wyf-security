package com.fengwenyi.wyf_security_app;

import com.fengwenyi.wyf_security_core.authentication.AbstractChannelSecurityConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

/**
 * @author Erwin Feng
 * @since 2019-08-07 11:52
 */
//@Configuration
public class SpringSecurityConfig extends AbstractChannelSecurityConfig {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.headers().frameOptions().disable();
        http.authorizeRequests()
                .antMatchers("/403").permitAll() // for test
                .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access", "/appManager").permitAll() // for login
                .antMatchers("/image", "/js/**", "/fonts/**").permitAll() // for login
                .antMatchers("/j_spring_security_check").permitAll()
                .antMatchers("/oauth/authorize").authenticated();
        /*.anyRequest().fullyAuthenticated();*/
        http.formLogin().loginPage("/login").failureUrl("/login?error").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and().logout().invalidateHttpSession(true)
//                .and().sessionManagement().maximumSessions(1).expiredUrl("/login?expired").sessionRegistry(sessionRegistry());
        ;
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        http.rememberMe().disable();
        http.httpBasic();
    }
}
