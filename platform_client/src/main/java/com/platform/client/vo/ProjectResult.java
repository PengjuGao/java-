package com.platform.client.vo;

/**
 * Created by Administrator on 2016/10/27.
 * 返回结果类
 */
public class ProjectResult extends CommonVo {

    private String userId;//返回用户id
    private String path;//返回项目根目录路径

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
