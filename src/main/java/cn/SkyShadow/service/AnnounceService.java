package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.announce;
import cn.SkyShadow.model.organization;

import java.util.List;

/**
 * 公告管理器
 * Created by Richard on 16/9/13.
 */
public interface AnnounceService {
    /**
     * 发布组织/部门公告
     * @param a 公告
     * @param o 组织
     * @return 执行结果
     */
    Excution Announce(announce a, Long organizationID);

    /**
     * 删除公告
     * @param annId 公告ID
     * @return 执行结果
     */
    Excution DeleteAnnounce(Long annId);

    /**
     * 查询组织/部门的公告
     * @param orgId 组织ID
     * @return 公告列表
     */
    List<announce> SelectAnnListByOrgId(Long orgId);
}
