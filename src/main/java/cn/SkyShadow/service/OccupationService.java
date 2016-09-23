package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.Apply;
import cn.SkyShadow.model.apply.ApplyChildren.AddUserToOccupation;
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
	BaseExecution CreateOccupation(Occupation occupation);

    /**
     * 特定用户删除职位
     * @param occupationId 职位ID
     * @return 执行结果
     */
    BaseExecution DeleteOccupation(Long occupationId);

    /**
     * 特定用户修改职位的信息
     * @param occupation 职位
     * @return 执行结果
     */
    BaseExecution ModifyOccupation(Occupation occupation);

    /**
     * 特定用户修改职位的权限
     * @param occupation 职位
     * @return 执行结果
     */
    BaseExecution ModifyOccupation_Power(Occupation occupation);

    /**
     * 处理将用户加入职位的申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution AddUserToOccupationCallBack(Receipt<AddUserToOccupation> receipt);

    /**
     * 特定用户将用户开除出职位
     * @param userId 用户ID
     * @param occupationId 职位
     * @return 执行结果
     */
    BaseExecution RemoveUser(Long userId, Long occupationId);
}
