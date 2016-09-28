package cn.SkyShadow.service.Impl;

import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.service.ApplyInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * 请求拦截器
 * Created by RichardW on 9/25/2016.
 */
@Component
@Transactional
public class ApplyInterceptorImpl<T extends Apply> implements ApplyInterceptor<T> {
    @Override
    public OperationAuthorityEnum getOperationAuthorityEnum(T apply) {
        return OperationAuthorityEnum.FULL;
    }

    @Override
    public OperationAuthorityEnum HasAuthorityToReceipt(Receipt receipt) {
        return OperationAuthorityEnum.FULL;
    }
}
