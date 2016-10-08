package cn.SkyShadow.dao;


import cn.SkyShadow.base.SpringTest;
import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;
import cn.SkyShadow.model.apply.Receipt;
import cn.SkyShadow.model.apply.applyChildren.ModifyOrganization;
import org.junit.Test;

public class ReceiptMapperTest extends SpringTest{
    private ApplyMapper applyMapper
            = (ApplyMapper) applicationContext.getBean("applyMapper");
    private OrganizationMapper organizationMapper
            = (OrganizationMapper) applicationContext.getBean("organizationMapper");
    private ReceiptMapper receiptMapper =
            (ReceiptMapper) applicationContext.getBean("receiptMapper");
    @Test
    public void apply(){
        Organization o = organizationMapper.selectByPrimaryKey(3L);
        o.setName("yes!!!");
        User u = new User("","");
        u.setUserId(12L);
        ModifyOrganization modifyOrganization = new ModifyOrganization();
        modifyOrganization.setOrganization(o);
        modifyOrganization.setUser(u);
        organizationMapper.insertTemp(o);
        applyMapper.createModifyOrganization(modifyOrganization);
    }
    @Test
    public void apply1(){
        System.out.println(applyMapper.getModifyOrganization(3L));
    }
    @Test
    public void receipt(){
        Receipt<ModifyOrganization> receipt = new Receipt<>();
        User u = new User("","");
        u.setUserId(13L);
        receipt.setUser(u);
        receipt.setAgree("Y");
        receipt.setApply(applyMapper.getModifyOrganization(3L));
        receiptMapper.create(receipt);
    }
    @Test
    public void receipt1(){
        System.out.println(receiptMapper.getModifyOrganization(1L));
    }

}