package cn.SkyShadow.dto.tp;

import cn.SkyShadow.enums.PhoneValidateEnum;

/**
 * 手机验证信息
 * Created by RichardW on 8/25/2016.
 */
public class PhoneValidateResult {
    private int result;
    private String resultInfo;

    /**
     * 获取验证结果码
     * @return 验证结果码
     */
    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    /**
     * 获取验证结果信息
     * @return 验证结果信息
     */
    public String getResultInfo() {
        return resultInfo;
    }

    public void setResultInfo(String resultInfo) {
        this.resultInfo = resultInfo;
    }

    public PhoneValidateResult(PhoneValidateEnum phoneValidateEnum) {
        this.result = phoneValidateEnum.getState();
        this.resultInfo = phoneValidateEnum.getStateInfo();
    }

    @Override
    public String toString() {
        return "PhoneValidateResult{" +
                "result=" + result +
                ", resultInfo='" + resultInfo + '\'' +
                '}';
    }
}
