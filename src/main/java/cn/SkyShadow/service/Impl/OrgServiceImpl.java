package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dto.file.FileList;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.OrgService;

import java.util.List;

/**
 * Created by Richard on 16/8/31.
 * 组织管理器
 */
public class OrgServiceImpl implements OrgService {


    @Override
    public Excution CreateNewOrg(organization org) {
        return null;
    }

    @Override
    public Excution ModifyOrg(organization o) {
        return null;
    }

    @Override
    public Excution ApplyParentOrg(Apply a) {
        return null;
    }

    @Override
    public Excution ApplyParentOrgCallBack(Receipt r) {
        return null;
    }

    @Override
    public Excution RollBackApplyParentOrg(Long applyId) {
        return null;
    }

    @Override
    public Excution ApplyUnlockParentOrg(Apply a) {
        return null;
    }

    @Override
    public Excution RollBackApplyUnlockParentOrg(Long applyId) {
        return null;
    }

    @Override
    public Excution ApplyUnlockParentOrgCallBack(Receipt r) {
        return null;
    }

    @Override
    public Excution RollBackApplyUnlockParentOrgCallBack(Long applyId) {
        return null;
    }

    @Override
    public Excution DiliverOrgNotWithSonOrg(Apply a) {
        return null;
    }

    @Override
    public Excution CreateDepartment(organization o) {
        return null;
    }

    @Override
    public Excution ComandDeparementLeader(Apply a) {
        return null;
    }

    @Override
    public Excution ComandDeparementLeaderCallBack(Receipt r) {
        return null;
    }

    @Override
    public Excution UnlockDeparementLeader(organization o) {
        return null;
    }

    @Override
    public List<organization> SearchOrg(String str) {
        return null;
    }

}
