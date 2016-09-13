package cn.SkyShadow.tp.service.Impl;

import cn.SkyShadow.tp.service.ReadProperties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Properties读取器
 * Created by RichardW on 9/13/2016.
 */
public class ReadPropertiesImpl implements ReadProperties {
    private Map<String,String> pros = new HashMap<>();
    @Override
    public String GetValue(String key) {
        return pros.get(key);
    }

    ReadPropertiesImpl() {
        Properties prop = new Properties();
        InputStream in = Object.class.getResourceAsStream("/Apply/apply.properties");
        try {
            prop.load(in);
            Enumeration enumeration = prop.propertyNames();
            while (enumeration.hasMoreElements()){
                String key = (String) enumeration.nextElement();
                String value = prop.getProperty(key);
                pros.put(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
