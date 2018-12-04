package com.platform.client.factory.FunctionFactory.impl;

import com.platform.client.factory.FunctionFactory.BaseFunction;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/6.
 */
@Service(value="springDatabaseFunction")
public class SpringDataBaseImpl extends BaseFunction{


    @Override
    protected void parseJAVA(Element element) {

    }

    @Override
    protected void parseSELF(Element element) {

    }
}
