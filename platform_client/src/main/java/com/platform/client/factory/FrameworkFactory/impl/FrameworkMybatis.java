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
 * 只添加Mybatis框架
 */
@Service("mybatis")
public class FrameworkMybatis implements Framework {

    @Autowired
    FunctionFactory factory;

    @Override
    public void add(FrameworkVo vo) {
        /**
         * 初步设想：mybatis的功能添加有3中情况
         * 1:没有web框架的情况
         * 2:web框架为spring的时候
         * 3:web框架为structs2的时候
         */
        if(vo.getWebFrameworkType()==0){
            //没有web框架

        }else if(vo.getWebFrameworkType()==1){
            //spring 框架
            try {
                vo.setSelfPath(vo.getPath()+ File.separator+ Resources.PRO_MAIN);
                factory.getService(FunctionEnum.springMybatis.code).setVo(vo);
                factory.getService(FunctionEnum.springMybatis.code).parse(FunctionEnum.springMybatis.configUrl);
            } catch (DocumentException e) {
                e.printStackTrace();
            }

        }else if(vo.getWebFrameworkType()==2){
            //structs2 框架
        }
    }
}
