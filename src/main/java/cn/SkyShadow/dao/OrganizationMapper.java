package cn.SkyShadow.dao;

import cn.SkyShadow.dto.file.FileList;
import cn.SkyShadow.model.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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
     * 添加管理员
     * @param orgId 组织ID
     * @param userId 用户ID
     * @return 执行结果
     */
    int AddAdmin(@Param("orgId") Long orgId, @Param("userId") Long userId);

    /**
     * 移除管理员
     * @param orgId 组织ID
     * @param userId 用户ID
     * @return 执行结果
     */
    int RemoveAdmin(@Param("orgId") Long orgId, @Param("userId") Long userId);

    /**
     * 获取所有文件
     * @param organizationID 组织ID
     * @return 执行结果
     */
    FileList GetFileList(Long organizationID);

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
    /**
     * 搜索组织
     * @param str 搜索字段
     * @return 返回组织列表
     */
    List<Organization> SearchOrg(String str);

    /**
     * 获取组织基本信息
     * @param orgId 组织ID
     * @return 返回组织信息
     */
}