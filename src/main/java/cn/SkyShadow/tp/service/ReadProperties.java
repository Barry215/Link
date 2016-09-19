package cn.SkyShadow.tp.service;

/**
 * 读取Properties
 * Created by RichardW on 9/13/2016.
 */

public interface ReadProperties {
    void setPath(String path);
    String getValue(String key);
}
