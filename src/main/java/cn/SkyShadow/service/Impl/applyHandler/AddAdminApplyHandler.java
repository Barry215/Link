package cn.SkyShadow.service.Impl.applyHandler;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.apply.applyChildren.AddAdmin;
import cn.SkyShadow.service.ApplyHandler;

/**
 * 添加管理员
 * Created by RichardW on 10/1/2016.
 */
public class AddAdminApplyHandler extends ApplyHandler<AddAdmin>{
    private final OrganizationMapper organizationMapper;
    private final ApplyMapper applyMapper;

    public AddAdminApplyHandler(OrganizationMapper organizationMapper, ApplyMapper applyMapper) {
        this.organizationMapper = organizationMapper;
        this.applyMapper = applyMapper;
    }

    @Override
    public ResultMapper doSomeThing_FULL(AddAdmin apply) {
        organizationMapper.AddAdmin(apply.getOrganization().getOrgId(),
                apply.getAdmin().getUserId());
        return ResultMapper.SUCCESS;
    }

    @Override
    public ResultMapper doSomeThing_APPLY_AVAILABLE(AddAdmin apply) {
        applyMapper.createAddAdmin(apply);
        return null;
    }
}
