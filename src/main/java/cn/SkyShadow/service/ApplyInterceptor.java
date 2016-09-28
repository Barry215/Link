package cn.SkyShadow.service;

import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.model.apply.Receipt;

/**
 * 申请拦截器
 * Created by RichardW on 9/12/2016.
 */
public interface ApplyInterceptor<T extends Apply> {
    /**
     * 是否能够申请
     * @param apply 申请
     * @return 三种可能的结果
     */
    OperationAuthorityEnum getOperationAuthorityEnum(T apply);

    /**
     * 是否能够处理申请
     * @param receipt 执行结果
     * @return 是或者否
     */
    OperationAuthorityEnum HasAuthorityToReceipt(Receipt receipt);
}
