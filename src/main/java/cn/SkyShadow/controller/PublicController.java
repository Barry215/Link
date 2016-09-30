package cn.SkyShadow.controller;

import cn.SkyShadow.basic_component.ExceptionHandler;
import cn.SkyShadow.factory.JsonResultFactory;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.dto.user.PasswordProtectedKey;
import cn.SkyShadow.enums.*;
import cn.SkyShadow.model.City;
import cn.SkyShadow.model.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import cn.SkyShadow.dto.json.JsonResult;
import cn.SkyShadow.dto.tp.EmailSendSession;
import cn.SkyShadow.dto.tp.PhoneSendSession;
import cn.SkyShadow.service.PublicService;
import cn.SkyShadow.tp.service.SendEmailService;
import cn.SkyShadow.tp.service.SendPhoneService;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
@Transactional
@Controller
@RequestMapping("/public")
public class PublicController{
	private final PublicService p;
	private final SendEmailService emailService;
	private final SendPhoneService phoneService;
	private final ExceptionHandler exceptionHandle;


	public PublicController(SendEmailService emailService, PublicService p, SendPhoneService phoneService, ExceptionHandler exceptionHandle) {
		this.emailService = emailService;
		this.p = p;
		this.phoneService = phoneService;
		this.exceptionHandle = exceptionHandle;
		exceptionHandle.setClass(this.getClass());
	}

