package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.mailboxgroup;

public interface mailboxgroupMapper {
	int deleteByPrimaryKey(Long groupId);

	int insert(mailboxgroup record);

	int addmail(@Param("mailbox_id") Long mailbox_id,
                @Param("mailgroup_id") Long mailgroup_id);
	
	mailboxgroup selectgroup(Long groupId);
}