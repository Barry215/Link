package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.model.mail;

import java.util.List;

public interface MailService {

    /**
     * 接收邮件
     * @param userId 用户ID
     * @return 执行结果
     */
	List<mail> Receive(Long userId);

    /**
     * 发送邮件
     * @param mail 邮件
     * @return 执行结果
     */
    Execution SendMail(mail mail);

    /**
     * 删除邮件
     * @param mailId 邮件ID
     * @return 执行结果
     */
	Execution DeleteMail(Long mailId);

    /**
     * 把未读邮件变成已读邮件
     * @param IdList ID列表
     * @return 执行结果
     */
    Execution ReadMail(List<Long> IdList);
}
