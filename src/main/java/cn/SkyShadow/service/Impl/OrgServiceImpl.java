package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dao.organizationMapper;
import cn.SkyShadow.dao.locationMapper;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by Richard on 16/8/31.
 * 组织管理器
 */
public class OrgServiceImpl implements OrgService {

    private final organizationMapper organizationMapper;
    private final locationMapper lMapper;
    private final ApplyMapper applyMapper;
    private final ReceiptMapper receiptMapper;

    @Autowired(required = false)
    public OrgServiceImpl(cn.SkyShadow.dao.organizationMapper organizationMapper, locationMapper lMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper) {
        this.organizationMapper = organizationMapper;
        this.lMapper = lMapper;
        this.applyMapper = applyMapper;
        this.receiptMapper = receiptMapper;
    }




    @Override
    public Excution CreateNewOrg(organization org) {
        if (org == null) {
            return new Excution(0, "组织信息为空");
        }
        if (org.getCreatorId() == null || org.getCreatorId().getUserId() == 0L) {
            return new Excution(-1, "用户名为空");
        }
        if (org.getName().length() > 255 || org.getName().length() < 6) {
            return new Excution(-2, "组织姓名长度为6-255个字符");
        }
        if (HasOrgName(org.getName())) {
            return new Excution(-3, "组织名被占用");
        }
        if (org.getOrgId() != 0L) {
            organization fatherOrg = organizationMapper.selectBaseInfo(org.getOrgId());
            if (fatherOrg == null) {
                return new Excution(-4, "父组织不存在");
            }
        }
        if (org.getLocation() == null) {
            return new Excution(-5, "请填写地点");
        }
        location location = lMapper.selectByPrimaryKey(org.getLocation().getLocationId());
        if (location == null){
            return new Excution(-6, "地点不存在");
        }
        int result = organizationMapper.insert(org);
        return new Excution(result,"操作已执行");
    }

    @Override
    public Excution ModifyOrg(organization o) {
        int result = organizationMapper.updateByPrimaryKeySelective(o);
        return new Excution(result,"操作已执行");
    }

    @Override
    public Excution ApplyParentOrg(Apply a) {
        int result = applyMapper.Create(a);
        return new Excution(result,"操作已执行");
    }

    @Override
    public Excution ApplyParentOrgCallBack(Receipt r) {
        int result = receiptMapper.Create(r);
        return new Excution(result,"操作已执行");
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

    @Override
    public Excution DeleteOrg(Long ID) {
        return null;
    }

    @Override
    public boolean HasOrgName(String Name) {
        return false;
    }

}
