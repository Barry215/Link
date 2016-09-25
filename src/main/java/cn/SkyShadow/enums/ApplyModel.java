package cn.SkyShadow.enums;

/**
 * 请求模式
 * Created by RichardW on 9/25/2016.
 */
public enum ApplyModel {
    APPLY_MODEL(),
    DIRECT();
    public static ApplyModel getApplyModel(String str){
        if (str.toUpperCase().equals("APPLY")){
            return APPLY_MODEL;
        }else{
            return DIRECT;
        }
    }
}
