package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.messageMapper;
import cn.SkyShadow.dao.sessionMapper;
import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.dto.factory.ExcutionFactory;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 会话处理器
 * Created by RichardW on 9/12/2016.
 */
@Transactional
@Service
public class SessionServiceImpl implements SessionService {
    private final sessionMapper sessionMapper;
    private final messageMapper messageMapper;
    @Autowired(required = false)
    public SessionServiceImpl(cn.SkyShadow.dao.sessionMapper sessionMapper, cn.SkyShadow.dao.messageMapper messageMapper) {
        this.sessionMapper = sessionMapper;
        this.messageMapper = messageMapper;
    }

    @Override
    public List<session> GetAllSession(Long userId) {
        return sessionMapper.GetAllSession(userId);
    }

    @Override
    public Execution SendMessage(message message) {
        return ExcutionFactory.GetExcutionByResultCode(messageMapper.insert(message));
    }

    @Override
    public Execution RollBackMessage(Long messageId) {
        return ExcutionFactory.GetExcutionByResultCode(messageMapper.deleteByPrimaryKey(messageId));
    }

    @Override
    public int GetNotReadMessageNum(Long userId) {
        return messageMapper.GetNotReadMessageNum(userId);
    }

    @Override
    public List<message> GetNotReadMessage(Long userId) {
        return messageMapper.GetNotReadMessage(userId);
    }

    @Override
    public Execution ReadMessage(List<String> IdList) {
        return ExcutionFactory.GetExcutionByResultCode(messageMapper.ReadMessage(IdList));
    }
}
