package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dao.organizationMapper;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.*;
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
    private final organizationMapper organizationMapper;
    private final ApplyMapper applyMapper;
    private final ReceiptMapper receiptMapper;
    @Autowired(required = false)
    public DepartmentServiceImpl(cn.SkyShadow.dao.organizationMapper organizationMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper) {
        this.organizationMapper = organizationMapper;
        this.applyMapper = applyMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public BaseExecution CreateDepartment(organization o) {
        return ExecutionFactory.GetExcutionByResultCode(organizationMapper.insert(o));
    }

    @Override
    public BaseExecution AddAdmin(Apply apply) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Create(apply));
    }

    @Override
    public BaseExecution MakeAdminCallback(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.AddAdmin(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExecutionFactory.GetExcutionByResultCode(receiptMapper.Create(r));
    }
        
    @Override
    public BaseExecution RollBackAddAdmin(Long ApplyId) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Remove(ApplyId));
    }

    @Override
    public BaseExecution RemoveAdmin(Long depId, Long userid) {
        return ExecutionFactory.GetExcutionByResultCode(organizationMapper.RemoveAdmin(depId,userid));
    }

    @Override
    public BaseExecution DeliverDepartmentCreator(Apply a) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public BaseExecution RollBackDeliverDepartmentCreator(Long applyId) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public BaseExecution DeliverDepartmentCreatorCallback(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.ModifyCreator(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExecutionFactory.GetExcutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public BaseExecution DeleteDepartment(Long DepId) {
        return ExecutionFactory.GetExcutionByResultCode(organizationMapper.deleteByPrimaryKey(DepId));
    }

    @Override
    public BaseExecution ModifyDepart(organization o) {
        return ExecutionFactory.GetExcutionByResultCode(organizationMapper.updateByPrimaryKeySelective(o));
    }
}
