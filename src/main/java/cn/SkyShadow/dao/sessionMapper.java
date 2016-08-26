package cn.SkyShadow.dao;

import cn.SkyShadow.model.session;

public interface sessionMapper {
    int deleteByPrimaryKey(Long sessionId);

    int insert(session record);

    session selectByPrimaryKey(Long sessionId);

}