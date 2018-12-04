package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbConfig implements Serializable {
    /**
     * tb_config.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer id;

    /**
     * tb_config.config_name (配置文件类型名)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String configName;

    /**
     * tb_config.key (key)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String key;

    /**
     * tb_config.value (value)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String value;

    /**
     * tb_config.status (1:有效 2:无效数据)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer status;

    /**
     * tb_config.message (字段说明)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String message;

    /**
     * tb_config.create_time (创建时间,unixTime)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConfigName() {
        return configName;
    }

    public void setConfigName(String configName) {
        this.configName = configName;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
}