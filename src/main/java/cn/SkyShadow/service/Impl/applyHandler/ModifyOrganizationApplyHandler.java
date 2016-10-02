package cn.SkyShadow.service.Impl.applyHandler;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.apply.applyChildren.ModifyOrganization;
import cn.SkyShadow.service.ApplyHandler;

/**
 * 修改组织信息
 * Created by RichardW on 10/1/2016.
 */
public class ModifyOrganizationApplyHandler extends ApplyHandler<ModifyOrganization>{
    private final OrganizationMapper organizationMapper;
    private final ApplyMapper applyMapper;

    public ModifyOrganizationApplyHandler(OrganizationMapper organizationMapper, ApplyMapper applyMapper) {
        this.organizationMapper = organizationMapper;
        this.applyMapper = applyMapper;
    }

    @Override
    public ResultMapper doSomeThing_FULL(ModifyOrganization apply) {
        organizationMapper.updateByPrimaryKey(apply.getOrganization());
        return ResultMapper.SUCCESS;
    }

    @Override
    public ResultMapper doSomeThing_APPLY_AVAILABLE(ModifyOrganization apply) {
        Organization organization = apply.getOrganization();
        int orgId = organizationMapper.insertTemp(organization);
        organization.setOrgId((long) orgId);
        apply.setOrganization(organization);
        applyMapper.createModifyOrganization(apply);
        return ResultMapper.SUCCESS;
    }
}
