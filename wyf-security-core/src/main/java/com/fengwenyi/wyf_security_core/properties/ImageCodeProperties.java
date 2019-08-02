package com.fengwenyi.wyf_security_core.properties;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片验证码配置属性
 * @author Erwin Feng
 * @since 2019-08-01 18:10
 */
@Getter
@Setter
public class ImageCodeProperties {

    /** 图片宽度 */
    private int width = 67;

    /** 图片高度 */
    private int height = 23;

    /** 验证码长度 */
    private int length = 4;

    /** 验证码有效时间（单位：秒） */
    private int expireIn = 60;

    /** 待验证的验证码地址，多个用逗号隔开 */
    private String url;

}
