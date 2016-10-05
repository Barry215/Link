package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.applyChildren.CreateDepartment;
import cn.SkyShadow.model.apply.applyChildren.DeleteDepartment;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.ModifyDepartment;


/**
 * 部门管理器
 * Created by RichardW on 9/12/2016.
 */
public interface DepartmentService {
    /**
     * 特定角色可以在组织下创建一个部门，并且让组织的创建者成为部门的创建者
     * 或者
     * 特定角色在当前部门下新建子部门，并且让本部门的创建者成为这个子部门的创建者
     * @param apply 申请
     * @return 执行结果
     */
    BaseExecution CreateDepartment(CreateDepartment apply);

    /**
     * 处理创建部门的请求
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution CreateDepartmentCallback(Receipt<CreateDepartment> receipt);

    /**
     * 删除部门
     * @param apply 申请
     * @return 执行结果
     */
    BaseExecution DeleteDepartment(DeleteDepartment apply);

    /**
     * 处理删除部门的申请
     * @param receipt 执行结果
     * @return 执行结果
     */
    BaseExecution DeleteDepartmentCallback(Receipt<DeleteDepartment> receipt);

    /**
     * 特定角色可以修改部门的基本信息
     * @param apply 部门信息
     * @return 执行结果
     */
    BaseExecution ModifyDepartment(ModifyDepartment apply);

    /**
     * 处理修改部门信息的请求
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution ModifyDepartment(Receipt<ModifyDepartment> receipt);
}
