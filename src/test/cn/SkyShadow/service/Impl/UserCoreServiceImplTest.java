package cn.SkyShadow.service.Impl;

import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.result_model.RegisterResult;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.UserCoreService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/spring-mvc.xml"})
public class UserCoreServiceImplTest {
    @Autowired
    private UserCoreService userMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void getLoginResult() throws Exception {
        user u = new user();
        u.setUsername("18100174605");
        u.setPassword("123456");
        LoginResult l = userMapper.getLoginResult(u);
        logger.info("测试登录"+l);
    }

    @Test
    public void getRegisterResult_NOEMAIL() throws Exception {
        user u = new user();
        u.setUsername("test001");
        u.setPassword("123456");
        u.setPhone("13888888888");
        RegisterResult r = userMapper.getRegisterResult(u);
        logger.info("测试注册1"+r);
    }

    @Test
    public void getRegisterResult() throws Exception {
        user u = new user();
        u.setUsername("test002");
        u.setPassword("123456");
        u.setPhone("13888888886");
        u.setEmail("88888@hdu.com");
        RegisterResult r = userMapper.getRegisterResult(u);
        logger.info("测试注册1"+r);
    }

    @Test
    public void selectUserByLogin() throws Exception {
        user u = new user();
        u.setUsername("test001");
        u.setPassword("123456");
        logger.info("测试登录用户信息获取"+userMapper.SelectUserByLogin(u));
    }

    @Test
    public void selectUserBaseInfo() throws Exception {
        logger.info("测试登录用户信息获取"+userMapper.selectUserBaseInfo(3L));
    }

    @Test
    public void validateEmail() throws Exception {
        logger.info("测试验证邮箱结果"+userMapper.ValidateEmail(3L,"123@www.com"));
    }

    @Test
    public void validatePhone() throws Exception {
        logger.info("测试验证手机结果"+userMapper.ValidatePhone(4L,"13866668888"));
    }

    @Test
    public void changeValidateEmail() throws Exception {
        logger.info("测试修改邮箱结果"+userMapper.ChangeValidateEmail(4L,"13866668889@qq.com"));
    }

    @Test
    public void changeValidatePhone() throws Exception {
        logger.info("测试修改手机结果"+userMapper.ChangeValidatePhone(4L,"13834388888"));
    }

    @Test
    public void  OpenOrClosePasswordChangeValidate() throws  Exception{
        logger.info("测试"+userMapper.OpenOrClosePasswordChangeValidate(4L));
        logger.info("测试"+userMapper.OpenOrClosePasswordChangeValidate(4L));
    }


}