package cn.SkyShadow.tp.service.Impl;

import cn.SkyShadow.tp.service.ReadConfigFile;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
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

    @Override
    public void setPath(String path) {
        in = Object.class.getResourceAsStream(path);
    }

    @Override
    public Object getValue(String key) throws Exception {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(in, "utf-8"));
        Document document = db.parse(in);
        Element element = document.getDocumentElement();
        NodeList nodeList = element.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node;
            node = nodeList.item(i);
            System.out.println(i+"node"+node);
            if (node!=null&&node.getNodeValue().equals("result")) {
                return node;
            }
        }
        throw new NullPointerException("没有对应的值");
    }
}
