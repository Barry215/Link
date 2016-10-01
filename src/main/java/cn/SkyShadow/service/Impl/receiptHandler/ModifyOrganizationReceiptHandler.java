package cn.SkyShadow.service.Impl.receiptHandler;

import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.model.apply.applyChildren.ModifyOrganization;
import cn.SkyShadow.service.ReceiptHandler;

/**
 * 修改组织信息
 * Created by RichardW on 10/1/2016.
 */
public class ModifyOrganizationReceiptHandler extends ReceiptHandler<ModifyOrganization>{
    private final OrganizationMapper organizationMapper;
    private final ReceiptMapper receiptMapper;

    public ModifyOrganizationReceiptHandler(OrganizationMapper organizationMapper, ReceiptMapper receiptMapper) {
        this.organizationMapper = organizationMapper;
        this.receiptMapper = receiptMapper;
    }

    @Override
    public void doIfAgree() {
        organizationMapper.updateByPrimaryKey(receipt.getApply().getOrganization());
        receiptMapper.Create(receipt);
    }

    @Override
    public void doIfDisagree() {
        receiptMapper.Create(receipt);
    }
}
