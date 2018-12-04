package com.platform.core.param;

import com.platform.core.param.common.CommonParam;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by gaopengju on 2016/12/26.
 * 信息反馈
 */
public class FeedbackParam extends CommonParam implements Serializable {

    private String email;//邮箱地址
    private Integer type;//反馈类型1：建议 2：投诉 3：框架问题 4：合作
    private String message;//反馈信息
    private Date createTime = new Date();
    private Date updateTime = new Date();
    private Integer status = 1;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
