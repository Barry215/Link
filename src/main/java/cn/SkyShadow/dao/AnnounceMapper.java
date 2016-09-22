package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.Announce;

import java.util.List;

public interface AnnounceMapper {
    /**
     * 按照ID来删除公告
     * @param annId 公告ID
     * @return 执行结果,成功返回1
     */
    int deleteByPrimaryKey(Long annId);

    /**
     * 新建一个公告
     * @param Announce 公告
     * @param orgId 组织ID
     * @return 执行结果,成功返回1
     */
    int insert(@Param("Announce") Announce Announce, @Param("orgId") Long orgId);

    /**
     * 获取公告
     * @param orgId 组织ID,或者部门ID
     * @return 公告列表
     */
    List<Announce> selectByOrganizationId(Long orgId);
}