package cn.SkyShadow.dao;

import cn.SkyShadow.model.at;

public interface atMapper {
    int insert(at at);

    at selectByPrimaryKey(Long atId);
}