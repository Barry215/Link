package cn.SkyShadow.dto.exception;

import org.jetbrains.annotations.NonNls;

/**
 * 没有请求拦截器
 * Created by RichardW on 9/25/2016.
 */
public class NoApplyInterceptor extends RuntimeException {
    public NoApplyInterceptor(@NonNls String message) {
        super(message);
    }
}
