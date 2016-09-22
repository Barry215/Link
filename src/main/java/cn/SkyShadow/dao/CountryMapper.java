package cn.SkyShadow.dao;

import cn.SkyShadow.model.Country;

import java.util.List;

public interface CountryMapper {
    /**
     * 查询所有国家
     * @return 国家列表
     */
    List<Country> select();

    /**
     * 根据国家ID查询国家信息
     * @param countryId 国家ID
     * @return 国家信息
     */
    Country selectByPrimaryKey(Long countryId);
}