	/**
	 * 查询手机号是否被使用了
	 * @param phone 手机号码
	 * @return 结果
	 */
	@RequestMapping(value = "/{phone}/hasPhone", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<?> hasPhone(@PathVariable("phone") String phone) {
		try {
			String hS = p.HasPhone(phone);
			return JsonResultFactory.CreateJsonResult_True(hS);
		} catch (Exception e) {
			exceptionHandle.ExceptionHandle(e);
			return JsonResultFactory.CreateJsonResult_False(e);
		}
	}

	/**
	 * 查询用户名是否被使用了
	 * @param username 用户名
	 * @return 结果
	 */
	@RequestMapping(value = "/{username}/hasUsername", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<?> hasUserName(
			@PathVariable("username") String username) {
		try {
			String hu = p.HasUsername(username);
			return JsonResultFactory.CreateJsonResult_True(hu);
		} catch (Exception e) {
			exceptionHandle.ExceptionHandle(e);
			return JsonResultFactory.CreateJsonResult_False(e);
		}
	}

	/**
	 * 查询邮箱是否被注册
	 * @param email 邮箱
	 * @return 结果
	 */
	@RequestMapping(value = "/{email}/hasEmail", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<?> hasEmail(@PathVariable("email") String email) {
		try {
			String hu = p.HasEmail(email);
			return JsonResultFactory.CreateJsonResult_True(hu);
		} catch (Exception e) {
			exceptionHandle.ExceptionHandle(e);
			return JsonResultFactory.CreateJsonResult_False(e);
		}
	}

	/**
	 * 查询城市列表
	 * @return 包装类List City
	 */
	@RequestMapping(value = "/cityList_zh", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<?> getCityList_zh() {
		
		try {
			List<City> cities = p.get_ZH_Cities();
			return JsonResultFactory.CreateJsonResult_True(cities);
		} catch (Exception e) {
			exceptionHandle.ExceptionHandle(e);
			return JsonResultFactory.CreateJsonResult_False(e);
		}
	}

	/**
	 * 查询国家列表
	 * @return 包装类list Country
	 */
	@RequestMapping(value = "/countryList", produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<?> getCountryList() {
		try {
			List<Country> countries = p.getCountries();
			return JsonResultFactory.CreateJsonResult_True(countries);
		} catch (Exception e) {
			exceptionHandle.ExceptionHandle(e);
			return JsonResultFactory.CreateJsonResult_False(e);
		}
	}

	/**
	 * 注册时使用，发送邮箱验证码
	 * @param email 邮箱
	 * @param session 会话session
	 * @return 发送是否成功
	 */
	@RequestMapping(value = "/{email}/sendEmailValidateCode", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<?> sendEmailValidateCode(
			@PathVariable("email") String email, HttpSession session) {
		JsonResult<?> result;
		try {
			if (p.HasEmail(email).equals("ER")) {
				return JsonResultFactory.CreateJsonResult_True("FORMAT!");
			}
			if (p.HasEmail(email).equals("Y")) {
				return JsonResultFactory.CreateJsonResult_True("EXITS!");
			}
			EmailSendSession e = (EmailSendSession) session
					.getAttribute("public_email");
			if (e == null) {
				String r = emailService.SendValidateCode(email);
				result = JsonResultFactory.CreateJsonResult_True(r);
				if (!r.equals("ERROR!")) {
					session.setAttribute("public_email", new EmailSendSession(r,email));
				}
			} else {
				Date date = new Date();
				Date sessionDate = e.getSendDate();
				if (date.getTime() - sessionDate.getTime() < 60000) {
					result = JsonResultFactory.CreateJsonResult_True("OVERCLOCKING!");
				} else {
					String r = emailService.SendValidateCode(email);
					result = JsonResultFactory.CreateJsonResult_True(r);
					if (!r.equals("ERROR!")) {
						session.setAttribute("public_email", new EmailSendSession(r,email));
					}
				}
			}
		} catch (Exception e) {
			exceptionHandle.ExceptionHandle(e);
			result = JsonResultFactory.CreateJsonResult_False(e);
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
	public JsonResult<?> sendPhoneValidateCode(
			@PathVariable("phone") String phone, HttpSession session) {
		
		try {
			if (p.HasPhone(phone).equals("ER")) {
				return JsonResultFactory.CreateJsonResult_True("FORMAT!");
			}
			if (p.HasPhone(phone).equals("Y")) {
				return JsonResultFactory.CreateJsonResult_True("EXITS!");
			}
			PhoneSendSession e = (PhoneSendSession) session
					.getAttribute("public_phone");
			if (e == null) {
				String r = phoneService.SendValidateCode(phone);
				if (!r.equals("ERROR!")) {
					session.setAttribute("public_phone", new PhoneSendSession(r,phone));
				}
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
				Date date = new Date();
				Date sessionDate = e.getSendDate();
				if (date.getTime() - sessionDate.getTime() < 60000) {
					return JsonResultFactory.CreateJsonResult_True("OVERCLOCKING!");
				} else {
					String r = phoneService.SendValidateCode(phone);
					if (!r.equals("ERROR!")) {
						session.setAttribute("public_phone", new PhoneSendSession(r,phone));
					}
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
			}
		} catch (Exception e) {
			exceptionHandle.ExceptionHandle(e);
			return JsonResultFactory.CreateJsonResult_False(e);
		}
	}
	/**
	 * 找回密码时使用
	 * 返回用户是否可以使用手机验证，用户是否可以使用邮箱验证,要求不登陆状态
	 * @param loginName 模糊的名称,支持用户名,验证过的邮箱和手机。
     * @param session 回话session
	 * @return 包装类PasswordProtected
	 */
	@RequestMapping(value = "/GetPasswordProtectedMethod", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public JsonResult<?> GetPasswordProtectedMethod(String loginName,HttpSession session){
        try {
            Object user = session.getAttribute("user");
            if (user!=null){
                return  JsonResultFactory.CreateJsonResult_True(ResultMapper.User_LoginING);
            }
            PasswordProtected pp = p.getPasswordProtectByLoginName(loginName);
            pp.setPasswordChangeValidate(null);
            session.setAttribute("PasswordProtectedMethod_GETBACKPSD",pp);
            return JsonResultFactory.CreateJsonResult_True(pp);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
	}
	/**
	 * 发送短信，用于验证密保，要求不登录状态
	 * @param session 会话session
	 * @return 发送结果
	 */
	@RequestMapping(value = "/PhoneSendToCheckPasswordProtected", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<?> PhoneSendToCheckPasswordProtected(HttpSession session){
        try {
            Object user = session.getAttribute("user");
            if (user!=null){
                return  JsonResultFactory.CreateJsonResult_True(ResultMapper.User_LoginING);
            }
            PasswordProtected pp =(PasswordProtected) (session.getAttribute("PasswordProtectedMethod_GETBACKPSD"));
			if (pp==null){
				return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_OverTime);
			}
            if (pp.getPhoneValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_UnValidated);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute("public_validate_password_protected_phone");
            if (e == null) {
                String r = phoneService.SendValidateCode(pp.getPhone());
                if (!r.equals("ERROR!")) {
                    session.setAttribute("public_validate_password_protected_phone", new PhoneSendSession(r, pp.getPhone()));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessionDate = e.getSendDate();
                if (date.getTime() - sessionDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Phone_OverLocking);
                } else {
                    String r = phoneService.SendValidateCode(pp.getPhone());
                    if (!r.equals("ERROR!")) {
                        session.setAttribute("public_validate_password_protected_phone", new PhoneSendSession(r, pp.getPhone()));
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
	}
	/**
	 * 发送邮箱验证码，用于验证密保，要求不登录状态
	 *
	 * @param session 会话session
	 * @return 发送结果
	 */
	@RequestMapping(value = "/EmailSendToCheckPasswordProtected", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<?> EmailSendToCheckPasswordProtected(HttpSession session){
        try {
            Object user = session.getAttribute("user");
            if (user!=null){
                return  JsonResultFactory.CreateJsonResult_True(ResultMapper.User_LoginING);
            }
            PasswordProtected pp =(PasswordProtected) (session.getAttribute("PasswordProtectedMethod_GETBACKPSD"));
            if (p==null){
				return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_OverTime);
			}
			if (pp.getEmailValidate().equals("N")) {
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_UnValidated);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute("public_validate_password_protected_email");
            if (e == null) {
                String r = emailService.SendValidateCode(pp.getEmail());
                if (!r.equals("ERROR!")) {
                    session.setAttribute("public_validate_password_protected_email", new EmailSendSession(r, pp.getEmail()));
                }
                return JsonResultFactory.CreateJsonResult_True(r);
            } else {
                Date date = new Date();
                Date sessionDate = e.getSendDate();
                if (date.getTime() - sessionDate.getTime() < 60000) {
                    return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_Email_OverLocking);
                } else {
                    String r = emailService.SendValidateCode(pp.getEmail());
                    if (!r.equals("ERROR!")) {
                        session.setAttribute("public_validate_password_protected_email", new EmailSendSession(r, pp.getEmail()));
                    }
                    return JsonResultFactory.CreateJsonResult_True(r);
                }
            }
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
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
	public JsonResult<?> ValidatePasswordProtectedMethodByEmail(HttpSession session, @PathVariable("code") String code){
        try {
            Object user = session.getAttribute("user");
            if (user!=null){
                return  JsonResultFactory.CreateJsonResult_True(ResultMapper.User_LoginING);
            }
            EmailSendSession e = (EmailSendSession) session
                    .getAttribute("public_validate_password_protected_email");
            if (e != null && e.getValidateCode().equals(code)) {
                session.setAttribute("public_validate_password_protected_key", new PasswordProtectedKey());
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
	 * 用手机验证密保
	 *
	 * @param code    验证码
	 * @param session 会话session
	 * @return 验证结果
	 */
	@RequestMapping(value = "{code}/ValidatePasswordProtectedMethodByPhone", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<?> ValidatePasswordProtectedMethodByPhone(HttpSession session, @PathVariable("code") String code){
        try {
            Object user = session.getAttribute("user");
            if (user!=null){
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.User_LoginING);
            }
            PhoneSendSession e = (PhoneSendSession) session
                    .getAttribute("public_validate_password_protected_phone");
            if (e != null && e.getValidateCode().equals(code)) {
                session.setAttribute("public_validate_password_protected_key", new PasswordProtectedKey());
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
	 * 重设密码，需要有密保验证的key
	 * @param session 当前会话
	 * @param password 新密码
	 * @return 修改结果
	 */
	@RequestMapping(value = "/ResetPassword", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
	@ResponseBody
	public JsonResult<?> ResetPassword(HttpSession session, String password){
        try {
            Object user = session.getAttribute("user");
            if (user!=null){
                return  JsonResultFactory.CreateJsonResult_True(ResultMapper.User_UnLogin);
            }
            PasswordProtectedKey pk =
                    (PasswordProtectedKey) session.getAttribute("public_validate_password_protected_key");
            PasswordProtected pp =
                    (PasswordProtected)session.getAttribute("PasswordProtectedMethod_GETBACKPSD");
            if (pk==null||pp==null){
                return JsonResultFactory.CreateJsonResult_True(ResultMapper.Public_No_PasswordProtectedKey);
            }
            p.ChangePassword(pp.getUserId(),password);
            session.setAttribute("user_validate_password_protected_key",null);
            return JsonResultFactory.CreateJsonResult_True(ResultMapper.SUCCESS);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
	}
}
