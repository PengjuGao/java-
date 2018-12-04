package com.platform.service.testMVC;

import com.platform.base.utils.BeanToMapUtil;
import com.platform.client.common.FTLUtils;
import com.platform.client.common.Node;
import com.platform.client.common.ProjectUtils;
import com.platform.client.common.XMLUtils;
import com.platform.client.enums.ProjectEnum;
import com.platform.client.factory.FrameworkFactory.FrameworkFactory;
import com.platform.client.service.MakeProjectService;
import com.platform.client.vo.CommonFrameWorkVo;
import com.platform.client.vo.FrameworkVo;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.IntrospectionException;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/10/27.
 */
public class TestMakeProject extends TestMVC {

    @Autowired
    MakeProjectService makeProjectService;
    @Autowired
    FrameworkFactory factory;
    @Test
    public void testMakeProject(){
        //第一步：创建项目骨架
        FrameworkVo vo = new FrameworkVo();
        vo.setMavenType("web");
        vo.setProjectName("hello11");
        vo.setUserId("evilwolf");
         makeProjectService.makeProject(vo);
        vo.setOrmFrameworkType(0);
        vo.setWebFrameworkType(1);
        int value = vo.getWebFrameworkType()*10+vo.getOrmFrameworkType();
        factory.getFramework(value).add(vo);
    }

    @Test
    public void testSpringMybaits(){
        //第一步：创建项目骨架
        FrameworkVo vo = new FrameworkVo();
        vo.setMavenType("web");
        vo.setProjectName("hello11");
        vo.setUserId("evilwolf");
        makeProjectService.makeProject(vo);
        //第二步：添加spring MYBATIS框架
        vo.setOrmFrameworkType(1);
        vo.setWebFrameworkType(1);
        int value = vo.getWebFrameworkType()*10+vo.getOrmFrameworkType();
        factory.getFramework(value).add(vo);
        //第三步添加数据库

    }

    public void testJavaApplication(){
        //第一步：创建项目骨架
        FrameworkVo frameVo = new FrameworkVo();
        frameVo.setMavenType("jar");
        frameVo.setProjectName("springMybatis");
        frameVo.setUserId("nihao11");
        makeProjectService.makeProject(frameVo);
        //第二步：添加spring MYBATIS框架
        frameVo.setOrmFrameworkType(1);
        frameVo.setWebFrameworkType(1);
        int value = frameVo.getWebFrameworkType()*10+frameVo.getOrmFrameworkType();
        factory.getFramework(value).add(frameVo);
        //第三步添加数据库

    }

    @Test
    public void testFtl(){

        CommonFrameWorkVo vo = new CommonFrameWorkVo();
        vo.setCache("memcached");
        vo.setUserId("sshUser");
        vo.setDatabasePool("C3P0");
        vo.setOrmFramework("hibernate");
        vo.setWebFramework("structs2");
        vo.setProject("mysshtest");
        vo.setDatabaseType("mysql");
        vo.setMavenType("web");
        vo.setPackageName("com.newsm.sitemesh");
        vo.setFrameworkType("ssh");
        vo.setDatabasePool("Proxool");
        vo.setTemplate("velocity");
        vo.setSitemesh("yes");
        try {
            Map map = BeanToMapUtil.convertBean(vo);
           File file =  ProjectUtils.makeProject(map);
           Document doc = XMLUtils.getDocument(new FileInputStream(file));
            /**
             * =====springMVC
             * 1:spring+hibernate
             * 2:spring+mybatis
             * ======structs2spring
             * 1:ssh
             * 2:ssm
             * =====structsMVC
             * 1:structs+hibernate
             * 2:structs+mybatis
             */
            String content = "";
            if("springMybatis".equals(vo.getFrameworkType())){
                //1:拷贝spring 需要的文件
                //2：拷贝database需要的文件
                //3：拷贝其他文件
                content =  FTLUtils.getContent(ProjectEnum.getUrl("springMybatis"),map);
            }else if("structs2spring".equals(vo.getFrameworkType())){
                //1:拷贝spring，structs 需要的文件
                //2：拷贝database需要的文件
                //3：拷贝其他文件
            }else if("structsMVC".equals(vo.getFrameworkType())){
                //1:拷贝 structs 需要的文件
                //2：拷贝database需要的文件
                //3：拷贝其他文件
            }else if("springHibernate".equals(vo.getFrameworkType())){
                content =  FTLUtils.getContent(ProjectEnum.getUrl("springHibernate"),map);
            }else if("structs2Hibernate".equals(vo.getFrameworkType())){
                content = FTLUtils.getContent(ProjectEnum.getUrl("structs2Hibernate"),map);
            }else if("structs2Mybatis".equals(vo.getFrameworkType())){
                content = FTLUtils.getContent(ProjectEnum.getUrl("structs2Mybatis"),map);
            }else if("ssh".equals(vo.getFrameworkType())){
                content = FTLUtils.getContent(ProjectEnum.getUrl("ssh"),map);
            }else if("ssm".equals(vo.getFrameworkType())){
                content = FTLUtils.getContent(ProjectEnum.getUrl("ssm"),map);
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(content.trim().getBytes());
            Document tempDoc = XMLUtils.getDocument(byteArrayInputStream);
            Element root = tempDoc.getRootElement();
            List<Element> chilren = root.elements();
            for (Element element:
                    chilren) {
                List<Attribute> attrList = element.attributes();
                Node node = XMLUtils.getNode(attrList);
                XMLUtils.executeFtl(node,doc,map);
            }
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
