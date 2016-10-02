package cn.SkyShadow.service.Impl.applyHandler;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.applyChildren.DeliverOrg;
import cn.SkyShadow.service.ApplyHandler;

/**
 * 转移组织
 * Created by RichardW on 10/1/2016.
 */
public class DeliverOrgApplyHandler extends ApplyHandler<DeliverOrg>{
    private final OrganizationMapper organizationMapper;
    private final ApplyMapper applyMapper;

    public DeliverOrgApplyHandler(OrganizationMapper organizationMapper, ApplyMapper applyMapper) {
        this.organizationMapper = organizationMapper;
        this.applyMapper = applyMapper;
    }

    @Override
    public ResultMapper doSomeThing_FULL(DeliverOrg apply) {
        organizationMapper.ModifyCreator(apply.getOrganization().getOrgId(),apply.getU().getUserId());
        return ResultMapper.SUCCESS;
    }

    @Override
    public ResultMapper doSomeThing_APPLY_AVAILABLE(DeliverOrg apply) {
        applyMapper.createDeliverOrg(apply);
        return ResultMapper.SUCCESS;
    }
}
