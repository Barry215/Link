package cn.SkyShadow.dto.org;

import cn.SkyShadow.enums.CheckOrgNameResultEnum;

/**
 * 名称审查结果
 * Created by RichardW on 9/17/2016.
 */
public class CheckOrgNameResult {
    private CheckOrgNameResultEnum checkOrgNameResultEnum;

    public CheckOrgNameResult(CheckOrgNameResultEnum checkOrgNameResultEnum) {
        this.checkOrgNameResultEnum = checkOrgNameResultEnum;
    }
}
