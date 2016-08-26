package cn.SkyShadow.dao;

import cn.SkyShadow.model.content;

import java.util.List;

public interface contentMapper {
    int deleteByPrimaryKey(Long contentID);

    int insertSelective(content record);

    List<content> selectByPrimaryKey(Long contentID);

    int updateByPrimaryKeySelective(content record);
}