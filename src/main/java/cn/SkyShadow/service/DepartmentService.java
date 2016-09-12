package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.dto.file.FileList;
import cn.SkyShadow.model.*;


/**
 * 部门管理器
 * Created by RichardW on 9/12/2016.
 */
public interface DepartmentService {
    /**
     * 特定角色可以在组织下创建一个部门，并且让组织的创建者成为部门的创建者
     * 或者
     * 特定角色在当前部门下新建子部门，并且让本部门的创建者成为这个子部门的创建者
     * @param o 组织
     * @return 执行结果
     */
    Excution CreateDepartment(organization o,organization father);

    /**
     * 特定角色为一个部门指定一个最高管理者提交申请
     * @param user 用户
     * @param o 组织
     * @return 执行结果
     */
    Excution MakeAdmin(user user,organization o);

    /**
     * 处理部门指定最高管理者的申请
     * @param r 回执
     * @return 执行结果
     */
    Excution MakeAdminCallback(Receipt r);

    /**
     * 撤销部门指定最高管理者的申请
     * @param ApplyId 申请
     * @return 执行结果
     */
    Excution MakeAdmin(Long ApplyId);

    /**
     * 特定角色为组织的创建者转移子部门的创建者提交申请
     * @param a 申请
     * @return 执行结果
     */
    Excution DeliverDepartmentCreator(Apply a);

    /**
     * 撤销部门指定创建者的申请
     * @param applyId 申请ID
     * @return 执行结果
     */
    Excution RollBackDeliverDepartmentCreator(Long applyId);

    /**
     * 处理部门指定创建者的申请
     * @param r 回执
     * @return 执行结果
     */
    Excution DeliverDepartmentCreatorCallback(Receipt r);

    /**
     * 特定角色可以删除部门，不可撤销
     * @param DepId 部门ID
     * @return 执行结果
     */
    Excution DeleteDepartment(Long DepId);

    /**
     * 特定角色可以修改部门的基本信息
     * @param o 部门信息
     * @return 执行结果
     */
    Excution ModifyDepart(organization o);

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
    /**
     * 发布组织公告
     * @param a 公告
     * @param o 组织
     * @return 执行结果
     */
    Excution Announce(announce a, organization o);

    /**
     * 删除公告
     * @param annId 公告ID
     * @return 执行结果
     */
    Excution DeleteAnnounce(Long annId);
}