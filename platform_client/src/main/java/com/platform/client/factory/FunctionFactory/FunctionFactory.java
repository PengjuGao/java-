package com.platform.client.factory.FunctionFactory;

import com.platform.client.enums.FunctionEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/10/30.
 */
@Component
public class FunctionFactory {

    @Resource(name = "springFunction")
    BaseFunction springFunction;
    @Resource(name = "springMybatisFunction")
    BaseFunction springMybatis;
    /**
     * 获取function 的处理类
     * @param code
     * @return
     */
    public BaseFunction getService(int code){
        FunctionEnum functionEnum = FunctionEnum.getEnum(code);
        switch (functionEnum){
            case springMVC:
                return springFunction;
            case springMybatis:
                return springMybatis;
        }
        return null;
    }

}
