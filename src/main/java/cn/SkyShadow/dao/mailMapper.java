package cn.SkyShadow.dao;

import cn.SkyShadow.model.mail;

public interface mailMapper {
    int deleteByPrimaryKey(Long mailId);

    int insertSelective(mail record);

    mail selectByPrimaryKey(Long mailId);

}