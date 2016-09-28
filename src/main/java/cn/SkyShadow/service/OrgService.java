package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.enums.ApplyModel;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.ModifyOrganization;

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
     * 检查是否有这个组织名
     * @param Name 组织名
     * @return 结果
     */
    String HasOrgName(String Name);

    /**
     * 修改组织信息申请
     * @param apply 申请
     * @param applyModel 申请模式
     * @return 执行结果
     */
    ResultMapper modifyOrganization(ModifyOrganization apply, ApplyModel applyModel);

    /**
     *
     * @param receipt 回执
     * @return 执行结果
     */
    ResultMapper modifyOrganizationCallBack(Receipt<ModifyOrganization> receipt);
}
