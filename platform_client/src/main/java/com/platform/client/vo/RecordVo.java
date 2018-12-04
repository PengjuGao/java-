package com.platform.client.vo;

import net.sf.json.JSONObject;
import java.io.Serializable;
import java.util.Date;

/**
 * 辅助vo，处理json串
 */
public class RecordVo implements Serializable {
    /**
     * tb_record.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long id;

    /**
     * tb_record.user_id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Long userId;

    /**
     * tb_record.record_type (1:ssh2:ssm3:s2h4:s2m5:sh6:sm7:other)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer recordType;

    /**
     * tb_record.record_detail (记录详细信息)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private JSONObject recordDetail;

    /**
     * tb_record.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    /**
     * tb_record.update_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date updateTime;

    /**
     * tb_record.status (0:禁用 1:正常)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer status;

    /**
     * tb_record.time (下载次数)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

    public JSONObject getRecordDetail() {
        return recordDetail;
    }

    public void setRecordDetail(JSONObject recordDetail) {
        this.recordDetail = recordDetail;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}