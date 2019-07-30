package com.fengwenyi.wyf_security_core.validate.core;

import org.springframework.security.core.AuthenticationException;

/**
 * 验证码校验异常
 * @author Erwin Feng
 * @since 2019-07-30 12:20
 */
public class ValidateCodeException extends AuthenticationException {

    private static final long serialVersionUID = 2926819364371913258L;

    public ValidateCodeException(String explanation) {
        super(explanation);
    }
}
