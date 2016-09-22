package cn.SkyShadow.dao;

import cn.SkyShadow.model.Mailbox;

public interface MailboxMapper {
    /**
     * 删除邮箱
     * @param mailboxId 邮箱ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long mailboxId);

    /**
     * 新建一个邮箱
     * @param record 邮箱
     * @return 执行结果
     */
    int insertSelective(Mailbox record);

    /**
     * 查询邮箱
     * @param mailboxId 邮箱ID
     * @return 执行结果
     */
    Mailbox selectByPrimaryKey(Long mailboxId);
}