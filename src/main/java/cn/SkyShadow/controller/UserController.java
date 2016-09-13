package cn.SkyShadow.controller;

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
import cn.SkyShadow.service.JsonResultFactory;
import cn.SkyShadow.service.PublicService;
import cn.SkyShadow.tp.service.SendEmailService;
import cn.SkyShadow.tp.service.SendPhoneService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import cn.SkyShadow.dto.JsonResult;
import cn.SkyShadow.dto.user.LoginState;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.UserCoreService;

import javax.servlet.http.HttpSession;
import java.util.Date;
@Transactional
@Controller
@RequestMapping("/user")
public class UserController {
    private final UserCoreService uService;
    private final SendEmailService emailService;
    private final SendPhoneService phoneService;
    private final PublicService pService;
    private final CheckService checkService;
    private final JsonResultFactory jsonResultFactory;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public UserController(PublicService pService, UserCoreService uService, SendPhoneService phoneService, SendEmailService emailService,CheckService checkService,JsonResultFactory jsonResultFactory) {
        this.pService = pService;
        this.uService = uService;
        this.phoneService = phoneService;
        this.emailService = emailService;
        this.checkService = checkService;
        this.jsonResultFactory = jsonResultFactory;
    }

    /**
     * 登陆方法
     * @param u           包装好的用户信息
     * @param httpSession 会话sessio
     * @return 登录结果信息，如果登录成功，会自动存取session
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getLoginResult(@RequestBody user u, HttpSession httpSession) {
        LoginResult result;
        try {
            user u1 = uService.SelectUserByLogin(u);
            if (u1==null){
                result = new LoginResult("登录失败，用户名或密码有误",0);
                return jsonResultFactory.CreateJsonResult_True(result);
            }
            u1.setPassword(u.getPassword());
            httpSession.setAttribute(SessionNameEnum.user.getSessionName(),u1);
            result = new LoginResult("登录成功",1);
            return jsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            httpSession.removeAttribute(SessionNameEnum.user.getSessionName());
            return jsonResultFactory.CreateJsonResult_False(e);
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
            return jsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
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
        LoginState loginState;
        try {
            if (!checkService.LoginState(session)){
                loginState = new LoginState(1,"在线",checkService.LoginSate(session));
            }
            else{
                loginState = new LoginState(0,"离线",null);
            }
            return jsonResultFactory.CreateJsonResult_True(loginState);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
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
            if (checkService.HasThisSessionRecord(session,SessionNameEnum.public_phone)
                    &&checkService.CheckPhoneCode(session,SessionNameEnum.public_phone,signUpForm.getPhoneCode(),signUpForm.getUser().getPhone())){
                result = uService.getRegisterResult_NOEMAIL(signUpForm.getUser());
                return jsonResultFactory.CreateJsonResult_True(result);
            }else{
                result = new RegisterResult("手机验证码不正确", 2);
                return jsonResultFactory.CreateJsonResult_True(result);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
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
            if (checkService.CheckEmailCode(session,SessionNameEnum.public_email,signUpForm.getEmailCode(),signUpForm.getUser().getEmail())
                    &&
                    checkService.CheckPhoneCode(session,SessionNameEnum.public_phone,signUpForm.getPhoneCode(),signUpForm.getUser().getPhone())) {
                result= uService.getRegisterResult(signUpForm.getUser());
            } else {
                result = new RegisterResult("手机验证码不正确或者邮箱验证码不正确",3);
            }
            return jsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
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
        JsonResult<String> result;
        try {
            if (pService.HasEmail(email).equals("ER")) {
                return new JsonResult<>(true, EmailSendResultEnum.FORMAT.getInfo(), null);
            }
            else if (pService.HasEmail(email).equals("Y")) {
                return new JsonResult<>(true, EmailSendResultEnum.EXITS.getInfo(), null);
            }
            else if (!checkService.LoginState(session)) {
                result = new JsonResult<>(true, EmailSendResultEnum.UN_LOGIN.getInfo(), null);
                return result;
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getEmailValidate().equals("Y")) {
                return new JsonResult<>(true, EmailSendResultEnum.VALIDATED.getInfo(), null);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_email.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(email);
                result = new JsonResult<>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_email.getSessionName(),new EmailSendSession(r, email));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<>(true, EmailSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r = emailService.SendValidateCode(email);
                    result = new JsonResult<>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.removeAttribute(SessionNameEnum.user_email.getSessionName());
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<String> result;
        try {
            if (pService.HasPhone(phone).equals("ER")) {
                return new JsonResult<>(true, PhoneSendResultEnum.FORMAT.getInfo(), null);
            }
            if (pService.HasPhone(phone).equals("Y")) {
                return new JsonResult<>(true, PhoneSendResultEnum.EXITS.getInfo(), null);
            }
            if (!checkService.LoginState(session)) {
                result = new JsonResult<>(true, PhoneSendResultEnum.UN_LOGIN.getInfo(), null);
                return result;
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getPhoneValidate().equals("Y")) {
                return new JsonResult<>(true, PhoneSendResultEnum.VALIDATED.getInfo(), null);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_phone.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(phone);
                result = new JsonResult<>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_phone.getSessionName(), new PhoneSendSession(r, phone));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<>(true, PhoneSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r = phoneService.SendValidateCode(phone);
                    result = new JsonResult<>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_phone.getSessionName(), new PhoneSendSession(r, phone));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<PhoneValidateResult> result;
        try {
            if (!checkService.LoginState(session)) {
                PhoneSendSession p = (PhoneSendSession) session.getAttribute(SessionNameEnum.user_phone.getSessionName());
                if (p == null) {
                    PhoneValidateResult phoneValidateResult = new PhoneValidateResult(PhoneValidateEnum.MESSAGE_FALL);
                    result = new JsonResult<>(true, phoneValidateResult, null);
                } else if (p.getValidateCode().equals(code)) {
                    uService.ValidatePhone(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId(), p.getPhone());
                    result = new JsonResult<>(true, new PhoneValidateResult(PhoneValidateEnum.SUCCESS), null);
                } else {
                    PhoneValidateResult phoneValidateResult = new PhoneValidateResult(PhoneValidateEnum.ERROR_CODE);
                    result = new JsonResult<>(true, phoneValidateResult, null);
                }
            } else {
                PhoneValidateResult phoneValidateResult = new PhoneValidateResult(PhoneValidateEnum.LOGIN_FAIL);
                result = new JsonResult<>(true, phoneValidateResult, null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<EmailValidateResult> result;
        try {
            if (!checkService.LoginState(session)) {
                EmailSendSession e = (EmailSendSession) session.getAttribute(SessionNameEnum.user_email.getSessionName());
                if (e == null) {
                    EmailValidateResult emailValidateResult = new EmailValidateResult(EmailValidateEnum.MESSAGE_FALL);
                    result = new JsonResult<>(true, emailValidateResult, null);
                } else {
                    if (e.getValidateCode().equals(code)) {
                        uService.ValidateEmail(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId(), e.getEmail());
                        result = new JsonResult<>(true, new EmailValidateResult(EmailValidateEnum.SUCCESS), null);
                    } else {
                        EmailValidateResult emailValidateResult = new EmailValidateResult(EmailValidateEnum.ERROR_CODE);
                        result = new JsonResult<>(true, emailValidateResult, null);
                    }
                }
            } else {
                EmailValidateResult emailValidateResult = new EmailValidateResult(EmailValidateEnum.LOGIN_FAIL);
                result = new JsonResult<>(true, emailValidateResult, null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
    }

    /**
     * 本方法用于，查询用户当前拥有的密保手段，要求用户在登录状态
     * 返回用户是否可以使用手机验证，用户是否可以使用邮箱验证，修改密码是否需要验证密保
     * @param session 会话session
     * @return 包装类PasswordProtected
     */
    @RequestMapping(value = "/GetPasswordProtectedMethod", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> getPasswordProtected(HttpSession session) {
        JsonResult<PasswordProtected> result;
        try {
            if (!checkService.LoginState(session)) {
                loginout(session);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            result = new JsonResult<>(true, p, null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
    }

    /**
     * 发送短信，用于验证密保，要求登录状态
     * @param session 会话session
     * @return 发送结果
     */
    @RequestMapping(value = "/PhoneSendToCheckPasswordProtected", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> PhoneSendToCheckPasswordProtected(HttpSession session) {
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, PhoneSendResultEnum.UN_LOGIN.getInfo(), null);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getPhoneValidate().equals("N")) {
                return new JsonResult<>(true, PhoneSendResultEnum.UN_VALIDATE.getInfo(), null);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(p.getPhone());
                result = new JsonResult<>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName(), new PhoneSendSession(r, p.getPhone()));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<>(true, PhoneSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r;
                    r = phoneService.SendValidateCode(p.getPhone());
                    result = new JsonResult<>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName(), new PhoneSendSession(r, p.getPhone()));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, EmailSendResultEnum.UN_LOGIN.getInfo(), null);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) (session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId());
            if (p.getEmailValidate().equals("N")) {
                return new JsonResult<>(true, EmailSendResultEnum.UN_VALIDATE.getInfo(), null);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(p.getEmail());
                result = new JsonResult<>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName(), new EmailSendSession(r, p.getEmail()));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<>(true, EmailSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r = emailService.SendValidateCode(p.getEmail());
                    result = new JsonResult<>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName(), new EmailSendSession(r, p.getEmail()));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<EmailValidateResult> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, new EmailValidateResult(EmailValidateEnum.LOGIN_FAIL), null);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_email.getSessionName());
            if (e != null && e.getValidateCode().equals(code)) {
                result = new JsonResult<>(true, new EmailValidateResult(EmailValidateEnum.SUCCESS), null);
                session.setAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName(), new PasswordProtectedKey());
            } else if (e == null) {
                result = new JsonResult<>(true, new EmailValidateResult(EmailValidateEnum.MESSAGE_FALL), null);
            } else {
                result = new JsonResult<>(true, new EmailValidateResult(EmailValidateEnum.ERROR_CODE), null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<PhoneValidateResult> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, new PhoneValidateResult(PhoneValidateEnum.LOGIN_FAIL), null);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute(SessionNameEnum.user_validate_password_protected_phone.getSessionName());
            if (e != null && e.getValidateCode().equals(code)) {
                result = new JsonResult<>(true, new PhoneValidateResult(PhoneValidateEnum.SUCCESS), null);
                session.setAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName(), new PasswordProtectedKey());
            } else if (e == null) {
                result = new JsonResult<>(true, new PhoneValidateResult(PhoneValidateEnum.MESSAGE_FALL), null);
            } else {
                result = new JsonResult<>(true, new PhoneValidateResult(PhoneValidateEnum.ERROR_CODE), null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
    }

    /**
     * 用于密保验证完成后，修改手机号码时，向手机发送短信，要求用户是登录状态
     *
     * @param session 会话session
     * @param phone 手机号码
     * @return 发送结果 包装类
     */
    @RequestMapping(value = "/{phone}/ChangeValidatePhoneSend", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ChangeValidatePhoneSend(HttpSession session, @PathVariable("phone") String phone) {
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, PhoneSendResultEnum.UN_LOGIN.getInfo(), null);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId());
            if (p.getPhoneValidate().equals("N")) {
                return new JsonResult<>(true, PhoneSendResultEnum.UN_VALIDATE.getInfo(), null);
            }
            if (pService.HasPhone(phone).equals("ER")) {
                return new JsonResult<>(true, PhoneSendResultEnum.FORMAT.getInfo(), null);
            }
            if (pService.HasPhone(phone).equals("Y")) {
                return new JsonResult<>(true, PhoneSendResultEnum.EXITS.getInfo(), null);
            }
            PhoneSendSession e = (PhoneSendSession) session.getAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
            if (e == null) {
                String r = phoneService.SendValidateCode(phone);
                result = new JsonResult<>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_phone_by_validated.getSessionName(), new PhoneSendSession(r, phone));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<>(true, PhoneSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r = phoneService.SendValidateCode(phone);
                    result = new JsonResult<>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_phone_by_validated.getSessionName(), new PhoneSendSession(r, phone));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
    }

    /**
     * 用于密保验证完成后，修改邮箱时，向邮箱发送验证码，要求用户是登录状态
     *
     * @param session 会话session
     * @param email  邮箱
     * @return 发送结果 包装类
     */
    @RequestMapping(value = "/{email}/ChangeValidateEmailSend", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ChangeValidateEmailSend(HttpSession session, @PathVariable("email") String email) {
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, EmailSendResultEnum.UN_LOGIN.getInfo(), null);
            }
            PasswordProtected p = uService.getPasswordProtectByUserId(((user) session.getAttribute(SessionNameEnum.user.getSessionName())).getUserId());
            if (p.getEmailValidate().equals("N")) {
                return new JsonResult<>(true, EmailSendResultEnum.UN_VALIDATE.getInfo(), null);
            }
            if (pService.HasEmail(email).equals("ER")) {
                return new JsonResult<>(true, PhoneSendResultEnum.FORMAT.getInfo(), null);
            }
            if (pService.HasEmail(email).equals("Y")) {
                return new JsonResult<>(true, PhoneSendResultEnum.EXITS.getInfo(), null);
            }
            EmailSendSession e = (EmailSendSession) session.getAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
            if (e == null) {
                String r = emailService.SendValidateCode(email);
                result = new JsonResult<>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute(SessionNameEnum.user_email_by_validated.getSessionName(), new PhoneSendSession(r, email));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<>(true, PhoneSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r = emailService.SendValidateCode(email);
                    result = new JsonResult<>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute(SessionNameEnum.user_email_by_validated.getSessionName(), new PhoneSendSession(r, email));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, EmailModifyResultEnum.UN_LOGIN.getInfo(), null);
            }
            PasswordProtectedKey p = (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (p==null){
                return  new JsonResult<>(true,EmailModifyResultEnum.NO_KEY.getInfo(),null);
            }else if ((new Date().getTime())-p.getCreateDate().getTime()>1200000){
                return  new JsonResult<>(true,EmailModifyResultEnum.OVERTIME.getInfo(),null);
            }else{
                EmailSendSession e = (EmailSendSession) session
                        .getAttribute(SessionNameEnum.user_email_by_validated.getSessionName());
                if (e != null && e.getValidateCode().equals(code)) {
                    String email = e.getEmail();
                    if (pService.HasEmail(email).equals("ER")) {
                        return new JsonResult<>(true, EmailModifyResultEnum.FORMAT.getInfo(), null);
                    }
                    if (pService.HasEmail(email).equals("Y")) {
                        return new JsonResult<>(true, EmailModifyResultEnum.EXITS.getInfo(), null);
                    }
                    result = new JsonResult<>(true, EmailModifyResultEnum.SUCCESS.getInfo(), null);
                    uService.ChangeValidateEmail(((user)(session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId(),email);
                    session.setAttribute(SessionNameEnum.user_email_by_validated.getSessionName(), null);
                } else if (e == null) {
                    result = new JsonResult<>(true, EmailModifyResultEnum.MESSAGE_FALL.getInfo(), null);
                } else {
                    result = new JsonResult<>(true, EmailModifyResultEnum.ERROR_CODE.getInfo(), null);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
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
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, PhoneModifyResultEnum.UN_LOGIN.getInfo(), null);
            }
            PasswordProtectedKey p = (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (p==null){
                return  new JsonResult<>(true,PhoneModifyResultEnum.NO_KEY.getInfo(),null);
            }else if ((new Date().getTime())-p.getCreateDate().getTime()>1200000){
                return  new JsonResult<>(true,PhoneModifyResultEnum.OVERTIME.getInfo(),null);
            }else{
                PhoneSendSession ps = (PhoneSendSession) session
                        .getAttribute(SessionNameEnum.user_phone_by_validated.getSessionName());
                if (ps != null && ps.getValidateCode().equals(code)) {
                    String phone = ps.getPhone();
                    if (pService.HasPhone(phone).equals("ER")) {
                        return new JsonResult<>(true, PhoneModifyResultEnum.FORMAT.getInfo(), null);
                    }
                    if (pService.HasPhone(phone).equals("Y")) {
                        return new JsonResult<>(true, PhoneModifyResultEnum.EXITS.getInfo(), null);
                    }
                    result = new JsonResult<>(true, PhoneModifyResultEnum.SUCCESS.getInfo(), null);
                    uService.ChangeValidatePhone(((user)(session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId(),phone);
                    session.setAttribute(SessionNameEnum.user_phone_by_validated.getSessionName(), null);
                } else if (ps == null) {
                    result = new JsonResult<>(true, PhoneModifyResultEnum.MESSAGE_FALL.getInfo(), null);
                } else {
                    result = new JsonResult<>(true, PhoneModifyResultEnum.ERROR_CODE.getInfo(), null);
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return result;
    }

    /**
     * 打开（修改密码时验证密保） 需要
     * 1.用户是登录状态
     * @param session 会话session
     * @return 处理结果
     */
    @RequestMapping(value = "OpenPasswordChangeValidate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> OpenPasswordChangeValidate(HttpSession session){
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, PasswordChangeValidateEnum.UN_LOGIN.getInfo(), null);
            }
            Long userId = ((user)(session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId();
            PasswordProtected p = uService.getPasswordProtectByUserId(userId);
            if (p.getPasswoordChangeValidate().equals("Y")){
                return new JsonResult<>(true, PasswordChangeValidateEnum.Opened.getInfo(), null);
            }
            uService.OpenOrClosePasswordChangeValidate(userId);
            result = new JsonResult<>(true, PasswordChangeValidateEnum.Success.getInfo(), null);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return  result;
    }

    /**
     * 打开（修改密码时验证密保） 需要
     * 1.用户是登录状态
     * 2.用户以验证密保
     * @param session 会话session
     * @return 处理结果
     */
    @RequestMapping(value = "ClosePasswordChangeValidate", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ClosePasswordChangeValidate(HttpSession session){
        JsonResult<String> result;
        try {
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, PasswordChangeValidateEnum.UN_LOGIN.getInfo(), null);
            }
            Long userId = ((user)(session.getAttribute(SessionNameEnum.user.getSessionName()))).getUserId();
            PasswordProtected p = uService.getPasswordProtectByUserId(userId);
            if (p.getPasswoordChangeValidate().equals("N")){
                return new JsonResult<>(true, PasswordChangeValidateEnum.Closed.getInfo(), null);
            }
            PasswordProtectedKey pk =
                    (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
            if (pk==null){
                return new JsonResult<>(true, PasswordChangeValidateEnum.NeedKey.getInfo(), null);
            }
            uService.OpenOrClosePasswordChangeValidate(userId);
            result = new JsonResult<>(true, PasswordChangeValidateEnum.Success.getInfo(), null);
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return  result;
    }

    /**
     * 修改密码，需要用户是登录状态
     * 1.若用户打开了（修改密码时验证密保），不需要验证旧密码，直接可以设置新密码
     * 2.若用户关闭了（修改密码时验证密保），需要验证旧密码，然后可以设置新密码
     * 3.修改后用户需要重新登录
     * @param session 会话session
     * @param oldPassword 旧密码
     * @param newPassword 新密码
     * @return 处理结果
     */
    @RequestMapping(value = "ModifyPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public JsonResult<?> ModifyPassword(HttpSession session,String oldPassword,String newPassword){
        JsonResult<String> result;
        try {
            if(newPassword==null||newPassword.length()>20||newPassword.length()<6){
                return new JsonResult<>(true, ModifyPaswordEnum.FORMAT.getInfo(), null);
            }
            if (!checkService.LoginState(session)) {
                return new JsonResult<>(true, ModifyPaswordEnum.UN_LOGIN.getInfo(), null);
            }
            user u = ((user)(session.getAttribute(SessionNameEnum.user.getSessionName())));
            PasswordProtected p = uService.getPasswordProtectByUserId(u.getUserId());
            if (p.getPasswoordChangeValidate().equals("Y")){
                PasswordProtectedKey pk =
                        (PasswordProtectedKey) session.getAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
                if (pk==null){
                    return new JsonResult<>(true, ModifyPaswordEnum.NeedKey.getInfo(), null);
                }
                uService.ChangePasword(u.getUserId(),newPassword);
                session.removeAttribute(SessionNameEnum.user_validate_password_protected_key.getSessionName());
                result = new JsonResult<>(true, ModifyPaswordEnum.Success.getInfo(), null);
            }else{
                u.setPassword(oldPassword);
                LoginResult l = uService.getLoginResult(u);
                if (l.getResultNum()==1){
                    uService.ChangePasword(u.getUserId(),newPassword);
                    result = new JsonResult<>(true, ModifyPaswordEnum.Success.getInfo(), null);
                }else{
                    result = new JsonResult<>(true, ModifyPaswordEnum.WrongPsd.getInfo(), null);
                }
            }
        }catch (Exception e) {
            logger.error(e.getMessage(), e);
            return jsonResultFactory.CreateJsonResult_False(e);
        }
        return  result;
    }
}