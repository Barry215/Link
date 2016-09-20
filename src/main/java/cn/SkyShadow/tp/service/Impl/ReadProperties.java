package cn.SkyShadow.tp.service.Impl;

import cn.SkyShadow.basic_component.ExceptionHandller;
import cn.SkyShadow.tp.service.ReadConfigFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Properties读取器
 * Created by RichardW on 9/13/2016.
 */
@Component
public class ReadProperties implements ReadConfigFile {
    private Map<String, String> pros = new HashMap<>();

    @Override
    public void setPath(String path) throws Exception {
        Properties prop = new Properties();
        InputStream in = Object.class.getResourceAsStream(path);
        BufferedReader bf = new BufferedReader(new InputStreamReader(in, "utf-8"));
        prop.load(bf);
        Enumeration enumeration = prop.propertyNames();
        while (enumeration.hasMoreElements()) {
            String key = (String) enumeration.nextElement();
            String value = prop.getProperty(key);
            pros.put(key, value);
        }
        bf.close();
        in.close();
    }

    @Override
    public Object getValue(String key) {
        return pros.get(key);
    }
}
