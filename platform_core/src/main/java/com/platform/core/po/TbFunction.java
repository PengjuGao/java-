package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbFunction implements Serializable {
    /**
     * tb_function.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long id;

    /**
     * tb_function.function_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String functionId;

    /**
     * tb_function.name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String name;

    /**
     * tb_function.is_valid
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer isValid;

    /**
     * tb_function.creator
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creator;

    /**
     * tb_function.creator_name
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String creatorName;

    /**
     * tb_function.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * tb_function.modify_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date modifyTime;

    /**
     * tb_function.function_url
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String functionUrl;

    /**
     * tb_function.parent_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String parentId;

    /**
     * tb_function.function_type (菜单类型：菜单，功能，模块)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String functionType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFunctionId() {
        return functionId;
    }

    public void setFunctionId(String functionId) {
        this.functionId = functionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getFunctionUrl() {
        return functionUrl;
    }

    public void setFunctionUrl(String functionUrl) {
        this.functionUrl = functionUrl;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getFunctionType() {
        return functionType;
    }

    public void setFunctionType(String functionType) {
        this.functionType = functionType;
    }
}