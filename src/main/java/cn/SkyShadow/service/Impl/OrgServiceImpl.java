package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.Apply;
import cn.SkyShadow.model.Receipt;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.OrgService;

import java.util.List;

/**
 * Created by Richard on 16/8/31.
 * 组织管理器
 */
public class OrgServiceImpl implements OrgService {


    public Excution CreateNewOrg(organization org) {
        return null;
    }

    public Excution ModifyOrg(organization o) {
        return null;
    }

    public Excution ApplyParentOrg(organization o, organization parent, Apply a) {
        return null;
    }

    public Excution ApplyParentOrgCallBack(Receipt receipt) {
        return null;
    }

    public Excution ApplyUnlockParentOrg(organization o, Apply a) {
        return null;
    }

    public Excution ApplyUnlockParentOrgCallBack(Receipt r) {
        return null;
    }

    public Excution DiliverOrgNotWithSonOrg(organization o, user u, Apply a) {
        return null;
    }

    public Excution DeliverOrgWithSonOrg(organization o, user u, Apply a) {
        return null;
    }

    public Excution CreateDepartment(organization o) {
        return null;
    }

    public Excution ComandDeparementLeader(organization o, user u, Apply a) {
        return null;
    }

    public Excution ComandDeparementLeaderCallBack(Receipt r) {
        return null;
    }

    public Excution UnlockDeparementLeader(organization o) {
        return null;
    }

    public List<organization> SearchOrg(String str) {
        return null;
    }
}
