package cn.SkyShadow.dao;

import cn.SkyShadow.model.imagine;

public interface imagineMapper {
    int deleteByPrimaryKey(Long imgId);

    int insertSelective(imagine record);

    imagine selectByPrimaryKey(Long imgId);

    int updateByPrimaryKey(imagine record);
}