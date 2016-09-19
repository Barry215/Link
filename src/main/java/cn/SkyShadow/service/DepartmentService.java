package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
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
    BaseExecution CreateDepartment(organization o);

    /**
     * 特定角色为一个部门指定一个最高管理者提交申请
     * @param apply 申请
     * @return 执行结果
     */
    BaseExecution AddAdmin(Apply apply);

    /**
     * 处理部门指定最高管理者的申请
     * @param r 回执
     * @return 执行结果
     */
    BaseExecution MakeAdminCallback(Receipt r);

    /**
     * 撤销部门指定最高管理者的申请
     * @param ApplyId 申请
     * @return 执行结果
     */
    BaseExecution RollBackAddAdmin(Long ApplyId);
    BaseExecution RemoveAdmin(Long depId, Long userid);
    /**
     * 特定角色为组织的创建者转移子部门的创建者提交申请
     * @param a 申请
     * @return 执行结果
     */
    BaseExecution DeliverDepartmentCreator(Apply a);

    /**
     * 撤销部门指定创建者的申请
     * @param applyId 申请ID
     * @return 执行结果
     */
    BaseExecution RollBackDeliverDepartmentCreator(Long applyId);

    /**
     * 处理部门指定创建者的申请
     * @param r 回执
     * @return 执行结果
     */
    BaseExecution DeliverDepartmentCreatorCallback(Receipt r);

    /**
     * 特定角色可以删除部门，不可撤销
     * @param DepId 部门ID
     * @return 执行结果
     */
    BaseExecution DeleteDepartment(Long DepId);

    /**
     * 特定角色可以修改部门的基本信息
     * @param o 部门信息
     * @return 执行结果
     */
    BaseExecution ModifyDepart(organization o);
}
