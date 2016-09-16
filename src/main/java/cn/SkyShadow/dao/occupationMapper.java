package cn.SkyShadow.dao;

import cn.SkyShadow.model.occupation;

public interface occupationMapper {
    /**
     * 删除职业
     * @param occupationId 职业ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(Long occupationId);

    /**
     *
     * 新建职业
     * @param record 职业
     * @return 执行结果
     */
    int insert(occupation record);

    /**
     * 查询职业
     * @param occupationId 职业ID
     * @return 执行结果
     */
    occupation selectByPrimaryKey(Long occupationId);

    /**
     * 更新职业信息
     * @param record 职业信息
     * @return 执行结果
     */
    int updateByPrimaryKeySelective(occupation record);

    /**
     * 添加成员
     * @param occId 职业ID
     * @param userId 成员ID
     * @return 执行结果
     */
    int addUser(Long occId,Long userId);
    /**
     * 去除成员
     * @param occId 职业ID
     * @param userId 成员ID
     * @return 执行结果
     */
    int removeUser(Long occId,Long userId);
}