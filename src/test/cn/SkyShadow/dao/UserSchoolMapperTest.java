package cn.SkyShadow.dao;

import cn.SkyShadow.base.SpringBase;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserSchoolMapperTest extends SpringBase{
    private UserSchoolMapper userSchoolMapper = (UserSchoolMapper) applicationContext.getBean("userSchoolMapper");
    @Test
    public void selectByPrimaryKey() throws Exception {
        System.out.println(userSchoolMapper.selectByPrimaryKey(10L));
    }

}