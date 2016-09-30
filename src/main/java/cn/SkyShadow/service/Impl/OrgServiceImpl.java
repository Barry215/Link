package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.ApplyMapper;
import cn.SkyShadow.dao.LocationMapper;
import cn.SkyShadow.dao.OrganizationMapper;
import cn.SkyShadow.dao.ReceiptMapper;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.enums.ApplyModel;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.*;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.*;
import cn.SkyShadow.service.ApplyHandler;
import cn.SkyShadow.service.OrgService;
import cn.SkyShadow.service.ReceiptHandler;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final ReceiptMapper receiptMapper;
    private final ApplyMapper applyMapper;


    public OrgServiceImpl(OrganizationMapper OrganizationMapper, LocationMapper lMapper, ApplyMapper applyMapper, ReceiptMapper receiptMapper) {
        this.OrganizationMapper = OrganizationMapper;
        this.lMapper = lMapper;
        this.receiptMapper = receiptMapper;
        this.applyMapper = applyMapper;
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
        return OrganizationMapper.getBaseInfo(orgId);
    }


    @Override
    public String HasOrgName(String Name) {
        return OrganizationMapper.HasOrgName(Name);
    }

    @Override
    public ResultMapper modifyOrganization(ModifyOrganization apply, ApplyModel applyModel) {
        ApplyHandler<ModifyOrganization> applyHandler = new ApplyHandler<ModifyOrganization>() {
            @Override
            public ResultMapper doSomeThing_FULL(ModifyOrganization apply) {
                OrganizationMapper.updateByPrimaryKeySelective(apply.getOrganization());
                return ResultMapper.SUCCESS;
            }

            @Override
            public ResultMapper doSomeThing_APPLY_AVAILABLE(ModifyOrganization apply) {
                applyMapper.ModifyOrganization(apply);
                return ResultMapper.SUCCESS;
            }
        };
        return applyHandler.handler(apply,applyModel);
    }

    /**
     * @param receipt 回执
     * @return 执行过程
     */
    @Override
    public ResultMapper modifyOrganizationCallBack(Receipt<ModifyOrganization> receipt) {
        ReceiptHandler<ModifyOrganization> receiptHandler = new ReceiptHandler<ModifyOrganization>() {
            @Override
            public void doIfAgree() {
                OrganizationMapper.updateByPrimaryKeySelective(receipt.getApply().getOrganization());
                receiptMapper.Create(receipt);
            }

            @Override
            public void doIfDisagree() {
                receiptMapper.Create(receipt);
            }
        };
        return receiptHandler.handler(receipt);
    }

    /**
     * 向外申请父组织
     *
     * @param applyParentOrg 申请
     * @return 执行
     */
    @Override
    public ResultMapper applyFatherOrganization(ApplyParentOrg applyParentOrg) {
        ApplyHandler<ApplyParentOrg> applyHandler = new ApplyHandler<ApplyParentOrg>() {
            @Override
            public ResultMapper doSomeThing_FULL(ApplyParentOrg apply) {
                return null;// TODO: 9/28/2016  
            }

            @Override
            public ResultMapper doSomeThing_APPLY_AVAILABLE(ApplyParentOrg apply) {
                return null;
            }
        };
        return applyHandler.handler(applyParentOrg,ApplyModel.APPLY_MODEL);
    }

    /**
     * 处理其他组织父组织的申请
     *
     * @param receipt 回执
     * @return 处理结果
     */
    @Override
    public ResultMapper applyFatherOrganizationCallback(Receipt<ApplyParentOrg> receipt) {
        ReceiptHandler<ApplyParentOrg> receiptHandler = new ReceiptHandler<ApplyParentOrg>() {
            @Override
            public void doIfAgree() {
            }

            @Override
            public void doIfDisagree() {
                
            }
        };
        return receiptHandler.handler(receipt);
    }

    /**
     * 向外申请解除父组织
     *
     * @param unlockParentOrg 申请
     * @return 执行
     */
    @Override
    public ResultMapper applyUnlockFatherOrganization(ApplyUnlockParentOrg unlockParentOrg) {
        ApplyHandler<ApplyUnlockParentOrg> applyHandler = new ApplyHandler<ApplyUnlockParentOrg>() {

            @Override
            public ResultMapper doSomeThing_FULL(ApplyUnlockParentOrg apply) {
                return null;
            }

            @Override
            public ResultMapper doSomeThing_APPLY_AVAILABLE(ApplyUnlockParentOrg apply) {
                return null;
            }
        };
        return applyHandler.handler(unlockParentOrg,ApplyModel.APPLY_MODEL);
    }

    /**
     * 处理其他组织解除父组织的申请
     *
     * @param receipt 回执
     * @return 处理结果
     */
    @Override
    public ResultMapper applyUnlockFatherOrganizationCallback(Receipt<ApplyUnlockParentOrg> receipt) {
        ReceiptHandler<ApplyUnlockParentOrg> receiptHandler = new ReceiptHandler<ApplyUnlockParentOrg>() {
            @Override
            public void doIfAgree() {
                
            }

            @Override
            public void doIfDisagree() {

            }
        };
        return receiptHandler.handler(receipt);
    }

    /**
     * 申请转让组织的创建者
     *
     * @param deliverOrg 申请
     * @return 执行结果
     */
    @Override
    public ResultMapper deliverOrganization(DeliverOrg deliverOrg) {
        ApplyHandler<DeliverOrg> applyHandler = new ApplyHandler<DeliverOrg>() {

            @Override
            public ResultMapper doSomeThing_FULL(DeliverOrg apply) {
                return null;
            }

            @Override
            public ResultMapper doSomeThing_APPLY_AVAILABLE(DeliverOrg apply) {
                return null;
            }
        };
        return applyHandler.handler(deliverOrg,ApplyModel.APPLY_MODEL);
    }

    /**
     * 处理转让组织的创建者的申请
     *
     * @param receipt 申请
     * @return 执行结果
     */
    @Override
    public ResultMapper deliverOrganizationCallback(Receipt<DeliverOrg> receipt) {
        ReceiptHandler<DeliverOrg> receiptHandler = new ReceiptHandler<DeliverOrg>() {
            @Override
            public void doIfAgree() {

            }

            @Override
            public void doIfDisagree() {

            }
        };
        return receiptHandler.handler(receipt);
    }

    /**
     * 添加管理员
     *
     * @param addAdmin 申请
     * @return 执行结果
     */
    @Override
    public ResultMapper addAdmin(AddAdmin addAdmin) {
        ApplyHandler<AddAdmin> applyHandler = new ApplyHandler<AddAdmin>() {

            @Override
            public ResultMapper doSomeThing_FULL(AddAdmin apply) {
                return null;
            }

            @Override
            public ResultMapper doSomeThing_APPLY_AVAILABLE(AddAdmin apply) {
                return null;
            }
        };
        return applyHandler.handler(addAdmin,ApplyModel.APPLY_MODEL);
    }

    /**
     * 处理添加管理员的申请
     *
     * @param receipt 回执
     * @return 执行结果
     */
    @Override
    public ResultMapper addAdminCallback(Receipt<AddAdmin> receipt) {
        ReceiptHandler<AddAdmin> receiptHandler = new ReceiptHandler<AddAdmin>() {
            @Override
            public void doIfAgree() {

            }

            @Override
            public void doIfDisagree() {

            }
        };
        return receiptHandler.handler(receipt);
    }

    /**
     * 删除组织
     *
     * @param userId 用户ID
     * @param orgId  组织ID
     * @return 执行结果
     */
    @Override
    public ResultMapper deleteOrganization(Long userId, Long orgId) {
        return null;// TODO: 9/28/2016
    }

}
