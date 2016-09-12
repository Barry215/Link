package cn.SkyShadow.service;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.city;
import cn.SkyShadow.model.country;

import java.util.List;

/*
 * 开放信息
 */
public interface PublicService {
    /**
     * 检查手机号是否被注册
     * @param Phone 手机号码
     *@return 返回 Y 或者 N
     */
    String HasPhone(String Phone);

    /**
     * 检查用户名是否重复
     * @param  username 用户名
     * @return 返回 Y 或者 N
     */
    String HasUsername(String username);

    /**
     * 检查邮件是否被注册
     * @param email 邮件地址
     * @return 返回 Y 或者 N
     */
    String HasEmail(String email);

    /**
     * 获取国家列表
     * @return 返回国家列表
     */
    List<country> getCountries();

    /**
     * 获取城市列表（中国）
     * @return 返回城市列表
     */
    List<city> get_ZH_Cities();

    /**
     * 获取用户的密码保护方式
     * @param LoginName 用户名,手机号码,邮箱
     * @return 用户的密码保护方式
     */
    PasswordProtected getPasswordProtectByLoginName(String LoginName);

    /**
     * 修改密码
     * @param userId 用户ID
     * @param password 新密码
     * @return 执行结果
     */
    int ChangePasword(Long userId, String password);
}
