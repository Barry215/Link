package cn.SkyShadow.dao;

import cn.SkyShadow.model.user_school;
import cn.SkyShadow.model.user_schoolKey;

import java.util.List;

public interface user_schoolMapper {
    int deleteByPrimaryKey(user_schoolKey key);

    int insert(user_school record);

    List<user_school> selectByPrimaryKey(Long key);

    int updateByPrimaryKey(user_school record);
}