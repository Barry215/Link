package cn.SkyShadow.model.apply.applyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.apply.Apply;

/**
 * 修改组织信息
 * Created by RichardW on 9/28/2016.
 */
public class ModifyOrganization extends Apply {
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
