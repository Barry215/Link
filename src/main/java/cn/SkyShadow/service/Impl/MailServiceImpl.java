package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.MailMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.model.Mail;
import cn.SkyShadow.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 邮件管理器
 * Created by Richard on 16/9/13.
 */
@Transactional
@Service
public class MailServiceImpl implements MailService {
    private final MailMapper MailMapper;

    public MailServiceImpl(MailMapper MailMapper) {
        this.MailMapper = MailMapper;
    }

    @Override
    public List<Mail> Receive(Long userId) {
        return MailMapper.receive(userId);
    }

    @Override
    public BaseExecution SendMail(Mail mail) {
        return null;
    }

    @Override
    public BaseExecution DeleteMail(Long mailId) {
        return null;
    }

    @Override
    public BaseExecution ReadMail(List<Long> IdList) {
        return null;
    }
}
