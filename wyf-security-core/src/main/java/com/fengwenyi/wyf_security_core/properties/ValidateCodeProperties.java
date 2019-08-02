package com.fengwenyi.wyf_security_core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 验证码
 * @author Erwin Feng
 * @since 2019-08-01 18:14
 */
@Getter
@Setter
public class ValidateCodeProperties {

    /** 图片验证码 */
    private ImageCodeProperties image = new ImageCodeProperties();

}
