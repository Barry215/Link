package cn.SkyShadow.dao;

import cn.SkyShadow.model.mailbox;

public interface mailboxMapper {
    int deleteByPrimaryKey(Long mailboxId);

    int insertSelective(mailbox record);

    mailbox selectByPrimaryKey(Long mailboxId);
}