package cn.SkyShadow.dao;

import cn.SkyShadow.model.imagine;

public interface imagineMapper {
    /**
     * 删除图片
     * @param imgId 图片ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long imgId);

    /**
     * 插入一个图片
     * @param record 图片
     * @return 执行结果
     */
    int insertSelective(imagine record);

    /**
     * 查询图片
     * @param imgId 图片ID
     * @return 图片信息
     */
    imagine selectByPrimaryKey(Long imgId);

    /**
     * 更新图片信息
     * @param record 图片
     * @return 执行结果
     */
    int updateByPrimaryKey(imagine record);
}