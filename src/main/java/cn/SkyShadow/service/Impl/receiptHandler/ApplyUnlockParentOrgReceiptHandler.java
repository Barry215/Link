package cn.SkyShadow.service.Impl.receiptHandler;

import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.model.apply.applyChildren.ApplyUnlockParentOrg;
import cn.SkyShadow.service.ReceiptHandler;


public class ApplyUnlockParentOrgReceiptHandler extends ReceiptHandler<ApplyUnlockParentOrg>{
    private final OrganizationMapper organizationMapper;
    private final ReceiptMapper receiptMapper;

    public ApplyUnlockParentOrgReceiptHandler(OrganizationMapper organizationMapper, ReceiptMapper receiptMapper) {
        this.organizationMapper = organizationMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public void doIfAgree() {
        organizationMapper.ModifyParent(receipt.getApply().getSon().getOrgId(),null);
        receiptMapper.create(receipt);
    }

    @Override
    public void doIfDisagree() {
        receiptMapper.create(receipt);
    }
}
