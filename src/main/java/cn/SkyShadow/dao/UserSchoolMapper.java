package cn.SkyShadow.dao;

import cn.SkyShadow.model.UserSchool;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserSchoolMapper {
    /**
     * 删除用户的教育记录
     * @param userId 用户ID
     * @param schoolTd 学校ID
     * @return 执行结果
     */
    int deleteByPrimaryKey(@Param("userId")Long userId,@Param("schoolId")Long schoolTd);

    /**
     * 新建一条教育记录
     * @param record 教育记录
     * @return 执行结果
     */
    int insert(UserSchool record);

    /**
     * 查询用户的教育信息
     * @param key 用户的ID
     * @return 教育信息列表
     */
    List<UserSchool> selectByPrimaryKey(Long key);

    /**
     * 更新用户的教育记录
     * @param record 记录
     * @return 执行结果
     */
    int updateByPrimaryKey(UserSchool record);
}