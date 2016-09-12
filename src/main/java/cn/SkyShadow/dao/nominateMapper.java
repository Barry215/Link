package cn.SkyShadow.dao;

import cn.SkyShadow.model.nominate;

public interface nominateMapper {
    /**
     * 删除名片
     * @param nominateId 名片ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long nominateId);

    /**
     * 插入名片
     * @param record 名片
     * @return 执行结果
     */
    int insert(nominate record);

    /**
     * 查询名片
     * @param nominateId 名片ID
     * @return 名片信息
     */
    nominate selectByPrimaryKey(Long nominateId);
}