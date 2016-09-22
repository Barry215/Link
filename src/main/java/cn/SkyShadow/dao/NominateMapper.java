package cn.SkyShadow.dao;

import cn.SkyShadow.model.Nominate;

public interface NominateMapper {
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
    int insert(Nominate record);

    /**
     * 查询名片
     * @param nominateId 名片ID
     * @return 名片信息
     */
    Nominate selectByPrimaryKey(Long nominateId);
}