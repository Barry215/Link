package cn.SkyShadow.model.apply.ApplyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;
import cn.SkyShadow.model.apply.Apply;

/**
 * 添加管理员
 * Created by RichardW on 9/22/2016.
 */
public class AddAdmin extends Apply {
    private User admin;
    private Organization organization;

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }
}
