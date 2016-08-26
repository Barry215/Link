package cn.SkyShadow.dao;

import cn.SkyShadow.model.voice;

public interface voiceMapper {
    int deleteByPrimaryKey(Long voiceId);

    int insert(voice record);

    voice selectByPrimaryKey(Long voiceId);
}