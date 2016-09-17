package cn.SkyShadow.basic_component.Impl;

import cn.SkyShadow.basic_component.CheckOrgName;
import cn.SkyShadow.dto.factory.CheckOrgNameResultFactory;
import cn.SkyShadow.dto.org.CheckOrgNameResult;
import cn.SkyShadow.enums.CheckOrgNameResultEnum;

/**
 * 检查
 * Created by RichardW on 9/17/2016.
 */
public class CheckOrgNameComponent implements CheckOrgName{
    @Override
    public CheckOrgNameResult check(String name) {
        return CheckOrgNameResultFactory.CreateResult(CheckOrgNameResultEnum.SUCCESS);
    }
}
