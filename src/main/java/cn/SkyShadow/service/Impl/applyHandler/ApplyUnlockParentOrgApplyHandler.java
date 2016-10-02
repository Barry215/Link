package cn.SkyShadow.service.Impl.applyHandler;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.applyChildren.ApplyUnlockParentOrg;
import cn.SkyShadow.service.ApplyHandler;

/**
 * 申请解除父组织
 * Created by RichardW on 10/1/2016.
 */
public class ApplyUnlockParentOrgApplyHandler extends ApplyHandler<ApplyUnlockParentOrg>{
    private final OrganizationMapper organizationMapper;
    private final ApplyMapper applyMapper;

    public ApplyUnlockParentOrgApplyHandler(OrganizationMapper organizationMapper, ApplyMapper applyMapper) {
        this.organizationMapper = organizationMapper;
        this.applyMapper = applyMapper;
    }

    @Override
    public ResultMapper doSomeThing_FULL(ApplyUnlockParentOrg apply) {
        organizationMapper.ModifyParent(apply.getSon().getOrgId(),null);
        return ResultMapper.SUCCESS;
    }

    @Override
    public ResultMapper doSomeThing_APPLY_AVAILABLE(ApplyUnlockParentOrg apply) {
        applyMapper.createApplyUnlockParentOrg(apply);
        return ResultMapper.SUCCESS;
    }
}
