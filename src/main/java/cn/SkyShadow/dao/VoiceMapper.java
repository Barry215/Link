package cn.SkyShadow.dao;

import cn.SkyShadow.model.Voice;

public interface VoiceMapper {
    /**
     * 删除语音
     * @param voiceId 语音ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long voiceId);

    /**
     * 新建一条语音
     * @param record 语音
     * @return 执行结果
     */
    int insert(Voice record);

    /**
     * 查询语音
     * @param voiceId 语音ID
     * @return 语音信息
     */
    Voice selectByPrimaryKey(Long voiceId);
}