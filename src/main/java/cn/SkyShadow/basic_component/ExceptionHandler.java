package cn.SkyShadow.basic_component;

/**
 * 异常处理器
 * Created by RichardW on 9/15/2016.
 */
public interface ExceptionHandler {
    void setClass(Class clazz);
    void exceptionHandle(Exception e);
}
