package cn.SkyShadow.dao;

import cn.SkyShadow.model.Occupation;
import org.apache.ibatis.annotations.Param;

public interface OccupationMapper {
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
    int insert(Occupation record);

    /**
     * 查询职业
     * @param occupationId 职业ID
     * @return 执行结果
     */
    Occupation selectByPrimaryKey(Long occupationId);

    /**
     * 更新职业信息
     * @param record 职业信息
     * @return 执行结果
     */
    int update(Occupation record);

    /**
     * 添加成员
     * @param occId 职业ID
     * @param userId 成员ID
     * @return 执行结果
     */
    int addUser(@Param("occId") Long occId, @Param("userId")Long userId);
    /**
     * 去除成员
     * @param occId 职业ID
     * @param userId 成员ID
     * @return 执行结果
     */
    int removeUser(@Param("occId") Long occId, @Param("userId")Long userId);
}