package cn.SkyShadow.service.Impl.receiptHandler;

import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.model.apply.applyChildren.ApplyParentOrg;
import cn.SkyShadow.service.ReceiptHandler;


public class ApplyParentOrgReceiptHandler extends ReceiptHandler<ApplyParentOrg>{
    private final OrganizationMapper organizationMapper;
    private final ReceiptMapper receiptMapper;

    public ApplyParentOrgReceiptHandler(OrganizationMapper organizationMapper, ReceiptMapper receiptMapper) {
        this.organizationMapper = organizationMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public void doIfAgree() {
        organizationMapper.ModifyParent(receipt.getApply().getSon().getOrgId(),
                receipt.getApply().getFather().getOrgId());
        receiptMapper.create(receipt);
    }

    @Override
    public void doIfDisagree() {
        receiptMapper.create(receipt);
    }
}
