package cn.SkyShadow.dao;


import cn.SkyShadow.base.SpringTest;
import org.junit.Test;

public class MailboxMapperTest extends SpringTest {
    private MailboxMapper mailboxMapper =
            (MailboxMapper) applicationContext.getBean("mailboxMapper");
    @Test
    public void Test(){
        System.out.println(mailboxMapper.selectByPrimaryKey(1L));
    }

}