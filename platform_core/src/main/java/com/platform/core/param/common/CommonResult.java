package com.platform.core.param.common;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaopengju on 2016/12/27.
 * 公共返回参数
 */
public class CommonResult<T> implements Serializable {

    private int code=200;//返回码 200 正确，非200 错误
    private String message="success"; //返回信息
    private List<T> data = new ArrayList<T>(); //返回结果集

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * 设置单个对象
     */
    public void set(T t){
        this.data.add(t);
    }

    /**
     * 设置集合对象
     */
    public void setList(List<T> list){
        this.data.addAll(list);
    }

}
