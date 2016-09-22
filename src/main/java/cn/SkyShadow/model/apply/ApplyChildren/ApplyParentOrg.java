package cn.SkyShadow.model.apply.ApplyChildren;

import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.model.Organization;

/**
 * 申请父组织
 * Created by RichardW on 9/21/2016.
 */
public class ApplyParentOrg extends Apply{
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
