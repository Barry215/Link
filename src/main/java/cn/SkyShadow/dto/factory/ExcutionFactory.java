package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.dto.excution.OrgCreateExecution;
import cn.SkyShadow.enums.OrgCreateResultEnum;
import cn.SkyShadow.model.organization;

/**
 * Excution工厂
 * Created by RichardW on 9/14/2016.
 */
public class ExcutionFactory {
    public static Execution GetExcutionByResultCode(int resultCode){
        return new Execution(resultCode,"操作已执行");
    }
    public static Execution GetExcutionByResultCode(int resultCode, String info){
        return new Execution(resultCode,info);
    }
    public static Execution GetExcutionByResultCode(int resultCode, String info, Object obj){
        return new Execution(resultCode,info,obj);
    }
    public static OrgCreateExecution getOrgCreateExecution_True(OrgCreateResultEnum orgCreateResultEnum, organization o){
        return new OrgCreateExecution(orgCreateResultEnum.getCode(),orgCreateResultEnum.getInfo(),o,true);
    }
    public static OrgCreateExecution getOrgCreateExecution_False(OrgCreateResultEnum orgCreateResultEnum){
        return new OrgCreateExecution(orgCreateResultEnum.getCode(),orgCreateResultEnum.getInfo(),false);
    }
}
