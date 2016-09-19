package cn.SkyShadow.service;

import cn.SkyShadow.dto.exception.NoMaxWrongNumEnumException;
import cn.SkyShadow.enums.MaxWrongNumEnum;

import javax.servlet.http.HttpSession;

/**
 * 图形验证码服务
 * Created by RichardW on 9/15/2016.
 */
public interface KaptchaService {
    boolean check(HttpSession session,String UserCode,MaxWrongNumEnum m) throws NoMaxWrongNumEnumException;
    void addFailNum(HttpSession session);
    void removeFailNum(HttpSession session);
}
