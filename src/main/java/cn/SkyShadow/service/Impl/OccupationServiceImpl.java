package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dao.occupationMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
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
    public BaseExecution CreateOccupation(occupation occupation) {
        return ExecutionFactory.getExecutionByResultCode(occupationMapper.insert(occupation));
    }

    @Override
    public BaseExecution DeleteOccupation(Long occupationId) {
        return ExecutionFactory.getExecutionByResultCode(occupationMapper.deleteByPrimaryKey(occupationId));
    }

    @Override
    public BaseExecution ModifyOccupation(occupation occupation) {
        return ExecutionFactory.getExecutionByResultCode(occupationMapper.updateByPrimaryKeySelective(occupation));
    }

    @Override
    public BaseExecution ModifyOccupation_Power(occupation occupation) {
        return ExecutionFactory.getExecutionByResultCode(occupationMapper.updateByPrimaryKeySelective(occupation));
    }

    @Override
    public BaseExecution AddUserToOccupation(Apply apply) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Create(apply));
    }

    @Override
    public BaseExecution RollBackAddUserToOccupation(Long ApplyId) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Remove(ApplyId));
    }

    @Override
    public BaseExecution AddUserToOccupationCallBcak(Receipt receipt) {
        if (receipt.isSuccess()){
            occupationMapper.addUser(receipt.getApply().getIDA(),receipt.getApply().getIDB());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(receipt));
    }

    @Override
    public BaseExecution RemoveUser(Long userId, Long occuId) {
        return ExecutionFactory.getExecutionByResultCode(occupationMapper.removeUser(occuId,userId));
    }
}
