package com.fengwenyi.wyf_security_core.validate.core;

import javax.servlet.ServletRequest;

/**
 * 校验码的生成器
 * @author Erwin Feng
 * @since 2019-08-02 15:05
 */
public interface ValidateCodeGenerator {

    ImageCode generate(ServletRequest request);

}
