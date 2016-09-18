package cn.SkyShadow.dto.excution;

/**
 * 登录结果
 * Created by Richard on 16/9/18.
 */
public class LoginStateExecution extends Execution{

    public LoginStateExecution(int resultNum, String resultInfo, Object obj) {
        super(resultNum, resultInfo, obj);
    }

    public LoginStateExecution(int resultNum, String resultInfo) {
        super(resultNum, resultInfo);
    }
}
