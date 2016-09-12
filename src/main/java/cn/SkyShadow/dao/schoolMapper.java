package cn.SkyShadow.dao;

import cn.SkyShadow.model.school;

public interface schoolMapper {
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
	int insert(school record);

    /**
     * 查询学校
     * @param schoolId 学校ID
     * @return 学校
     */
	school selectByPrimaryKey(Long schoolId);
}