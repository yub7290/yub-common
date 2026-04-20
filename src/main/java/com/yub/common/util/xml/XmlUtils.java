package com.yub.common.util.xml;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringReader;
import java.io.StringWriter;

/**
 * @Author: bing.yu
 * @CreateTime: 2026-04-20
 * @Description: XML 工具类
 * @Version: 1.0.0
 */
public final class XmlUtils {

    /** 私有构造器，禁止实例化 */
    private XmlUtils() {
        throw new UnsupportedOperationException("This class cannot be instantiated");
    }

    private static final ThreadLocal<DocumentBuilder> BUILDER_HOLDER = ThreadLocal.withInitial(() -> {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
            factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
            factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
            return factory.newDocumentBuilder();
        } catch (Exception e) {
            throw new RuntimeException("Failed to create DocumentBuilder", e);
        }
    });

    /**
     * 解析 XML 字符串为 Document
     *
     * @param xml XML 字符串
     * @return Document
     */
    public static Document parse(String xml) {
        if (xml == null || xml.isEmpty()) {
            return null;
        }
        try {
            InputSource inputSource = new InputSource(new StringReader(xml));
            return BUILDER_HOLDER.get().parse(inputSource);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse XML", e);
        }
    }

    /**
     * Document 转 XML 字符串
     *
     * @param document Document
     * @return XML 字符串
     */
    public static String toXml(Document document) {
        if (document == null) {
            return null;
        }
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(document), new StreamResult(writer));
            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException("Failed to transform Document to XML", e);
        }
    }

    /**
     * 判断是否为有效 XML
     *
     * @param xml XML 字符串
     * @return 是否有效
     */
    public static boolean isValid(String xml) {
        if (xml == null || xml.isEmpty()) {
            return false;
        }
        try {
            parse(xml);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
