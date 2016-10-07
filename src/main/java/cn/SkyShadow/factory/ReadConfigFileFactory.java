package cn.SkyShadow.factory;

import cn.SkyShadow.tp.service.Impl.ReadProperties;
import cn.SkyShadow.tp.service.Impl.ReadXml;
import cn.SkyShadow.tp.service.ReadConfigFile;

import java.util.HashMap;
import java.util.Map;

/**
 * 读取工具工厂
 * Created by RichardW on 10/5/2016.
 */
public class ReadConfigFileFactory {
    private static Map<String,ReadConfigFile> readConfigFileMap = new HashMap<>();
    public static ReadConfigFile getReadXmlTools(String path){
        if (readConfigFileMap.containsKey(path)){
            return readConfigFileMap.get(path);
        }else {
            ReadConfigFile readConfigFile = new ReadXml();
            try {
                readConfigFile.setPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
            readConfigFileMap.put(path,readConfigFile);
            return readConfigFileMap.get(path);
        }
    }
    public static ReadConfigFile getReadPropertiesTools(String path){
        if (readConfigFileMap.containsKey(path)){
            return readConfigFileMap.get(path);
        }else {
            ReadConfigFile readConfigFile = new ReadProperties();
            try {
                readConfigFile.setPath(path);
            } catch (Exception e) {
                e.printStackTrace();
            }
            readConfigFileMap.put(path,readConfigFile);
            return readConfigFileMap.get(path);
        }
    }
}
