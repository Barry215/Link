package cn.SkyShadow.dao;

import cn.SkyShadow.model.file;

public interface fileMapper {
    int deleteByPrimaryKey(Long fileId);

    int insert(file record);

    file selectByPrimaryKey(Long fileId);

    int updateByPrimaryKeySelective(file record);

    int updateByPrimaryKey(file record);
}