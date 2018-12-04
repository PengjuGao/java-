package com.platform.service.testMVC;

import com.platform.client.vo.CommonFrameWorkVo;

/**
 * Created by gaopengju on 2016/12/30.
 */
public class VoUtils {

    public CommonFrameWorkVo s2hVo(){
        CommonFrameWorkVo vo = new CommonFrameWorkVo();
        vo.setCache("redis");
        vo.setUserId("sitemesh");
        vo.setDatabasePool("C3P0");
        vo.setOrmFramework("mybatis");
        vo.setWebFramework("springMVC");
        vo.setProject("springMybatis_sitemesh_velocity");
        vo.setDatabaseType("mysql");
        vo.setMavenType("web");
        vo.setPackageName("com.newsm.sitemesh");
        vo.setFrameworkType("springMybatis");
        vo.setDatabasePool("C3P0");
        vo.setTemplate("velocity");
        vo.setSitemesh("yes");
        return vo;
    }
}
