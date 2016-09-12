package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dto.file.FileList;
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
    Excution CreateNewOrg(organization org);

    /**
     * 获取用户在组织内的职务（是否是创建者或者管理员等等）
     * @param u 用户
     * @param o 组织
     * @return 结果
     */
    Excution ModifyOrg(organization o);
    /**
     * 申请父组织
     * @param a 申请
     * @return 申请结果
     */
    Excution ApplyParentOrg(Apply a);
    /**
     * 申请父组织(回调函数）
     *
     * @param r 回执
     * @return 执行结果
     */
    Excution ApplyParentOrgCallBack(Receipt r);

    /**
     * 撤回向外申请父组织
     * @param applyId 申请ID
     * @return 执行结果
     */
    Excution RollBackApplyParentOrg(Long applyId);

    /**
     * 解除父组织
     *
     * @param a 申请
     * @return 执行结果
     */
    Excution ApplyUnlockParentOrg(Apply a);

    /**
     * 撤回向外申请解除父组织
     * @param applyId 申请ID
     * @return 执行结果
     */
    Excution RollBackApplyUnlockParentOrg(Long applyId);
    /**
     * 申请解除父组织回调函数
     *
     * @param r 回执
     * @return 执行结果
     */
    Excution ApplyUnlockParentOrgCallBack(Receipt r);

    /**
     * 撤回申请转让组织的创建者
     * @param applyId 申请ID
     * @return 执行结果
     */
    Excution RollBackApplyUnlockParentOrgCallBack(Long applyId);

    /**
     * 转让组织的创建者(最高权限),不附带子部门
     *
     * @param a 申请
     * @return 执行结果
     */
    Excution DiliverOrgNotWithSonOrg(Apply a);

    /**
     * 转让组织的创建者(最高权限),附带子部门
     *
     * @param o 组织
     * @return 执行结果
     */
    Excution CreateDepartment(organization o);

    /**
     * 创建组织最高管理者
     * @param a 申请
     * @return 执行结果
     */
    Excution ComandDeparementLeader(Apply a);

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

    /**
     * 删除组织
     * @param o 组织
     * @return 执行结果
     */
    Excution DeleteOrg(organization o);

    /**
     * 发布组织公告
     * @param a 公告
     * @param o 组织
     * @return 执行结果
     */
    Excution Announce(announce a,organization o);

    /**
     * 删除公告
     * @param annId 公告ID
     * @return 执行结果
     */
    Excution DeleteAnnounce(Long annId);
    /**
     * 特定角色为部门上传文件
     * @param file 文件
     * @return 执行结果
     */
    Excution UpdateFile(file file);

    /**
     * 特定角色为部门上传文件组
     * @param filegroup 文件组
     * @return 执行结果
     */
    Excution UpdateFileGroup(filegroup filegroup);
    /**
     * 特定角色获取部门文件列表
     * @param organization 组织
     * @return 执行结果
     */
    FileList GetFileList(organization organization);

    /**
     * 特定角色删除部门文件
     * @param fileId 文件ID
     * @return 执行结果
     */
    Excution DeleteFile(Long fileId);
    /**
     * 特定角色删除部门文件组
     * @param filegroupId 文件组ID
     * @return 执行结果
     */
    Excution DeleteFileGroup(Long filegroupId);
}
