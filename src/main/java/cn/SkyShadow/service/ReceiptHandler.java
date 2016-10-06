package cn.SkyShadow.service;

import cn.SkyShadow.enums.OperationAuthorityEnum;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.service.Impl.ApplyInterceptorImpl;


/**
 * 请求处理器
 * Created by RichardW on 9/25/2016.
 */
public abstract class ReceiptHandler<T extends Apply> {
    private ApplyInterceptor<T> applyInterceptor;
    protected Receipt<T> receipt;

    protected ReceiptHandler() {
        this.applyInterceptor = new ApplyInterceptorImpl<>();
    }
    public ResultMapper handler(Receipt<T> receipt){
        if (receipt==null){
            return ResultMapper.NULL_ERROR;
        }else{
            this.receipt = receipt;
            OperationAuthorityEnum op =applyInterceptor.HasAuthorityToReceipt(receipt);
            if (op== OperationAuthorityEnum.FULL){
                if (receipt.isSuccess()){
                    doIfAgree();
                }else{
                    doIfDisagree();
                }
                return ResultMapper.SUCCESS;
            }else if (op==OperationAuthorityEnum.NULL){
                return ResultMapper.NeedAuthority;
            }else if (op==OperationAuthorityEnum.APPLY_ALREADY_FINISHED){
                return ResultMapper.APPLY_ALREADY_FINISHED;
            }
        }
        return ResultMapper.DB_ERROR;
    }
    public abstract void doIfAgree();
    public abstract void doIfDisagree();
}
