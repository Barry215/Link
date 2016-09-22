package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.Mail;

import java.util.List;

public interface MailService {

    /**
     * 接收邮件
     * @param userId 用户ID
     * @return 执行结果
     */
	List<Mail> Receive(Long userId);

    /**
     * 发送邮件
     * @param mail 邮件
     * @return 执行结果
     */
    BaseExecution SendMail(Mail mail);

    /**
     * 删除邮件
     * @param mailId 邮件ID
     * @return 执行结果
     */
	BaseExecution DeleteMail(Long mailId);

    /**
     * 把未读邮件变成已读邮件
     * @param IdList ID列表
     * @return 执行结果
     */
    BaseExecution ReadMail(List<Long> IdList);
}
