package cn.SkyShadow.dao;

import cn.SkyShadow.model.Organization;
import org.apache.ibatis.annotations.Param;

public interface OrganizationMapper {
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
    int insert(Organization record);

    /**
     * 查询组织全部信息
     * @param orgId 组织ID
     * @return 组织
     */
    Organization selectByPrimaryKey(Long orgId);

    /**
     * 删除临时的组织信息
     * @param orgId 组织ID
     * @return 执行结果
     */
    Organization selectByPrimaryKeyTemp(Long orgId);

    /**
     * 插入临时的组织数据
     * @param record 组织信息
     * @return 执行结果
     */
    int insertTemp(Organization record);

    /**
     * 更新组织的信息
     * @param record 组织信息
     * @return 执行结果
     */
    int updateByPrimaryKey(Organization record);

    /**
     * 查询组织的基本信息
     * @param orgId 组织ID
     * @return 组织
     */
    Organization selectBaseInfo(Long orgId);

    /**
     * 修改创建者
     * @param orgId 组织ID
     * @param userId 用户ID
     * @return 执行结果
     */
    int ModifyCreator(@Param("orgId") Long orgId, @Param("userId") Long userId);
    /**
     * 修改父组织
     * @param orgId 组织
     * @param parentId 父组织
     * @return 执行结果
     */
    int ModifyParent(@Param("orgId") Long orgId, @Param("parentId") Long parentId);

    /**
     * 是否有组织
     * @param name 组织名字
     * @return 执行解雇
     */
    String HasOrgName(String name);
}