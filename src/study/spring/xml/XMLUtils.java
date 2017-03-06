package study.spring.xml;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * This class is to parse XML file
 * 
 * @author Administrator 2017年2月5日
 */
public class XMLUtils {
    
    
    /**
     * This method will transform a <code>Element</code> into a JavaBean 
     * @param e The <code>Element</code> to provide data
     * @param clazz The type of JavaBean
     * @return a new JavaBean
     */
    public static <T> T toBean(Element e,Class<T> clazz){
        Map<String, String> map = toMap(e);
        T bean = null;
        try {
            bean = clazz.newInstance();
            BeanUtils.populate(bean, map);
        } catch (Exception ex) {
            throw new RuntimeException("class:"+clazz.getName()+"newinstance fail");
        }
        return bean;
    }

    /**
     * This method is to put <code>Element</code> attribute and sub elements' text into a Map. The name of
     * attributes or elements as key, the value of the attributes or elements' text as value
     * 
     * @param e The <code>Element</code> need to transform <code>Map</code>
     * @return The new <code>Map</code>
     */
    public static Map<String, String> toMap(Element e) {
        Map<String, String> map = new LinkedHashMap<String, String>();
        // put element attribute into map
        @SuppressWarnings("unchecked")
        List<Attribute> attrs = e.attributes();
        for (Attribute attr : attrs) {
            map.put(attr.getName(), attr.getValue());
        }

        
        //put Element's text into map
        @SuppressWarnings("unchecked")
        List<Element> eles = e.elements();
        for (Element ele : eles) {
            if(ele.isTextOnly())
            map.put(ele.getName(), ele.getText());
        }

        return map;
    }

    /**
     * This method is to parse XML file
     * 
     * @param xmlName The XML name needed to parse
     * @return The <code>Document</code> contains XML file
     */
    public static Document getDocument(String xmlName) {
        return getDocument(xmlName, true);
    }

    /**
     * 
     * @param xmlName The name of XML file
     * @param relative The relative of XML and currentThread
     * @return The <code>Document</code> parse by SAXReader
     */
    public static Document getDocument(String xmlName, boolean relative) {
        try {
            xmlName = Thread.currentThread().getContextClassLoader().getResource(xmlName).getPath();
            return new SAXReader().read(xmlName);
        } catch (DocumentException e) {
            throw new RuntimeException("SAXReader parse " + xmlName + " fail" + e.getMessage());
        }
    }

}
