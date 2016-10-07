package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.MailboxGroup;

public interface MailboxGroupMapper {
    /**
     * 删除邮箱组
     * @param groupId 邮箱组ID
     * @return 执行结果
     */
	int deleteByPrimaryKey(Long groupId);

    /**
     * 插入一个邮箱组
     * @param record 邮箱组
     * @return 执行结果
     */
	int insert(MailboxGroup record);

    /**
     * 向邮箱组添加邮箱
     * @param mailbox_id 邮箱ID
     * @param mailGroup_id 邮箱组ID
     * @return 执行结果
     */
	int addMail(@Param("mailbox_id") Long mailbox_id,
                @Param("mailGroup_id") Long mailGroup_id);

    /**
     * 查询邮箱组信息
     * @param groupId 邮箱组信息
     * @return 执行结果
     */
	MailboxGroup selectGroup(Long groupId);
}