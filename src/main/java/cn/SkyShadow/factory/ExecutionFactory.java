package cn.SkyShadow.factory;

import cn.SkyShadow.dto.execution.BaseExecution;
import cn.SkyShadow.enums.ResultMapper;

/**
 * Excution工厂
 * Created by RichardW on 9/14/2016.
 */
public class ExecutionFactory {
    public static BaseExecution GetExcutionByResultCode(int resultCode){
        return new BaseExecution(resultCode,"操作已执行");
    }
    public static BaseExecution GetExcutionByResultCode(int resultCode, String info){
        return new BaseExecution(resultCode,info);
    }
    public static BaseExecution getExecution_True(ResultMapper ResultMapper, Object o){
        return new BaseExecution(true,ResultMapper.getCode(),ResultMapper.getInfo(),o);
    }
    public static BaseExecution getExecution_True(ResultMapper ResultMapper){
        return new BaseExecution(ResultMapper.getCode(),ResultMapper.getInfo(),false);
    }

}
