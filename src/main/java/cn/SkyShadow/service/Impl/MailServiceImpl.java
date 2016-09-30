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
        return MailMapper.Receive(userId);
    }

    @Override
    public BaseExecution SendMail(Mail mail) {
        if (mail==null){
            return ExecutionFactory.getExecutionByResultCode(0,"邮件不能为空");
        }
        return ExecutionFactory.getExecutionByResultCode(MailMapper.insertSelective(mail));
    }

    @Override
    public BaseExecution DeleteMail(Long mailId) {
        return ExecutionFactory.getExecutionByResultCode(MailMapper.deleteByPrimaryKey(mailId));
    }

    @Override
    public BaseExecution ReadMail(List<Long> IdList) {
        return ExecutionFactory.getExecutionByResultCode(MailMapper.ReadMail(IdList));
    }
}
