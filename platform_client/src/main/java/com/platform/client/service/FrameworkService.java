package com.platform.client.service;

import com.platform.client.factory.FrameworkFactory.FrameworkFactory;
import com.platform.client.vo.FrameworkVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/10/28.
 * 添加框架的service 类
 */
@Service
public class FrameworkService {
    @Autowired
    FrameworkFactory factory;
    /**
     * 添加web框架，orm框架
     * @param vo
     */
    public void addFramework(FrameworkVo vo) {
        int value = vo.getWebFrameworkType()*10+vo.getOrmFrameworkType();
        factory.getFramework(value).add(vo);
    }

}
