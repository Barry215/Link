package cn.SkyShadow.dao;

import cn.SkyShadow.model.country;

import java.util.List;

public interface countryMapper {

    List<country> select();
    country selectByPrimaryKey(Long countryId);
}