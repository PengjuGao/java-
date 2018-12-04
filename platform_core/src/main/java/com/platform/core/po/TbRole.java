package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbRole implements Serializable {
    /**
     * tb_role.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long id;

    /**
     * tb_role.role_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String roleId;

    /**
     * tb_role.role_name (角色名称)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String roleName;

    /**
     * tb_role.role_status (角色状态)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String roleStatus;

    /**
     * tb_role.creator_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creatorId;

    /**
     * tb_role.creator_name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creatorName;

    /**
     * tb_role.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * tb_role.modify_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date modifyTime;

    /**
     * tb_role.parent_id (父角色)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String parentId;

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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(String roleStatus) {
        this.roleStatus = roleStatus;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
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

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}