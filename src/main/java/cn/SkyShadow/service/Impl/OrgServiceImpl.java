package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dao.organizationMapper;
import cn.SkyShadow.dao.locationMapper;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.enums.ResultMapper;
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
    public BaseExecution CreateNewOrg(organization org) {
        if (org == null) {
            return ExecutionFactory.getExecution(ResultMapper.Org_NULL_ORG);
        }
        if (org.getCreatorId() == null || org.getCreatorId().getUserId() == 0L) {
            return ExecutionFactory.getExecution(ResultMapper.Org_NULL_User_ID);
        }
        if (org.getName().length() > 255 || org.getName().length() < 6) {
            return ExecutionFactory.getExecution(ResultMapper.Org_FORMAT_NAME);
        }
        if (HasOrgName(org.getName()).equals("Y")) {
            return ExecutionFactory.getExecution(ResultMapper.Org_ILLEGAL_NAME);
        }
        if (org.getOrgId() != 0L) {
            organization fatherOrg = organizationMapper.selectBaseInfo(org.getOrgId());
            if (fatherOrg == null) {
                return ExecutionFactory.getExecution(ResultMapper.Org_ILLEGAL_PARENT);
            }
        }
        if (org.getLocation() == null) {
            return ExecutionFactory.getExecution(ResultMapper.Org_NULL_LOCATION);
        }
        location location = lMapper.selectByPrimaryKey(org.getLocation().getLocationId());
        if (location == null){
            return ExecutionFactory.getExecution(ResultMapper.Public_ILLEGAL_LOCATION);
        }
        int result = organizationMapper.insert(org);
        if (result==1) {
            return ExecutionFactory.getExecution(ResultMapper.SUCCESS,org);
        }
        else{
            return ExecutionFactory.getExecution(ResultMapper.DB_ERROR);
        }
    }

    @Override
    public organization getBaseInfo(Long orgId) {
        return organizationMapper.getBaseInfo(orgId);
    }

    @Override
    public BaseExecution ModifyOrg(organization o) {
        int result = organizationMapper.updateByPrimaryKeySelective(o);
        return ExecutionFactory.getExecutionByResultCode(result,"操作已执行");
    }

    @Override
    public BaseExecution ApplyParentOrg(Apply a) {
        int result = applyMapper.Create(a);
        return ExecutionFactory.getExecutionByResultCode(result,"操作已执行");
    }

    @Override
    public BaseExecution ApplyParentOrgCallBack(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.ModifyParent(r.getApply().getIDA(),r.getApply().getIDB());
        }
        int result = receiptMapper.Create(r);
        return ExecutionFactory.getExecutionByResultCode(result,"操作已执行");
    }

    @Override
    public BaseExecution RollBackApplyParentOrg(Long applyId) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public BaseExecution ApplyUnlockParentOrg(Apply a) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public BaseExecution RollBackApplyUnlockParentOrg(Long applyId) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public BaseExecution ApplyUnlockParentOrgCallBack(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.ModifyParent(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public BaseExecution RollBackApplyUnlockParentOrgCallBack(Long applyId) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public BaseExecution DiliverOrgNotWithSonOrg(Apply a) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public BaseExecution CreateDepartment(organization o) {
        return ExecutionFactory.getExecutionByResultCode(organizationMapper.insert(o));
    }

    @Override
    public BaseExecution ComandDeparementLeader(Apply a) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public BaseExecution ComandDeparementLeaderCallBack(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.AddAdmin(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public BaseExecution UnlockDeparementLeader(Long orgId, Long userId) {
        return ExecutionFactory.getExecutionByResultCode(organizationMapper.RemoveAdmin(orgId,userId));
    }

    @Override
    public List<organization> SearchOrg(String str) {
        return organizationMapper.SearchOrg(str);
    }

    @Override
    public BaseExecution DeleteOrg(Long ID) {
        return ExecutionFactory.getExecutionByResultCode(organizationMapper.deleteByPrimaryKey(ID));
    }

    @Override
    public String HasOrgName(String Name) {
        return organizationMapper.HasOrgName(Name);
    }

}
