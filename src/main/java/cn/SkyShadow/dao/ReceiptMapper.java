package cn.SkyShadow.dao;

import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.ApplyParentOrg;
import cn.SkyShadow.model.apply.applyChildren.ApplyUnlockParentOrg;
import cn.SkyShadow.model.apply.applyChildren.ModifyOrganization;

/**
 * 回执数据处理
 * Created by RichardW on 9/13/2016.
 */
public interface ReceiptMapper {
    int create(Receipt receipt);

    Receipt<ModifyOrganization> getModifyOrganization(Long receiptId);

    Receipt<ApplyParentOrg> getApplyParentOrg(Long receiptId);

    Receipt<ApplyUnlockParentOrg> getApplyUnlockParentOrg(Long receiptId);

    Receipt<ApplyUnlockParentOrg> getDeliverOrg(Long receiptId);
}
