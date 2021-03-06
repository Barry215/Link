package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.*;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.applyChildren.AddFriend;
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

    public FriendServiceImpl(FriendMapper FriendMapper, UserMapper UserMapper,ReceiptMapper receiptMapper, FriendGroupMapper FriendGroupMapper) {
        this.FriendMapper = FriendMapper;
        this.UserMapper = UserMapper;
        this.receiptMapper = receiptMapper;
        this.FriendGroupMapper = FriendGroupMapper;
    }


    @Override
    public BaseExecution AddFriend(AddFriend apply) {
        return null;
    }

    @Override
    public BaseExecution AddFriendCallBack(Receipt<AddFriend> receipt) {
        if (receipt.isSuccess()){
            FriendMapper.insert(receipt.getApply().getFriend());
        }
        return null;
    }

    @Override
    public BaseExecution CreateFriendGroup(FriendGroup friendGroup) {
        return null;
    }

    @Override
    public BaseExecution ModifyFriendGroup(FriendGroup friendGroup) {
        return null;
    }

    @Override
    public BaseExecution DeleteFriend(Long friendId) {
        return null;
    }

    @Override
    public BaseExecution deleteFriendGroup(Long friendGroupId) {
        return null;
    }
}
