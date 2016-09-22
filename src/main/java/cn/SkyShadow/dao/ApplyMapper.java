package cn.SkyShadow.dao;
import cn.SkyShadow.model.apply.ApplyChildren.ApplyParentOrg;
import cn.SkyShadow.model.apply.ApplyChildren.ApplyUnlockParentOrg;
import cn.SkyShadow.model.apply.ApplyChildren.CommandDepartmentLeader;

/**
 * 申请数据处理
 * Created by RichardW on 9/13/2016.
 */
public interface ApplyMapper {
    // TODO: 9/21/2016  
    int CreateApplyParentOrg(ApplyParentOrg apply);
    int RemoveApplyParentOrg(Long applyId);
    int CreateApplyUnlockParentOrg(ApplyUnlockParentOrg apply);
    int RemoveApplyUnlockParentOrg(Long applyId);
    int CreateCommandDepartmentLeader(CommandDepartmentLeader apply);
    int RemoveCommandDepartmentLeader(Long applyId);
}
