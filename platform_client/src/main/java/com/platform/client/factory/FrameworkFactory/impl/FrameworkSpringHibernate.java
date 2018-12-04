package com.platform.client.factory.FrameworkFactory.impl;

import com.platform.client.factory.FrameworkFactory.Framework;
import com.platform.client.vo.FrameworkVo;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/28.
 * 添加Spring Mybatis框架
 */
@Service("springHibernate")
public class FrameworkSpringHibernate implements Framework{
    @Override
    public void add(FrameworkVo vo) {

    }
}
