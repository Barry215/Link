package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.dao.organizationMapper;
import cn.SkyShadow.dto.factory.ExcutionFactory;
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
    public Execution CreateDepartment(organization o) {
        return ExcutionFactory.GetExcutionByResultCode(organizationMapper.insert(o));
    }

    @Override
    public Execution AddAdmin(Apply apply) {
        return ExcutionFactory.GetExcutionByResultCode(applyMapper.Create(apply));
    }

    @Override
    public Execution MakeAdminCallback(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.AddAdmin(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExcutionFactory.GetExcutionByResultCode(receiptMapper.Create(r));
    }
        
    @Override
    public Execution RollBackAddAdmin(Long ApplyId) {
        return ExcutionFactory.GetExcutionByResultCode(applyMapper.Remove(ApplyId));
    }

    @Override
    public Execution RemoveAdmin(Long depId, Long userid) {
        return ExcutionFactory.GetExcutionByResultCode(organizationMapper.RemoveAdmin(depId,userid));
    }

    @Override
    public Execution DeliverDepartmentCreator(Apply a) {
        return ExcutionFactory.GetExcutionByResultCode(applyMapper.Create(a));
    }

    @Override
    public Execution RollBackDeliverDepartmentCreator(Long applyId) {
        return ExcutionFactory.GetExcutionByResultCode(applyMapper.Remove(applyId));
    }

    @Override
    public Execution DeliverDepartmentCreatorCallback(Receipt r) {
        if (r.isSuccess()){
            organizationMapper.ModifyCreator(r.getApply().getIDA(),r.getApply().getIDB());
        }
        return ExcutionFactory.GetExcutionByResultCode(receiptMapper.Create(r));
    }

    @Override
    public Execution DeleteDepartment(Long DepId) {
        return ExcutionFactory.GetExcutionByResultCode(organizationMapper.deleteByPrimaryKey(DepId));
    }

    @Override
    public Execution ModifyDepart(organization o) {
        return ExcutionFactory.GetExcutionByResultCode(organizationMapper.updateByPrimaryKeySelective(o));
    }
}
