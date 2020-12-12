package com.apple.developer.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/*
 * 将系统中可能用到对象注册到内存中，需要的时候直接从内存取出来即可，不需要每次都new
 */
public class ObjectFactory {
    private final static Map<String, Object> OBJECT_MAP = new HashMap<String, Object>();

    static {
        //字节流
        InputStream is = ObjectFactory.class.getClassLoader().getResourceAsStream("beans.xml");
        SAXReader saxReader = new SAXReader();
        try {
            Document doc = saxReader.read(is);
            Element rootElement = doc.getRootElement();
            List<Element> children = rootElement.elements("bean");
            for (Element beanEl : children) {
                String id = beanEl.attributeValue("id");
                String className = beanEl.attributeValue("className");
                //创建className所代表的类的对象
                Object obj = Class.forName(className).newInstance();
                List<Element> properties = beanEl.elements("property");
                if (properties != null && properties.size() > 0) {
                    Iterator<Element> iter = properties.iterator();
                    while (iter.hasNext()) {
                        Element propElement = iter.next();
                        String propertyName = propElement.attributeValue("name");
                        String ref = propElement.attributeValue("ref");
                        //得到set方法的名字
                        String setMethodName = "set" + propertyName.substring(0, 1).toUpperCase() + propertyName.substring(1);
                        Method setMethod = obj.getClass().getDeclaredMethod(setMethodName, OBJECT_MAP.get(ref).getClass().getInterfaces()[0]);
                        //调用set方法
                        setMethod.invoke(obj, OBJECT_MAP.get(ref));
                    }
                }
                OBJECT_MAP.put(id, obj);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /*
     * 提供外部可以拿值的方法。
     * */
    public static Object getObject(String key) {
        return OBJECT_MAP.get(key);
    }
}
