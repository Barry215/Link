package cn.SkyShadow.controller;

import cn.SkyShadow.basic_component.Impl.AjaxCommonComponent;
import cn.SkyShadow.dto.excution.LoginStateExecution;
import cn.SkyShadow.dto.factory.JsonResultFactory;
import cn.SkyShadow.dto.factory.UserFactory;
import cn.SkyShadow.dto.tp.EmailSendSession;
import cn.SkyShadow.dto.tp.EmailValidateResult;
import cn.SkyShadow.dto.tp.PhoneSendSession;
import cn.SkyShadow.dto.tp.PhoneValidateResult;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.dto.user.PasswordProtectedKey;
import cn.SkyShadow.dto.user.SignUpForm;
import cn.SkyShadow.enums.*;
import cn.SkyShadow.model.result_model.RegisterResult;
import cn.SkyShadow.service.CheckService;
import cn.SkyShadow.service.KaptchaService;
import cn.SkyShadow.service.PublicService;
import cn.SkyShadow.tp.service.SendEmailService;
import cn.SkyShadow.tp.service.SendPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import cn.SkyShadow.dto.JsonResult;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.UserCoreService;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Transactional
@Controller
@RequestMapping("/user")
public class UserController{
    private final UserCoreService uService;
    private final SendEmailService emailService;
    private final SendPhoneService phoneService;
    private final PublicService pService;
    private final CheckService checkService;
    private final AjaxCommonComponent ajaxCommonComponent;
    private final KaptchaService kaptchaService;

    @Autowired
    public UserController(PublicService pService, UserCoreService uService, SendPhoneService phoneService, SendEmailService emailService, CheckService checkService, KaptchaService kaptchaService) {
        this.pService = pService;
        this.uService = uService;
        this.phoneService = phoneService;
        this.emailService = emailService;
        this.checkService = checkService;
        this.kaptchaService = kaptchaService;
        this.ajaxCommonComponent = new AjaxCommonComponent(this.getClass());
    }

