package cn.SkyShadow.model.apply.applyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.apply.Apply;

/**
 * 修改组织信息
 * Created by RichardW on 9/28/2016.
 */
public class ModifyDepartment extends Apply {
    private Organization department;

    public Organization getDepartment() {
        return department;
    }

    public void setDepartment(Organization department) {
        this.department = department;
    }
}
