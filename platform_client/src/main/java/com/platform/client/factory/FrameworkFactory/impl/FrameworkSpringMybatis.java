package com.platform.client.factory.FrameworkFactory.impl;

import com.platform.client.factory.FrameworkFactory.Framework;
import com.platform.client.vo.FrameworkVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/28.
 * 添加Spring Mybatis框架
 */
@Service("springMybatis")
public class FrameworkSpringMybatis implements Framework{

    @Resource(name = "spring")
    Framework spring;
    @Resource(name="mybatis")
    Framework mybatis;
    @Override
    public void add(FrameworkVo vo) {
        //第一步：添加spring框架
        spring.add(vo);
        //第二步：添加spring mybatis框架
        mybatis.add(vo);
    }
}
