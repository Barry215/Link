package cn.SkyShadow.controller;

import cn.SkyShadow.base.SpringTest;
import cn.SkyShadow.enums.ResultMapper;
import org.junit.Test;


public class UserControllerTest extends SpringTest {
    private UserController userController = (UserController) applicationContext.getBean("userController");
    @Test
    public void Test1(){
        userController.sendEmailValidateCode("1277",getSession());
        System.out.print(ResultMapper.SUCCESS);
    }
    public static void main(String[] a){
        System.out.print(ResultMapper.SUCCESS);
    }
}