package cn.SkyShadow.service;

import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.model.apply.Apply;

/**
 * 申请拦截器
 * Created by RichardW on 9/12/2016.
 */
public interface ApplyInterceptor<T extends Apply> {
    OperationAuthorityEnum getOperationAuthorityEnum(T apply);
}
