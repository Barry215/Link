package cn.SkyShadow.dto.execution;

/**
 * 修改组织基本信息结果
 * Created by Richard on 16/9/19.
 */
public class ModifyOrgExecution extends Execution{
    private boolean isSuccess;

    public ModifyOrgExecution(int resultNum, String resultInfo, Object obj, boolean isSuccess) {
        super(resultNum, resultInfo, obj);
        this.isSuccess = isSuccess;
    }

    public ModifyOrgExecution(int resultNum, String resultInfo, boolean isSuccess) {
        super(resultNum, resultInfo);
        this.isSuccess = isSuccess;
    }
}
