package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.location;

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
    Excution Add(location location);

    /**
     * 删除地点
     * @param locationId 地点ID
     * @return 执行结果
     */
    Excution Remove(Long locationId);
    /**
     * 修改地点
     * @param location 地点
     * @return 执行结果
     */
    Excution Modify(location location);
}