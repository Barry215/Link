package cn.SkyShadow.dao;

import cn.SkyShadow.base.SpringTest;
import cn.SkyShadow.model.Occupation;
import cn.SkyShadow.model.Organization;
import org.junit.Test;


public class OccupationMapperTest extends SpringTest {
    private OccupationMapper occupationMapper =
            (OccupationMapper) applicationContext.getBean("occupationMapper");
    @Test
    public void insert() throws Exception {
        Organization organization = new Organization();
        organization.setOrgId(4L);
        Occupation o = new Occupation();
        o.setOrganization(organization);
        o.setRank("MANAGER");
        o.setName("馆长");
        System.out.println(occupationMapper.insert(o));
    }
    @Test
    public void insert1(){
        System.out.println(occupationMapper.selectByPrimaryKey(3L));
    }


}