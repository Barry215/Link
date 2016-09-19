package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dao.occupationMapper;
import cn.SkyShadow.dto.execution.Execution;
import cn.SkyShadow.dto.factory.ExecutionFactory;
import cn.SkyShadow.model.Apply;
import cn.SkyShadow.model.Receipt;
import cn.SkyShadow.model.occupation;
import cn.SkyShadow.service.OccupationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 职位管理器
 * Created by Richard on 16/9/13.
 */
@Transactional
@Service
public class OccupationServiceImpl implements OccupationService {
    private final occupationMapper occupationMapper;
    private final ApplyMapper applyMapper;
    private final ReceiptMapper receiptMapper;
    @Autowired(required = false)
    public OccupationServiceImpl(cn.SkyShadow.dao.occupationMapper occupationMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper) {
        this.occupationMapper = occupationMapper;
        this.applyMapper = applyMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public Execution CreateOccupation(occupation occupation) {
        return ExecutionFactory.GetExcutionByResultCode(occupationMapper.insert(occupation));
    }

    @Override
    public Execution DeleteOccupation(Long occupationId) {
        return ExecutionFactory.GetExcutionByResultCode(occupationMapper.deleteByPrimaryKey(occupationId));
    }

    @Override
    public Execution ModifyOccupation(occupation occupation) {
        return ExecutionFactory.GetExcutionByResultCode(occupationMapper.updateByPrimaryKeySelective(occupation));
    }

    @Override
    public Execution ModifyOccupation_Power(occupation occupation) {
        return ExecutionFactory.GetExcutionByResultCode(occupationMapper.updateByPrimaryKeySelective(occupation));
    }

    @Override
    public Execution AddUserToOccupation(Apply apply) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Create(apply));
    }

    @Override
    public Execution RollBackAddUserToOccupation(Long ApplyId) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Remove(ApplyId));
    }

    @Override
    public Execution AddUserToOccupationCallBcak(Receipt receipt) {
        if (receipt.isSuccess()){
            occupationMapper.addUser(receipt.getApply().getIDA(),receipt.getApply().getIDB());
        }
        return ExecutionFactory.GetExcutionByResultCode(receiptMapper.Create(receipt));
    }

    @Override
    public Execution RemoveUser(Long userId, Long occuId) {
        return ExecutionFactory.GetExcutionByResultCode(occupationMapper.removeUser(occuId,userId));
    }
}
