package com.platform.manager.web.genterProject.service;

import com.platform.manager.web.genterProject.constants.EConstants;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 创建文件工厂类
 * Created by gaoepngju on 16/7/4.
 */
@Component
public class ConfigFileFactory {
    @Resource
    private CreateConfigFileService pomService;
    @Resource
    private CreateConfigFileService webService;

    /**
     * 根据指定的文件名获取对应的service
     * @param fileName
     * @return
     */
    public CreateConfigFileService getService(String fileName){

        EConstants.CreateFileType tempEnum = EConstants.CreateFileType.getEnumObj(fileName);

        switch (tempEnum){
            case POM:
                return pomService;
            case WEB:
                return webService;
            default:
                return null;

        }
    }

}
