package cn.SkyShadow.controller;

import cn.SkyShadow.dto.tp.EmailValidateResult;
import cn.SkyShadow.dto.tp.PhoneValidateResult;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.dto.user.PasswordProtectedKey;
import cn.SkyShadow.enums.*;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.UserCoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.SkyShadow.dto.JsonResult;
import cn.SkyShadow.dto.tp.EmailSendSession;
import cn.SkyShadow.dto.tp.PhoneSendSession;
import cn.SkyShadow.model.city;
import cn.SkyShadow.model.country;
import cn.SkyShadow.service.PublicService;
import cn.SkyShadow.tp.service.SendEmailService;
import cn.SkyShadow.tp.service.SendPhoneService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
@Transactional
@Controller
@RequestMapping("/public")
public class PublicController {
	/*
	 * 模版:
	 * 
	 * JsonResult<> result; try {
	 * 
	 * result = new JsonResult<>(true, , null); } catch (Exception e) {
	 * logger.error(e.getMessage(), e); result = new JsonResult<>(false,
	 * e.getMessage()); } return result;
	 */
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private PublicService p;
	@Autowired
	private SendEmailService emailService;
	@Autowired
	private SendPhoneService phoneService;
    @Autowired
    private UserCoreService userCoreService;

	/**
	 * 查询手机号是否被使用了
	 * @param phone 手机号码
	 * @return 结果
	 */
	@RequestMapping(value = "/{phone}/hasPhone", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<String> hasPhone(@PathVariable("phone") String phone) {
		JsonResult<String> result;
		try {
			String hS = p.HasPhone(phone);
			result = new JsonResult<String>(true, hS, null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new JsonResult<String>(false, e.getMessage());
		}
		return result;
	}

	/**
	 * 查询用户名是否被使用了
	 * @param username 用户名
	 * @return 结果
	 */
	@RequestMapping(value = "/{username}/hasUsername", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<String> hasUserName(
			@PathVariable("username") String username) {
		JsonResult<String> result;
		try {
			String hu = p.HasUsername(username);
			result = new JsonResult<String>(true, hu, null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new JsonResult<String>(false, e.getMessage());
		}
		return result;
	}

	/**
	 * 查询邮箱是否被注册
	 * @param email 邮箱
	 * @return 结果
	 */
	@RequestMapping(value = "/{email}/hasEmail", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<String> hasEmail(@PathVariable("email") String email) {
		JsonResult<String> result;
		try {
			String hu = p.HasEmail(email);
			result = new JsonResult<String>(true, hu, null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new JsonResult<String>(false, e.getMessage());
		}
		return result;
	}

	/**
	 * 查询城市列表
	 * @return 包装类List city
	 */
	@RequestMapping(value = "/cityList_zh", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<List<city>> getCityList_zh() {
		JsonResult<List<city>> result;
		try {
			List<city> cities = p.get_ZH_Cities();
			result = new JsonResult<List<city>>(true, cities, null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new JsonResult<List<city>>(false, e.getMessage());
		}
		return result;
	}

	/**
	 * 查询国家列表
	 * @return 包装类list country
	 */
	@RequestMapping(value = "/countryList", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<List<country>> getCountryList() {
		JsonResult<List<country>> result;
		try {
			List<country> countries = p.getCountries();
			result = new JsonResult<List<country>>(true, countries, null);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new JsonResult<List<country>>(false, e.getMessage());
		}
		return result;
	}

	/**
	 * 注册时使用，发送邮箱验证码
	 * @param email 邮箱
	 * @param session 会话session
	 * @return 发送是否成功
	 */
	@RequestMapping(value = "/{email}/sendEmailValidateCode", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<String> sendEmailValidateCode(
			@PathVariable("email") String email, HttpSession session) {
		JsonResult<String> result;
		try {
			if (p.HasEmail(email).equals("ER")) {
				return new JsonResult<String>(true, "FORMAT!", null);
			}
			if (p.HasEmail(email).equals("Y")) {
				return new JsonResult<String>(true, "EXITS!", null);
			}
			EmailSendSession e = (EmailSendSession) session
					.getAttribute("public_email");
			if (e == null) {
				String r = emailService.SendValidateCode(email);
				result = new JsonResult<String>(true, r, null);
				if (!r.equals("ERROR!")) {
					session.setAttribute("public_email", new EmailSendSession(r,email));
				}
			} else {
				Date date = new Date();
				Date sessiondDate = e.getSendDate();
				if (date.getTime() - sessiondDate.getTime() < 60000) {
					result = new JsonResult<String>(true, "OVERCLOCKING!", null);
				} else {
					String r = emailService.SendValidateCode(email);
					result = new JsonResult<String>(true, r, null);
					if (!r.equals("ERROR!")) {
						session.setAttribute("public_email", new EmailSendSession(r,email));
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new JsonResult<String>(false, e.getMessage());
		}
		return result;
	}

	/**
	 * 注册时使用，发送手机验证码
	 * @param phone 手机号码
	 * @param session 会话session
	 * @return 是否成功
	 */
	@RequestMapping(value = "/{phone}/sendPhoneValidateCode", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<String> sendPhoneValidateCode(
			@PathVariable("phone") String phone, HttpSession session) {
		JsonResult<String> result;
		try {
			if (p.HasPhone(phone).equals("ER")) {
				return new JsonResult<String>(true, "FORMAT!", null);
			}
			if (p.HasPhone(phone).equals("Y")) {
				return new JsonResult<String>(true, "EXITS!", null);
			}
			PhoneSendSession e = (PhoneSendSession) session
					.getAttribute("public_phone");
			if (e == null) {
				String r = phoneService.SendValidateCode(phone);
				result = new JsonResult<String>(true, r, null);
				System.out.print(result);
				if (!r.equals("ERROR!")) {
					session.setAttribute("public_phone", new PhoneSendSession(r,phone));
				}
			} else {
				Date date = new Date();
				Date sessiondDate = e.getSendDate();
				if (date.getTime() - sessiondDate.getTime() < 60000) {
					result = new JsonResult<String>(true, "OVERCLOCKING!", null);
				} else {
					String r = phoneService.SendValidateCode(phone);
					result = new JsonResult<String>(true, r, null);
					if (!r.equals("ERROR!")) {
						session.setAttribute("public_phone", new PhoneSendSession(r,phone));
					}
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			result = new JsonResult<String>(false, e.getMessage());
		}
		return result;
	}
	/**
	 * 找回密码时使用
	 * 返回用户是否可以使用手机验证，用户是否可以使用邮箱验证,要求不登陆状态
	 * @return 包装类PasswordProtected
	 */
	@RequestMapping(value = "//GetPasswordProtectedMethod", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<PasswordProtected> GetPasswordProtectedMethod(String loginName,HttpSession session){
        JsonResult<PasswordProtected> result;
        try {
            Object user = session.getAttribute("user");
            if (user==null){
                return  new JsonResult<PasswordProtected>(true,null,null);
            }
            PasswordProtected pp = p.getPasswordProtectByLoginName(loginName);
            pp.setPasswoordChangeValidate(null);
            result = new JsonResult<PasswordProtected>(true, pp, null);
            session.setAttribute("PasswordProtectedMethod_GETBACKPSD",pp);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new JsonResult<PasswordProtected>(false, e.getMessage());
        }
        return result;
	}
	/**
	 * 发送短信，用于验证密保，要求不登录状态
	 * @param session 会话session
	 * @return 发送结果
	 */
	@RequestMapping(value = "/PhoneSendToCheckPasswordProtected", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<String> PhoneSendToCheckPasswordProtected(HttpSession session){
        JsonResult<String> result;
        try {
            Object user = session.getAttribute("user");
            if (user==null){
                return  new JsonResult<String>(true,PhoneSendResultEnum.LOGINED.getInfo(),null);
            }
            PasswordProtected pp =(PasswordProtected) (session.getAttribute("PasswordProtectedMethod_GETBACKPSD"));
            if (pp==null||pp.getPhoneValidate().equals("N")) {
                return new JsonResult<String>(true, PhoneSendResultEnum.UN_VALIDATE.getInfo(), null);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute("public_validate_password_protected_phone");
            if (e == null) {
                String r = phoneService.SendValidateCode(pp.getPhone());
                result = new JsonResult<String>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute("public_validate_password_protected_phone", new PhoneSendSession(r, pp.getPhone()));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<String>(true, PhoneSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r = phoneService.SendValidateCode(pp.getPhone());
                    result = new JsonResult<String>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute("public_validate_password_protected_phone", new PhoneSendSession(r, pp.getPhone()));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new JsonResult<String>(false, e.getMessage());
        }
        return result;
	}
	/**
	 * 发送邮箱验证码，用于验证密保，要求不登录状态
	 *
	 * @param session 会话session
	 * @return 发送结果
	 */
	@RequestMapping(value = "/EmailSendToCheckPasswordProtected", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<String> EmailSendToCheckPasswordProtected(HttpSession session){
        JsonResult<String> result;
        try {
            Object user = session.getAttribute("user");
            if (user==null){
                return  new JsonResult<String>(true,EmailSendResultEnum.LOGINED.getInfo(),null);
            }
            PasswordProtected pp =(PasswordProtected) (session.getAttribute("PasswordProtectedMethod_GETBACKPSD"));
            if (pp==null||pp.getEmailValidate().equals("N")) {
                return new JsonResult<String>(true, EmailSendResultEnum.UN_VALIDATE.getInfo(), null);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute("public_validate_password_protected_email");
            if (e == null) {
                String r = emailService.SendValidateCode(pp.getEmail());
                result = new JsonResult<String>(true, r, null);
                if (!r.equals("ERROR!")) {
                    session.setAttribute("public_validate_password_protected_email", new EmailSendSession(r, pp.getEmail()));
                }
            } else {
                Date date = new Date();
                Date sessiondDate = e.getSendDate();
                if (date.getTime() - sessiondDate.getTime() < 60000) {
                    result = new JsonResult<String>(true, EmailSendResultEnum.OVERCLOCKING.getInfo(), null);
                } else {
                    String r = emailService.SendValidateCode(pp.getEmail());
                    result = new JsonResult<String>(true, r, null);
                    if (!r.equals("ERROR!")) {
                        session.setAttribute("public_validate_password_protected_email", new EmailSendSession(r, pp.getEmail()));
                    }
                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new JsonResult<String>(false, e.getMessage());
        }
        return result;
	}
	/**
	 * 用邮箱验证密保，要求不登录状态
	 *
	 * @param code    验证码
	 * @param session 会话session
	 * @return 验证结果
	 */
	@RequestMapping(value = "{code}/ValidatePasswordProtectedMethodByEmail", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<EmailValidateResult> ValidatePasswordProtectedMethodByEmail(HttpSession session, @PathVariable("code") String code){
        JsonResult<EmailValidateResult> result;
        try {
            Object user = session.getAttribute("user");
            if (user==null){
                return  new JsonResult<EmailValidateResult>(true,new  EmailValidateResult(EmailValidateEnum.LOGINED),null);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute("public_validate_password_protected_email");
            if (e != null && e.getValidateCode().equals(code)) {
                result = new JsonResult<EmailValidateResult>(true, new EmailValidateResult(EmailValidateEnum.SUCCESS), null);
                session.setAttribute("public_validate_password_protected_key", new PasswordProtectedKey());
            } else if (e == null) {
                result = new JsonResult<EmailValidateResult>(true, new EmailValidateResult(EmailValidateEnum.MESSAGE_FALL), null);
            } else {
                result = new JsonResult<EmailValidateResult>(true, new EmailValidateResult(EmailValidateEnum.ERROR_CODE), null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new JsonResult<EmailValidateResult>(false, e.getMessage());
        }
        return result;
	}
	/**
	 * 用手机验证密保
	 *
	 * @param code    验证码
	 * @param session 会话session
	 * @return 验证结果
	 */
	@RequestMapping(value = "{code}/ValidatePasswordProtectedMethodByPhone", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<PhoneValidateResult> ValidatePasswordProtectedMethodByPhone(HttpSession session, @PathVariable("code") String code){
        JsonResult<PhoneValidateResult> result;
        try {
            Object user = session.getAttribute("user");
            if (user==null){
                return  new JsonResult<PhoneValidateResult>(true,new  PhoneValidateResult(PhoneValidateEnum.LOGINED),null);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute("public_validate_password_protected_phone");
            if (e != null && e.getValidateCode().equals(code)) {
                result = new JsonResult<PhoneValidateResult>(true, new PhoneValidateResult(PhoneValidateEnum.SUCCESS), null);
                session.setAttribute("public_validate_password_protected_key", new PasswordProtectedKey());
            } else if (e == null) {
                result = new JsonResult<PhoneValidateResult>(true, new PhoneValidateResult(PhoneValidateEnum.MESSAGE_FALL), null);
            } else {
                result = new JsonResult<PhoneValidateResult>(true, new PhoneValidateResult(PhoneValidateEnum.ERROR_CODE), null);
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new JsonResult<PhoneValidateResult>(false, e.getMessage());
        }
        return result;
	}

	/**
	 * 重设密码，需要有密保验证的key
	 * @param session 当前会话
	 * @param password 新密码
	 * @return 修改结果
	 */
	@RequestMapping(value = "/ResetPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<String> ResetPassword(HttpSession session, String password){
        JsonResult<String> result;
        try {
            Object user = session.getAttribute("user");
            if (user==null){
                return  new JsonResult<String>(true, ModifyPaswordEnum.LOGINED.getInfo(),null);
            }
            PasswordProtectedKey pk =
                    (PasswordProtectedKey) session.getAttribute("public_validate_password_protected_key");
            PasswordProtected pp =
                    (PasswordProtected)session.getAttribute("PasswordProtectedMethod_GETBACKPSD");
            if (pk==null||pp==null){
                return new JsonResult<String>(true, ModifyPaswordEnum.NeedKey.getInfo(), null);
            }
            p.ChangePasword(pp.getUserId(),password);
            session.setAttribute("user_validate_password_protected_key",null);
            result = new JsonResult<String>(true, ModifyPaswordEnum.Success.getInfo(), null);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new JsonResult<String>(false, e.getMessage());
        }
        return result;
	}
}
