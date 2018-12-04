package com.platform.client.factory.FunctionFactory;

import com.platform.client.common.CommonParser;
import com.platform.client.utils.FileUtils;
import com.platform.client.vo.FrameworkVo;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2016/10/30.
 * 所有功能实现接口
 */
public abstract class BaseFunction {

    /**
     * 解析并返回xml Document
     * @param fileName
     * @return
     */
    Document parseDom(String fileName) throws DocumentException {
        InputStream in = BaseFunction.class.getClassLoader().getResourceAsStream(fileName);
        SAXReader sax = new SAXReader();
        Document document = sax.read(in);
        return document;
    }

    /**
     * 第一：读取配置文件,并解析配置文件
     */
    public  void parse(String fileName) throws DocumentException {
        Document document = parseDom(fileName);
        Element root = document.getRootElement();
        List<Element> list =  root.elements();
        for (Element element :
                list) {
            String name = element.getName();
            if("java".equals(name)){
                parseJAVA(element);
            }else if("pom".equals(name)){
                parsePOM(element);
            }else if("web".equals(name)){
                parseWEB(element);
            }else if("self".equals(name)){
                parseSELF(element);
            }
        }
    }

    /**
     * 第二：处理文件中的java节点数据
     */
    protected abstract void parseJAVA(Element element);
    /**
     * 第三：处理文件中pom节点数据
     */
    protected void parsePOM(Element element){
        //获取pom路径
        String pomPath = this.functionVo.getPomPath();
        //根据element 获取需要拷贝的文件地址
        Document doc = CommonParser.getDoc(element);
        //meger
        CommonParser.megreFile(pomPath,doc,"pom");
    }
    /**
     * 第四:处理文件中self节点数据
     */
    protected abstract void parseSELF(Element element);
    /**
     * 第五：处理文件中web.xml节点数据
     */
    protected void parseWEB(Element element){
        //获取项目web路径
        String webPath = this.functionVo.getWebPath();
        //根据element中要拷贝的地址，拷贝文件到web中去
        Document doc = CommonParser.getDoc(element);
        //meger
        CommonParser.megreFile(webPath,doc,"web");
    }
    //辅助vo类
    protected FrameworkVo functionVo;
    public void setVo(FrameworkVo vo) {
        this.functionVo = vo;
    }


    //每个功能，无非几种添加方式：1：合并文件 2：拷贝文件
    public static void megerFile(){
        //暂无使用（合并文件不能写成公共的，需要针对不同的功能分别来写，这里只是写出业务的逻辑）
    }

    /***
     * copy 前提处理
     * @param path
     * @param list
     */
    public void copyFile(String path,List<Element> list){
        for (Element tempObj :
                list) {
            String type = tempObj.attribute("type").getValue();
            if("copy".equals(type)){
                //获取拷贝的目标文件夹
                String target = tempObj.attribute("target").getValue();
                target = path+ File.separator+target;
                //获取要拷贝的文件内容
                String src = tempObj.getTextTrim();
                String[] tempArr = src.split(";");
                List<String> fileList = Arrays.asList(tempArr);
                //调用本身的copy方法
                this.copyFile(fileList,target);
            }
        }
    }

    /**
     * copy 正式处理
     * @param fileNames
     * @param target
     */
    public  void copyFile(List<String> fileNames,String target){

        for (String fileName:
             fileNames) {
            String newFileName = dealFileName(fileName);
            InputStream in = BaseFunction.class.getClassLoader().getResourceAsStream(fileName);
            FileUtils.copyFile(in,target,newFileName);
        }

    }

    /**
     * 根据给出的文件相对路径获取文件的名称
     * @param fileName
     * @return
     */
    public static String dealFileName(String fileName){
       String[] tempArr = fileName.split("/");
        return tempArr[tempArr.length-1];
    }
}
