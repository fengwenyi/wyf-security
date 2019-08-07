package com.fengwenyi.wyf_security_core.support;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * @author Erwin Feng
 * @since 2019-07-27 23:04
 */
@Getter
@Accessors(chain = true)
public class SimpleResponse {

    private Object content;

    public SimpleResponse() {
    }

    public SimpleResponse(Object content) {
        this.content = content;
    }
}
