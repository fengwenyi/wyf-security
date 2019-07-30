package com.fengwenyi.wyf_security_browser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Erwin Feng
 * @since 2019-07-27 23:40
 */
@Controller
@RequestMapping("/view")
public class ViewController {

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/demo-login.html")
    public String demoLogin() {
        return "demo-login";
    }

}
