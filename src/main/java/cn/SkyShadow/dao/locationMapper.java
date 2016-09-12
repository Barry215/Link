package cn.SkyShadow.dao;

import cn.SkyShadow.model.location;

public interface locationMapper {
    /**
     * 查询地点
     * @param locationId 地点ID
     * @return 地点
     */
    location selectByPrimaryKey(Long locationId);

    /**
     * 新建一个地点
     * @param location 地点
     * @return 执行结果
     */
    int CreateNewLocation(location location);
}