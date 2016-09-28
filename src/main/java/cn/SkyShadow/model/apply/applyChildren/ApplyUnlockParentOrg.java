package cn.SkyShadow.model.apply.applyChildren;

import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.apply.Apply;

/**
 * 解除父组织关系
 * Created by RichardW on 9/21/2016.
 */
public class ApplyUnlockParentOrg extends Apply{
    private Organization son;
    private Organization father;

    public Organization getSon() {
        return son;
    }

    public void setSon(Organization son) {
        this.son = son;
    }

    public Organization getFather() {
        return father;
    }

    public void setFather(Organization father) {
        this.father = father;
    }
}
