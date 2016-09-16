package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.excution.Excution;

/**
 * Excution工厂
 * Created by RichardW on 9/14/2016.
 */
public class ExcutionFactory {
    public static Excution GetExcutionByResultCode(int resultCode){
        return new Excution(resultCode,"操作已执行");
    }
    public static Excution GetExcutionByResultCode(int resultCode,String info){
        return new Excution(resultCode,info);
    }
    public static Excution GetExcutionByResultCode(int resultCode,String info,Object obj){
        return new Excution(resultCode,info,obj);
    }
}
