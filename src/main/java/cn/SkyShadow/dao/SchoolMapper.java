package cn.SkyShadow.dao;

import cn.SkyShadow.model.School;

public interface SchoolMapper {
	/**
	 * 删除学校
	 * @param schoolId 学校ID
	 * @return 执行结果
	 */
	int deleteByPrimaryKey(Long schoolId);

    /**
     * 新建学校
     * @param record 学校信息
     * @return 执行结果
     */
	int insert(School record);

    /**
     * 查询学校
     * @param schoolId 学校ID
     * @return 学校
     */
	School selectByPrimaryKey(Long schoolId);
}