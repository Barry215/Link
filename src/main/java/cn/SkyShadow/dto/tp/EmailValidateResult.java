package cn.SkyShadow.dto.tp;

import cn.SkyShadow.enums.EmailValidateEnum;

/**
 * 邮箱验证信息
 * Created by RichardW on 8/25/2016.
 */
public class EmailValidateResult {
    private int result;
    private String resultInfo;
    /**
     * 获取返回码
     * @return 返回码
     */
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    /**
     * 获取返回信息
     * @return 返回信息
     */
    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public EmailValidateResult(EmailValidateEnum emailValidateEnum) {
        this.result = emailValidateEnum.getState();
        this.resultInfo = emailValidateEnum.getStateInfo();
    }

    @Override
    public String toString() {
        return "EmailValidateResult{" +
                "result=" + result +
                ", resultInfo='" + resultInfo + '\'' +
                '}';
    }
}
