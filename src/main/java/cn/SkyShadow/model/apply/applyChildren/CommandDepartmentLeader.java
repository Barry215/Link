package cn.SkyShadow.model.apply.applyChildren;

import cn.SkyShadow.model.User;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.model.Organization;

/**
 * 制定部门领导者
 * Created by RichardW on 9/21/2016.
 */
public class CommandDepartmentLeader extends Apply {
    private Organization department;
    private User u;

    public Organization getDepartment() {
        return department;
    }

    public void setDepartment(Organization department) {
        this.department = department;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }
}
