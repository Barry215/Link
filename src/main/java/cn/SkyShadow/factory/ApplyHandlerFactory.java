package cn.SkyShadow.factory;

import cn.SkyShadow.model.apply.applyChildren.*;
import cn.SkyShadow.service.ApplyHandler;

/**
 * 申请方法工厂
 */
public class ApplyHandlerFactory {
    private final ApplyHandler<ModifyOrganization> modifyOrganizationApplyHandler;
    private final ApplyHandler<ApplyParentOrg> applyParentOrgApplyHandler;
    private final ApplyHandler<ApplyUnlockParentOrg> applyUnlockParentOrgApplyHandler;
    private final ApplyHandler<DeliverOrg> deliverOrgApplyHandler;

    public ApplyHandlerFactory(ApplyHandler<ModifyOrganization> modifyOrganizationApplyHandler,ApplyHandler<ApplyParentOrg> applyParentOrgApplyHandler, ApplyHandler<ApplyUnlockParentOrg> applyUnlockParentOrgApplyHandler, ApplyHandler<DeliverOrg> deliverOrgApplyHandler) {
        this.modifyOrganizationApplyHandler = modifyOrganizationApplyHandler;
        this.applyParentOrgApplyHandler = applyParentOrgApplyHandler;
        this.applyUnlockParentOrgApplyHandler = applyUnlockParentOrgApplyHandler;
        this.deliverOrgApplyHandler = deliverOrgApplyHandler;
    }

    public ApplyHandler<ModifyOrganization> getModifyOrganizationApplyHandler() {
        return modifyOrganizationApplyHandler;
    }

    public ApplyHandler<ApplyParentOrg> getApplyParentOrgApplyHandler() {
        return applyParentOrgApplyHandler;
    }

    public ApplyHandler<ApplyUnlockParentOrg> getApplyUnlockParentOrgApplyHandler() {
        return applyUnlockParentOrgApplyHandler;
    }

    public ApplyHandler<DeliverOrg> getDeliverOrgApplyHandler() {
        return deliverOrgApplyHandler;
    }
}
