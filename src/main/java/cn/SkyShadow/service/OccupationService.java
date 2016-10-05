package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.apply.applyChildren.*;
import cn.SkyShadow.model.apply.Receipt;


/**
 * 职位管理器
 */
public interface OccupationService {

    /**
     * 特定用户创建一个职位，并赋予职位权限，职位分为组织级别和部门级别。
     * @param occupation 职位
     * @return 执行结果
     */
	BaseExecution CreateOccupation(CreateOccupation occupation);

    /**
     * 处理申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution CreateOccupationCallback(Receipt<CreateOccupation> receipt);

    /**
     * 特定用户删除职位
     * @param occupationId 职位ID
     * @return 执行结果
     */
    BaseExecution DeleteOccupation(DeleteOccupation occupationId);

    /**
     * 处理删除职位的申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution DeleteOccupationCallback(Receipt<DeleteOccupation> receipt);

    /**
     * 特定用户修改职位的信息
     * @param apply 职位
     * @return 执行结果
     */
    BaseExecution ModifyOccupation(ModifyOccupation apply);

    /**
     * 处理修改职位信息的申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution ModifyOccupationCallback(Receipt<ModifyOccupation> receipt);

    /**
     * 特定用户修改职位的权限
     * @param occupation 职位
     * @return 执行结果
     */
    BaseExecution ModifyOccupation_Power(ModifyOccupation_Power occupation);

    /**
     * 将用户加入职位
     * @param apply 申请
     * @return 回执
     */
    BaseExecution AddUserToOccupation(AddUserToOccupation apply);
    /**
     * 处理将用户加入职位的申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution AddUserToOccupationCallBack(Receipt<AddUserToOccupation> receipt);

    /**
     * 特定用户将用户开除出职位
     * @param removeUser 信息
     * @return 执行结果
     */
    BaseExecution RemoveUser(RemoveUser removeUser);
}
