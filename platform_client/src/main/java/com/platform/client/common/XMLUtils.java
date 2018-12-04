package com.platform.client.common;

import com.platform.base.utils.BeanToMapUtil;
import com.platform.base.web.SpringHolder;
import com.platform.client.config.ConfigVo;
import com.platform.client.enums.ProjectEnum;
import com.platform.client.utils.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.*;
import org.dom4j.dom.DOMElement;
import org.dom4j.io.SAXReader;
import org.dom4j.xpath.DefaultXPath;

import java.beans.IntrospectionException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * Created by Administrator on 2016/11/9.
 * 处理xml
 */
public class XMLUtils {
    /**
     * @param inputStream
     * @return
     */
    public static Document getDocument(InputStream inputStream) {
        try {
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(inputStream);
            return document;
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 处理document
     *
     * @param document
     */
    public static void parse(Document document, Map map) {
        Element rootElement = document.getRootElement();
        parse(rootElement, map);
    }

    /***
     * 递归解析element
     * @param element
     */
    public static void parse(Element element, Map map) {
        ConfigVo vo = SpringHolder.getBean("configVo");
        String userId = (String) map.get("userId");
        String path = vo.getRootPath();
        String tagName = element.getName();
        if (tagName.contains("#")) {
            tagName.replace("#", ".");
        }
        String action = element.attributeValue("action");
        if ("create".equals(action) || StringUtils.isEmpty(action)) {
            path = path + File.separator + userId + File.separator + element.getUniquePath();
        } else {
            path = path + File.separator + userId + File.separator + element.getParent().getUniquePath();
        }

        if ("create".equals(action) || StringUtils.isEmpty(action)) {
            File file = FileUtils.createDir(path);
            System.out.println("文件夹-------：" + file.getAbsolutePath());
            List<Element> tempList = element.elements();
            if (tempList.size() > 0) {
                for (Element tempEle :
                        tempList) {
                    parse(tempEle, map);
                }
            }
        } else if ("copy".equals(action)) {
            String suffix = element.attributeValue("suffix");
            String target = element.attributeValue("target");
            if (target.endsWith(".ftl")) {
                String content = FTLUtils.getContent(target, map);
                ByteArrayInputStream inputStream = new ByteArrayInputStream(content.trim().getBytes());
                File file = FileUtils.copyFile(inputStream, path, tagName + "." + suffix);
                System.out.println("文件------------：" + file.getAbsolutePath());
            }
        }
    }

    /**
     * 根据元素名称获取元素
     *
     * @return
     */
    public static Element getElementBytagName(String tagName, String userId) {
        Document document = ProjectUtils.getProjectDocument(userId);
        return getElementBytagName(document, tagName);
    }

    /**
     * 根据节点名称获取element
     *
     * @param doc
     * @param tagName
     * @return
     */
    public static Element getElementBytagName(Document doc, String tagName) {
        Element root = doc.getRootElement();
        List<Element> tempList = root.elements(tagName);
        if (null != tempList && tempList.size() == 1) {
            return tempList.get(0);
        }
        return null;
    }

    /**
     * 根据元素id获取元素
     *
     * @param id
     * @return
     */
    public static Element getElementById(String id, String userId) {
        Document document = ProjectUtils.getProjectDocument(userId);
        return getElementById(document, id);
    }

    /**
     * 根据元素id获取元素
     *
     * @param doc
     * @return
     */
    public static Element getElementById(Document doc, String id) {
        Element root = doc.getRootElement();
        Element element = loopElement(root, id);
        return element;
    }

    /**
     * 遍历节点
     *
     * @param parent
     * @param idOrName
     * @return
     */
    public static Element loopElement(Element parent, String idOrName) {

        Element ele = null;

        List<Element> list = parent.elements();
        for (Element element :
                list) {
            String idValue = element.attributeValue("id");
            if (idOrName.equals(idValue) || idOrName.equals(element.getName())) {
                ele = element;
            }
            if (ele != null) {
                return ele;
            }
            ele = loopElement(element, idOrName);
            if (ele != null) {
                return ele;
            }
        }
        return ele;
    }

    /**
     * 通过id 或者元素名称获取element
     *
     * @param idOrName
     * @param userId
     * @return
     */
    public static Element getElement(String idOrName, String userId) {
        Element element = getElementBytagName(idOrName, userId);
        if (null == element) {
            element = getElementById(idOrName, userId);
        }
        return element;
    }

    /**
     * @param doc
     * @param idOrName
     * @return
     */
    public static Element getElement(Document doc, String idOrName) {
        Element element = getElementBytagName(doc, idOrName);
        if (null == element) {
            element = getElementById(doc, idOrName);
        }
        return element;
    }

    /**
     * 添加元素
     *
     * @param node
     * @param userId
     */
    public static void addElement(Node node, String userId) {
        //第一步，获取父节点
        Element parent = getElement(node.getParentNode(), userId);
        //第二步，根据类型创建节点
        String type = node.getType();
        String nodeName = node.getName();
        if (StringUtils.isEmpty(type) || "dir".equals(type)) {
            Element currentEle = parent.addElement(nodeName);
            currentEle.addAttribute("action", "added");
        } else if ("file".equals(type)) {
            String tag = nodeName.split("\\.")[0];
            String suffix = nodeName.split("\\.")[1];
            Element currentEle = parent.addElement(tag);
            currentEle.addAttribute("type", "file");
            currentEle.addAttribute("suffix", suffix);
            currentEle.addAttribute("action", "added");
        } else if ("package".equals(type)) {
            String[] tagArr = nodeName.split("\\.");
            createElement(parent, tagArr, 0);
        }

    }

    /**
     * 递归创建包
     *
     * @param parent
     * @param tagArr
     * @param num
     */
    private static Element createElement(Element parent, String[] tagArr, int num) {
        if (num >= tagArr.length) {
            return parent;
        }
        String tag = tagArr[num];
        Element currentEle = XMLUtils.loopElement(parent, tag);
        if (currentEle == null) {
            currentEle = parent.addElement(tag);
            currentEle.addAttribute("action", "added");
        } else {
            System.out.println("------------tag is not null");
        }
        ++num;
        return createElement(currentEle, tagArr, num);

    }

    /**
     * 获取node对象
     *
     * @param attributs
     * @return
     */
    public static Node getNode(List attributs) {
        try {
            if (attributs == null || attributs.size() <= 0) {
                return null;
            }
            Node node = new Node();
            Map<String, String> map = BeanToMapUtil.convertBean(node);
            for (Object attr :
                    attributs) {
                Attribute tempAttr = (Attribute) attr;
                String attrName = tempAttr.getName();
                String attrValue = tempAttr.getValue();
                if (map.containsKey(attrName)) {
                    map.put(attrName, attrValue);
                }
            }
            node = (Node) BeanToMapUtil.convertMap(Node.class, map);
            return node;
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 拼接document：
     * 1：执行ftl中的elements 元素
     * 2：将执行后的结果拼接到elements
     */
    public static void executeFtl(Node node, Document doc, Map map) {
        String userId = (String) map.get("userId");
        String path = ProjectUtils.getProjectPath(userId);
        Element parentElement = XMLUtils.getElement(doc, node.getParentNode());
        if (parentElement == null) {
            System.err.println("node.getParentNode--------" + node.getParentNode());
        }
        //根据节点type属性获取新节点
        Element child = XMLUtils.createElement(node, parentElement);
        String type = node.getType();
        String action = node.getAction();
        String suffix = node.getSuffix();
        if ("file".equals(type) || !suffix.isEmpty()) {
            File file = FileUtils.createFile(path + File.separator + child.getParent().getUniquePath());
            if ("create".equals(action)) {
                //TODO： 暂时不做处理，如果后续要单独创建文件
            } else if ("copy".equals(action)) {
                String target = node.getTarget();
                String filename = child.getName();
                if (target.endsWith(".ftl")) {
                    String content = FTLUtils.getContent(target, map);
                    ByteArrayInputStream inputstream = new ByteArrayInputStream(content.trim().getBytes());
                    FileUtils.copyFile(inputstream, file.getAbsolutePath(), filename + "." + suffix);
                } else {
                    InputStream inputStream = XMLUtils.class.getResourceAsStream(target);
                    FileUtils.copyFile(inputStream, file.getAbsolutePath(), filename + "." + suffix);
                }
            } else if ("merge".equals(type)) {

            }
        } else if ("dir".equals(type) || "package".equals(type)) {
            FileUtils.createDir(path + File.separator + child.getUniquePath());
        }
        //每添加一个节点写入到文件中去
        ByteArrayInputStream inputStream = new ByteArrayInputStream(doc.asXML().getBytes());
        FileUtils.copyFile(inputStream, path, userId + "_doc.xml");
    }

    /**
     * 根据node属性创建新节点（所有包都按照package类型以点号分隔）
     *
     * @param node
     * @return
     */
    private static Element createElement(Node node, Element parent) {
        String[] name = node.getName().split("\\.");
        Element child = XMLUtils.createElement(parent, name, 0);
        if (child == null) {
            System.err.println("创建子节点失败-----------");
        }
        //添加属性---为后续用到此元素的其他元素做准备
        if (child == null) {
            System.err.println("child is null----" + parent.getName() + "###");
        }
        try {
            Map<String, String> map = (Map<String, String>) BeanToMapUtil.convertBean(node);
            Set<String> keySet = map.keySet();
            for (String key :
                    keySet) {
                String value = map.get(key);
                if (StringUtils.isNotEmpty(value)) {
                    child.addAttribute(key, value);
                }
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return child;
    }

    /**
     * 根据parentNode 获取doc中的节点地址
     *
     * @param doc
     * @param node
     * @return
     */
    public static String getNodePath(Document doc, String node) throws Exception {
        Element element = XMLUtils.getElement(doc, node);
        if (element == null) {
            throw new Exception("---------------can't find node from doc by idOrName");
        } else {
            return element.getUniquePath();
        }
    }


}
