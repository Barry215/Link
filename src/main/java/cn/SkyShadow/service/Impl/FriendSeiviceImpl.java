package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.*;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.FriendSeivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 好友处理器
 * Created by Richard on 16/9/13.
 */
@Transactional
@Service
public class FriendSeiviceImpl implements FriendSeivice {
    private final friendMapper friendMapper;
    private final userMapper userMapper;
    private final ApplyMapper applyMapper;
    private final ReceiptMapper receiptMapper;
    private final friendgroupMapper friendgroupMapper;
    @Autowired(required = false)
    public FriendSeiviceImpl(cn.SkyShadow.dao.friendMapper friendMapper, userMapper userMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper, friendgroupMapper friendgroupMapper) {
        this.friendMapper = friendMapper;
        this.userMapper = userMapper;
        this.applyMapper = applyMapper;
        this.receiptMapper = receiptMapper;
        this.friendgroupMapper = friendgroupMapper;
    }

    @Override
    public List<user> Search(String str) {
        return userMapper.Search(str);
    }

    @Override
    public BaseExecution AddFriend(Apply apply) {
        return ExecutionFactory.getExecutionByResultCode(applyMapper.Create(apply));
    }

    @Override
    public BaseExecution AddFriendCallBack(Receipt receipt) {
        if (receipt.isSuccess()){
            friendMapper.insert((friend) receipt.getApply().getObjectA());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(receipt));
    }

    @Override
    public BaseExecution CreateFriendGroup(friendgroup friendgroup) {
        return ExecutionFactory.getExecutionByResultCode(friendgroupMapper.insert(friendgroup));
    }

    @Override
    public BaseExecution ModifyFriendGroup(friendgroup friendgroup) {
        return ExecutionFactory.getExecutionByResultCode(friendgroupMapper.update(friendgroup));
    }

    @Override
    public BaseExecution Deletefriend(Long friendId) {
        return ExecutionFactory.getExecutionByResultCode(friendMapper.deleteByPrimaryKey(friendId));
    }

    @Override
    public BaseExecution deleteFriendGroup(Long friendGroupId) {
        return ExecutionFactory.getExecutionByResultCode(friendgroupMapper.deleteByPrimaryKey(friendGroupId));
    }
}
