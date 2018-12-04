package com.platform.client.web;

import com.platform.base.utils.BeanToMapUtil;
import com.platform.client.common.FTLUtils;
import com.platform.client.common.Node;
import com.platform.client.common.ProjectUtils;
import com.platform.client.common.XMLUtils;
import com.platform.client.enums.ProjectEnum;
import com.platform.client.vo.CommonFrameWorkVo;

import org.dom4j.Document;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.beans.IntrospectionException;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;


/**
 * Created by Administrator on 2016/11/9.
 */
@Controller
@RequestMapping("/platform")
public class NewController {

    /***
     * 创建spring mybatis
     * @return
     */
    @RequestMapping("/newMakeProject")
    public String makeProject(CommonFrameWorkVo vo){
        try {
            Map map = BeanToMapUtil.convertBean(vo);
            File userFile = ProjectUtils.makeProject(map);
            Document userDoc = XMLUtils.getDocument(new FileInputStream(userFile));
            String projectFrameworkName = vo.getFrameworkType();
            String ftlUrl = ProjectEnum.getUrl(projectFrameworkName);
            //第一步解析成正常文件
            String content = FTLUtils.getContent(ftlUrl,map);
            //第二步转换成document
            ByteArrayInputStream inputStream = new ByteArrayInputStream(content.trim().getBytes());
            Document document = XMLUtils.getDocument(inputStream);
            //解析document，在userDoc中添加数据
            Element rootElement = document.getRootElement();
            List<Element> list = rootElement.elements();
            for (Element childEle:
                 list) {
              List attrList = childEle.attributes();
                Node node = XMLUtils.getNode(attrList);
                XMLUtils.executeFtl(node,document,map);
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
