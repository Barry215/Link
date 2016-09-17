package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Execution;
import cn.SkyShadow.model.*;

import java.util.List;

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
    Execution CreateNewOrg(organization org);

    /**
     * 修改父组织
     * @param o 组织
     * @return 结果
     */
    Execution ModifyOrg(organization o);
    /**
     * 申请父组织
     * @param a 申请
     * @return 申请结果
     */
    Execution ApplyParentOrg(Apply a);
    /**
     * 申请父组织(回调函数）
     *
     * @param r 回执
     * @return 执行结果
     */
    Execution ApplyParentOrgCallBack(Receipt r);

    /**
     * 撤回向外申请父组织
     * @param applyId 申请ID
     * @return 执行结果
     */
    Execution RollBackApplyParentOrg(Long applyId);

    /**
     * 解除父组织
     *
     * @param a 申请
     * @return 执行结果
     */
    Execution ApplyUnlockParentOrg(Apply a);

    /**
     * 撤回向外申请解除父组织
     * @param applyId 申请ID
     * @return 执行结果
     */
    Execution RollBackApplyUnlockParentOrg(Long applyId);
    /**
     * 申请解除父组织回调函数
     *
     * @param r 回执
     * @return 执行结果
     */
    Execution ApplyUnlockParentOrgCallBack(Receipt r);

    /**
     * 撤回申请转让组织的创建者
     * @param applyId 申请ID
     * @return 执行结果
     */
    Execution RollBackApplyUnlockParentOrgCallBack(Long applyId);

    /**
     * 转让组织的创建者(最高权限),不附带子部门
     *
     * @param a 申请
     * @return 执行结果
     */
    Execution DiliverOrgNotWithSonOrg(Apply a);

    /**
     * 转让组织的创建者(最高权限),附带子部门
     *
     * @param o 组织
     * @return 执行结果
     */
    Execution CreateDepartment(organization o);

    /**
     * 创建组织最高管理者
     * @param a 申请
     * @return 执行结果
     */
    Execution ComandDeparementLeader(Apply a);

    /**
     * 创建组织最高管理者
     * @param r 回执
     * @return 执行结果
     */
    Execution ComandDeparementLeaderCallBack(Receipt r);

    /**
     * 解除组织最高管理者
     * @param orgId 组织ID
     * @param userId  用户ID
     * @return 执行结果
     */
    Execution UnlockDeparementLeader(Long orgId, Long userId);

    /**
     * 搜索组织
     * @param str 搜索字段
     * @return 返回组织列表
     */
    List<organization> SearchOrg(String str);

    /**
     * 删除组织
     * @param ID 组织
     * @return 执行结果
     */
    Execution DeleteOrg(Long ID);

    /**
     * 检查是否有这个组织名
     * @param Name 组织名
     * @return 结果
     */
    String HasOrgName(String Name);
}
