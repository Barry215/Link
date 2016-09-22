package cn.SkyShadow.dto.org;

import cn.SkyShadow.model.Occupation;
import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;

/**
 * 组织证件类
 * Created by Richard on 16/9/19.
 */
public class OrgCertificate {
    private User baseInfo;
    private Organization baseOrg;
    private boolean isCreator;
    private boolean isAdmin;
    private boolean isInOrg;
    private Occupation[] occupations;

    public User getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(User baseInfo) {
        this.baseInfo = baseInfo;
    }

    public Organization getBaseOrg() {
        return baseOrg;
    }

    public void setBaseOrg(Organization baseOrg) {
        this.baseOrg = baseOrg;
    }

    public boolean isCreator() {
        return isCreator;
    }

    public void setCreator(boolean creator) {
        isCreator = creator;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isInOrg() {
        return isInOrg;
    }

    public void setInOrg(boolean inOrg) {
        isInOrg = inOrg;
    }

    public Occupation[] getOccupations() {
        return occupations;
    }

    public void setOccupations(Occupation[] occupations) {
        this.occupations = occupations;
    }
}
