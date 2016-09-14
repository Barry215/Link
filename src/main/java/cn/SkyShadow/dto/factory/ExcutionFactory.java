package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.excution.Excution;

/**
 * Excution工厂
 * Created by RichardW on 9/14/2016.
 */
public class ExcutionFactory {
    public static Excution GetExcutionByResultCode(int resultCode){
        return  ExcutionFactory.GetExcutionByResultCode(resultCode);
    }
    public static Excution GetExcutionByResultCode(int resultCode,String info){
        return  ExcutionFactory.GetExcutionByResultCode(resultCode,info);
    }
}
