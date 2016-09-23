package cn.SkyShadow.controller;

import cn.SkyShadow.base.SpringBase;
import cn.SkyShadow.dto.user.SignUpForm;
import cn.SkyShadow.model.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
public class UserControllerTest extends SpringBase{
    private final HttpSession session = getSession();
    @Autowired
    private UserController userController;
    @Autowired
    private PublicController publicController;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void LoginAndLoginOut()throws Exception{
        User u = new User();
        u.setUsername("test001");
        u.setPassword("123456");
        logger.info(session.getId());
//        logger.info("登录："+userController.getLoginResult(u,null,Session));
//        logger.info("登录："+userController.getLoginResult(u,null,Session));
//        logger.info("登录："+userController.getLoginResult(u,null,Session));
        logger.info("登录："+userController.getLoginResult(u,null,session));
        //u.setPassword("123456");
        //logger.info("登录："+userController.getLoginResult(u,null,Session));
        //u.setPassword("123456789");
        //logger.info("登录："+userController.getLoginResult(u,null,Session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("退出："+userController.loginOut(session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info(session.getId());
    }

    @Test
    public void signUpNoEmail() throws Exception {
        String code = (String) publicController.sendPhoneValidateCode("+8618100174600",session).getData();
        if (!code.equals("ERROR!")){
            User u = new User();
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
        String code = (String) publicController.sendPhoneValidateCode("+8618100174611",session).getData();
        String code1 = (String) publicController.sendEmailValidateCode("123@aaaa.com",session).getData();
        if (!code.equals("ERROR!")){
            User u = new User();
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
        User u = new User();
        u.setUsername("test003");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,null,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("绑定邮箱："+userController.ValidateEmail(session,"123456"));
    }

    @Test
    public void sendPhoneValidateCode() throws Exception {
        User u = new User();
        u.setUsername("test004");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,null,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("绑定手机："+userController.ValidatePhone(session,"666666"));
    }

    @Test
    public void getPasswordProtected() throws Exception {
        User u = new User();
        u.setUsername("test003");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,null,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("密保手段："+userController.getPasswordProtected(session));
    }

    @Test
    public void phoneSendToCheckPasswordProtected() throws Exception {
        User u = new User();
        u.setUsername("test004");
        u.setPassword("123456789");
        logger.info("登录："+userController.getLoginResult(u,null,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("验证密保(手机)"+userController.ValidatePasswordProtectedMethodByPhone(session,"636366"));
        logger.info("修改手机(发送短信)"+"123456");
        logger.info("修改手机"+userController.ChangeValidatePhone(session,"000000"));
    }

    @Test
    public void emailSendToCheckPasswordProtected() throws Exception {
        User u = new User();
        u.setUsername("test004");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,null,session));
        logger.info("登录状态："+userController.getLoginState(session));
//        String code = (String) userController.EmailSendToCheckPasswordProtected(session).getData();
        logger.info("验证密保(邮箱)"+userController.ValidatePasswordProtectedMethodByPhone(session,"123456"));
//        String code1 = (String) userController.ChangeValidateEmailSend(session,"1523@qq.com").getData();
        logger.info("修改邮箱(发送短信)"+"1234656");
        logger.info("修改邮箱"+userController.ChangeValidateEmail(session,"123456"));
    }
    @Test
    public void  ModifyPassword() throws  Exception{
        User u = new User();
        u.setUsername("test004");
        u.setPassword("123456");
        logger.info("登录："+userController.getLoginResult(u,null,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("验证密保(邮箱)"+userController.ValidatePasswordProtectedMethodByEmail(session,"000000"));
        logger.info("打开密码更改保护"+userController.OpenPasswordChangeValidate(session));
        logger.info("修改密码"+userController.ModifyPassword(session,null,"123456789"));
        u.setPassword("123456789");
        logger.info("登录："+userController.getLoginResult(u,null,session));
        logger.info("登录状态："+userController.getLoginState(session));
        logger.info("验证密保(邮箱)"+userController.ValidatePasswordProtectedMethodByEmail(session,"000000"));
        logger.info("关闭密码更改保护"+userController.ClosePasswordChangeValidate(session));
        logger.info("修改密码"+userController.ModifyPassword(session,null,"123456"));
    }
}