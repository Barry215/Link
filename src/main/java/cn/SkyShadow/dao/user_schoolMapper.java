package cn.SkyShadow.dao;

import cn.SkyShadow.model.user_school;
import cn.SkyShadow.model.user_schoolKey;

import java.util.List;

public interface user_schoolMapper {
    /**
     * 删除用户的教育记录
     * @param key 教育记录的KEY
     * @return 执行结果
     */
    int deleteByPrimaryKey(user_schoolKey key);

    /**
     * 新建一条教育记录
     * @param record 教育记录
     * @return 执行结果
     */
    int insert(user_school record);

    /**
     * 查询用户的教育信息
     * @param key 用户的ID
     * @return 教育信息列表
     */
    List<user_school> selectByPrimaryKey(Long key);

    /**
     * 更新用户的教育记录
     * @param record 记录
     * @return 执行结果
     */
    int updateByPrimaryKey(user_school record);
}