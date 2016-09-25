package cn.SkyShadow.service.Impl;

import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.service.ApplyInterceptor;

/**
 * 请求拦截器
 * Created by RichardW on 9/25/2016.
 */
public class ApplyInterceptorImpl<T extends Apply> implements ApplyInterceptor<T> {
    @Override
    public OperationAuthorityEnum getOperationAuthorityEnum(T apply) {
        return null;
    }
}
