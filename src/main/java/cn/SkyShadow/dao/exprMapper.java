package cn.SkyShadow.dao;

import cn.SkyShadow.model.expr;

public interface exprMapper {
    int deleteByPrimaryKey(Long exprId);

    int insert(expr record);

    expr selectByPrimaryKey(Long exprId);
}