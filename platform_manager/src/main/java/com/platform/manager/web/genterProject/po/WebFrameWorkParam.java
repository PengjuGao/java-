package com.platform.manager.web.genterProject.po;

import java.io.Serializable;

/**
 * Created by gaoepngju on 16/7/1.
 */
public class WebFrameWorkParam implements Serializable {

    /**添加的web框架类型,目前只支持springMvc*/
    private String frameworkType;

    public String getFrameworkType() {
        return frameworkType;
    }

    public void setFrameworkType(String frameworkType) {
        this.frameworkType = frameworkType;
    }
}
