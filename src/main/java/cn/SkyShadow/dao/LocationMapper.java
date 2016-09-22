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

    /**
     * 移除地点
     * @param locationID 地点ID
     * @return 执行结果
     */
    int RemoveLocation(Long locationID);//// TODO: 9/14/2016

    /**
     * 修改地点
     * @param location 地点信息
     * @return 执行结果
     */
    int ModifyLocation(Location location);//// TODO: 9/14/2016
}