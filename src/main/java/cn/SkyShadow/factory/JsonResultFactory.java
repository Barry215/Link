package cn.SkyShadow.factory;

import cn.SkyShadow.dto.json.JsonResult;

/**
 * Json结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class JsonResultFactory {
    public static JsonResult CreateJsonResult_True(Object o) {

        return new JsonResult<>(true,o.getClass().cast(o),null);
    }

    public static JsonResult CreateJsonResult_False(Exception e) {
        return (JsonResult<?>) new JsonResult(false,e.getMessage());
    }
}
