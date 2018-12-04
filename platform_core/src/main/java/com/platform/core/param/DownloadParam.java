package com.platform.core.param;

import com.platform.core.param.common.CommonParam;

import java.io.Serializable;

/**
 * Created by gaopengju on 2016/12/27.
 * 下载参数类
 */
public class DownloadParam extends CommonParam implements Serializable {

    private String fileName;
    private String url;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
