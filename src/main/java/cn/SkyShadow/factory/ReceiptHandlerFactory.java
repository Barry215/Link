package cn.SkyShadow.factory;

import cn.SkyShadow.model.apply.applyChildren.*;
import cn.SkyShadow.service.Impl.receiptHandler.ModifyOrganizationReceiptHandler;
import cn.SkyShadow.service.ReceiptHandler;

/**
 * 处理方法工厂
 * Created by RichardW on 10/1/2016.
 */
public class ReceiptHandlerFactory {
    private final ReceiptHandler<ModifyOrganization> modifyOrganizationReceiptHandler;
    private final ReceiptHandler<AddAdmin> addAdminReceiptHandler;
    private final ReceiptHandler<ApplyParentOrg> applyParentOrgReceiptHandler;
    private final ReceiptHandler<ApplyUnlockParentOrg> applyUnlockParentOrgReceiptHandler;
    private final ReceiptHandler<DeliverOrg> deliverOrgReceiptHandler;

    public ReceiptHandlerFactory(ModifyOrganizationReceiptHandler modifyOrganizationReceiptHandler, ReceiptHandler<AddAdmin> addAdminReceiptHandler, ReceiptHandler<ApplyParentOrg> applyParentOrgReceiptHandler, ReceiptHandler<ApplyUnlockParentOrg> applyUnlockParentOrgReceiptHandler, ReceiptHandler<DeliverOrg> deliverOrgReceiptHandler) {
        this.modifyOrganizationReceiptHandler = modifyOrganizationReceiptHandler;
        this.addAdminReceiptHandler = addAdminReceiptHandler;
        this.applyParentOrgReceiptHandler = applyParentOrgReceiptHandler;
        this.applyUnlockParentOrgReceiptHandler = applyUnlockParentOrgReceiptHandler;
        this.deliverOrgReceiptHandler = deliverOrgReceiptHandler;
    }

    public ReceiptHandler<ModifyOrganization> getModifyOrganizationReceiptHandler() {
        return modifyOrganizationReceiptHandler;
    }

    public ReceiptHandler<AddAdmin> getAddAdminReceiptHandler() {
        return addAdminReceiptHandler;
    }

    public ReceiptHandler<ApplyParentOrg> getApplyParentOrgReceiptHandler() {
        return applyParentOrgReceiptHandler;
    }

    public ReceiptHandler<ApplyUnlockParentOrg> getApplyUnlockParentOrgReceiptHandler() {
        return applyUnlockParentOrgReceiptHandler;
    }

    public ReceiptHandler<DeliverOrg> getDeliverOrgReceiptHandler() {
        return deliverOrgReceiptHandler;
    }
}
