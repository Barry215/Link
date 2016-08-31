package cn.SkyShadow.controller;

import cn.SkyShadow.dto.user.SignUpForm;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import  cn.SkyShadow.model.user;

import javax.servlet.http.HttpSession;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/spring-mvc.xml"})
public class UserControllerTest {
    private HttpSession session;
    @Before
    public void setUp(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        request.setCharacterEncoding("UTF-8");
        session = request.getSession();
    }
    @Autowired
    private UserController userController;
    @Autowired
    private PublicController publicController;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void LoginAndLoginOut()throws Exception{
        user u = new user();
        u.setUsername("test001");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("退出："+userController.loginout(session));
        logger.info("登录状态："+userController.getLoginState(session));
    }

    @Test
    public void signUpNoEmail() throws Exception {
        String code = publicController.sendPhoneValidateCode("+8618100174600",session).getData();
        if (!code.equals("ERROR!")){
            user u = new user();
            u.setUsername("test003");
            u.setPassword("123456");
            u.setPhone("18100174600");
            SignUpForm signUpForm = new SignUpForm();
            signUpForm.setPhoneCode(code);
            signUpForm.setUser(u);
            logger.info("无邮箱注册结果："+userController.signUpNoEmail(session,signUpForm));
        }
    }

    @Test
    public void signUp() throws Exception {
        String code = publicController.sendPhoneValidateCode("+8618100174611",session).getData();
        String code1 = publicController.sendEmailValidateCode("123@aaaa.com",session).getData();
        if (!code.equals("ERROR!")){
            user u = new user();
            u.setUsername("test004");
            u.setPassword("123456");
            u.setPhone("18100174611");
            u.setEmail("123@aaaa.com");
            SignUpForm signUpForm = new SignUpForm();
            signUpForm.setEmailCode(code1);
            signUpForm.setPhoneCode(code);
            signUpForm.setUser(u);
            logger.info("有邮箱注册结果："+userController.signUpNoEmail(session,signUpForm));
        }
    }

    @Test
    public void sendEmailValidateCode() throws Exception {
        user u = new user();
        u.setUsername("test003");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        String code = userController.sendEmailValidateCode("789@qq.com",session).getData();
        logger.info("绑定邮箱："+userController.ValidateEmail(session,code));
    }

    @Test
    public void sendPhoneValidateCode() throws Exception {
        user u = new user();
        u.setUsername("test004");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        String code = userController.sendPhoneValidateCode("+8613555555555",session).getData();
        logger.info("绑定手机："+userController.ValidatePhone(session,code));
    }

    @Test
    public void getPasswordProtected() throws Exception {
        user u = new user();
        u.setUsername("test003");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("密保手段："+userController.getPasswordProtected(session));
    }

    @Test
    public void phoneSendToCheckPasswordProtected() throws Exception {
        user u = new user();
        u.setUsername("test004");
        u.setPassword("123456789");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        String code = userController.PhoneSendToCheckPasswordProtected(session).getData();
        logger.info("验证密保(手机)"+userController.ValidatePasswordProtectedMethodByPhone(session,code));
        String code1 = userController.ChangeValidatePhoneSend(session,"+8618100174611").getData();
        logger.info("修改手机(发送短信)"+code1);
        logger.info("修改手机"+userController.ChangeValidatePhone(session,code1));
    }

    @Test
    public void emailSendToCheckPasswordProtected() throws Exception {
        user u = new user();
        u.setUsername("test004");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        String code = userController.EmailSendToCheckPasswordProtected(session).getData();
        logger.info("验证密保(邮箱)"+userController.ValidatePasswordProtectedMethodByPhone(session,code));
        String code1 = userController.ChangeValidateEmailSend(session,"1523@qq.com").getData();
        logger.info("修改邮箱(发送短信)"+code1);
        logger.info("修改邮箱"+userController.ChangeValidateEmail(session,code1));
    }
    @Test
    public void  ModifyPassword() throws  Exception{
        user u = new user();
        u.setUsername("test004");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        String code = userController.EmailSendToCheckPasswordProtected(session).getData();
        logger.info("验证密保(邮箱)"+userController.ValidatePasswordProtectedMethodByEmail(session,code));
        logger.info("打开密码更改保护"+userController.OpenPasswordChangeValidate(session));
        logger.info("修改密码"+userController.ModifyPassword(session,null,"123456789"));
        u.setPassword("123456789");
        logger.info("登录："+userController.getLoginResult(u,session));
        logger.info("登录状态："+userController.getLoginState(session));
        code = userController.EmailSendToCheckPasswordProtected(session).getData();
        logger.info("验证密保(邮箱)"+userController.ValidatePasswordProtectedMethodByEmail(session,code));
        logger.info("关闭密码更改保护"+userController.ClosePasswordChangeValidate(session));
        logger.info("修改密码"+userController.ModifyPassword(session,null,"123456"));
    }
}