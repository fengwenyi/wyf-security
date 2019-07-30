package com.fengwenyi.wyf_security_core.validate.core;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * 图形验证码
 * @author Erwin Feng
 * @since 2019-07-30 10:49
 */
@Getter
public class ImageCode {

    /** 图片 */
    private BufferedImage image;

    /** 验证码 */
    private String code;

    /** 验证码过期时间 */
    private LocalDateTime expireTime;

    public ImageCode() {
    }

    /**
     * 构建ImageCode
     * @param image
     * @param code
     * @param expireTime 过期的时间点
     */
    public ImageCode(BufferedImage image, String code, LocalDateTime expireTime) {
        this.image = image;
        this.code = code;
        this.expireTime = expireTime;
    }

    // 验证码 在多少秒内过期

    /**
     * 构建ImageCode
     * @param image
     * @param code
     * @param expireIn 有效时间（秒）
     */
    public ImageCode(BufferedImage image, String code, int expireIn) {
        this.image = image;
        this.code = code;
        this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
    }

    // 验证码 是否已经过期
    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expireTime);
    }
}
