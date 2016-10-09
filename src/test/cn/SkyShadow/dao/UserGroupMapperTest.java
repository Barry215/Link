package cn.SkyShadow.dao;

import cn.SkyShadow.base.SpringTest;
import org.junit.Test;

public class UserGroupMapperTest extends SpringTest{
    private UserGroupMapper userGroupMapper=
            (UserGroupMapper) applicationContext.getBean("userGroupMapper");
    @Test
    public void selectUserGroup() throws Exception {
        System.out.println(userGroupMapper.selectUserGroup(12L));
    }

}