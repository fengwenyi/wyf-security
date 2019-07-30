package com.fengwenyi.wyf_security_browser.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Erwin Feng
 * @since 2019-07-29 17:29
 */
@RestController
@RequestMapping("/user")
public class UserController {

    // 获取当前登录用户信息
    /*@GetMapping("/me")
    @ResponseBody
    public Object getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication();
    }*/

    /*@GetMapping("/me")
    @ResponseBody
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }*/

    @GetMapping("/me")
    @ResponseBody
    public Object getCurrentUser(@AuthenticationPrincipal UserDetails user) {
        return user;
    }

}
