package cn.SkyShadow.tp.service.Impl;

import cn.SkyShadow.tp.service.ReadProperties;
import org.springframework.stereotype.Service;

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
@Service
public class ReadPropertiesImpl implements ReadProperties {
    private Map<String,String> pros = new HashMap<>();
    private String filePath;
    @Override
    public void setPath(String path) {
        this.filePath = path;
        Properties prop = new Properties();
        InputStream in = Object.class.getResourceAsStream(filePath);
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

    @Override
    public String getValue(String key) {
        return pros.get(key);
    }
}
