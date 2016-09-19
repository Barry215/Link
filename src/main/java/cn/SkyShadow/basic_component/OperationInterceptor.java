package cn.SkyShadow.basic_component;

import cn.SkyShadow.dto.opera.OperaObject;
import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.enums.OperationByAuthorityEnum;

/**
 * 操作拦截器，控制用户能否进行当前的操作
 * Created by RichardW on 9/18/2016.
 */
public interface OperationInterceptor {
    /**
     * 检查权限
     * @param operaObject 操作对象
     * @param opera 操作
     * @return 操作权限
     */
    OperationAuthorityEnum check(OperaObject operaObject, OperationByAuthorityEnum opera);
    /**
     * 检查是否有完全权限
     * @param operaObject 操作对象
     * @param opera 操作
     * @return 操作权限
     */
    boolean checkFull(OperaObject operaObject, OperationByAuthorityEnum opera);
    /**
     * 检查是否有申请权限
     * @param operaObject 操作对象
     * @param opera 操作
     * @return 操作权限
     */
    boolean checkApply_AVAIl(OperaObject operaObject, OperationByAuthorityEnum opera);
    /**
     * 检查是否没有权限
     * @param operaObject 操作对象
     * @param opera 操作
     * @return 操作权限
     */
    boolean checkNULL(OperaObject operaObject, OperationByAuthorityEnum opera);
}
