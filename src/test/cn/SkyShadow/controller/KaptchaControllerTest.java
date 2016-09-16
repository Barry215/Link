package cn.SkyShadow.controller;

import com.google.code.kaptcha.Constants;
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

import static org.junit.Assert.*;

/**
 * 验证码测试
 * Created by RichardW on 9/15/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/spring-mvc.xml"})
public class KaptchaControllerTest {
    @Before
    public void setUp(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
        request.setCharacterEncoding("UTF-8");
        session = request.getSession();
    }
    private HttpSession session;
    private MockHttpServletResponse response;
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KaptchaController kaptchaController;
    @Test
    public void handleRequest() throws Exception {
        kaptchaController.handleRequest(session, response);
        logger.info((String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY));
    }
}