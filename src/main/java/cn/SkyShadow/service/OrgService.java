package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.enums.ApplyModel;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.*;

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
    BaseExecution modifyOrganization(ModifyOrganization apply, ApplyModel applyModel);

    /**
     * 处理组织修改信息
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution modifyOrganizationCallBack(Receipt<ModifyOrganization> receipt);
    /**
     * 向外申请父组织
     * @param applyParentOrg 申请
     * @return 执行
     */
    BaseExecution applyFatherOrganization(ApplyParentOrg applyParentOrg);

    /**
     * 处理其他组织父组织的申请
     * @param receipt 回执
     * @return 处理结果
     */
    BaseExecution applyFatherOrganizationCallback(Receipt<ApplyParentOrg> receipt);
    /**
     * 向外申请解除父组织
     * @param unlockParentOrg 申请
     * @return 执行
     */
    BaseExecution applyUnlockFatherOrganization(ApplyUnlockParentOrg unlockParentOrg);

    /**
     * 处理其他组织解除父组织的申请
     * @param receipt 回执
     * @return 处理结果
     */
    BaseExecution applyUnlockFatherOrganizationCallback(Receipt<ApplyUnlockParentOrg> receipt);
    /**
     * 申请转让组织的创建者
     * @param deliverOrg 申请
     * @return 执行结果
     */
    BaseExecution deliverOrganization(DeliverOrg deliverOrg);

    /**
     * 处理转让组织的创建者的申请
     * @param receipt 申请
     * @return 执行结果
     */
    BaseExecution deliverOrganizationCallback(Receipt<DeliverOrg> receipt);

    /**
     * 添加管理员
     * @param addAdmin 申请
     * @return 执行结果
     */
    BaseExecution addAdmin(AddAdmin addAdmin);

    /**
     * 处理添加管理员的申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution addAdminCallback(Receipt<AddAdmin> receipt);

    /**
     * 删除组织
     * @param userId 用户ID
     * @param orgId 组织ID
     * @return 执行结果
     */
    BaseExecution deleteOrganization(Long userId,Long orgId);

}
