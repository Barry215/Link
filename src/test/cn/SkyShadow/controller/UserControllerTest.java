package cn.SkyShadow.controller;

import cn.SkyShadow.base.SpringBase;
import cn.SkyShadow.enums.ResultMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Richard on 16/10/5.
 */
public class UserControllerTest extends SpringBase {
    private UserController userController = (UserController) applicationContext.getBean("userController");
    @Test
    public void Test1(){
        //userController.sendEmailValidateCode("1277",getSession());
        System.out.print(ResultMapper.SUCCESS);
    }
    public static void main(String[] a){
        System.out.print(ResultMapper.SUCCESS);
    }
}