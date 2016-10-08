package cn.SkyShadow.dao;

import cn.SkyShadow.base.SpringTest;
import org.junit.Test;

public class UserSchoolMapperTest extends SpringTest {
    private UserSchoolMapper userSchoolMapper = (UserSchoolMapper) applicationContext.getBean("userSchoolMapper");
    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(userSchoolMapper.selectByPrimaryKey(10L));
    }

}