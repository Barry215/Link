package cn.SkyShadow.factory;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dto.json.JsonResult;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.enums.ResultMapper;

import java.util.List;

/**
 * Json结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class JsonResultFactory {
    public static JsonResult CreateJsonResult_True(ResultMapper resultMapper) {
        return new JsonResult<>(true,ExecutionFactory.getExecution(resultMapper),null);
    }
    public static JsonResult CreateJsonResult_True(BaseExecution baseExecution) {
        return new JsonResult<>(true,baseExecution,null);
    }
    public static JsonResult CreateJsonResult_True(String object){
        return new JsonResult<>(true,object,null);
    }
    public static JsonResult CreateJsonResult_True(List object){
        return new JsonResult<>(true,object,null);
    }
    public static JsonResult CreateJsonResult_True(PasswordProtected object){
        return new JsonResult<>(true,object,null);
    }
    public static JsonResult CreateJsonResult_False(Exception e) {
        return new JsonResult(false,e.getMessage());
    }
}
