package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.Announce;

import java.util.List;

/**
 * 公告管理器
 * Created by Richard on 16/9/13.
 */
public interface AnnounceService {
    /**
     * 发布组织/部门公告
     * @param a 公告
     * @param organizationID 组织
     * @return 执行结果
     */
    BaseExecution Announce(Announce a, Long organizationID);

    /**
     * 删除公告
     * @param annId 公告ID
     * @return 执行结果
     */
    BaseExecution DeleteAnnounce(Long annId);

    /**
     * 查询组织/部门的公告
     * @param orgId 组织ID
     * @return 公告列表
     */
    List<Announce> SelectAnnListByOrgId(Long orgId);
}
