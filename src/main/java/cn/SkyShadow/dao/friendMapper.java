package cn.SkyShadow.dao;

import cn.SkyShadow.model.friend;

import java.util.List;

public interface friendMapper {
    int deleteByPrimaryKey(Long friendId);

    int insert(friend record);

    List<friend> selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(friend record);

}