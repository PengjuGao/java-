package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbRoleUser implements Serializable {
    /**
     * tb_role_user.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long id;

    /**
     * tb_role_user.role_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String roleId;

    /**
     * tb_role_user.user_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String userId;

    /**
     * tb_role_user.creator
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creator;

    /**
     * tb_role_user.creator_name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creatorName;

    /**
     * tb_role_user.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * tb_role_user.modify_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date modifyTime;

    /**
     * tb_role_user.is_invalid
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer isInvalid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
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

    public Integer getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(Integer isInvalid) {
        this.isInvalid = isInvalid;
    }
}