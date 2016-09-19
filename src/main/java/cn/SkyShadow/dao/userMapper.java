package cn.SkyShadow.dao;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.dto.user.LoginResult;
import cn.SkyShadow.dto.user.RegisterResult;
import cn.SkyShadow.model.user;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userMapper {
    /**
     * 获取登录结果
     * @param user 用户
     * @return 登录结果
     */
    LoginResult getLoginResult(user user);

    /**
     * 注册结果
     * @param user 用户
     * @return 注册结果
     */
    RegisterResult getRegisterResult(user user);

    /**
     * 查询是否有用户名
     * @param username 用户名
     * @return 返回 Y 或者 N
     */
    String HasUserName(String username);

    /**
     * 查询是否有邮箱
     * @param email 邮箱
     * @return 返回 Y 或者 N
     */
    String HasEmail(String email);

    /**
     * 查询是否有手机号码
     * @param phone 手机号
     * @return 返回 Y 或者 N
     */
    String HasPhone(String phone);

    /**
     * 查询用户的全部信息
     * @param userId 用户ID
     * @return 用户信息
     */
    user selectByPrimaryKey(Long userId);

    /**
     * 查询用户的基本信息
     * @param userId 用户ID
     * @return 用户信息
     */
    user selectBaseInfo(Long userId);

    /**
     * 验证邮箱
     * @param email 邮箱
     * @param userId 用户ID
     * @return 执行结果
     */
    int validateEmail(@Param("email") String email, @Param("userId") Long userId);

    /**
     * 验证手机号码
     * @param phone 手机
     * @param userId 用户ID
     * @return 执行结果
     */
    int validatePhone(@Param("phone") String phone,@Param("userId") Long userId);

    /**
     * 查询用户的密保信息
     * @param userId 用户ID
     * @return 执行结果
     */
    PasswordProtected getPasswordProtect(Long userId);

    /**
     * 解除手机的绑定
     * @param userId 用户ID
     * @return 执行结果
     */
    int unValidatePhone(Long userId);

    /**
     * 解除邮箱的绑定
     * @param userId 用户ID
     * @return 执行结果
     */
    int unValidateEmail(Long userId);

    /**
     * 根据用户名,手机号,或者邮箱来查询用户
     * @param loginName 用户名,手机号,或者邮箱
     * @return 用户信息
     */
    user selectBaseInfoByLoginName(String loginName);

    /**
     * 打开或者关闭 "修改密码的时候需要验证密保"
     * @param userId 用户ID
     * @return 执行结果
     */
    int OpenOrClosePasswordChangeValidate(Long userId);

    /**
     * 修改密码
     * @param userId 用户ID
     * @param password 修改密码
     * @return 执行结果
     */
    int changePassword(@Param("userId")Long userId,@Param("password")String password);
    /**
     * 搜索用户
     * @param str 模糊字段
     * @return 用户信息列表
     */
    List<user> Search(String str);
}