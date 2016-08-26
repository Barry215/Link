package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.userMapper;
import cn.SkyShadow.model.user;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * Created by RichardW on 8/26/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/spring-dao.xml","classpath:config/spring-service.xml","classpath:config/spring-mvc.xml"})
public class PublicServiceImplTest {
    @Autowired
    private userMapper uMapper;
    @Autowired
    private cn.SkyShadow.dao.cityMapper cityMapper;
    @Autowired
    private cn.SkyShadow.dao.countryMapper countryMapper;
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void hasPhone() throws Exception {
        logger.info("测试hasPhone:"+uMapper.HasPhone("123456"));
        logger.info("测试hasPhone:"+uMapper.HasPhone("18100174605"));
        logger.info("测试hasPhone:"+uMapper.HasPhone("18100174520"));
    }

    @Test
    public void hasUsername() throws Exception {
        logger.info("测试hasUsername:"+uMapper.HasUserName("123456"));
        logger.info("测试hasUsername:"+uMapper.HasUserName("Richard"));
        logger.info("测试hasUsername:"+uMapper.HasUserName("CCCCCC"));
    }

    @Test
    public void hasEmail() throws Exception {
        logger.info("测试hasEmail:"+uMapper.HasEmail("123456"));
        logger.info("测试hasEmail:"+uMapper.HasEmail("18100174605@qq.com"));
        logger.info("测试hasEmail:"+uMapper.HasEmail("1277287015@qq.com"));
    }

    @Test
    public void getCountries() throws Exception {
        logger.info("测试国家列表:"+countryMapper.select());
    }

    @Test
    public void get_ZH_Cities() throws Exception {
        logger.info("测试城市列表:"+cityMapper.select_zh());
    }

    @Test
    public void getPasswordProtectByLoginName() throws Exception {
        user u = uMapper.selectBaseInfoByLoginName("123");
        if (u!=null) {
            logger.info("测试获取密保:" + uMapper.getPasswordProtect(u.getUserId()));
        }
        u = uMapper.selectBaseInfoByLoginName("Richard");
        if (u!=null) {
            logger.info("测试获取密保:" + uMapper.getPasswordProtect(u.getUserId()));
        }
    }

}