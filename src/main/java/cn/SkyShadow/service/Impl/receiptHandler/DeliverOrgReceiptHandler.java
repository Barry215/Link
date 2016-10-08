package cn.SkyShadow.service.Impl.receiptHandler;

import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.model.apply.applyChildren.DeliverOrg;
import cn.SkyShadow.service.ReceiptHandler;

public class DeliverOrgReceiptHandler extends ReceiptHandler<DeliverOrg>{
    private final OrganizationMapper organizationMapper;
    private final ReceiptMapper receiptMapper;

    public DeliverOrgReceiptHandler(OrganizationMapper organizationMapper, ReceiptMapper receiptMapper) {
        this.organizationMapper = organizationMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public void doIfAgree() {
        organizationMapper.ModifyCreator(receipt.getApply().getOrganization().getOrgId(),
                receipt.getApply().getU().getUserId());
        receiptMapper.create(receipt);
    }

    @Override
    public void doIfDisagree() {
        receiptMapper.create(receipt);
    }
}
