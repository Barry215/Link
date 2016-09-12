package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.announce;

import java.util.List;

public interface announceMapper {
    /**
     * 按照ID来删除公告
     * @param annId 公告ID
     * @return 执行结果,成功返回1
     */
    int deleteByPrimaryKey(Long annId);

    /**
     * 新建一个公告
     * @param announce 公告
     * @param orgId 组织ID
     * @return 执行结果,成功返回1
     */
    int insert(@Param("announce") announce announce, @Param("orgId") Long orgId);

    /**
     * 获取公告
     * @param orgId 组织ID,或者部门ID
     * @return 公告列表
     */
    List<announce> selectByOrganizationId(Long orgId);
}