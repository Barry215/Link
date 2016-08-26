package cn.SkyShadow.dao;

import cn.SkyShadow.model.friendgroup;

public interface friendgroupMapper {
    int deleteByPrimaryKey(Long friendgroupId);

    int insert(friendgroup record);

    friendgroup selectByPrimaryKey(Long friendgroupId);
}