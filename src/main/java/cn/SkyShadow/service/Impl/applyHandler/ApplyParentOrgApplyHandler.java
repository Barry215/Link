package cn.SkyShadow.service.Impl.applyHandler;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.applyChildren.ApplyParentOrg;
import cn.SkyShadow.service.ApplyHandler;

/**
 * 申请父组织
 * Created by RichardW on 10/1/2016.
 */
public class ApplyParentOrgApplyHandler extends ApplyHandler<ApplyParentOrg>{
    private final OrganizationMapper organizationMapper;
    private final ApplyMapper applyMapper;

    public ApplyParentOrgApplyHandler(OrganizationMapper organizationMapper, ApplyMapper applyMapper) {
        this.organizationMapper = organizationMapper;
        this.applyMapper = applyMapper;
    }

    @Override
    public ResultMapper doSomeThing_FULL(ApplyParentOrg apply) {
        organizationMapper.ModifyParent(apply.getSon().getOrgId(),apply.getFather().getOrgId());
        return ResultMapper.SUCCESS;
    }

    @Override
    public ResultMapper doSomeThing_APPLY_AVAILABLE(ApplyParentOrg apply) {
        applyMapper.createApplyParentOrg(apply);
        return ResultMapper.SUCCESS;
    }
}
