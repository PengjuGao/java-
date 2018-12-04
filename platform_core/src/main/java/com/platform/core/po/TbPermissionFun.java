package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbPermissionFun implements Serializable {
    /**
     * tb_permission_fun.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer id;

    /**
     * tb_permission_fun.permission_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String permissionId;

    /**
     * tb_permission_fun.function_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String functionId;

    /**
     * tb_permission_fun.is_valid
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer isValid;

    /**
     * tb_permission_fun.creator
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creator;

    /**
     * tb_permission_fun.creator_name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creatorName;

    /**
     * tb_permission_fun.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * tb_permission_fun.modify_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date modifyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public Integer getIsValid() {
        return isValid;
    }

    public void setIsValid(Integer isValid) {
        this.isValid = isValid;
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
}