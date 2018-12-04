package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbUserinfo implements Serializable {
    /**
     * tb_userinfo.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long id;

    /**
     * tb_userinfo.real_name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String realName;

    /**
     * tb_userinfo.nick (昵称)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String nick;

    /**
     * tb_userinfo.user_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String userId;

    /**
     * tb_userinfo.phone
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String phone;

    /**
     * tb_userinfo.email
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String email;

    /**
     * tb_userinfo.head_icon (头像)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String headIcon;

    /**
     * tb_userinfo.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * tb_userinfo.modify_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}