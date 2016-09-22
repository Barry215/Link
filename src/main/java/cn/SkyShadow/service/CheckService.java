package cn.SkyShadow.service;

import cn.SkyShadow.enums.SessionNameEnum;
import cn.SkyShadow.model.User;

import javax.servlet.http.HttpSession;

/**
 * 检查器
 * Created by Richard on 16/9/13.
 */
public interface CheckService {
    /**
     * 检查登录状态
     * @param session 会话
     * @return 是否登录
     */
    boolean LoginState(HttpSession session);

    /**
     * 登录状态
     * @param session 会话
     * @return 若登录，返回基本用户信息
     */
    User LoginSate(HttpSession session);

    /**
     * 检测是否有session记录
     * @param session 会话
     * @param sessionNameEnum 会话记录名
     * @return 是或否
     */
    boolean HasThisSessionRecord(HttpSession session, SessionNameEnum sessionNameEnum);

    /**
     * 检查手机发送的短信验证码是否正确
     * @param session 会话
     * @param sessionNameEnum 会话记录
     * @param UserCode 用户输入的验证码
     * @param Phone 手机号
     * @return 是或否
     */
    boolean CheckPhoneCode(HttpSession session,SessionNameEnum sessionNameEnum,String UserCode,String Phone);
    /**
     * 检查邮箱的验证码是否正确
     * @param session 会话
     * @param sessionNameEnum 会话记录
     * @param UserCode 用户输入的验证码
     * @param Email 邮箱地址
     * @return 是或否
     */
    boolean CheckEmailCode(HttpSession session,SessionNameEnum sessionNameEnum,String UserCode,String Email);

    /**
     * 获取当前的用户ID，登录状态返回用户ID，否则返回0
     * @param session 会话
     * @return 用户ID
     */
    Long getUserId(HttpSession session);
}
