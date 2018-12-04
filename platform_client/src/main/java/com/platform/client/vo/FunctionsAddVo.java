package com.platform.client.vo;

/**
 * Created by Administrator on 2016/11/2.
 * 页面传递的要添加的功能Vo
 */
public class FunctionsAddVo extends CommonVo{

    //页面传递的功能id
    private String[] functionId;

    public String[] getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String[] functionId) {
        this.functionId = functionId;
    }
}
