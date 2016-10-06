package cn.SkyShadow.model.apply.applyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.apply.Apply;

/**
 * 删除部门
 * Created by Richard on 16/10/4.
 */
public class DeleteDepartment extends Apply {
    private Organization department;

    public Organization getDepartment() {
        return department;
    }

    public void setDepartment(Organization department) {
        this.department = department;
    }
}
