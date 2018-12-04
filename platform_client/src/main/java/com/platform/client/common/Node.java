package com.platform.client.common;

/**
 * Created by Administrator on 2016/11/10.
 */
public class Node {

    private String type;//文件，包，文件夹
    private String suffix;//后缀
    private String parentNode;//父节点的id或者名称
    private String action;//merge，copy，create，added
    private String name;//节点名称
    private String id;//id 属性
    private String target;//目标文件

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getParentNode() {
        return parentNode;
    }

    public void setParentNode(String parentNode) {
        this.parentNode = parentNode;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
