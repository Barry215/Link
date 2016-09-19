package cn.SkyShadow.dto.execution;


import cn.SkyShadow.model.organization;

/**
 * 组织创建结果
 * Created by Richard on 16/9/18.
 */
public class OrgCreateExecution extends Execution{
    private boolean isSuccess;

    public OrgCreateExecution(int resultNum, String resultInfo, organization obj, boolean isSuccess) {
        super(resultNum, resultInfo, obj);
        this.isSuccess = isSuccess;
    }

    public OrgCreateExecution(int resultNum, String resultInfo, boolean isSuccess) {
        super(resultNum, resultInfo);
        this.isSuccess = isSuccess;
    }

    public organization getOrg(){
        return (organization) super.getObj();
    }
}