    /**
     * 登陆方法
     * @param u           包装好的用户信息
     * @param httpSession 会话session
     * @param imgCode 图像验证码
     * @return 登录结果信息，如果登录成功，会自动存取session
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getLoginResult(@RequestBody user u, @RequestBody String imgCode ,HttpSession httpSession) {
        LoginResult result;
        try {
            if (!kaptchaService.check(httpSession,imgCode,MaxWrongNumEnum.LOGIN)){
                result = UserFactory.GetLoginResult(LoginResultEnum.IMG_CODE);
                return JsonResultFactory.CreateJsonResult_True(result);
            }
            user u1 = uService.SelectUserByLogin(u);
            if (u1 == null) {
                result = UserFactory.GetLoginResult(LoginResultEnum.FAIL);
                kaptchaService.addFailNum(httpSession);
                return JsonResultFactory.CreateJsonResult_True(result);
            }
            u1.setPassword(u.getPassword());
            httpSession.setAttribute(SessionNameEnum.user.getSessionName(), u1);
            result = UserFactory.GetLoginResult(LoginResultEnum.SUCCESS);
            kaptchaService.removeFailNum(httpSession);
            return JsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            kaptchaService.addFailNum(httpSession);
            httpSession.removeAttribute(SessionNameEnum.user.getSessionName());
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 退出登录
     *
     * @param session 会话session
     * @return 是否成功
     */
    @RequestMapping(value = "/loginout", produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> loginout(HttpSession session) {
        String result;
        try {
            session.removeAttribute(SessionNameEnum.user.getSessionName());
            result = "Y";
            return JsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 查询登录状态
     *
     * @param session 会话session
     * @return 包装类loginState
     */
    @RequestMapping(value = "/loginState", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getLoginState(HttpSession session) {
        try {
            LoginStateExecution loginState;
            if (checkService.LoginState(session)) {
                loginState = UserFactory.getLoginStateExecution(LoginStateEnum.ONLINE, checkService.LoginSate(session));
            } else {
                loginState = UserFactory.getLoginStateExecution(LoginStateEnum.OFFLINE);
            }
            return JsonResultFactory.CreateJsonResult_True(loginState);
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 注册，不使用邮箱
     *
     * @param session    会话session
     * @param signUpForm 包装类报名信息
     * @return 注册结果
     */
    @RequestMapping(value = "/signUpNoEmail", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> signUpNoEmail(HttpSession session, @RequestBody SignUpForm signUpForm) {
        RegisterResult result;
        try {
            if (!kaptchaService.check(session,signUpForm.getImgcode(),MaxWrongNumEnum.REGISTER)){
                result = UserFactory.GetRegisterResult(RegisterResultEnum.IMGCODE);
                return JsonResultFactory.CreateJsonResult_True(result);
            }
            if (checkService.HasThisSessionRecord(session, SessionNameEnum.public_phone)
                    && checkService.CheckPhoneCode(session, SessionNameEnum.public_phone, signUpForm.getPhoneCode(), signUpForm.getUser().getPhone())) {
                result = uService.getRegisterResult_NOEMAIL(signUpForm.getUser());
                return JsonResultFactory.CreateJsonResult_True(result);
            } else {
                result = UserFactory.GetRegisterResult(RegisterResultEnum.PHONEVALIDATE);
                return JsonResultFactory.CreateJsonResult_True(result);
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 注册，使用邮箱
     *
     * @param session    会话session
     * @param signUpForm 包装类报名信息
     * @return 注册结果
     */
    @RequestMapping(value = "/signUp", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> signUp(HttpSession session, @RequestBody SignUpForm signUpForm) {
        RegisterResult result;
        try {
            if (!kaptchaService.check(session,signUpForm.getImgcode(),MaxWrongNumEnum.REGISTER)){
                result = UserFactory.GetRegisterResult(RegisterResultEnum.IMGCODE);
                return JsonResultFactory.CreateJsonResult_True(result);
            }
            if (!checkService.CheckEmailCode(session, SessionNameEnum.public_email, signUpForm.getEmailCode(), signUpForm.getUser().getEmail())) {
                result = UserFactory.GetRegisterResult(RegisterResultEnum.EMAILVALIDATE);
            } else if (!checkService.CheckPhoneCode(session, SessionNameEnum.public_phone, signUpForm.getPhoneCode(), signUpForm.getUser().getPhone())) {
                result = UserFactory.GetRegisterResult(RegisterResultEnum.PHONEVALIDATE);
            } else {
                result = uService.getRegisterResult(signUpForm.getUser());
            }
            return JsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 本方法用于，用户在邮箱为空时，发送邮箱一条验证码，要求在登录状态
     *
     * @param email   邮箱地址
     * @param session 会话session
     * @return 是否发送成功
     */
    @RequestMapping(value = "/{email}/sendEmailValidateCode", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> sendEmailValidateCode(
            @PathVariable("email") String email, HttpSession session) {
        try {
            if (pService.HasEmail(email).equals("ER")) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.FORMAT.getInfo());
            } else if (pService.HasEmail(email).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.EXITS.getInfo());
            } else if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.UN_LOGIN.getInfo());

            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getEmailValidate().equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.VALIDATED.getInfo());
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_email.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(email);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_email.getSessionName(), new EmailSendSession(r, email));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.OVERCLOCKING.getInfo());
                } else {
                    String r = emailService.SendValidateCode(email);
                    if (!r.equals("ERROR!")) {
                        session.removeAttribute(SessionNameEnum.user_email.getSessionName());
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 本方法用于，用户在手机信息为空时，发送手机一条验证码，要求在登录状态
     *
     * @param phone   手机号码
     * @param session 会话session
     * @return 发送结果
     */
    @RequestMapping(value = "/{phone}/sendPhoneValidateCode", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> sendPhoneValidateCode(
            @PathVariable("phone") String phone, HttpSession session) {
        try {
            if (pService.HasPhone(phone).equals("ER")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.FORMAT.getInfo());
            }
            if (pService.HasPhone(phone).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.EXITS.getInfo());
            }
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.UN_LOGIN.getInfo());

            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getPhoneValidate().equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.VALIDATED.getInfo());
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_phone.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(phone);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_phone.getSessionName(), new PhoneSendSession(r, phone));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.OVERCLOCKING.getInfo());
                } else {
                    String r = phoneService.SendValidateCode(phone);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_phone.getSessionName(), new PhoneSendSession(r, phone));
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 本方法用于在用户手机信息为空时，验证手机，要求在登录状态
     *
     * @param session 会话sessio
     * @param code    验证码
     * @return 验证结果
     */
    @RequestMapping(value = "/{code}/ValidatePhone", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ValidatePhone(HttpSession session, @PathVariable("code") String code) {
        try {
            if (!checkService.LoginState(session)) {
                PhoneSendSession p = (PhoneSendSession) session.getAttribute(SessionNameEnum.user_phone.getSessionName());
                if (p == null) {
                    PhoneValidateResult phoneValidateResult = new PhoneValidateResult(PhoneValidateEnum.MESSAGE_FALL);
                    return JsonResultFactory.CreateJsonResult_True(phoneValidateResult);
                } else if (p.getValidateCode().equals(code)) {
                    uService.ValidatePhone(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId(), p.getPhone());
                    return JsonResultFactory.CreateJsonResult_True(new PhoneValidateResult(PhoneValidateEnum.SUCCESS));
                } else {
                    PhoneValidateResult phoneValidateResult = new PhoneValidateResult(PhoneValidateEnum.ERROR_CODE);
                    return JsonResultFactory.CreateJsonResult_True(phoneValidateResult);
                }
            } else {
                PhoneValidateResult phoneValidateResult = new PhoneValidateResult(PhoneValidateEnum.LOGIN_FAIL);
                return JsonResultFactory.CreateJsonResult_True(phoneValidateResult);
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 本方法用于在用户邮箱信息为空时，验证邮箱，要求在登录状态
     *
     * @param session 会话session
     * @param code    验证码
     * @return 邮箱验证结果
     */
    @RequestMapping(value = "/{code}/ValidateEmail", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ValidateEmail(HttpSession session, @PathVariable("code") String code) {
        try {
            if (!checkService.LoginState(session)) {
                EmailSendSession e = (EmailSendSession) session.getAttribute(SessionNameEnum.user_email.getSessionName());
                if (e == null) {
                    EmailValidateResult emailValidateResult = new EmailValidateResult(EmailValidateEnum.MESSAGE_FALL);
                    return JsonResultFactory.CreateJsonResult_True(emailValidateResult);
                } else {
                    if (e.getValidateCode().equals(code)) {
                        uService.ValidateEmail(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId(), e.getEmail());
                        return JsonResultFactory.CreateJsonResult_True(new EmailValidateResult(EmailValidateEnum.SUCCESS));
                    } else {
                        EmailValidateResult emailValidateResult = new EmailValidateResult(EmailValidateEnum.ERROR_CODE);
                        return JsonResultFactory.CreateJsonResult_True(emailValidateResult);
                    }
                }
            } else {
                EmailValidateResult emailValidateResult = new EmailValidateResult(EmailValidateEnum.LOGIN_FAIL);
                return JsonResultFactory.CreateJsonResult_True(emailValidateResult);
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 本方法用于，查询用户当前拥有的密保手段，要求用户在登录状态
     * 返回用户是否可以使用手机验证，用户是否可以使用邮箱验证，修改密码是否需要验证密保
     *
     * @param session 会话session
     * @return 包装类PasswordProtected
     */
    @RequestMapping(value = "/GetPasswordProtectedMethod", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getPasswordProtected(HttpSession session) {
        try {
            if (!checkService.LoginState(session)) {
                loginout(session);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            return JsonResultFactory.CreateJsonResult_True(p);
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 发送短信，用于验证密保，要求登录状态
     *
     * @param session 会话session
     * @return 发送结果
     */
    @RequestMapping(value = "/PhoneSendToCheckPasswordProtected", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> PhoneSendToCheckPasswordProtected(HttpSession session) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.UN_LOGIN.getInfo());
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getPhoneValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.UN_VALIDATE.getInfo());
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(p.getPhone());
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName(), new PhoneSendSession(r, p.getPhone()));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.OVERCLOCKING.getInfo());
                } else {
                    String r;
                    r = phoneService.SendValidateCode(p.getPhone());
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName(), new PhoneSendSession(r, p.getPhone()));
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 发送邮箱验证码，用于验证密保，要求登录状态
     *
     * @param session 会话session
     * @return 发送结果
     */
    @RequestMapping(value = "/EmailSendToCheckPasswordProtected", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> EmailSendToCheckPasswordProtected(HttpSession session) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.UN_LOGIN.getInfo());
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getEmailValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.UN_VALIDATE.getInfo());
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(p.getEmail());
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName(), new EmailSendSession(r, p.getEmail()));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.OVERCLOCKING.getInfo());
                } else {
                    String r = emailService.SendValidateCode(p.getEmail());
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName(), new EmailSendSession(r, p.getEmail()));
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);

                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 用邮箱验证密保，要求登录状态
     *
     * @param code    验证码
     * @param session 会话session
     * @return 验证结果
     */
    @RequestMapping(value = "{code}/ValidatePasswordProtectedMethodByEmail", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ValidatePasswordProtectedMethodByEmail(HttpSession session, @PathVariable("code") String code) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(new EmailValidateResult(EmailValidateEnum.LOGIN_FAIL));
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName());
            if (e != null && e.getValidateCode().equals(code)) {
                session.setAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName(), new PasswordProtectedKey());
                return JsonResultFactory.CreateJsonResult_True(new EmailValidateResult(EmailValidateEnum.SUCCESS));
            } else if (e == null) {
                return JsonResultFactory.CreateJsonResult_True(new EmailValidateResult(EmailValidateEnum.MESSAGE_FALL));
            } else {
                return JsonResultFactory.CreateJsonResult_True(new EmailValidateResult(EmailValidateEnum.ERROR_CODE));
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 用手机验证密保，要求登录状态
     *
     * @param code    验证码
     * @param session 会话session
     * @return 验证结果
     */
    @RequestMapping(value = "{code}/ValidatePasswordProtectedMethodByPhone", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ValidatePasswordProtectedMethodByPhone(HttpSession session, @PathVariable("code") String code) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(new PhoneValidateResult(PhoneValidateEnum.LOGIN_FAIL));
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName());
            if (e != null && e.getValidateCode().equals(code)) {
                session.setAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName(), new PasswordProtectedKey());
                return JsonResultFactory.CreateJsonResult_True(new PhoneValidateResult(PhoneValidateEnum.SUCCESS));
            } else if (e == null) {
                return JsonResultFactory.CreateJsonResult_True(new PhoneValidateResult(PhoneValidateEnum.MESSAGE_FALL));
            } else {
                return JsonResultFactory.CreateJsonResult_True(new PhoneValidateResult(PhoneValidateEnum.ERROR_CODE));
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 用于密保验证完成后，修改手机号码时，向手机发送短信，要求用户是登录状态
     *
     * @param session 会话session
     * @param phone   手机号码
     * @return 发送结果 包装类
     */
    @RequestMapping(value = "/{phone}/ChangeValidatePhoneSend", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ChangeValidatePhoneSend(HttpSession session, @PathVariable("phone") String phone) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.UN_LOGIN.getInfo());
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId());
            if (p.getPhoneValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.UN_VALIDATE.getInfo());
            }
            if (pService.HasPhone(phone).equals("ER")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.FORMAT.getInfo());
            }
            if (pService.HasPhone(phone).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.EXITS.getInfo());
            }
            PhoneSendSession e = (PhoneSendSession) session.getAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(phone);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_phone_by_validated.getSessionName(), new PhoneSendSession(r, phone));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.OVERCLOCKING.getInfo());
                } else {
                    String r = phoneService.SendValidateCode(phone);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_phone_by_validated.getSessionName(), new PhoneSendSession(r, phone));
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }

    }

