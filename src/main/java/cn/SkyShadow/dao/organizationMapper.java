package cn.SkyShadow.dao;

import cn.SkyShadow.dto.file.FileList;
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

    /**
     * 修改创建者
     * @param orgId 组织ID
     * @param userId 用户ID
     * @return 执行结果
     */
    int ModifyCreator(Long orgId,Long userId);

    /**
     * 添加管理员
     * @param orgId 组织ID
     * @param userId 用户ID
     * @return 执行结果
     */
    int AddAdmin(Long orgId,Long userId);

    /**
     * 移除管理员
     * @param orgId 组织ID
     * @param userId 用户ID
     * @return 执行结果
     */
    int RemoveAdmin(Long orgId,Long userId);

    /**
     * 获取所有文件
     * @param organizationID 组织ID
     * @return 执行结果
     */
    FileList GetFileList(Long organizationID);//// TODO: 9/14/2016
}