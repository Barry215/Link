package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.org.CheckOrgNameResult;
import cn.SkyShadow.enums.CheckOrgNameResultEnum;

/**
 * 名称审查结果工厂
 * Created by RichardW on 9/17/2016.
 */
public class CheckOrgNameResultFactory {
    public static CheckOrgNameResult CreateResult(CheckOrgNameResultEnum resultEnum){
        return new CheckOrgNameResult(resultEnum);
    }
}
