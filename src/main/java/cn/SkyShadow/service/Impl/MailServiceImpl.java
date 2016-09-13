package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.mail;
import cn.SkyShadow.service.MailService;

import java.util.List;

/**
 * 邮件管理器
 * Created by Richard on 16/9/13.
 */
public class MailServiceImpl implements MailService {
    @Override
    public List<mail> Receive(Long userId) {
        return null;
    }

    @Override
    public Excution SendMail(mail mail) {
        return null;
    }

    @Override
    public Excution DeleteMail(Long mailId) {
        return null;
    }

    @Override
    public Excution ReadMail(List<String> IdList) {
        return null;
    }
}
