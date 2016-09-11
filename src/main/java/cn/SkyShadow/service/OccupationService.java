package cn.SkyShadow.service;

import cn.SkyShadow.model.occupation;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

import java.util.List;

public interface OccupationService {
	/**
	 * 创建职位
	 * @param org 职位所在的组织
	 * @param u 创建的用户
	 * @param o 创建的职位信息
	 * @return 执行结果
	 */
	 int CreateNewOccupation(organization org, occupation o, user u);

	/**
	 * 更改的职位信息
	 * @param o 职位
	 * @param u 操作的用户
	 * @return 执行结果
	 */
	 int ModifyOccupation(occupation o, user u);

	/**
	 * 获取职位列表
	 * @param o 组织
	 * @return 职位列表
	 */
	 List<occupation> GetOccupationList(organization o);

	/**
	 * 获取当前职位有哪些人
	 * @param o 职位
	 * @return 用户列表
	 */
	 List<user> getUserList(occupation o);
}
