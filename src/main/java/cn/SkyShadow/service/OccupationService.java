package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.*;


/**
 * 职位管理器
 */
public interface OccupationService {

    /**
     * 特定用户创建一个职位，并赋予职位权限，职位分为组织级别和部门级别。
     * @param occupation 职位
     * @return 执行结果
     */
	BaseExecution CreateOccupation(occupation occupation);

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
    BaseExecution ModifyOccupation(occupation occupation);

    /**
     * 特定用户修改职位的权限
     * @param occupation 职位
     * @return 执行结果
     */
    BaseExecution ModifyOccupation_Power(occupation occupation);

    /**
     * 特定用户将用户加入职位（申请）
     * @param apply 申请
     * @return 执行结果
     */
    BaseExecution AddUserToOccupation(Apply apply);

    /**
     * 撤销将用户加入职位
     * @param ApplyId 职位ID
     * @return 执行结果
     */
    BaseExecution RollBackAddUserToOccupation(Long ApplyId);

    /**
     * 处理将用户加入职位的申请
     * @param receipt 回执
     * @return 执行结果
     */
    BaseExecution AddUserToOccupationCallBcak(Receipt receipt);

    /**
     * 特定用户将用户开除出职位
     * @param userId 用户ID
     * @param occuId 职位
     * @return 执行结果
     */
    BaseExecution RemoveUser(Long userId, Long occuId);
}
