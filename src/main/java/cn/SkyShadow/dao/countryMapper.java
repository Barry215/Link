package cn.SkyShadow.dao;

import cn.SkyShadow.model.country;

import java.util.List;

public interface countryMapper {
    /**
     * 查询所有国家
     * @return 国家列表
     */
    List<country> select();

    /**
     * 根据国家ID查询国家信息
     * @param countryId 国家ID
     * @return 国家信息
     */
    country selectByPrimaryKey(Long countryId);
}