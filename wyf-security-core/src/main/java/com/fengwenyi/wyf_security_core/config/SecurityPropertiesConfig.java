package com.fengwenyi.wyf_security_core.config;

import com.fengwenyi.wyf_security_core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author Erwin Feng
 * @since 2019-07-27 23:30
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityPropertiesConfig {
}
