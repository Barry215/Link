package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.JsonResult;
import cn.SkyShadow.dto.tp.PhoneValidateResult;
import cn.SkyShadow.service.JsonResultFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Json结果工厂
 * Created by Richard on 16/9/13.
 */
@Transactional
@Service
public class JsonResultFactoryImpl implements JsonResultFactory {
    @Override
    public JsonResult CreateJsonResult_True(Object o) {

        JsonResult<?> jsonResult = new JsonResult<>(true,o.getClass().cast(o),null);
        return  jsonResult;
    }

    @Override
    public JsonResult CreateJsonResult_False(Exception e) {
        JsonResult<?> jsonResult = new JsonResult(false,e.getMessage());
        return  jsonResult;
    }
}
