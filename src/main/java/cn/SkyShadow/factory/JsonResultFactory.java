package cn.SkyShadow.factory;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.dto.json.JsonResult;
import cn.SkyShadow.enums.ResultMapper;

/**
 * Json结果工厂
 * Created by RichardW on 9/14/2016.
 */
public class JsonResultFactory {
    public static JsonResult<BaseExecution> CreateJsonResult_True(BaseExecution o) {
        return new JsonResult<>(true,o,null);
    }

    public static JsonResult CreateJsonResult_False(Exception e) {
        return new JsonResult(false,e.getMessage());
    }
    public static JsonResult<BaseExecution> CreateJsonResult_True(ResultMapper resultMapper) {
        return new JsonResult<>(true,ExecutionFactory.getExecution(resultMapper),null);
    }
    public static JsonResult CreateJsonResult_True(Object o){
        System.out.println("请立刻检查，本方法应该被删除");
        return null;
    }
}
