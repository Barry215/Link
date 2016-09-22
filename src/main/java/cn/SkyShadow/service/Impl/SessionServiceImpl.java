package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.MessageMapper;
import cn.SkyShadow.dao.SessionMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
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
    private final SessionMapper SessionMapper;
    private final MessageMapper MessageMapper;
    @Autowired(required = false)
    public SessionServiceImpl(SessionMapper SessionMapper, MessageMapper MessageMapper) {
        this.SessionMapper = SessionMapper;
        this.MessageMapper = MessageMapper;
    }

    @Override
    public List<Session> GetAllSession(Long userId) {
        return SessionMapper.GetAllSession(userId);
    }

    @Override
    public BaseExecution SendMessage(Message message) {
        return ExecutionFactory.getExecutionByResultCode(MessageMapper.insert(message));
    }

    @Override
    public BaseExecution RollBackMessage(Long messageId) {
        return ExecutionFactory.getExecutionByResultCode(MessageMapper.deleteByPrimaryKey(messageId));
    }

    @Override
    public int GetNotReadMessageNum(Long userId) {
        return MessageMapper.GetNotReadMessageNum(userId);
    }

    @Override
    public List<Message> GetNotReadMessage(Long userId) {
        return MessageMapper.GetNotReadMessage(userId);
    }

    @Override
    public BaseExecution ReadMessage(List<String> IdList) {
        return ExecutionFactory.getExecutionByResultCode(MessageMapper.ReadMessage(IdList));
    }
}
