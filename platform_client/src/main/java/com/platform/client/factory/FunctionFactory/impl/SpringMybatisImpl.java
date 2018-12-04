package com.platform.client.factory.FunctionFactory.impl;

import com.platform.client.factory.FunctionFactory.BaseFunction;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2016/11/2.
 */
@Service("springMybatisFunction")
public class SpringMybatisImpl extends BaseFunction {

    @Override
    protected void parseJAVA(Element element) {
        //获取javapath
        String javaPath = this.functionVo.getJavaPath();
        List<Element> list = element.elements();
        this.copyFile(javaPath,list);
    }

    @Override
    protected void parseSELF(Element element) {
        //获取selfPath
        String selfPath = this.functionVo.getSelfPath();
        List<Element> list = element.elements();
        this.copyFile(selfPath,list);
    }
}
