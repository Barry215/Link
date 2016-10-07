package cn.SkyShadow.tp.service.Impl;

import cn.SkyShadow.tp.service.ReadConfigFile;
import org.springframework.stereotype.Component;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 读取xml
 * Created by Richard on 16/9/20.
 */
@Component
public class ReadXml implements ReadConfigFile {
    private InputStream in;
    private Document document;

    @Override
    public void setPath(String path) throws Exception {
        in = Object.class.getResourceAsStream(path);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        document = db.parse(in);
    }

    @Override
    public Object getValue(String key) throws Exception {
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getElementsByTagName("result");
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            NodeList childNode = node.getChildNodes();
            for (int j = 0;j<childNode.getLength();j++){
                Node node1 = childNode.item(j);
                if (node1.getNodeType()==Node.ELEMENT_NODE){
                    if (node1.getFirstChild().getNodeValue().equals(key)){
                        return node;
                    }
                }
            }
        }
        throw new NullPointerException("没有对应的值"+key);
    }
}
