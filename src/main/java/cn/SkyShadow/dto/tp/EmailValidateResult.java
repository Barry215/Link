package cn.SkyShadow.dto.tp;

import cn.SkyShadow.enums.ResultMapper;

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

    public EmailValidateResult(ResultMapper ResultMapper) {
        this.result = ResultMapper.getCode();
        this.resultInfo = ResultMapper.getInfo();
    }

    @Override
    public String toString() {
        return "EmailValidateResult{" +
                "result=" + result +
                ", resultInfo='" + resultInfo + '\'' +
                '}';
    }
}
