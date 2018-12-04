package com.platform.client.factory.FrameworkFactory.impl;

import com.platform.client.common.Resources;
import com.platform.client.enums.FunctionEnum;
import com.platform.client.factory.FrameworkFactory.Framework;
import com.platform.client.factory.FunctionFactory.FunctionFactory;
import com.platform.client.vo.FrameworkVo;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

/**
 * Created by Administrator on 2016/10/28.
 * 只添加spring框架
 */
@Service("spring")
public class FrameworkSpring implements Framework {
    @Autowired
    FunctionFactory factory;
    @Override
    public void add(FrameworkVo vo) {
        try {
            vo.setSelfPath(vo.getPath()+ File.separator+Resources.PRO_MAIN);
            factory.getService(FunctionEnum.springMVC.code).setVo(vo);
            factory.getService(FunctionEnum.springMVC.code).parse(FunctionEnum.springMVC.configUrl);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
