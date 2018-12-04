package com.platform.client.service;

import com.platform.client.factory.FunctionFactory.BaseFunction;
import com.platform.client.vo.FrameworkVo;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/6.
 * 组织功能接入的辅助service类
 */
@Service
public class CommonService {

    /**
     * 通过参数获取需要添加的database
     * @param vo
     * @return
     */
    public static BaseFunction getDataBaseFunctionService(FrameworkVo vo) {
        //如果是spring mybatis配置
        if(vo.getWebFrameworkType()==1 && vo.getOrmFrameworkType()==1){
            //第一：获取数据库类型，并替换

            //第二：获取线程池类型，并替换

            //第三：获取是否是多数据源
        }



        return null;
    }
}
