package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.dto.factory.ExcutionFactory;
import cn.SkyShadow.model.mail;
import cn.SkyShadow.dao.mailMapper;
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
    private final mailMapper mailMapper;
    @Autowired(required = false)
    public MailServiceImpl(cn.SkyShadow.dao.mailMapper mailMapper) {
        this.mailMapper = mailMapper;
    }

    @Override
    public List<mail> Receive(Long userId) {
        return mailMapper.Receive(userId);
    }

    @Override
    public Execution SendMail(mail mail) {
        if (mail==null){
            return ExcutionFactory.GetExcutionByResultCode(0,"邮件不能为空");
        }
        return ExcutionFactory.GetExcutionByResultCode(mailMapper.insertSelective(mail));
    }

    @Override
    public Execution DeleteMail(Long mailId) {
        return ExcutionFactory.GetExcutionByResultCode(mailMapper.deleteByPrimaryKey(mailId));
    }

    @Override
    public Execution ReadMail(List<Long> IdList) {
        return ExcutionFactory.GetExcutionByResultCode(mailMapper.ReadMail(IdList));
    }
}
