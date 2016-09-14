package cn.SkyShadow.dto.factory;

import cn.SkyShadow.dto.JsonResult;

/**
 * Json结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class JsonResultFactory {
    public static JsonResult CreateJsonResult_True(Object o) {

        JsonResult<?> jsonResult = new JsonResult<>(true,o.getClass().cast(o),null);
        return  jsonResult;
    }

    public static JsonResult CreateJsonResult_False(Exception e) {
        JsonResult<?> jsonResult = new JsonResult(false,e.getMessage());
        return  jsonResult;
    }
}
