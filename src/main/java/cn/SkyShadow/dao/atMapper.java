package cn.SkyShadow.dao;

import cn.SkyShadow.model.at;

public interface atMapper {
    /**
     * 插入一个"提到"
     * @param at 提到
     * @return 执行结果
     */
    int insert(at at);

    /**
     * 查询并返回一个at
     * @param atId at的ID
     * @return AT
     */
    at selectByPrimaryKey(Long atId);
}