package com.platform.client.service;

import com.platform.client.enums.FunctionEnum;
import com.platform.client.factory.FunctionFactory.BaseFunction;
import com.platform.client.factory.FunctionFactory.FunctionFactory;
import com.platform.client.vo.FrameworkVo;
import org.dom4j.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2016/11/2.
 */
@Service
public class FunctionService {
    @Autowired
    FunctionFactory factory;

    /***
     * 页面传递过来的要添加的功能
     * @param vo
     * @return
     */
    public String addFunction(FrameworkVo vo){
        int[] functionIds = vo.getFunctionIds();
        for (int functionId :
                functionIds) {
            BaseFunction function = factory.getService(functionId);
            function.setVo(vo);
            try {
                function.parse(FunctionEnum.getEnum(functionId).configUrl);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
