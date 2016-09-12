package cn.SkyShadow.service;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.result_model.RegisterResult;
import cn.SkyShadow.model.user;

public interface UserCoreService {
    /**
     * 获取登录结果
     * @param user 用户
     * @return 登录结果
     */
    LoginResult getLoginResult(user user);

    /**
     * 获取注册结果(无邮箱注册)
     * @param user 用户
     * @return 注册结果
     */
    RegisterResult getRegisterResult_NOEMAIL(user user);

    /**
     * 获取注册结果(含邮箱注册)
     * @param user 用户
     * @return 注册结果
     */
    RegisterResult getRegisterResult(user user);

    /**
     * 根据用户的登录结果,获取到用户的全部信息
     * @param user 用户
     * @return 用户全部信息
     */
    user SelectUserByLogin(user user);

    /**
     * 根据用户的ID,获取用户的基本公开信息
     * @param userId 用户ID
     * @return 执行结果
     */
    user selectUserBaseInfo(Long userId);

    /**
     * 验证邮件
     * @param userId 用户ID
     * @param Email 邮件地址
     * @return 执行结果
     */
    int ValidateEmail(Long userId,String Email);

    /**
     * 验证手机号码
     * @param userId 用户ID
     * @param phone 手机号码
     * @return 执行结果
     */
    int ValidatePhone(Long userId,String phone);

    /**
     * 更改邮件地址
     * @param userId 用户ID
     * @param Email 邮件地址
     * @return 执行结果
     */
    int ChangeValidateEmail(Long userId,String Email);

    /**
     * 更改手机号码
     * @param userId 用户ID
     * @param phone 手机号码
     * @return 执行结果
     */
    int ChangeValidatePhone(Long userId,String phone);

    /**
     * 获取用户的密保手段
     * @param UserId 用户ID
     * @return 用户的密保手段
     */
    PasswordProtected getPasswordProtectByUserId(Long UserId);

    /**
     * 打开或者关闭"修改密码时验证密保"
     * @param userId 用户ID
     * @return 执行结果
     */
    int OpenOrClosePasswordChangeValidate(Long userId);

    /**
     * 修改密码
     * @param userId 用户ID
     * @param password 密码
     * @return 执行结果
     */
    int ChangePasword(Long userId,String password);

}
