package cn.SkyShadow.factory;

import cn.SkyShadow.dto.json.JsonResult;
import cn.SkyShadow.enums.ResultMapper;

/**
 * Json结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class JsonResultFactory {
    public static JsonResult CreateJsonResult_True(ResultMapper resultMapper) {
        return new JsonResult<>(true,ExecutionFactory.getExecution(resultMapper),null);
    }
    public static JsonResult CreateJsonResult_True(Object object){
        return new JsonResult<>(true,object,null);
    }
    public static JsonResult CreateJsonResult_False(Exception e) {
        return new JsonResult(false,e.getMessage());
    }
}
