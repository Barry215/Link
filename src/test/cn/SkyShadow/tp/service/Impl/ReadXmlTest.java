package cn.SkyShadow.tp.service.Impl;

import cn.SkyShadow.base.SpringBase;
import cn.SkyShadow.tp.service.ReadConfigFile;
import org.junit.Test;
import org.w3c.dom.Node;

import static org.junit.Assert.*;

/**
 * 读取测试
 * Created by Richard on 16/9/20.
 */
public class ReadXmlTest extends SpringBase{
    @Test
    public void Test() throws Exception {
        ReadConfigFile readConfigFile = new ReadXml();
        readConfigFile.setPath("/resultConfig/result.xml");
        Node n = (Node) readConfigFile.getValue("SUCCESS");
    }
}