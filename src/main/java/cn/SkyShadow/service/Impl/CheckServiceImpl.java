package cn.SkyShadow.service.Impl;
import cn.SkyShadow.dto.tp.EmailSendSession;
import cn.SkyShadow.dto.tp.PhoneSendSession;
import cn.SkyShadow.enums.SessionNameEnum;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.CheckService;
import cn.SkyShadow.service.UserCoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * 检查器
 * Created by Richard on 16/9/13.
 */
@Transactional
@Service
public class CheckServiceImpl implements CheckService {
    private final UserCoreService uService;
    @Autowired
    public CheckServiceImpl(UserCoreService uService) {
        this.uService = uService;
    }

    @Override
    public boolean LoginState(HttpSession session) {
        LoginResult l = uService.getLoginResult((user) session.getAttribute(SessionNameEnum.user.getSessionName()));
        return l.getResultNum() != 0;
    }

    @Override
    public user LoginSate(HttpSession session) {
        LoginResult l = uService.getLoginResult((user) session.getAttribute(SessionNameEnum.user.getSessionName()));
        if (l.getResultNum() != 0) {
            return uService.selectUserBaseInfo(l.getResultNum());
        }
        return null;
    }

    @Override
    public boolean HasThisSessionRecord(HttpSession session, SessionNameEnum sessionNameEnum) {
        Object obj = session.getAttribute(sessionNameEnum.getSessionName());
        return obj != null;
    }

    @Override
    public void RemoveSession(HttpSession session, SessionNameEnum sessionNameEnum) {
        session.removeAttribute(sessionNameEnum.getSessionName());
    }

    @Override
    public boolean CheckPhoneCode(HttpSession session, SessionNameEnum sessionNameEnum, String UserCode,String Phone) {
        PhoneSendSession phoneSendSession = (PhoneSendSession) session.getAttribute(sessionNameEnum.getSessionName());
        return (phoneSendSession != null) && phoneSendSession.getValidateCode().equals(UserCode) && phoneSendSession.getPhone().equals(Phone);
    }

    @Override
    public boolean CheckEmailCode(HttpSession session, SessionNameEnum sessionNameEnum, String UserCode,String Email) {
        EmailSendSession emailSendSession = (EmailSendSession) session.getAttribute(sessionNameEnum.getSessionName());
        return (emailSendSession != null) && emailSendSession.getValidateCode().equals(UserCode) && emailSendSession.getEmail().equals(Email);
    }

    @Override
    public void AddSession(HttpSession session, Object object, SessionNameEnum sessionNameEnum) {
        session.setAttribute(sessionNameEnum.getSessionName(),object);
    }
}
