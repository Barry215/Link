package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.LocationMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.enums.ApplyModel;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.ModifyOrganization;
import cn.SkyShadow.service.ApplyHandler;
import cn.SkyShadow.service.ApplyInterceptor;
import cn.SkyShadow.service.OrgService;
import cn.SkyShadow.service.ReceiptHandler;
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
    private final ApplyInterceptor applyInterceptor;
    private final ApplyMapper applyMapper;

    @Autowired(required = false)
    public OrgServiceImpl(OrganizationMapper OrganizationMapper, LocationMapper lMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper, ApplyInterceptor applyInterceptor, ApplyMapper applyMapper1) {
        this.OrganizationMapper = OrganizationMapper;
        this.lMapper = lMapper;
        this.receiptMapper = receiptMapper;
        this.applyInterceptor = applyInterceptor;
        this.applyMapper = applyMapper1;
    }


    @Override
    public BaseExecution CreateNewOrg(Organization org) {
        if (org == null) {
            return ExecutionFactory.getExecution(ResultMapper.NULL_ERROR);
        }
        if (org.getCreatorId() == null || org.getCreatorId().getUserId() == 0L) {
            return ExecutionFactory.getExecution(ResultMapper.NULL_ERROR);
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
            return ExecutionFactory.getExecution(ResultMapper.NULL_ERROR);
        }
        Location location = lMapper.selectByPrimaryKey(org.getLocation().getLocationId());
        if (location == null) {
            return ExecutionFactory.getExecution(ResultMapper.Public_ILLEGAL_LOCATION);
        }
        int result = OrganizationMapper.insert(org);
        if (result == 1) {
            return ExecutionFactory.getExecution(ResultMapper.SUCCESS, org);
        } else {
            return ExecutionFactory.getExecution(ResultMapper.DB_ERROR);
        }
    }

    @Override
    public Organization getBaseInfo(Long orgId) {
        return OrganizationMapper.getBaseInfo(orgId);
    }


    @Override
    public String HasOrgName(String Name) {
        return OrganizationMapper.HasOrgName(Name);
    }

    @Override
    public ResultMapper modifyOrganization(ModifyOrganization apply, ApplyModel applyModel) {
        ApplyHandler<ModifyOrganization> applyHandler = new ApplyHandler<ModifyOrganization>(applyInterceptor) {
            @Override
            public ResultMapper doSomeThing_FULL(ModifyOrganization apply) {
                OrganizationMapper.updateByPrimaryKeySelective(apply.getOrganization());
                return ResultMapper.SUCCESS;
            }

            @Override
            public ResultMapper doSomeThing_APPLY_AVAILABLE(ModifyOrganization apply) {
                applyMapper.ModifyOrganization(apply);
                return ResultMapper.SUCCESS;
            }
        };
        return applyHandler.handler(apply,applyModel);
    }

    @Override
    public ResultMapper modifyOrganizationCallBack(Receipt<ModifyOrganization> receipt) {
        ReceiptHandler<ModifyOrganization> receiptHandler = new ReceiptHandler<ModifyOrganization>(applyInterceptor) {
            @Override
            public void doIfAgree() {
                receiptMapper.Create(receipt);
            }

            @Override
            public void doIfDisagree() {
                receiptMapper.Create(receipt);
            }
        };
        return receiptHandler.handler(receipt);
    }

}
