package cn.SkyShadow.service;

import cn.SkyShadow.dto.JsonResult;

/**
 * Json结果工厂
 * Created by Richard on 16/9/13.
 */
public interface JsonResultFactory {
    JsonResult CreateJsonResult_True(Object o);
    JsonResult CreateJsonResult_False(Exception e);
}
