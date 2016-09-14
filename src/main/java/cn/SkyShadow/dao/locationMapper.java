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
    int Modifylocation(location location);//// TODO: 9/14/2016
}