package com.platform.client.factory.FrameworkFactory.impl;

import com.platform.client.factory.FrameworkFactory.Framework;
import com.platform.client.vo.FrameworkVo;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/28.
 * 任何web框架和orm框架都不添加
 */
@Service("none")
public class FrameworkNone implements Framework{
    @Override
    public void add(FrameworkVo vo) {

    }
}
