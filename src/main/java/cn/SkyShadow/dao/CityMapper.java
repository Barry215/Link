package cn.SkyShadow.dao;

import cn.SkyShadow.model.City;

import java.util.List;

public interface CityMapper {
	/**
	 * 查询中国境内的城市列表,包括了省份信息和国家信息
	 * @return 城市列表
	 */
	List<City> select_zh();

	/**
	 * 删除指定的城市
	 * @param cityID 城市ID
	 * @return 执行结果,成功返回1
	 */
	int deleteByPrimaryKey(Long cityID);

	/**
	 * 插入一个城市
	 * @param record 城市
	 * @return 执行结果,成功返回1
	 */
	int insert(City record);

	/**
	 * 编辑城市信息
	 * @param record 更新后带有城市ID属性的城市信息
	 * @return 执行结果
	 */
	int updateByPrimaryKey(City record);
}