package cn.SkyShadow.basic_component;

import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.enums.OperationByAuthorityEnum;

/**
 * 操作拦截器，控制用户能否进行当前的操作
 * Created by RichardW on 9/18/2016.
 */
public interface OperationInterceptor {
    /**
     * 检查权限
     * @param userId 用户ID
     * @param opera 操作
     * @return 操作权限
     */
    OperationAuthorityEnum check(Long userId, OperationByAuthorityEnum opera);
    /**
     * 检查是否有完全权限
     * @param userId 用户ID
     * @param opera 操作
     * @return 操作权限
     */
    boolean checkFull(Long userId, OperationByAuthorityEnum opera);
    /**
     * 检查是否有申请权限
     * @param userId 用户ID
     * @param opera 操作
     * @return 操作权限
     */
    boolean checkApply_AVAIl(Long userId, OperationByAuthorityEnum opera);
    /**
     * 检查是否没有权限
     * @param userId 用户ID
     * @param opera 操作
     * @return 操作权限
     */
    boolean checkNULL(Long userId, OperationByAuthorityEnum opera);
}
