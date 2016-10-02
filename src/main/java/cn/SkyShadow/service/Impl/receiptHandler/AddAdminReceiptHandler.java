package cn.SkyShadow.service.Impl.receiptHandler;

import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.model.apply.applyChildren.AddAdmin;
import cn.SkyShadow.service.ReceiptHandler;

/**
 * Created by RichardW on 10/1/2016.
 */
public class AddAdminReceiptHandler extends ReceiptHandler<AddAdmin>{
    private final OrganizationMapper organizationMapper;
    private final ReceiptMapper receiptMapper;

    public AddAdminReceiptHandler(OrganizationMapper organizationMapper, ReceiptMapper receiptMapper) {
        this.organizationMapper = organizationMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public void doIfAgree() {
        organizationMapper.AddAdmin(receipt.getApply().getOrganization().getOrgId(),
                receipt.getApply().getAdmin().getUserId());
        receiptMapper.Create(receipt);
    }

    @Override
    public void doIfDisagree() {
        receiptMapper.Create(receipt);
    }
}
