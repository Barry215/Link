package cn.SkyShadow.basic_component.Impl;

import cn.SkyShadow.basic_component.OperationInterceptor;
import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.enums.OperationByAuthorityEnum;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 操作拦截器，控制用户能否进行当前的操作
 * Created by RichardW on 9/18/2016.
 */
@Transactional
@Service
public class OperationInterceptorImpl implements OperationInterceptor {
    @Override
    public OperationAuthorityEnum check(Long userId, OperationByAuthorityEnum opera) {
        return OperationAuthorityEnum.FULL;
    }

    @Override
    public boolean checkFull(Long userId, OperationByAuthorityEnum opera) {
        if (check(userId,opera)==OperationAuthorityEnum.FULL){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkApply_AVAIl(Long userId, OperationByAuthorityEnum opera) {
        if (check(userId,opera)==OperationAuthorityEnum.APPLY_AVAILABLE){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkNULL(Long userId, OperationByAuthorityEnum opera) {
        if (check(userId,opera)==OperationAuthorityEnum.NULL){
            return true;
        }
        return false;
    }
}
