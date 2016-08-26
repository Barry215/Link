package cn.SkyShadow.dao;

import cn.SkyShadow.model.school;

public interface schoolMapper {
	int deleteByPrimaryKey(Long schoolId);

	int insert(school record);

	school selectByPrimaryKey(Long schoolId);
}