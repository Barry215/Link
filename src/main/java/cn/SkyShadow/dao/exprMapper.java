package cn.SkyShadow.dao;

import cn.SkyShadow.model.expr;

public interface exprMapper {
    /**
     * 删除指定的表情
     * @param exprId 表情ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long exprId);

    /**
     * 插入一个表情
     * @param record 表情
     * @return 执行结果
     */
    int insert(expr record);

    /**
     * 根据ID来选择表情
     * @param exprId 表情ID
     * @return 表情
     */
    expr selectByPrimaryKey(Long exprId);
}