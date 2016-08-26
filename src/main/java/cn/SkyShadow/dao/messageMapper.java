package cn.SkyShadow.dao;

import cn.SkyShadow.model.message;

public interface messageMapper {
	int deleteByPrimaryKey(Long msgId);

	int insert(message record);

	message selectByPrimaryKey(Long msgId);
}