package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dto.org.Org_usership;
import cn.SkyShadow.model.Apply;
import cn.SkyShadow.model.Receipt;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

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
    Excution CreateNewOrg(organization org);

    /**
     * 获取用户在组织内的职务（是否是创建者或者管理员等等）
     * @param u 用户
     * @param o 组织
     * @return 结果
     */
    Org_usership getOrg_usership(user u,organization o);
    /**
     * 修改组织基本信息
     * @param u 用户
     * @param o 组织
     * @return 修改结果
     */
    Excution ModifyOrg(organization o,user u);

    /**
     * 申请父组织
     *
     * @param o      组织
     * @param parent 父组织
     * @param a      申请
     * @return 申请结果
     */
    Excution ApplyParentOrg(organization o, organization parent, Apply a);

    /**
     * 申请父组织(回调函数)
     *
     * @param r 回执
     * @return 执行结果
     */
    Excution ApplyParentOrgCallBack(Receipt r);

    /**
     * 解除父组织
     *
     * @param o 组织
     * @param a 申请
     * @return 执行结果
     */
    Excution ApplyUnlockParentOrg(organization o, Apply a);

    /**
     * 申请解锁父组织回调函数
     *
     * @param r 回执
     * @return 执行结果
     */
    Excution ApplyUnlockParentOrgCallBack(Receipt r);

    /**
     * 转让组织的创建者(最高权限),不附带子部门
     *
     * @param o 组织
     * @param u 被转让者
     * @param a 申请
     * @return 执行结果
     */
    Excution DiliverOrgNotWithSonOrg(organization o, user u, Apply a);

    /**
     * 转让组织的创建者(最高权限),附带子部门
     *
     * @param o 组织
     * @param u 被转让着
     * @param a 被转让者
     * @return 执行结果
     */
    Excution DeliverOrgWithSonOrg(organization o, user u, Apply a);

    /**
     * 创建部门
     * @param o 创建部门
     * @return 执行结果
     */
    Excution CreateDepartment(organization o);

    /**
     * 创建组织最高管理者
     * @param o 组织
     * @param u 用户
     * @param a 申请
     * @return 执行结果
     */
    Excution ComandDeparementLeader(organization o, user u, Apply a);

    /**
     * 创建组织最高管理者
     * @param r 回执
     * @return 执行结果
     */
    Excution ComandDeparementLeaderCallBack(Receipt r);

    /**
     * 解除组织最高管理者
     * @param o 组织
     * @return 执行结果
     */
    Excution UnlockDeparementLeader(organization o);

    /**
     * 搜索组织
     * @param str 搜索字段
     * @return 返回组织列表
     */
    List<organization> SearchOrg(String str);
}
