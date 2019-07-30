package com.fengwenyi.wyf_security_core.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Erwin Feng
 * @since 2019-07-27 23:23
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "wyf.security")
public class SecurityProperties {

    private BrowserProperties browser = new BrowserProperties();

}
