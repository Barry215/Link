package cn.SkyShadow.service;

import cn.SkyShadow.enums.SessionNameEnum;
import cn.SkyShadow.model.user;
import javax.servlet.http.HttpSession;

/**
 * 检查器
 * Created by Richard on 16/9/13.
 */
public interface CheckService {
    boolean LoginState(HttpSession session);
    user LoginSate(HttpSession session);
    boolean HasThisSessionRecord(HttpSession session, SessionNameEnum sessionNameEnum);
    void RemoveSession(HttpSession session,SessionNameEnum sessionNameEnum);
    boolean CheckPhoneCode(HttpSession session,SessionNameEnum sessionNameEnum,String UserCode,String Phone);
    boolean CheckEmailCode(HttpSession session,SessionNameEnum sessionNameEnum,String UserCode,String Email);
    void AddSession(HttpSession session,Object object,SessionNameEnum sessionNameEnum);
}
