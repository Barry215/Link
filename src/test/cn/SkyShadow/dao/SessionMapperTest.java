package cn.SkyShadow.dao;

import cn.SkyShadow.base.SpringTest;
import cn.SkyShadow.model.Session;
import org.junit.Test;

import java.util.Date;


public class SessionMapperTest extends SpringTest{
    private SessionMapper sessionMapper =
            (SessionMapper) applicationContext.getBean("sessionMapper");
    private UserGroupMapper userGroupMapper =
            (UserGroupMapper) applicationContext.getBean("userGroupMapper");
    @Test
    public void insert() throws Exception {
        Session session = new Session();
        Date date = new Date();
        session.setEndTime(date);
        session.setUserGroupId(userGroupMapper.selectUserGroup(12L));
        sessionMapper.insert(session);
    }

}