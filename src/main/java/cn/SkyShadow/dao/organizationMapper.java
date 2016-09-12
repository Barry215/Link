package cn.SkyShadow.dao;

import cn.SkyShadow.model.organization;

public interface organizationMapper {
    /**
     * 删除组织
     * @param orgId 组织ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long orgId);

    /**
     * 新建组织
     * @param record 组织
     * @return 执行结果
     */
    int insert(organization record);

    /**
     * 查询组织全部信息
     * @param orgId 组织ID
     * @return 组织
     */
    organization selectByPrimaryKey(Long orgId);

    /**
     * 更新组织的信息
     * @param record 组织信息
     * @return 执行结果
     */
    int updateByPrimaryKeySelective(organization record);

    /**
     * 查询组织的基本信息
     * @param orgId 组织ID
     * @return 组织
     */
    organization selectBaseInfo(Long orgId);

}