package study.spring.utils;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;

import study.spring.BeanFactory;
import study.spring.cfg.BeanConfig;
import study.spring.cfg.PropertyConfig;
import study.spring.xml.XMLUtils;

/**
 * This class help BeanFactory to parse XML file and get <code>BeanConfig</code>
 * @author Administrator
 * 2017年2月5日
 */
public class BeanFactoryUtils {

    /**
     * This method loads XML file,then put <bean> label attributes into <code>BeanConfig</code>
     * and put <property> label attributes into <code>PropertyConfig</code>
     * then #{BeanConfig.addPropertyConfig(PropertyConfig);}
     * 
     * @param factory The <code>BeanFactory</code> store <code>BeanConfig</code>
     * @param xmlName The name of XML file need to parse
     */
    public static void load(BeanFactory factory,String xmlName){
        Document doc = XMLUtils.getDocument(xmlName);
        @SuppressWarnings("unchecked")
        //get bean label
        List<Element> beanEleList = doc.selectNodes("//bean");
        for(Element beanEle:beanEleList){
            //transform bean label into BeanConfig
            BeanConfig bc = XMLUtils.toBean(beanEle, BeanConfig.class);
            @SuppressWarnings("unchecked")
            List<Element> propEleList = beanEle.elements();
            for(Element propEle:propEleList){
                //transform property label into BeanConfig
                PropertyConfig pc = XMLUtils.toBean(propEle, PropertyConfig.class);
                bc.addPropertyConfig(pc);
            }
            factory.addBeanConfig(bc);
        }
    }
}