    /**
     * 用于密保验证完成后，修改邮箱时，向邮箱发送验证码，要求用户是登录状态
     *
     * @param session 会话session
     * @param email   邮箱
     * @return 发送结果 包装类
     */
    @RequestMapping(value = "/{email}/ChangeValidateEmailSend", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ChangeValidateEmailSend(HttpSession session, @PathVariable("email") String email) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.UN_LOGIN.getInfo());
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId());
            if (p.getEmailValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(EmailSendResultEnum.UN_VALIDATE.getInfo());
            }
            if (pService.HasEmail(email).equals("ER")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.FORMAT.getInfo());
            }
            if (pService.HasEmail(email).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.EXITS.getInfo());
            }
            EmailSendSession e = (EmailSendSession) session.getAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(email);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_email_by_validated.getSessionName(), new PhoneSendSession(r, email));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(PhoneSendResultEnum.OVERCLOCKING.getInfo());
                } else {
                    String r = emailService.SendValidateCode(email);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_email_by_validated.getSessionName(), new PhoneSendSession(r, email));
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 用于，密保验证完成后，修改邮箱，要求用户是登录状态
     *
     * @param session 会话session
     * @param code    验证码
     * @return 修改结果
     */
    @RequestMapping(value = "{code}/ChangeValidateEmail", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ChangeValidateEmail(HttpSession session, @PathVariable("code") String code) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(EmailModifyResultEnum.UN_LOGIN.getInfo());
            }
            PasswordProtectedKey p = (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (p == null) {
                return new JsonResult<>(true, EmailModifyResultEnum.NO_KEY.getInfo(), null);
            } else if ((new Date().getTime()) - p.getCreateDate().getTime() > 1200000) {
                return new JsonResult<>(true, EmailModifyResultEnum.OVERTIME.getInfo(), null);
            } else {
                EmailSendSession e = (EmailSendSession) session
                        .getAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
                if (e != null && e.getValidateCode().equals(code)) {
                    String email = e.getEmail();
                    if (pService.HasEmail(email).equals("ER")) {
                        return JsonResultFactory.CreateJsonResult_True(EmailModifyResultEnum.FORMAT.getInfo());
                    }
                    if (pService.HasEmail(email).equals("Y")) {
                        return JsonResultFactory.CreateJsonResult_True(EmailModifyResultEnum.EXITS.getInfo());
                    }
                    uService.ChangeValidateEmail(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId(), email);
                    session.removeAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
                    return JsonResultFactory.CreateJsonResult_True(EmailModifyResultEnum.SUCCESS.getInfo());
                } else if (e == null) {
                    return JsonResultFactory.CreateJsonResult_True(EmailModifyResultEnum.MESSAGE_FALL.getInfo());
                } else {
                    return JsonResultFactory.CreateJsonResult_True(EmailModifyResultEnum.ERROR_CODE.getInfo());
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 用于，密保验证完成后，修改手机号码，要求用户是登录状态
     *
     * @param session 会话session
     * @param code    验证码
     * @return 修改结果
     */
    @RequestMapping(value = "{code}/ChangeValidatePhone", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ChangeValidatePhone(HttpSession session, @PathVariable("code") String code) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(PhoneModifyResultEnum.UN_LOGIN.getInfo());
            }
            PasswordProtectedKey p = (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (p == null) {
                return new JsonResult<>(true, PhoneModifyResultEnum.NO_KEY.getInfo(), null);
            } else if ((new Date().getTime()) - p.getCreateDate().getTime() > 1200000) {
                return new JsonResult<>(true, PhoneModifyResultEnum.OVERTIME.getInfo(), null);
            } else {
                PhoneSendSession ps = (PhoneSendSession) session
                        .getAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
                if (ps != null && ps.getValidateCode().equals(code)) {
                    String phone = ps.getPhone();
                    if (pService.HasPhone(phone).equals("ER")) {
                        return JsonResultFactory.CreateJsonResult_True(PhoneModifyResultEnum.FORMAT.getInfo());
                    }
                    if (pService.HasPhone(phone).equals("Y")) {
                        return JsonResultFactory.CreateJsonResult_True(PhoneModifyResultEnum.EXITS.getInfo());
                    }
                    uService.ChangeValidatePhone(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId(), phone);
                    session.removeAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
                    return JsonResultFactory.CreateJsonResult_True(PhoneModifyResultEnum.SUCCESS.getInfo());
                } else if (ps == null) {
                    return JsonResultFactory.CreateJsonResult_True(PhoneModifyResultEnum.MESSAGE_FALL.getInfo());
                } else {
                    return JsonResultFactory.CreateJsonResult_True(PhoneModifyResultEnum.ERROR_CODE.getInfo());
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 打开（修改密码时验证密保） 需要
     * 1.用户是登录状态
     *
     * @param session 会话session
     * @return 处理结果
     */
    @RequestMapping(value = "OpenPasswordChangeValidate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> OpenPasswordChangeValidate(HttpSession session) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(PasswordChangeValidateEnum.UN_LOGIN.getInfo());
            }
            Long userId = ((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId();
            PasswordProtected p = uService.getPasswordProtectByUserId(userId);
            if (p.getPasswoordChangeValidate().equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(PasswordChangeValidateEnum.Opened.getInfo());
            }
            uService.OpenOrClosePasswordChangeValidate(userId);
            return JsonResultFactory.CreateJsonResult_True(PasswordChangeValidateEnum.Success.getInfo());
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 打开（修改密码时验证密保） 需要
     * 1.用户是登录状态
     * 2.用户以验证密保
     *
     * @param session 会话session
     * @return 处理结果
     */
    @RequestMapping(value = "ClosePasswordChangeValidate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ClosePasswordChangeValidate(HttpSession session) {
        try {
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(PasswordChangeValidateEnum.UN_LOGIN.getInfo());
            }
            Long userId = ((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId();
            PasswordProtected p = uService.getPasswordProtectByUserId(userId);
            if (p.getPasswoordChangeValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(PasswordChangeValidateEnum.Closed.getInfo());
            }
            PasswordProtectedKey pk =
                    (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (pk == null) {
                return JsonResultFactory.CreateJsonResult_True(PasswordChangeValidateEnum.NeedKey.getInfo());
            }
            uService.OpenOrClosePasswordChangeValidate(userId);
            return JsonResultFactory.CreateJsonResult_True(PasswordChangeValidateEnum.Success.getInfo());
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }

    /**
     * 修改密码，需要用户是登录状态
     * 1.若用户打开了（修改密码时验证密保），不需要验证旧密码，直接可以设置新密码
     * 2.若用户关闭了（修改密码时验证密保），需要验证旧密码，然后可以设置新密码
     * 3.修改后用户需要重新登录
     *
     * @param session     会话session
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 处理结果
     */
    @RequestMapping(value = "ModifyPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ModifyPassword(final HttpSession session, String oldPassword, String newPassword) {
        try {
            if (newPassword == null || newPassword.length() > 20 || newPassword.length() < 6) {
                return JsonResultFactory.CreateJsonResult_True(ModifyPaswordEnum.FORMAT.getInfo());
            }
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(ModifyPaswordEnum.UN_LOGIN.getInfo());
            }
            user u = ((user) (session.getAttribute(SessionNameEnum.user.getSessionName())));
            PasswordProtected p = uService.getPasswordProtectByUserId(u.getUserId());
            if (p.getPasswoordChangeValidate().equals("Y")) {
                PasswordProtectedKey pk =
                        (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
                if (pk == null) {
                    return JsonResultFactory.CreateJsonResult_True(ModifyPaswordEnum.NeedKey.getInfo());
                }
                uService.ChangePasword(u.getUserId(), newPassword);
                session.removeAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
                return JsonResultFactory.CreateJsonResult_True(ModifyPaswordEnum.Success.getInfo());
            } else {
                u.setPassword(oldPassword);
                LoginResult l = uService.getLoginResult(u);
                if (l.getResultNum() == 1) {
                    uService.ChangePasword(u.getUserId(), newPassword);
                    return JsonResultFactory.CreateJsonResult_True(ModifyPaswordEnum.Success.getInfo());
                } else {
                    return JsonResultFactory.CreateJsonResult_True(ModifyPaswordEnum.WrongPsd.getInfo());
                }
            }
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
}