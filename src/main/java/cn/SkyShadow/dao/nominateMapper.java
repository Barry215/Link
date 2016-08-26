package cn.SkyShadow.dao;

import cn.SkyShadow.model.nominate;

public interface nominateMapper {
    int deleteByPrimaryKey(Long nominateId);

    int insert(nominate record);

    nominate selectByPrimaryKey(Long nominateId);
}