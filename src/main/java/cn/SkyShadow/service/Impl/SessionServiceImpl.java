package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.*;
import cn.SkyShadow.service.SessionService;

import java.util.List;

/**
 * 会话处理器
 * Created by RichardW on 9/12/2016.
 */
public class SessionServiceImpl implements SessionService {
    @Override
    public List<session> GetAllSession(Long userId) {
        return null;
    }

    @Override
    public Excution SendMessage(message message) {
        return null;
    }

    @Override
    public Excution RollBackMessage(Long messageId) {
        return null;
    }

    @Override
    public int GetNotReadMessageNum(Long userId) {
        return 0;
    }

    @Override
    public List<message> GetNotReadMessage(Long userId) {
        return null;
    }

    @Override
    public Excution ReadMessage(List<String> IdList) {
        return null;
    }
}
