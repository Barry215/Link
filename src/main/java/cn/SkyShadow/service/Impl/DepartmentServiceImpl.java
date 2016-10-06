package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.applyChildren.AddAdmin;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.CreateDepartment;
import cn.SkyShadow.model.apply.applyChildren.DeleteDepartment;
import cn.SkyShadow.model.apply.applyChildren.ModifyDepartment;
import cn.SkyShadow.service.DepartmentService;
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

    public DepartmentServiceImpl(OrganizationMapper OrganizationMapper, ReceiptMapper receiptMapper) {
        this.OrganizationMapper = OrganizationMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public BaseExecution CreateDepartment(CreateDepartment apply) {
        return null;
    }

    @Override
    public BaseExecution CreateDepartmentCallback(Receipt<CreateDepartment> receipt) {
        return null;
    }

    @Override
    public BaseExecution DeleteDepartment(DeleteDepartment apply) {
        return null;
    }

    @Override
    public BaseExecution DeleteDepartmentCallback(Receipt<DeleteDepartment> receipt) {
        return null;
    }

    @Override
    public BaseExecution ModifyDepartment(ModifyDepartment apply) {
        return null;
    }

    @Override
    public BaseExecution ModifyDepartment(Receipt<ModifyDepartment> receipt) {
        return null;
    }
}
