package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.mailboxgroup;

public interface mailboxgroupMapper {
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
	int insert(mailboxgroup record);

    /**
     * 向邮箱组添加邮箱
     * @param mailbox_id 邮箱ID
     * @param mailgroup_id 邮箱组ID
     * @return 执行结果
     */
	int addmail(@Param("mailbox_id") Long mailbox_id,
                @Param("mailgroup_id") Long mailgroup_id);

    /**
     * 查询邮箱组信息
     * @param groupId 邮箱组信息
     * @return 执行结果
     */
	mailboxgroup selectgroup(Long groupId);
}