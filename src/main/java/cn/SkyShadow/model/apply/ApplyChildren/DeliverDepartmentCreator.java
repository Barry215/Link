package cn.SkyShadow.model.apply.ApplyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;
import cn.SkyShadow.model.apply.Apply;

/**
 * 转移组织的创建者
 * Created by RichardW on 9/22/2016.
 */
public class DeliverDepartmentCreator extends Apply {
    private User creator;
    private Organization organization;

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
