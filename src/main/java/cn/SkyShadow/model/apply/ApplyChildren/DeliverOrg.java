package cn.SkyShadow.model.apply.ApplyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;
import cn.SkyShadow.model.apply.Apply;

/**
 * 转移组织
 * Created by RichardW on 9/21/2016.
 */
public class DeliverOrg extends Apply{
    private Organization organization;
    private User u;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
