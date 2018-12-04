package com.platform.client.service;

import com.platform.client.common.Resources;
import com.platform.client.config.ConfigVo;
import com.platform.client.utils.FileUtils;
import com.platform.client.vo.FrameworkVo;
import com.platform.client.vo.ProjectResult;
import com.platform.client.vo.ProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;

/**
 * Created by Administrator on 2016/10/24.
 */
@Service
public class MakeProjectService {

    @Autowired
    ConfigVo configVo;

    /***
     * 创建项目骨架
     * @param vo
     */
    public void makeProject(FrameworkVo vo){
        try {

            //获取根目录文件+项目名称
            String path = configVo.getRootPath() + File.separator
                    + vo.getUserId() + File.separator
                    + vo.getProjectName();
            vo.setPath(path);
            vo.setUserId(vo.getUserId());
            //创建骨架
            FileUtils.createDir(path + File.separator + Resources.PRO_MAIN_JAVA);
            FileUtils.createDir(path + File.separator + Resources.PRO_MAIN_RESOURCES);
            //pom.xml 拷贝之后需要修改替换里面的内容
            File pomFile = null;
            if ("web".equals(vo.getMavenType())) {
                //创建页面的views
                FileUtils.createDir(path + File.separator + Resources.PRO_MAIN_VIEWS);
                //copy web.xml 文件
                InputStream webInputStream = MakeProjectService.class.getClassLoader().getResourceAsStream("template/baseFile/web.xml");
                if (webInputStream == null) {
                    System.err.println("错误");
                }
                FileUtils.copyFile(webInputStream, path + File.separator + Resources.PRO_MAIN_WEBINF, "web.xml");
                //copy jsp 文件
                InputStream jspInputStream = MakeProjectService.class.getClassLoader().getResourceAsStream("template/baseFile/index.jsp");
                FileUtils.copyFile(jspInputStream, path + File.separator + Resources.PRO_MAIN_WEBAPP, "index.jsp");

                //copy web pom 文件
                InputStream pomInputStream = MakeProjectService.class.getClassLoader().getResourceAsStream("template/baseFile/pom.xml");
                pomFile = FileUtils.copyFile(pomInputStream, path + File.separator,"pom.xml");
            }else if("jar".equals(vo.getMavenType())){
                //copy jar pom 文件
                InputStream pomInputStream = MakeProjectService.class.getClassLoader().getResourceAsStream("template/baseFile/jar_pom.xml");
                pomFile = FileUtils.copyFile(pomInputStream, path + File.separator,"pom.xml");
            }
            //将pomFile中的${project} 替换成项目名称
            String value = com.platform.base.common.classTemplate.FileUtils.getFileContent(pomFile.getAbsolutePath(),"utf-8");
            value = value.replaceAll("\\$#project#",vo.getProjectName());
            com.platform.base.common.classTemplate.FileUtils.makeFile(pomFile.getAbsolutePath(),value,"utf-8",true);

            FileUtils.createDir(path + File.separator + Resources.PRO_TEST_JAVA);
            FileUtils.createDir(path + File.separator + Resources.PRO_TEST_RESOURCES);

            //生成测试文件目录
            FileUtils.createDir(path + File.separator + Resources.PRO_MAIN_JAVA+"/com/auto/test");

        }catch (Exception e){
            e.printStackTrace();
        }
     }

}
