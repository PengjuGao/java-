package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TbClickRecord implements Serializable {
    /**
     * tb_click_record.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long id;

    /**
     * tb_click_record.menuId (菜单id)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer menuid;

    /**
     * tb_click_record.userId (用户)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long userid;

    /**
     * tb_click_record.ip
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String ip;

    /**
     * tb_click_record.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * tb_click_record.update_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date updateTime;

    /**
     * tb_click_record.browser (浏览器类型)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String browser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }
}