package cn.SkyShadow.basic_component.Impl;

import cn.SkyShadow.basic_component.ExceptionHandller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AJAX前端处理器
 * Created by RichardW on 9/15/2016.
 */
public class AjaxCommonComponent implements ExceptionHandller{
    private Logger logger;
    private Class controllerClass;

    public AjaxCommonComponent(Class controllerClass) {
        this.controllerClass = controllerClass;
    }

    @Override
    public void ExceptionHandle(Exception e) {
        logger = LoggerFactory.getLogger(controllerClass);
        logger.error(e.getMessage(), e);
    }
}
