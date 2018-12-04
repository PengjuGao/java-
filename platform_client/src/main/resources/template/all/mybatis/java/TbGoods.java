package com.platform.core.po;

import java.io.Serializable;

public class TbGoods implements Serializable {
    /**
     * tb_goods.id
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private Integer id;

    /**
     * tb_goods.name (商品名称)
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private String name;

    /**
     * tb_goods.price (商品价格)
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private Long price;

    /**
     * tb_goods.type (商品类型)
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private Integer type;

    /**
     * tb_goods.time_value (商品的通话时长)
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private Integer timeValue;

    /**
     * tb_goods.create_time
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private Integer createTime;

    /**
     * tb_goods.update_time
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private Integer updateTime;

    /**
     * tb_goods.status (0:无效 1:有效)
     * @ibatorgenerated 2016-10-17 15:35:46
     */
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTimeValue() {
        return timeValue;
    }

    public void setTimeValue(Integer timeValue) {
        this.timeValue = timeValue;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}