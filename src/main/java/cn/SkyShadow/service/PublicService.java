package cn.SkyShadow.service;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.city;
import cn.SkyShadow.model.country;

import java.util.List;

/*
 * 开放信息
 */
public interface PublicService {
    /*
     * 检查手机号是否被注册
     */
    String HasPhone(String Phone);

    /*
     * 检查用户名是否重复
     */
    String HasUsername(String username);

    /*
     * 检查邮件是否被注册
     */
    String HasEmail(String email);

    /*
     * 获取国家列表
     */
    List<country> getCountries();

    /*
     * 获取城市列表（中国）
     */
    List<city> get_ZH_Cities();

    PasswordProtected getPasswordProtectByLoginName(String LoginName);
}
