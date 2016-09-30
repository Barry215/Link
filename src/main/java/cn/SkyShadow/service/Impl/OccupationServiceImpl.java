package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.OccupationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.Occupation;
import cn.SkyShadow.model.apply.applyChildren.AddUserToOccupation;
import cn.SkyShadow.model.apply.Receipt;
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
    private final OccupationMapper OccupationMapper;
    private final ApplyMapper applyMapper;
    private final ReceiptMapper receiptMapper;
    public OccupationServiceImpl(OccupationMapper OccupationMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper) {
        this.OccupationMapper = OccupationMapper;
        this.applyMapper = applyMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public BaseExecution CreateOccupation(Occupation occupation) {
        return ExecutionFactory.getExecutionByResultCode(OccupationMapper.insert(occupation));
    }

    @Override
    public BaseExecution DeleteOccupation(Long occupationId) {
        return ExecutionFactory.getExecutionByResultCode(OccupationMapper.deleteByPrimaryKey(occupationId));
    }

    @Override
    public BaseExecution ModifyOccupation(Occupation occupation) {
        return ExecutionFactory.getExecutionByResultCode(OccupationMapper.updateByPrimaryKeySelective(occupation));
    }

    @Override
    public BaseExecution ModifyOccupation_Power(Occupation occupation) {
        return ExecutionFactory.getExecutionByResultCode(OccupationMapper.updateByPrimaryKeySelective(occupation));
    }

    @Override
    public BaseExecution AddUserToOccupationCallBack(Receipt<AddUserToOccupation> receipt) {
        if (receipt.isSuccess()){
            OccupationMapper.addUser(receipt.getApply().getOccupation().getOccupationId()
                    ,receipt.getApply().getPerson().getUserId());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(receipt));
    }

    @Override
    public BaseExecution RemoveUser(Long userId, Long occupationId) {
        return ExecutionFactory.getExecutionByResultCode(OccupationMapper.removeUser(occupationId,userId));
    }
}
