package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.LocationMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Richard on 16/8/31.
 * 组织管理器
 */
@Transactional
@Service
public class OrgServiceImpl implements OrgService {

    private final OrganizationMapper OrganizationMapper;
    private final LocationMapper lMapper;
    private final ReceiptMapper receiptMapper;

    @Autowired(required = false)
    public OrgServiceImpl(OrganizationMapper OrganizationMapper, LocationMapper lMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper) {
        this.OrganizationMapper = OrganizationMapper;
        this.lMapper = lMapper;
        this.receiptMapper = receiptMapper;
    }




    @Override
    public BaseExecution CreateNewOrg(Organization org) {
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
            Organization fatherOrg = OrganizationMapper.selectBaseInfo(org.getOrgId());
            if (fatherOrg == null) {
                return ExecutionFactory.getExecution(ResultMapper.Org_ILLEGAL_PARENT);
            }
        }
        if (org.getLocation() == null) {
            return ExecutionFactory.getExecution(ResultMapper.Org_NULL_LOCATION);
        }
        Location location = lMapper.selectByPrimaryKey(org.getLocation().getLocationId());
        if (location == null){
            return ExecutionFactory.getExecution(ResultMapper.Public_ILLEGAL_LOCATION);
        }
        int result = OrganizationMapper.insert(org);
        if (result==1) {
            return ExecutionFactory.getExecution(ResultMapper.SUCCESS,org);
        }
        else{
            return ExecutionFactory.getExecution(ResultMapper.DB_ERROR);
        }
    }

    @Override
    public Organization getBaseInfo(Long orgId) {
        return OrganizationMapper.getBaseInfo(orgId);
    }

    @Override
    public BaseExecution ModifyOrg(Organization o) {
        int result = OrganizationMapper.updateByPrimaryKeySelective(o);
        if (result>0){
            return ExecutionFactory.getExecution(ResultMapper.SUCCESS);
        }
        else{
            return ExecutionFactory.getExecution(ResultMapper.DB_ERROR);
        }
    }

    @Override
    public String HasOrgName(String Name) {
        return OrganizationMapper.HasOrgName(Name);
    }

}
