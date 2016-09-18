package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.dao.organizationMapper;
import cn.SkyShadow.dao.locationMapper;
import cn.SkyShadow.dto.excution.OrgCreateExecution;
import cn.SkyShadow.dto.factory.ExecutionFactory;
import cn.SkyShadow.enums.OrgCreateResultEnum;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Richard on 16/8/31.
 * 组织管理器
 */
@Transactional
@Service
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
    public OrgCreateExecution CreateNewOrg(organization org) {
        if (org == null) {
            return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.NULL_ORG);
        }
        if (org.getCreatorId() == null || org.getCreatorId().getUserId() == 0L) {
            return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.NULL_USERID);
        }
        if (org.getName().length() > 255 || org.getName().length() < 6) {
            return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.FORMAT_NAME);
        }
        if (HasOrgName(org.getName()).equals("Y")) {
            return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.ILLEGAL_NAME);
        }
        if (org.getOrgId() != 0L) {
            organization fatherOrg = organizationMapper.selectBaseInfo(org.getOrgId());
            if (fatherOrg == null) {
                return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.ILLEGAL_PARENT);
            }
        }
        if (org.getLocation() == null) {
            return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.NULL_LOCATION);
        }
        location location = lMapper.selectByPrimaryKey(org.getLocation().getLocationId());
        if (location == null){
            return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.ILLEGAL_LOCATION);
        }
        int result = organizationMapper.insert(org);
        if (result==1) {
            return ExecutionFactory.getOrgCreateExecution_True(OrgCreateResultEnum.SUCCESS,org);
        }
        else{
            return ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.DB_ERROR);
        }
    }

    @Override
    public Execution ModifyOrg(organization o) {
        int result = organizationMapper.updateByPrimaryKeySelective(o);
        return ExecutionFactory.GetExcutionByResultCode(result,"操作已执行");
    }

    @Override
    public Execution ApplyParentOrg(Apply a) {
        int result = applyMapper.Create(a);
        return ExecutionFactory.GetExcutionByResultCode(result,"操作已执行");
    }

    @Override
    public Execution ApplyParentOrgCallBack(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.ModifyParent(r.getApply().getIDA(),r.getApply().getIDB());
        }
        int result = receiptMapper.Create(r);
        return ExecutionFactory.GetExcutionByResultCode(result,"操作已执行");
    }

    @Override
    public Execution RollBackApplyParentOrg(Long applyId) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public Execution ApplyUnlockParentOrg(Apply a) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public Execution RollBackApplyUnlockParentOrg(Long applyId) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public Execution ApplyUnlockParentOrgCallBack(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.ModifyParent(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExecutionFactory.GetExcutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public Execution RollBackApplyUnlockParentOrgCallBack(Long applyId) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public Execution DiliverOrgNotWithSonOrg(Apply a) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public Execution CreateDepartment(organization o) {
        return ExecutionFactory.GetExcutionByResultCode(organizationMapper.insert(o));
    }

    @Override
    public Execution ComandDeparementLeader(Apply a) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public Execution ComandDeparementLeaderCallBack(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.AddAdmin(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExecutionFactory.GetExcutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public Execution UnlockDeparementLeader(Long orgId, Long userId) {
        return ExecutionFactory.GetExcutionByResultCode(organizationMapper.RemoveAdmin(orgId,userId));
    }

    @Override
    public List<organization> SearchOrg(String str) {
        return organizationMapper.SearchOrg(str);
    }

    @Override
    public Execution DeleteOrg(Long ID) {
        return ExecutionFactory.GetExcutionByResultCode(organizationMapper.deleteByPrimaryKey(ID));
    }

    @Override
    public String HasOrgName(String Name) {
        return organizationMapper.HasOrgName(Name);
    }

}
