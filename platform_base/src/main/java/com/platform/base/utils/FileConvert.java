package com.platform.base.utils;

import org.apache.commons.beanutils.converters.FileConverter;
import org.apache.commons.io.output.FileWriterWithEncoding;
import org.mozilla.universalchardet.UniversalDetector;

import java.io.*;

/**
 * Created by Administrator on 2016/9/30.
 * 转换文件字符编码
 * 1:检测文件的编码格式
 * 2：转换文件的编码格式
 */
public class FileConvert {

    public final static String GBK = "GBK";
    public final static String UTF8 = "UTF-8";

    /**
     * 根据文件路径判断文件是否是GBK格式的文件
     *
     * @param file
     * @return
     */
    public static boolean isGBKFile(String file) {
        File tempFile = new File(file);
        return isGBKFile(tempFile);
    }

    /**
     * 根据文件判断文件是否是GBK格式文件
     *
     * @param file
     * @return
     */
    public static boolean isGBKFile(File file) {
        try {
            String encoding = FileConvert.getFileEncode(file);
            if (GBK.equalsIgnoreCase(encoding)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 根据文件路径判断文件是否是utf8格式
     *
     * @param file
     * @return
     */
    public static boolean isUTF8(String file) {
        File tempFile = new File(file);
        return isUTF8(tempFile);
    }

    /**
     * 根据文件判断文件是否是utf8格式
     *
     * @param file
     * @return
     */
    public static boolean isUTF8(File file) {
        try {
            String encoding = FileConvert.getFileEncode(file);
            if (UTF8.equalsIgnoreCase(encoding)) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /***
     * 获取文件的编码格式
     * @param file
     * @return
     * @throws Exception
     */
    public static String getFileEncode(File file) throws Exception {
        Long length = file.length();
        byte[] buf = new byte[length.intValue()];
        FileInputStream in = new FileInputStream(file);
        BufferedInputStream fis = new BufferedInputStream(in);
        // (1)
        UniversalDetector detector = new UniversalDetector(null);
        // (2)
        int nread;
        while ((nread = fis.read(buf)) > 0 && !detector.isDone()) {
            detector.handleData(buf, 0, nread);
        }
        // (3)
        detector.dataEnd();
        // (4)
        String encoding = detector.getDetectedCharset();
        // (5)
        detector.reset();
        in.close();
        fis.close();
        return encoding;
    }

    /**
     * GBK文件转换成UTF8格式(文件路径)
     * @param file
     */
    public static void convertGBK2UTF(String file){

    }

    /**
     * GBK文件转换成UTF8格式(文件)
     * @param file
     */
    public static void convertGBK2UTF(File file){

    }

    /**
     * utf8转换成gbk(文件)
     * @param file
     */
    public static void convertUTF2GBK(File file){

    }
    /**
     * utf8转换成gbk(文件路径)
     * @param file
     */
    public static void convertUTF2GBK(String file){

    }

    /**
     * 文件编码转换
     * @param file
     * @param oldEncoding
     * @param newEncoding
     */
    public static void convert(File file,String oldEncoding,String newEncoding){
        String fileName = file.getName();
        if(!fileName.endsWith(".java")&&!fileName.endsWith(".xml")&&!fileName.endsWith(".txt")
                &&!fileName.endsWith(".html")){
            System.out.println(file.getName()+"----------- skip skip-----------");
            return;
        }
        //1.备份
        try {
            Long length = file.length();
            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] bytes = new byte[length.intValue()];
            bufferedInputStream.read(bytes);
            inputStream.close();
            bufferedInputStream.close();
            //通过文件的编码，解码字节数组
            String converter = new String(bytes,oldEncoding);
            //解码之后的字符串，按照新需要的编码再次获取成字节数组
            byte[] tempByte = converter.getBytes(newEncoding);
            //用新的编码，再次解码，输入到文件中即可
            String result = new String(tempByte,newEncoding);
            FileOutputStream outputStream = new FileOutputStream(file);
            Writer writer =  new OutputStreamWriter(outputStream,newEncoding);
            writer.write(result);
            writer.flush();
            outputStream.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("file is not found");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(file.getName()+"----------- has been converter-----------");
    }

    /**
     * 将文件夹内所有的文件都进行转换
     * @param dir
     * @param oldEncoding
     * @param newEncoding
     */
    public static void executeDir(String dir,String oldEncoding,String newEncoding){

        File dirs = new File(dir);
        File[] files = dirs.listFiles();
        for (File file :
                files) {
            if (file.isDirectory()) {
                System.out.println(file.getName()+"----------is dirctory");
                executeDir(file.getAbsolutePath(),oldEncoding,newEncoding);
            }else{
                String encoding = "";
                if(isGBKFile(file)){
                    encoding = "GBK";
                  if(newEncoding.equalsIgnoreCase(GBK)){
                      continue;
                  }
                }else if(isUTF8(file)){
                    encoding = "UTF-8";
                    if(newEncoding.equalsIgnoreCase(UTF8)){
                        continue;
                    }
                }
                FileConvert.convert(file,oldEncoding,newEncoding);
            }
        }

    }






    public static void main(String[] args) {
      FileConvert.executeDir("F:\\most\\platform","GBK","utf-8");
    }
}