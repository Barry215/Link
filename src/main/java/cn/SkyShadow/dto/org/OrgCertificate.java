package cn.SkyShadow.dto.org;

import cn.SkyShadow.model.occupation;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

/**
 * 组织证件类
 * Created by Richard on 16/9/19.
 */
public class OrgCertificate {
    private user baseInfo;
    private organization baseOrg;
    private boolean isCreator;
    private boolean isAdmin;
    private boolean isInOrg;
    private occupation[] occupations;

    public user getBaseInfo() {
        return baseInfo;
    }

    public void setBaseInfo(user baseInfo) {
        this.baseInfo = baseInfo;
    }

    public organization getBaseOrg() {
        return baseOrg;
    }

    public void setBaseOrg(organization baseOrg) {
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

    public occupation[] getOccupations() {
        return occupations;
    }

    public void setOccupations(occupation[] occupations) {
        this.occupations = occupations;
    }
}
