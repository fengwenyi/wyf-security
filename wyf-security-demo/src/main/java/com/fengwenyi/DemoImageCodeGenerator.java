package com.fengwenyi;

import com.fengwenyi.wyf_security_core.validate.core.ImageCode;
import com.fengwenyi.wyf_security_core.validate.core.ValidateCodeGenerator;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequest;

/**
 * 更高级的图形验证码生成器
 * @author Erwin Feng
 * @since 2019-08-02 15:21
 * @deprecated {@link com.fengwenyi.wyf_security_demo.code.DemoImageCodeGenerator}
 */
@Deprecated
//@Component("imageCodeGenerator")
public class DemoImageCodeGenerator implements ValidateCodeGenerator {
    @Override
    public ImageCode generate(ServletRequest request) {
        return null;
    }
}
