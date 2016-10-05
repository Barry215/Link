package cn.SkyShadow.model.apply.applyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.apply.Apply;

/**
 * 创建组织
 * Created by Richard on 16/10/4.
 */
public class CreateDepartment extends Apply{
    private Organization fatherOrganization;
    private boolean isFatherTypeOrganization;
    private Organization department;

    public Organization getFatherOrganization() {
        return fatherOrganization;
    }

    public void setFatherOrganization(Organization fatherOrganization) {
        this.fatherOrganization = fatherOrganization;
    }

    public boolean isFatherTypeOrganization() {
        return isFatherTypeOrganization;
    }

    public void setFatherTypeOrganization(boolean fatherTypeOrganization) {
        isFatherTypeOrganization = fatherTypeOrganization;
    }

    public Organization getDepartment() {
        return department;
    }

    public void setDepartment(Organization department) {
        this.department = department;
    }
}
