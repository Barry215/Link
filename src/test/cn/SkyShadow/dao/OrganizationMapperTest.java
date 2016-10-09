package cn.SkyShadow.dao;


import cn.SkyShadow.base.SpringTest;
import org.junit.Test;

public class OrganizationMapperTest extends SpringTest {
    private OrganizationMapper organizationMapper =
            (OrganizationMapper) applicationContext.getBean("organizationMapper");
    @Test
    public void Test1(){
        System.out.println(organizationMapper.selectByPrimaryKey(3L));
    }

}