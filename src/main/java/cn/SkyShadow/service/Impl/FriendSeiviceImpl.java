package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.*;
import cn.SkyShadow.dto.execution.Execution;
import cn.SkyShadow.dto.factory.ExecutionFactory;
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
    public Execution AddFriend(Apply apply) {
        return ExecutionFactory.GetExcutionByResultCode(applyMapper.Create(apply));
    }

    @Override
    public Execution AddFriendCallBack(Receipt receipt) {
        if (receipt.isSuccess()){
            friendMapper.insert((friend) receipt.getApply().getObjectA());
        }
        return ExecutionFactory.GetExcutionByResultCode(receiptMapper.Create(receipt));
    }

    @Override
    public Execution CreateFriendGroup(friendgroup friendgroup) {
        return ExecutionFactory.GetExcutionByResultCode(friendgroupMapper.insert(friendgroup));
    }

    @Override
    public Execution ModifyFriendGroup(friendgroup friendgroup) {
        return ExecutionFactory.GetExcutionByResultCode(friendgroupMapper.update(friendgroup));
    }

    @Override
    public Execution Deletefriend(Long friendId) {
        return ExecutionFactory.GetExcutionByResultCode(friendMapper.deleteByPrimaryKey(friendId));
    }

    @Override
    public Execution deleteFriendGroup(Long friendGroupId) {
        return ExecutionFactory.GetExcutionByResultCode(friendgroupMapper.deleteByPrimaryKey(friendGroupId));
    }
}
