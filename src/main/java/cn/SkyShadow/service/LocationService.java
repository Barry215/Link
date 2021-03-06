package cn.SkyShadow.service;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.model.Location;

/**
 * 地点管理器
 * Created by RichardW on 9/13/2016.
 */
public interface LocationService {
    /**
     * 添加地点
     * @param location 地点
     * @return 执行结果
     */
    BaseExecution Add(Location location);

    /**
     * 删除地点
     * @param locationId 地点ID
     * @return 执行结果
     */
    BaseExecution Remove(Long locationId);
    /**
     * 修改地点
     * @param location 地点
     * @return 执行结果
     */
    BaseExecution Modify(Location location);
}
