package cn.SkyShadow.dao;

import cn.SkyShadow.model.Location;

public interface LocationMapper {
    /**
     * 查询地点
     * @param locationId 地点ID
     * @return 地点
     */
    Location selectByPrimaryKey(Long locationId);

    /**
     * 新建一个地点
     * @param location 地点
     * @return 执行结果
     */
    int CreateNewLocation(Location location);
}