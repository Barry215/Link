package cn.SkyShadow.service;

import cn.SkyShadow.dto.exception.NoApplyInterceptor;
import cn.SkyShadow.enums.ApplyModel;
import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.service.Impl.ApplyInterceptorImpl;


/**
 * 请求处理器
 * Created by RichardW on 9/25/2016.
 */
public abstract class ApplyHandler<T extends Apply> {
    private ApplyInterceptor<T> applyInterceptor;

    protected ApplyHandler() {
        this.applyInterceptor = new ApplyInterceptorImpl<>();
    }

    public abstract ResultMapper doSomeThing_FULL(T apply);
    public abstract ResultMapper doSomeThing_APPLY_AVAILABLE(T apply);
    private ResultMapper doSomeThing_NULL(){
        return ResultMapper.NeedAuthority;
    }
    public final ResultMapper handler(T apply, ApplyModel applyModel){
        if (applyInterceptor==null){
            throw new NoApplyInterceptor("需要写入请求拦截器");
        }
        else{
            OperationAuthorityEnum op = applyInterceptor.getOperationAuthorityEnum(apply);
            if (applyModel==ApplyModel.DIRECT){
                if (op==OperationAuthorityEnum.FULL){
                    return doSomeThing_FULL(apply);
                }
                else if (op==OperationAuthorityEnum.APPLY_AVAILABLE){
                    return ResultMapper.NoApply;
                }
                else{
                    return doSomeThing_NULL();
                }
            }
            if (applyModel==ApplyModel.APPLY_MODEL){
                if (op==OperationAuthorityEnum.APPLY_AVAILABLE||op==OperationAuthorityEnum.FULL){
                    return doSomeThing_APPLY_AVAILABLE(apply);
                }else{
                    return doSomeThing_NULL();
                }
            }
        }
        return ResultMapper.DB_ERROR;
    }
}
