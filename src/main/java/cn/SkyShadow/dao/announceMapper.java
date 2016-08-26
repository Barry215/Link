package cn.SkyShadow.dao;

import org.apache.ibatis.annotations.Param;
import cn.SkyShadow.model.announce;

import java.util.List;

public interface announceMapper {
    int deleteByPrimaryKey(Long annId);

    int insert(@Param("announce") announce announce, @Param("orgId") Long orgId);

    List<announce> selectByOrganizationId(Long orgId);
}