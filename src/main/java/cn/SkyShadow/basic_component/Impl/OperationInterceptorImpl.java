package cn.SkyShadow.basic_component.Impl;

import cn.SkyShadow.basic_component.OperationInterceptor;
import cn.SkyShadow.dto.opera.OperaObject;
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
    public OperationAuthorityEnum check(OperaObject operaObject, OperationByAuthorityEnum opera) {
        return OperationAuthorityEnum.FULL;
        // TODO: 16/9/19  
    }

    @Override
    public boolean checkFull(OperaObject operaObject, OperationByAuthorityEnum opera) {
        if (check(operaObject,opera)==OperationAuthorityEnum.FULL){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkApply_AVAIl(OperaObject operaObject, OperationByAuthorityEnum opera) {
        if (check(operaObject,opera)==OperationAuthorityEnum.APPLY_AVAILABLE){
            return true;
        }
        return false;
    }

    @Override
    public boolean checkNULL(OperaObject operaObject, OperationByAuthorityEnum opera) {
        if (check(operaObject,opera)==OperationAuthorityEnum.NULL){
            return true;
        }
        return false;
    }
}
