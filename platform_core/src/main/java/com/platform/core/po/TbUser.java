package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbUser implements Serializable {
    /**
     * tb_user.id
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private Long id;

    /**
     * tb_user.user_id (用户id)
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private String userId;

    /**
     * tb_user.password (用户密码)
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private String password;

    /**
     * tb_user.last_login_time
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private Date lastLoginTime;

    /**
     * tb_user.status (状态,正常，冻结，锁定，禁用等等)
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private String status;

    /**
     * tb_user.create_time
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private Date createTime;

    /**
     * tb_user.nick (0:学生)
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private String nick;

    /**
     * tb_user.user_type
     * @ibatorgenerated 2016-12-29 23:20:39
     */
    private Integer userType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}