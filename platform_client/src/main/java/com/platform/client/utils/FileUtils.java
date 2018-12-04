package com.platform.client.utils;

import com.platform.base.utils.StringUtils;

import java.io.*;

/**
 * Created by Administrator on 2016/10/25.
 */
public class FileUtils {
    /**
     * 创建文件
     * @param path
     */
    public static  File createFile(String path){
        File file = new File(path);
        if(!file.exists()){
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 创建文件夹
     * @param path
     */
    public static File createDir(String path){
        File file = new File(path);
        file.mkdirs();
        return file;
    }

    /**
     * 拷贝文件
     * @param file
     * @param targetPath
     * @param rename
     */
    public static void copyFile(File file,String targetPath,String rename){
        if(StringUtils.isNullString(rename)){
            rename = file.getName();
        }
        try {
            FileInputStream inputStream = new FileInputStream(file);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] arr = new byte[4096];
            String newFileName = "";
            if(StringUtils.isNullString(rename)){
                newFileName = targetPath+File.separator;
            }else{
                newFileName = targetPath+File.separator+rename;
            }
            File newFile = FileUtils.createFile(newFileName);
            FileOutputStream outputStream = new FileOutputStream(newFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int len = 0;
            while((len=bufferedInputStream.read(arr))!=-1){
                bufferedOutputStream.write(arr,0,len);
            }
            bufferedOutputStream.close();
            outputStream.close();
            bufferedInputStream.close();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 拷贝文件
     * @param inputStream
     * @param targetPath
     * @param rename
     */
    public static File copyFile(InputStream inputStream,String targetPath,String rename){
        if(rename.contains("#")){
            rename = rename.replace("#",".");
            System.out.println(rename+"-----------------------------------------");
        }
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            byte[] arr = new byte[1024];
            String newFileName = "";
            if(StringUtils.isNullString(rename)){
                newFileName = targetPath+File.separator;
            }else{
                newFileName = targetPath+File.separator+rename;
            }
            File newFile = FileUtils.createFile(newFileName);
            FileOutputStream outputStream = new FileOutputStream(newFile);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            int len = 0;
            while((len=bufferedInputStream.read(arr))!=-1){
                bufferedOutputStream.write(arr,0,len);
            }
            bufferedOutputStream.close();
            outputStream.close();
            bufferedInputStream.close();
            inputStream.close();
            return newFile;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.err.println("targetpath="+targetPath+"  rename="+rename);
        return null;
    }

    /**
     * 拷贝文件夹
     * 递归拷贝
     */
    public static void copyDir(String srcUrl,String targetUrl){
        File srcFile = new File(srcUrl);
        if(srcFile.isFile()){
            FileUtils.copyFile(srcFile,targetUrl,null);
        }else{
            String srcFileName = srcFile.getName();
            File tempTargetFile = null;
            if(!srcFileName.equals("other")) {
                tempTargetFile = new File(targetUrl + File.separator + srcFileName);
                tempTargetFile.mkdir();
            }else{
                tempTargetFile = new File(targetUrl);
            }

            for (File tempFile :
                    srcFile.listFiles()) {
                if(tempFile.isDirectory()){
                    copyDir(tempFile.getAbsolutePath(),tempTargetFile.getAbsolutePath());
                }else if(tempFile.isFile()){
                    copyFile(tempFile,tempTargetFile.getAbsolutePath(),null);
                }
            }
        }
    }


    public static void main(String[] args) {
        //File file = new File("d:\\mm.txt");
        //FileUtils.copyFile(file,"e:\\abc",null);
        copyDir("D:\\adb\\htmlFramework\\amazeUI","f:\\test");
    }

    /**
     * 判断对应的文件夹是否存在，如果存在删除
     * @param projectPath
     */
    public static void deleteFileOrZip(String projectPath) {
        File project = new File(projectPath);
        boolean success =project.delete();
        if (success) {
            System.out.println("Successfully deleted empty directory: " + projectPath);
        } else {
            System.out.println("Failed to delete empty directory: " + projectPath);
            deleteDir(project);
        }

    }

    /**
     * 删除非空文件夹
     * @param file
     * @return
     */
    public  static boolean deleteDir(File file) {
        if (file.isDirectory()) {
            String[] children = file.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(file, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        // The directory is now empty so now it can be smoked
        return file.delete();
    }

}
