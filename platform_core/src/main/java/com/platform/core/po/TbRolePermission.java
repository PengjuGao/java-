package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbRolePermission implements Serializable {
    /**
     * tb_role_permission.id (角色权限关系表)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer id;

    /**
     * tb_role_permission.role_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer roleId;

    /**
     * tb_role_permission.permission_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer permissionId;

    /**
     * tb_role_permission.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}