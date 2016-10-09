package cn.SkyShadow.dao;

import cn.SkyShadow.model.apply.applyChildren.*;

/**
 * 申请数据处理
 * Created by RichardW on 9/13/2016.
 */
public interface ApplyMapper {
    int createModifyOrganization(ModifyOrganization apply);

    int createApplyParentOrg(ApplyParentOrg apply);

    int createApplyUnlockParentOrg(ApplyUnlockParentOrg apply);

    int createDeliverOrg(DeliverOrg apply);

    ModifyOrganization getModifyOrganization(Long applyId);

    ApplyParentOrg getApplyParentOrg(Long applyId);

    ApplyUnlockParentOrg getApplyUnlockParentOrg(Long applyId);

    DeliverOrg getDeliverOrg(Long applyId);
}
