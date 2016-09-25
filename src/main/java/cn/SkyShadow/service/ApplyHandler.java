package cn.SkyShadow.service;

import cn.SkyShadow.dto.exception.NoApplyInterceptor;
import cn.SkyShadow.enums.ApplyModel;
import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.Apply;


/**
 * 请求处理器
 * Created by RichardW on 9/25/2016.
 */
public abstract class ApplyHandler<T extends Apply> {
    private ApplyInterceptor<T> applyInterceptor;

    public final void setApplyInterceptor(ApplyInterceptor<T> applyInterceptor) {
        this.applyInterceptor = applyInterceptor;
    }

    abstract ResultMapper doSomeThing_FULL(T apply);
    abstract ResultMapper doSomeThing_APPLY_AVAILABLE(T apply);
    public ResultMapper doSomeThing_NULL(){
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
                    return ResultMapper.NeedAuthority;
                }
            }
            if (applyModel==ApplyModel.APPLY_MODEL){
                if (op==OperationAuthorityEnum.APPLY_AVAILABLE||op==OperationAuthorityEnum.FULL){
                    return doSomeThing_APPLY_AVAILABLE(apply);
                }else{
                    return ResultMapper.NeedAuthority;
                }
            }
        }
        return ResultMapper.DB_ERROR;
    }
}
