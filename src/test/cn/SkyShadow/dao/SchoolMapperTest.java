package cn.SkyShadow.dao;


import cn.SkyShadow.base.SpringBase;
import org.junit.Test;

public class SchoolMapperTest extends SpringBase{
    private LocationMapper locationMapper =
            (LocationMapper) applicationContext.getBean("locationMapper");
    private SchoolMapper schoolMapper =
            (SchoolMapper) applicationContext.getBean("schoolMapper");
    @Test
    public void Test(){
        System.out.println(schoolMapper.selectByPrimaryKey(2554L));
    }

}