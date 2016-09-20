package cn.SkyShadow.basic_component;

/**
 * 异常处理器
 * Created by RichardW on 9/15/2016.
 */
public interface ExceptionHandller {
    void setClass(Class clazz);
    void ExceptionHandle(Exception e);
}
