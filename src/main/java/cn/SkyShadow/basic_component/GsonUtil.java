package cn.SkyShadow.basic_component;

import com.google.gson.Gson;

/**
 * Json转换器
 * Created by Richard on 16/10/5.
 */
public class GsonUtil {
    private static Gson gson = new Gson();
    public static String toJson(Object object){
        return gson.toJson(object);
    }
}
