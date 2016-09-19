package cn.SkyShadow.dto.tp;

import cn.SkyShadow.enums.ResultMapper;

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

    public PhoneValidateResult(ResultMapper ResultMapper) {
        this.result = ResultMapper.getCode();
        this.resultInfo = ResultMapper.getInfo();
    }

    @Override
    public String toString() {
        return "PhoneValidateResult{" +
                "result=" + result +
                ", resultInfo='" + resultInfo + '\'' +
                '}';
    }
}
