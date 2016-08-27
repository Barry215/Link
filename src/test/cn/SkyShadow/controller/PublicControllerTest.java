package cn.SkyShadow.controller;

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

import javax.servlet.http.HttpSession;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/spring-mvc.xml"})
public class PublicControllerTest {
    private HttpSession session;
    @Before
    public void setUp(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCharacterEncoding("UTF-8");
        session = request.getSession();
    }
    @Autowired
    private PublicController publicController;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Test
    public void hasPhone() throws Exception {
        logger.info("测试 hasphone:"+publicController.hasPhone("18100174605"));
    }

    @Test
    public void hasUserName() throws Exception {
        logger.info("测试 hasUserName:"+publicController.hasUserName("Richard"));
    }

    @Test
    public void hasEmail() throws Exception {
        logger.info("测试 hasEmail:"+publicController.hasEmail("123@qq.com"));
    }

    @Test
    public void getCityList_zh() throws Exception {
        logger.info("测试 getCityList_zh:"+publicController.getCityList_zh());
    }

    @Test
    public void getCountryList() throws Exception {
        logger.info("测试 getCountryList:"+publicController.getCountryList());
    }

    @Test
    public void sendEmailValidateCode() throws Exception {
        logger.info("测试 sendEmailValidateCode1:"+publicController.sendEmailValidateCode("1810017460@qq.com",session));
        logger.info("测试 sendEmailValidateCode2:"+publicController.sendEmailValidateCode("1810017460@qq.com",session));
    }

    @Test
    public void sendPhoneValidateCode() throws Exception {
        logger.info("测试 sendPhoneValidateCode:"+publicController.sendPhoneValidateCode("127728705@qq.com",session));
    }
}