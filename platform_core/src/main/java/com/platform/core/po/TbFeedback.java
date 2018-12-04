package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbFeedback implements Serializable {
    /**
     * tb_feedback.id
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private Long id;

    /**
     * tb_feedback.user_id
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private Long userId;

    /**
     * tb_feedback.type (反馈类型 0:提建议1:框架建议2:合作3:其它)
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private Integer type;

    /**
     * tb_feedback.message (反馈的信息)
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private String message;

    /**
     * tb_feedback.create_time
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private Date createTime;

    /**
     * tb_feedback.update_time
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private Date updateTime;

    /**
     * tb_feedback.status (0:无效1:正常)
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private Integer status;

    /**
     * tb_feedback.email (email 地址)
     * @ibatorgenerated 2017-01-13 13:08:52
     */
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}