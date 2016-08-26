package cn.SkyShadow.dao;

import cn.SkyShadow.model.occupation;

public interface occupationMapper {
    int deleteByPrimaryKey(Long occupationId);

    int insert(occupation record);

    occupation selectByPrimaryKey(Long occupationId);

    int updateByPrimaryKeySelective(occupation record);

}