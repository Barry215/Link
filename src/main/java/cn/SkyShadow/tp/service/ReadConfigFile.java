package cn.SkyShadow.tp.service;

/**
 * 读取Properties
 * Created by RichardW on 9/13/2016.
 */

public interface ReadConfigFile {
    void setPath(String path) throws Exception;
    Object getValue(String key) throws Exception;
}
