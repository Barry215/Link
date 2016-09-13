package cn.SkyShadow.service;

import cn.SkyShadow.model.*;

import java.util.List;

/**
 * 职位管理器
 */
public interface OccupationService {

    /**
     * 特定用户创建一个职位，并赋予职位权限，职位分为组织级别和部门级别。
     * @param occupation
     * @return
     */
	Exception CreateOccupation(occupation occupation);

    /**
     * 特定用户删除职位
     * @param occupationId
     * @return
     */
    Exception DeleteOccupation(Long occupationId);

    /**
     * 特定用户修改职位的信息
     * @param occupation
     * @return
     */
    Exception ModifyOccupation(occupation occupation);

    /**
     * 特定用户修改职位的权限
     * @param occupation
     * @return
     */
    Exception ModifyOccupation_Power(occupation occupation);

    /**
     * 特定用户将用户加入职位（申请）
     * @param apply
     * @return
     */
    Exception AddUserToOccupation(Apply apply);

    /**
     * 撤销将用户加入职位
     * @param ApplyId
     * @return
     */
    Exception RollBackAddUserToOccupation(Long ApplyId);

    /**
     * 处理将用户加入职位的申请
     * @param receipt
     * @return
     */
    Exception AddUserToOccupationCallBcak(Receipt receipt);

    /**
     * 特定用户将用户开除出职位
     * @param userId
     * @param occuId
     * @return
     */
    Exception RemoveUser(Long userId,Long occuId);
}
