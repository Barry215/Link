package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.model.apply.ApplyChildren.AddAdmin;
import cn.SkyShadow.model.apply.ApplyChildren.DeliverDepartmentCreator;
import cn.SkyShadow.model.apply.Receipt;


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
    BaseExecution CreateDepartment(Organization o);

    /**
     * 处理部门指定最高管理者的申请
     * @param r 回执
     * @return 执行结果
     */
    BaseExecution MakeAdminCallback(Receipt<AddAdmin> r);

    /**
     * 撤销管理人员
     * @param depId 部门的ID
     * @param userId 用户ID
     * @return 执行结果
     */
    BaseExecution RemoveAdmin(Long depId, Long userId);

    /**
     * 处理部门指定创建者的申请
     * @param r 回执
     * @return 执行结果
     */
    BaseExecution DeliverDepartmentCreatorCallback(Receipt<DeliverDepartmentCreator> r);

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
    BaseExecution ModifyDepart(Organization o);
}
