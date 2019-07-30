package com.fengwenyi.wyf_security_browser.config;

import com.fengwenyi.wyf_security_browser.authentication.MyAuthenticationFailureHandler;
import com.fengwenyi.wyf_security_browser.authentication.MyAuthenticationSuccessHandler;
import com.fengwenyi.wyf_security_core.properties.SecurityProperties;
import com.fengwenyi.wyf_security_core.validate.core.ValidateCodeFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security Config
 *
 * @author Erwin Feng
 * @since 2019-07-26 15:12
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private MyAuthenticationFailureHandler myAuthenticationFailureHandler;

    @Autowired
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
        validateCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

        http
                .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
                // 表单
                .formLogin()
                .loginPage("/authentication/require")
                .loginProcessingUrl("/authentication/form")
                .successHandler(myAuthenticationSuccessHandler)
                .failureHandler(myAuthenticationFailureHandler)
                // 弹窗
//                .httpBasic()
                .and()
                // 下面这些都是授权的配置
                .authorizeRequests()
                .antMatchers(
                        "/authentication/require"
                        , securityProperties.getBrowser().getLoginPage()
                        , "/code/image"
                ).permitAll()
                // 任何请求
                .anyRequest()
                // 都需要身份认证
                .authenticated()
                .and()
                .csrf().disable()
        ;
    }
}
