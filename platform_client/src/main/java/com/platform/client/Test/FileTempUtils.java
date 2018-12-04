package com.platform.client.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by kris on 2017/4/9.
 */
public class FileTempUtils {

    public static void main(String[] args) {
        try {
            File dir = File.createTempFile("pengju",".txt");
            System.out.println(dir.getPath());
            File file = File.createTempFile ("gao","txt",dir);
            if(dir.exists()){
                dir.delete();
            }else{
                dir.mkdirs();
            }
            if(file.exists()){
                file.delete();
            }else{
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
