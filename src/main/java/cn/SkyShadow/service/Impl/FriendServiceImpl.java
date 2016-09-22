package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.*;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.ApplyChildren.AddFriend;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.service.FriendService;
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
public class FriendServiceImpl implements FriendService {
    private final FriendMapper FriendMapper;
    private final UserMapper UserMapper;
    private final ReceiptMapper receiptMapper;
    private final FriendGroupMapper FriendGroupMapper;
    @Autowired(required = false)
    public FriendServiceImpl(FriendMapper FriendMapper, UserMapper UserMapper,ReceiptMapper receiptMapper, FriendGroupMapper FriendGroupMapper) {
        this.FriendMapper = FriendMapper;
        this.UserMapper = UserMapper;
        this.receiptMapper = receiptMapper;
        this.FriendGroupMapper = FriendGroupMapper;
    }

    @Override
    public List<User> Search(String str) {
        return UserMapper.Search(str);
    }

    @Override
    public BaseExecution AddFriendCallBack(Receipt<AddFriend> receipt) {
        if (receipt.isSuccess()){
            FriendMapper.insert(receipt.getApply().getFriend());
        }
        return ExecutionFactory.getExecutionByResultCode(receiptMapper.Create(receipt));
    }

    @Override
    public BaseExecution CreateFriendGroup(FriendGroup friendGroup) {
        return ExecutionFactory.getExecutionByResultCode(FriendGroupMapper.insert(friendGroup));
    }

    @Override
    public BaseExecution ModifyFriendGroup(FriendGroup friendGroup) {
        return ExecutionFactory.getExecutionByResultCode(FriendGroupMapper.update(friendGroup));
    }

    @Override
    public BaseExecution DeleteFriend(Long friendId) {
        return ExecutionFactory.getExecutionByResultCode(FriendMapper.deleteByPrimaryKey(friendId));
    }

    @Override
    public BaseExecution deleteFriendGroup(Long friendGroupId) {
        return ExecutionFactory.getExecutionByResultCode(FriendGroupMapper.deleteByPrimaryKey(friendGroupId));
    }
}
