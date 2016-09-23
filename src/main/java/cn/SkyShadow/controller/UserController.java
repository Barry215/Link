package cn.SkyShadow.controller;

import cn.SkyShadow.basic_component.ExceptionHandler;
import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.factory.JsonResultFactory;
import cn.SkyShadow.dto.tp.EmailSendSession;
import cn.SkyShadow.dto.tp.PhoneSendSession;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.dto.user.PasswordProtectedKey;
import cn.SkyShadow.dto.user.SignUpForm;
import cn.SkyShadow.enums.*;
import cn.SkyShadow.dto.user.RegisterResult;
import cn.SkyShadow.model.User;
import cn.SkyShadow.service.CheckService;
import cn.SkyShadow.service.KaptchaService;
import cn.SkyShadow.service.PublicService;
import cn.SkyShadow.tp.service.SendEmailService;
import cn.SkyShadow.tp.service.SendPhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import cn.SkyShadow.dto.json.JsonResult;
import cn.SkyShadow.dto.user.LoginResult;
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
    private final ExceptionHandler exceptionHandle;
    private final KaptchaService kaptchaService;

    @Autowired
    public UserController(PublicService pService, UserCoreService uService, SendPhoneService phoneService, SendEmailService emailService, CheckService checkService, ExceptionHandler exceptionHandle, KaptchaService kaptchaService) {
        this.pService = pService;
        this.uService = uService;
        this.phoneService = phoneService;
        this.emailService = emailService;
        this.checkService = checkService;
        this.exceptionHandle = exceptionHandle;
        this.kaptchaService = kaptchaService;
        exceptionHandle.setClass(this.getClass());
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
    public JsonResult<?> getLoginResult(@RequestBody User u, @RequestBody String imgCode , HttpSession httpSession) {
        try {
            if (!kaptchaService.check(httpSession,imgCode,MaxWrongNumEnum.LOGIN)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_IMG_CODE_Error));
            }
            User u1 = uService.SelectUserByLogin(u);
            if (u1 == null) {
                kaptchaService.addFailNum(httpSession);
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_Login_Fail);
            }
            u1.setPassword(u.getPassword());
            httpSession.setAttribute(SessionNameEnum.user.getSessionName(), u1);
            kaptchaService.removeFailNum(httpSession);
            return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
        try {
            session.removeAttribute(SessionNameEnum.user.getSessionName());
            return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
            BaseExecution loginState;
            if (checkService.LoginState(session)) {
                loginState = ExecutionFactory.getExecution(ResultMapper.User_Login_State_Online, checkService.LoginSate(session));
            } else {
                loginState = ExecutionFactory.getExecution(ResultMapper.User_Login_State_Offline);
            }
            return JsonResultFactory.CreateJsonResult_True(loginState);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
        try {
            if (!kaptchaService.check(session,signUpForm.getImgcode(),MaxWrongNumEnum.REGISTER)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_IMG_CODE_Error));
            }
            if (checkService.HasThisSessionRecord(session, SessionNameEnum.public_phone)
                    && checkService.CheckPhoneCode(session, SessionNameEnum.public_phone, signUpForm.getPhoneCode(), signUpForm.getUser().getPhone())) {
                RegisterResult result = uService.getRegisterResult_NOEMAIL(signUpForm.getUser());
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(result));
            } else {
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_Phone_Error_code));
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
        try {
            if (!kaptchaService.check(session,signUpForm.getImgcode(),MaxWrongNumEnum.REGISTER)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_IMG_CODE_Error));
            }
            if (!checkService.CheckEmailCode(session, SessionNameEnum.public_email, signUpForm.getEmailCode(), signUpForm.getUser().getEmail())) {
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_Email_Error_code));
            } else if (!checkService.CheckPhoneCode(session, SessionNameEnum.public_phone, signUpForm.getPhoneCode(), signUpForm.getUser().getPhone())) {
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_Phone_Error_code));
            } else {
                RegisterResult result = uService.getRegisterResult(signUpForm.getUser());
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(result));
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Format);
            } else if (pService.HasEmail(email).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Exist);
            } else if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);

            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((User) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getEmailValidate().equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Validated);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_email.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(email);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_email.getSessionName(), new EmailSendSession(r, email));
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                }else{
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                }

            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_OverLocking);
                } else {
                    String r = emailService.SendValidateCode(email);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_email.getSessionName(),new EmailSendSession(r,email));
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                    }else {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                    }
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Format);
            }
            if (pService.HasPhone(phone).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Exist);
            }
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);

            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((User) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getPhoneValidate().equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Validated);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_phone.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(phone);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_phone.getSessionName(), new PhoneSendSession(r, phone));
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                }else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_OverLocking);
                } else {
                    String r = phoneService.SendValidateCode(phone);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_phone.getSessionName(), new PhoneSendSession(r, phone));
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                    }else{
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                    }
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                } else if (p.getValidateCode().equals(code)) {
                    uService.ValidatePhone(((User) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId(), p.getPhone());
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                } else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Error_code);
                }
            } else {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
            if (checkService.LoginState(session)) {
                if (!checkService.HasThisSessionRecord(session,SessionNameEnum.user_email)){
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                } else {
                    EmailSendSession e = (EmailSendSession) session.getAttribute(SessionNameEnum.user_email.getSessionName());
                    if (e.getValidateCode().equals(code)) {
                        uService.ValidateEmail(((User) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId(), e.getEmail());
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                    } else {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Error_code);
                    }
                }
            } else {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
            PasswordProtected p = uService.getPasswordProtectByUserId(checkService.getUserId(session));
            return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(p));
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(checkService.getUserId(session));
            if (p.getPhoneValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_UnValidated);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(p.getPhone());
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName(), new PhoneSendSession(r, p.getPhone()));
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                }else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_OverLocking);
                } else {
                    String r;
                    r = phoneService.SendValidateCode(p.getPhone());
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName(), new PhoneSendSession(r, p.getPhone()));
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                    }else {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                    }
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((User) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getEmailValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_UnValidated);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(p.getEmail());
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName(), new EmailSendSession(r, p.getEmail()));
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                }else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_OverLocking);
                } else {
                    String r = emailService.SendValidateCode(p.getEmail());
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName(), new EmailSendSession(r, p.getEmail()));
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                    }else {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                    }
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName());
            if (e != null && e.getValidateCode().equals(code)) {
                session.setAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName(), new PasswordProtectedKey());
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
            } else if (e == null) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
            } else {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Error_code);
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName());
            if (e != null && e.getValidateCode().equals(code)) {
                session.setAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName(), new PasswordProtectedKey());
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
            } else if (e == null) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
            } else {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Error_code);
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((User) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId());
            if (p.getPhoneValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_UnValidated);
            }
            if (pService.HasPhone(phone).equals("ER")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Format);
            }
            if (pService.HasPhone(phone).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Exist);
            }
            PhoneSendSession e = (PhoneSendSession) session.getAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(phone);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_phone_by_validated.getSessionName(), new PhoneSendSession(r, phone));
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                }else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_OverLocking);
                } else {
                    String r = phoneService.SendValidateCode(phone);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_phone_by_validated.getSessionName(), new PhoneSendSession(r, phone));
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                    }else {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                    }
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((User) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId());
            if (p.getEmailValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_UnValidated);
            }
            if (pService.HasEmail(email).equals("ER")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Format);
            }
            if (pService.HasEmail(email).equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Exist);
            }
            EmailSendSession e = (EmailSendSession) session.getAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(email);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_email_by_validated.getSessionName(), new PhoneSendSession(r, email));
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                }else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_OverLocking);
                } else {
                    String r = emailService.SendValidateCode(email);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_email_by_validated.getSessionName(), new PhoneSendSession(r, email));
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                    }else {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                    }
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PasswordProtectedKey p = (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (p == null) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_No_PasswordProtectedKey);
            } else if ((new Date().getTime()) - p.getCreateDate().getTime() > 1200000) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_OverTime);
            } else {
                EmailSendSession e = (EmailSendSession) session
                        .getAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
                if (e != null && e.getValidateCode().equals(code)) {
                    String email = e.getEmail();
                    if (pService.HasEmail(email).equals("ER")) {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Format);
                    }
                    if (pService.HasEmail(email).equals("Y")) {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Exist);
                    }
                    uService.ChangeValidateEmail(checkService.getUserId(session), email);
                    session.removeAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                } else if (e == null) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_MessageSendFail);
                } else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_Error_code);
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PasswordProtectedKey p = (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (p == null) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_No_PasswordProtectedKey);
            } else if ((new Date().getTime()) - p.getCreateDate().getTime() > 1200000) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_OverTime);
            } else {
                PhoneSendSession ps = (PhoneSendSession) session
                        .getAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
                if (ps != null && ps.getValidateCode().equals(code)) {
                    String phone = ps.getPhone();
                    if (pService.HasPhone(phone).equals("ER")) {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Format);
                    }
                    if (pService.HasPhone(phone).equals("Y")) {
                        return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Exist);
                    }
                    uService.ChangeValidatePhone(((User) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId(), phone);
                    session.removeAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                } else if (ps == null) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_MessageSendFail);
                } else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_Error_code);
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            Long userId = ((User) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId();
            PasswordProtected p = uService.getPasswordProtectByUserId(userId);
            if (p.getPasswordChangeValidate().equals("Y")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_ResultMapper_Opened);
            }
            uService.OpenOrClosePasswordChangeValidate(userId);
            return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            Long userId = ((User) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId();
            PasswordProtected p = uService.getPasswordProtectByUserId(userId);
            if (p.getPasswordChangeValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_ResultMapper_Closed);
            }
            PasswordProtectedKey pk =
                    (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (pk == null) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_No_PasswordProtectedKey);
            }
            uService.OpenOrClosePasswordChangeValidate(userId);
            return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
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
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_ModifyPsd_Password_Format);
            }
            if (!checkService.LoginState(session)) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            User u = ((User) (session.getAttribute(SessionNameEnum.user.getSessionName())));
            PasswordProtected p = uService.getPasswordProtectByUserId(u.getUserId());
            if (p.getPasswordChangeValidate().equals("Y")) {
                PasswordProtectedKey pk =
                        (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
                if (pk == null) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_No_PasswordProtectedKey);
                }
                uService.ChangePasword(u.getUserId(), newPassword);
                session.removeAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
            } else {
                u.setPassword(oldPassword);
                LoginResult l = uService.getLoginResult(u);
                if (l.getResultNum() == 1) {
                    uService.ChangePasword(u.getUserId(), newPassword);
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
                } else {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_ModifyPsd_WrongOldPsd);
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
}