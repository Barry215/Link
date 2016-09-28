package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.applyChildren.AddAdmin;
import cn.SkyShadow.model.apply.applyChildren.DeliverDepartmentCreator;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 部门管理
 * Created by RichardW on 9/12/2016.
 */
@Transactional
@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final OrganizationMapper OrganizationMapper;
    private final ReceiptMapper receiptMapper;
    @Autowired(required = false)
    public DepartmentServiceImpl(OrganizationMapper OrganizationMapper, ReceiptMapper receiptMapper) {
        this.OrganizationMapper = OrganizationMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public BaseExecution CreateDepartment(Organization o) {
        return ExecutionFactory.getExecutionByResultCode(OrganizationMapper.insert(o));
    }


    @Override
    public BaseExecution MakeAdminCallback(Receipt<AddAdmin> r) {
        if (r.isSuccess()){
            OrganizationMapper.AddAdmin(r.getApply().getOrganization().getOrgId()
                    ,r.getApply().getUser().getUserId());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public BaseExecution RemoveAdmin(Long depId, Long userId) {
        return ExecutionFactory.getExecutionByResultCode(OrganizationMapper.RemoveAdmin(depId, userId));
    }

    @Override
    public BaseExecution DeliverDepartmentCreatorCallback(Receipt<DeliverDepartmentCreator> r) {
        if (r.isSuccess()){
            OrganizationMapper.ModifyCreator(r.getApply().getOrganization().getOrgId()
                    ,r.getApply().getUser().getUserId());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public BaseExecution DeleteDepartment(Long DepId) {
        return ExecutionFactory.getExecutionByResultCode(OrganizationMapper.deleteByPrimaryKey(DepId));
    }

    @Override
    public BaseExecution ModifyDepart(Organization o) {
        return ExecutionFactory.getExecutionByResultCode(OrganizationMapper.updateByPrimaryKeySelective(o));
    }
}
