package cn.SkyShadow.basic_component.Impl;

import cn.SkyShadow.basic_component.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 异常处理器
 * Created by RichardW on 9/15/2016.
 */
@Component
public class ExceptionHandlerImpl implements ExceptionHandler {
    private Logger logger;
    private Class controllerClass;

    @Override
    public void setClass(Class clazz) {
        this.controllerClass = clazz;
    }

    @Override
    public void ExceptionHandle(Exception e) {
        if (controllerClass==null){
            throw new NullPointerException("需要提前注入class");
        }
        logger = LoggerFactory.getLogger(controllerClass);
        logger.error(e.getMessage(), e);
    }
}
