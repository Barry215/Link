package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.announce;
import cn.SkyShadow.model.organization;

/**
 * 公告管理器
 * Created by Richard on 16/9/13.
 */
public interface AnnounceService {
    Excution DeleteOrg(organization o);

    /**
     * 发布组织/部门公告
     * @param a 公告
     * @param o 组织
     * @return 执行结果
     */
    Excution Announce(announce a, organization o);

    /**
     * 删除公告
     * @param annId 公告ID
     * @return 执行结果
     */

}
