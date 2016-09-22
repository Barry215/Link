package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.*;

/**
 * 组织管理
 */
public interface OrgService {
    /**
     * 创建一个新组织
     *
     * @param org 创建一个新组织
     * @return 创建结果
     */
    BaseExecution CreateNewOrg(Organization org);

    /**
     * 获取基本信息
     * @param orgId 组织ID
     * @return 组织信息
     */
    Organization getBaseInfo(Long orgId);

    /**
     * 修改组织
     * @param o 组织
     * @return 结果
     */
    BaseExecution ModifyOrg(Organization o);
    /**
     * 检查是否有这个组织名
     * @param Name 组织名
     * @return 结果
     */
    String HasOrgName(String Name);
}
