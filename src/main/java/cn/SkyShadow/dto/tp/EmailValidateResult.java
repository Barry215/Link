package cn.SkyShadow.dto.tp;

import cn.SkyShadow.enums.EmailValidateEnum;

/**
 * Created by RichardW on 8/25/2016.
 */
public class EmailValidateResult {
    private int result;
    private String resultInfo;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

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
