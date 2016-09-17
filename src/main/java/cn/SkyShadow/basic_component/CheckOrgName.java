package cn.SkyShadow.basic_component;

import cn.SkyShadow.dto.org.CheckOrgNameResult;

/**
 * 组织名审核
 * Created by RichardW on 9/17/2016.
 */
public interface CheckOrgName {
    CheckOrgNameResult check(String name);
}
