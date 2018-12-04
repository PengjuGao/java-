package com.platform.core.po;

import java.io.Serializable;
import java.util.Date;

public class TableAndColumns implements Serializable {
    /**
     * table_and_columns.id
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Integer id;

    /**
     * table_and_columns.table_name (表名称)
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String tableName;

    /**
     * table_and_columns.columns
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private String columns;

    /**
     * table_and_columns.create_time
     * @ibatorgenerated 2016-12-26 18:05:07
     */
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getColumns() {
        return columns;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}