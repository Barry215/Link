package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.LocationMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.enums.ApplyModel;
import cn.SkyShadow.factory.ApplyHandlerFactory;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.factory.ReceiptHandlerFactory;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.*;
import cn.SkyShadow.service.OrgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Richard on 16/8/31.
 * 组织管理器
 */
@Transactional
@Service
public class OrgServiceImpl implements OrgService {

    private final OrganizationMapper OrganizationMapper;
    private final LocationMapper lMapper;
    private final ApplyHandlerFactory applyHandlerFactory;
    private final ReceiptHandlerFactory receiptHandlerFactory;


    public OrgServiceImpl(OrganizationMapper OrganizationMapper, LocationMapper lMapper, ApplyHandlerFactory applyHandlerFactory, ReceiptHandlerFactory receiptHandlerFactory) {
        this.OrganizationMapper = OrganizationMapper;
        this.lMapper = lMapper;
        this.applyHandlerFactory = applyHandlerFactory;
        this.receiptHandlerFactory = receiptHandlerFactory;
    }

    @Override
    public BaseExecution CreateNewOrg(Organization org) {
        if (org == null) {
            return ExecutionFactory.getExecution(ResultMapper.NULL_ERROR);
        }
        if (org.getCreatorId() == null || org.getCreatorId().getUserId() == 0L) {
            return ExecutionFactory.getExecution(ResultMapper.NULL_ERROR);
        }
        if (org.getName().length() > 255 || org.getName().length() < 6) {
            return ExecutionFactory.getExecution(ResultMapper.Org_FORMAT_NAME);
        }
        if (HasOrgName(org.getName()).equals("Y")) {
            return ExecutionFactory.getExecution(ResultMapper.Org_ILLEGAL_NAME);
        }
        if (org.getOrgId() != 0L) {
            Organization fatherOrg = OrganizationMapper.selectBaseInfo(org.getOrgId());
            if (fatherOrg == null) {
                return ExecutionFactory.getExecution(ResultMapper.Org_ILLEGAL_PARENT);
            }
        }
        if (org.getLocation() == null) {
            return ExecutionFactory.getExecution(ResultMapper.NULL_ERROR);
        }
        Location location = lMapper.selectByPrimaryKey(org.getLocation().getLocationId());
        if (location == null) {
            return ExecutionFactory.getExecution(ResultMapper.Public_ILLEGAL_LOCATION);
        }
        int result = OrganizationMapper.insert(org);
        if (result == 1) {
            return ExecutionFactory.getExecution(ResultMapper.SUCCESS, org);
        } else {
            return ExecutionFactory.getExecution(ResultMapper.DB_ERROR);
        }
    }

    @Override
    public Organization getBaseInfo(Long orgId) {
        return OrganizationMapper.selectBaseInfo(orgId);
    }


    @Override
    public String HasOrgName(String Name) {
        return OrganizationMapper.HasOrgName(Name);
    }

    @Override
    public BaseExecution modifyOrganization(ModifyOrganization apply, ApplyModel applyModel) {
        ResultMapper resultMapper =applyHandlerFactory.getModifyOrganizationApplyHandler().handler(apply,applyModel);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,apply);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * @param receipt 回执
     * @return 执行过程
     */
    @Override
    public BaseExecution modifyOrganizationCallBack(Receipt<ModifyOrganization> receipt) {
        ResultMapper resultMapper= receiptHandlerFactory.getModifyOrganizationReceiptHandler().handler(receipt);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,receipt);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 向外申请父组织
     *
     * @param apply 申请
     * @return 执行
     */
    @Override
    public BaseExecution applyFatherOrganization(ApplyParentOrg apply) {
        ResultMapper resultMapper= applyHandlerFactory.getApplyParentOrgApplyHandler().handler(apply,ApplyModel.APPLY_MODEL);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,apply);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 处理其他组织父组织的申请
     *
     * @param receipt 回执
     * @return 处理结果
     */
    @Override
    public BaseExecution applyFatherOrganizationCallback(Receipt<ApplyParentOrg> receipt) {
        ResultMapper resultMapper =receiptHandlerFactory.getApplyParentOrgReceiptHandler().handler(receipt);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,receipt);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 向外申请解除父组织
     *
     * @param apply 申请
     * @return 执行
     */
    @Override
    public BaseExecution applyUnlockFatherOrganization(ApplyUnlockParentOrg apply) {
        ResultMapper resultMapper =applyHandlerFactory.getApplyUnlockParentOrgApplyHandler().handler(apply,ApplyModel.APPLY_MODEL);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,apply);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 处理其他组织解除父组织的申请
     *
     * @param receipt 回执
     * @return 处理结果
     */
    @Override
    public BaseExecution applyUnlockFatherOrganizationCallback(Receipt<ApplyUnlockParentOrg> receipt) {
        ResultMapper resultMapper =receiptHandlerFactory.getApplyUnlockParentOrgReceiptHandler().handler(receipt);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,receipt);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 申请转让组织的创建者
     *
     * @param apply 申请
     * @return 执行结果
     */
    @Override
    public BaseExecution deliverOrganization(DeliverOrg apply) {
        ResultMapper resultMapper = applyHandlerFactory.getDeliverOrgApplyHandler().handler(apply,ApplyModel.APPLY_MODEL);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,apply);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 处理转让组织的创建者的申请
     *
     * @param receipt 申请
     * @return 执行结果
     */
    @Override
    public BaseExecution deliverOrganizationCallback(Receipt<DeliverOrg> receipt) {
        ResultMapper resultMapper = receiptHandlerFactory.getDeliverOrgReceiptHandler().handler(receipt);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,receipt);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 添加管理员
     *
     * @param addAdmin 申请
     * @return 执行结果
     */
    @Override
    public BaseExecution addAdmin(AddAdmin addAdmin) {
        ResultMapper resultMapper= applyHandlerFactory.getAddAdminApplyHandler().handler(addAdmin,ApplyModel.APPLY_MODEL);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,addAdmin);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 处理添加管理员的申请
     *
     * @param receipt 回执
     * @return 执行结果
     */
    @Override
    public BaseExecution addAdminCallback(Receipt<AddAdmin> receipt) {
        ResultMapper resultMapper =receiptHandlerFactory.getAddAdminReceiptHandler().handler(receipt);
        if (resultMapper==ResultMapper.SUCCESS){
            return ExecutionFactory.getExecution(resultMapper,receipt);
        }
        return ExecutionFactory.getExecution(resultMapper);
    }

    /**
     * 删除组织
     *
     * @param userId 用户ID
     * @param orgId  组织ID
     * @return 执行结果
     */
    @Override
    public BaseExecution deleteOrganization(Long userId, Long orgId) {
        return null;// TODO: 9/28/2016
    }

}
