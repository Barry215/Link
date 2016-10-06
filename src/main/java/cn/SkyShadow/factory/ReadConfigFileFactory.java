package cn.SkyShadow.factory;

import cn.SkyShadow.tp.service.Impl.ReadProperties;
import cn.SkyShadow.tp.service.Impl.ReadXml;
import cn.SkyShadow.tp.service.ReadConfigFile;

/**
 * 读取工具工厂
 * Created by RichardW on 10/5/2016.
 */
public class ReadConfigFileFactory {
    private static ReadConfigFile readProperties = new ReadProperties();
    private static ReadConfigFile readXml = new ReadXml();
    public static ReadConfigFile getReadXmlTools(){
        return readXml;
    }
    public static ReadConfigFile getReadPropertiesTools(){
        return readProperties;
    }
}
