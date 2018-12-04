package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbVerifyCode implements Serializable {
    /**
     * tb_verify_code.id
     * @ibatorgenerated 2016-12-27 17:48:17
     */
    private Long id;

    /**
     * tb_verify_code.type (0:注册 1:忘记密码)
     * @ibatorgenerated 2016-12-27 17:48:17
     */
    private Integer type;

    /**
     * tb_verify_code.verify_code (验证码)
     * @ibatorgenerated 2016-12-27 17:48:17
     */
    private Long verifyCode;

    /**
     * tb_verify_code.create_time
     * @ibatorgenerated 2016-12-27 17:48:17
     */
    private Date createTime;

    /**
     * tb_verify_code.update_time
     * @ibatorgenerated 2016-12-27 17:48:17
     */
    private Date updateTime;

    /**
     * tb_verify_code.email (邮箱等于用户id)
     * @ibatorgenerated 2016-12-27 17:48:17
     */
    private String email;

    /**
     * tb_verify_code.status (0:无效 1:有效)
     * @ibatorgenerated 2016-12-27 17:48:17
     */
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(Long verifyCode) {
        this.verifyCode = verifyCode;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}