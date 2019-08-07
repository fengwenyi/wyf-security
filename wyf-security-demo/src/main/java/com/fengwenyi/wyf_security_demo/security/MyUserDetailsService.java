package com.fengwenyi.wyf_security_demo.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 获取用户信息
 * @author Erwin Feng
 * @since 2019-07-26 17:02
 */
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("登录用户名：{}", username);

        // 根据用户名查询用户信息

        // 根据查找到的用户信息判断用户是否被冻结


        // 返回 UserDetails
//        return new User(username,
//                "12345",
//                AuthorityUtils
//                        .commaSeparatedStringToAuthorityList("admin"));

        return new User(username,
                passwordEncoder.encode("123456"),
                true, true, true, true,
                AuthorityUtils.commaSeparatedStringToAuthorityList("admin,user"));
    }
}
