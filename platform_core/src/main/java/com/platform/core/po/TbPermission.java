package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbPermission implements Serializable {
    /**
     * `tb_ permission`.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long id;

    /**
     * `tb_ permission`. permission_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String permissionId;

    /**
     * `tb_ permission`.name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String name;

    /**
     * `tb_ permission`.is_invalid
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String isInvalid;

    /**
     * `tb_ permission`.creator
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creator;

    /**
     * `tb_ permission`.creator_name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creatorName;

    /**
     * `tb_ permission`.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * `tb_ permission`.modify_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsInvalid() {
        return isInvalid;
    }

    public void setIsInvalid(String isInvalid) {
        this.isInvalid = isInvalid;
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