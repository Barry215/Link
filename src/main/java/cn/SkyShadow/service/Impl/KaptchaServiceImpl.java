package cn.SkyShadow.service.Impl;

import cn.SkyShadow.enums.MaxWrongNumEnum;
import cn.SkyShadow.enums.SessionNameEnum;
import cn.SkyShadow.service.KaptchaService;
import com.google.code.kaptcha.Constants;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

/**
 * 验证码处理器
 * Created by RichardW on 9/15/2016.
 */
@Transactional
@Service
public class KaptchaServiceImpl implements KaptchaService {
    @Override
    public boolean check(HttpSession session, String userCode,MaxWrongNumEnum m) {
        if (m == null){
            //// TODO: 9/15/2016
            return false;
        }
        int failNum = 0;
        String realCode = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        Object failNumObj = session.getAttribute(SessionNameEnum.WrongNumEnum.getSessionName());
        if (failNumObj!=null){
            failNum = (int)failNumObj;
        }
        if (failNum < m.getNum()){
            return true;
        }else return realCode != null && userCode != null && realCode.equals(userCode);
    }

    @Override
    public void addFailNum(HttpSession session) {
        Object failNumObj = session.getAttribute(SessionNameEnum.WrongNumEnum.getSessionName());
        if (failNumObj==null){
            session.setAttribute(SessionNameEnum.WrongNumEnum.getSessionName(),1);
        }else{
            int failNum = (int)failNumObj;
            session.setAttribute(SessionNameEnum.WrongNumEnum.getSessionName(),(failNum+1));
        }
    }

    @Override
    public void removeFailNum(HttpSession session) {
        session.removeAttribute(SessionNameEnum.WrongNumEnum.getSessionName());
    }

}
