package cn.SkyShadow.dao;

import cn.SkyShadow.model.city;

import java.util.List;

public interface cityMapper {

	List<city> select_zh();

	int deleteByPrimaryKey(Long cityID);

	int insert(city record);

	int updateByPrimaryKey(city record);
}