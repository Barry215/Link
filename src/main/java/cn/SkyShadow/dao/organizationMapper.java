package cn.SkyShadow.dao;

import cn.SkyShadow.model.organization;

public interface organizationMapper {
    int deleteByPrimaryKey(Long orgId);

    int insert(organization record);

    organization selectByPrimaryKey(Long orgId);

    int updateByPrimaryKeySelective(organization record);
    
    organization selectBaseInfo(Long orgId);

}